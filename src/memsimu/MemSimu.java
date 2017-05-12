/*
 * MemSimu.java
 * Contiene la definicion de la funcion principal y la clase principal
 * del programa que se encarga de simular el sistema de memoria paginada
 */
package memsimu;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import memsimu.GUI.ConfigGUI;
import memsimu.GUI.NuevoProcesoGUI;
import memsimu.GUI.ProcesoGUI;
import memsimu.GUI.SimuGUI;

/**
 *
 * @author Ivan Arno y Ricardo Alustiza
 */
public class MemSimu {
    //HashMap<Integer,Proceso> procesos;
    
    HashMap<Integer,Proceso> procesos_listos;
    HashMap<Integer,Proceso> procesos_listos_suspendidos;
    HashMap<Integer,Proceso> procesos_bloqueados;
    HashMap<Integer,Proceso> procesos_bloqueados_suspendidos;
    
    ArrayList<Integer> memPrincipalLibre;
    ArrayList<Integer> memSecundariaLibre;
       
    int tamMemPrincipal;
    int tamMemSecundaria;
    int tamPagina;

    int nPagMemPrincipal;
    int nPagMemSecundaria;
    
    int bitsPagina;
    int bitsDesplazamiento;    
    
    SimuGUI simgui;
    int cuentaID;
    
    public MemSimu()
    {
        cuentaID=0;

        procesos_listos = new HashMap();
        procesos_listos_suspendidos = new HashMap();
        procesos_bloqueados = new HashMap();
        procesos_bloqueados_suspendidos = new HashMap();    
        
        simgui = new SimuGUI(this);
        simgui.pack();
        simgui.setLocationRelativeTo(null);        // para centrar la ventana
        ConfigGUI cgui = new ConfigGUI(simgui,true);
        cgui.pack();
        cgui.setLocationRelativeTo(null);        
        cgui.setVisible(true);        

        tamPagina=cgui.getTamPagina();
        tamMemPrincipal=cgui.getTamMemoriaPrincipal();
        tamMemSecundaria=cgui.getTamMemoriaSecundaria();
        cgui.dispose();
        
        nPagMemPrincipal=tamMemPrincipal/tamPagina;
        if((tamMemPrincipal%tamPagina)!=0)
            nPagMemPrincipal++;
        memPrincipalLibre = new ArrayList();
        for(int i=0; i<nPagMemPrincipal; i++)
            memPrincipalLibre.add(i);

        nPagMemSecundaria=tamMemSecundaria/tamPagina;
        if((tamMemSecundaria%tamPagina)!=0)
            nPagMemSecundaria++;
        memSecundariaLibre = new ArrayList();
        for(int i=0; i<nPagMemSecundaria; i++)
            memSecundariaLibre.add(i);

        bitsPagina=(int)(Math.log(memPrincipalLibre.size())/Math.log(2));
        bitsDesplazamiento=(int)(Math.log(tamPagina*1024)/Math.log(2));
        
        actualizaEstadisticas();
        simgui.setVisible(true);
    }
    
      
    public void nuevoProceso()
    {
        NuevoProcesoGUI nproc = new NuevoProcesoGUI(cuentaID,simgui,true);
        nproc.pack();
        nproc.setLocationRelativeTo(null);        
        nproc.setVisible(true);
        if(nproc.ok())
        {           
            int nPag=nproc.getprocTam()/tamPagina;
            if((nproc.getprocTam()%tamPagina)!=0)
                nPag++;
            Proceso proc=new Proceso(nproc.getProcID(), nPag);
            if((nPag>1 && nPag/2<=memPrincipalLibre.size()) || 
               (nPag==1 && 1<=memPrincipalLibre.size()))
            {
                while(!memPrincipalLibre.isEmpty() && nPag>0)
                {
                    int marco=memPrincipalLibre.get(0);
                    memPrincipalLibre.remove(0);
                    proc.paginas.add(new Pagina(marco,true));
                    nPag--;
                }
                while(nPag>0) {
                    int marco=memSecundariaLibre.get(0);
                    memSecundariaLibre.remove(0);
                    proc.paginas.add(new Pagina(marco,false));
                    nPag--;
                }
                proc.activar();
                procesos_listos.put(proc.ID, proc);
            }
            else if(nPag<=memSecundariaLibre.size())
            {
                for(int i=0; i<nPag; i++)
                {
                    int marco=memSecundariaLibre.get(0);
                    memSecundariaLibre.remove(0);
                    proc.paginas.add(new Pagina(marco,false));
                }       
                proc.suspender();
                procesos_listos_suspendidos.put(proc.ID,proc);
            }
            else {
                JOptionPane.showMessageDialog(simgui,
                        "No hay espacio disponible para\ncrear un nuevo proceso.",
                        "Error creando proceso",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            ProcesoGUI pgui=new ProcesoGUI(proc.ID,this);
            pgui.setVisible(true);
            simgui.nuevoProceso(pgui);
            cuentaID++;
            actualizaEstadisticas();
        }    
    }        

    public void suspenderProceso(int ID)
    {
        Proceso proc=null;
        if(procesos_listos.containsKey(ID))
            proc=procesos_listos.get(ID);
        else if(procesos_bloqueados.containsKey(ID))
            proc=procesos_bloqueados.get(ID);
        else  // ID no encontrada en los procesos listos o bloqueados
        {
            JOptionPane.showMessageDialog(simgui,
                    "El Proceso no esta en la memoria principal.",
                    "Error suspendiendo proceso",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        for(int j=0; j<proc.paginas.size(); j++)
        {
            Pagina pagina=proc.paginas.get(j);
            if (pagina.disponible)
            {                
                memPrincipalLibre.add(pagina.nMarco);
                int marco=memSecundariaLibre.get(0);
                memSecundariaLibre.remove(0);
                pagina.nMarco=marco;
                pagina.disponible=false;
            }
        }
        proc.suspender();
        if(procesos_listos.containsKey(ID))
        {
            procesos_listos_suspendidos.put(proc.ID,proc);
            procesos_listos.remove(proc.ID);
        }
        else
        {
            procesos_bloqueados_suspendidos.put(proc.ID,proc);
            procesos_bloqueados.remove(proc.ID);
        }
        
        for(Proceso proceso : procesos_listos_suspendidos.values())
        {
            if(proceso.ID!=proc.ID)
                activarProceso(proceso.ID);
        }
        for(Proceso proceso : procesos_bloqueados_suspendidos.values())
        {
            if(proceso.ID!=proc.ID)
                activarProceso(proceso.ID);
        }
        simgui.actualizaProcesos();
        actualizaEstadisticas();
    }        

    public void activarProceso(int ID)
    {
        Proceso proc=null;
        if(procesos_listos_suspendidos.containsKey(ID))
            proc=procesos_listos_suspendidos.get(ID);
        else if(procesos_bloqueados_suspendidos.containsKey(ID))
            proc=procesos_bloqueados_suspendidos.get(ID);
        else // ID no encontrada en los procesos listos o bloqueados
        {
            JOptionPane.showMessageDialog(simgui,
                    "El Proceso no esta en la memoria secundaria.",
                    "Error activando proceso",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int npags=0;
        for(int j=0; j<proc.paginas.size(); j++)
        {
            Pagina pagina=proc.paginas.get(j);
            if (!pagina.disponible)
               npags++;
        }        
        if((npags>1 && npags/2<=memPrincipalLibre.size()) || 
           (npags==1 && 1<=memPrincipalLibre.size()))
        {
            for(int j=0; j<proc.paginas.size() && !memPrincipalLibre.isEmpty(); j++)
            {
                Pagina pagina=proc.paginas.get(j);
                if (!pagina.disponible)
                {
                    int marco=memPrincipalLibre.get(0);
                    memPrincipalLibre.remove(0);
                    memSecundariaLibre.add(pagina.nMarco);
                    pagina.nMarco=marco;
                    pagina.disponible=true;
                }
            }
            proc.activar();
            if(procesos_listos_suspendidos.containsKey(ID))
            {
                procesos_listos.put(proc.ID,proc);
                procesos_listos_suspendidos.remove(proc.ID);
            }
            else
            {
                procesos_bloqueados.put(proc.ID,proc);
                procesos_bloqueados_suspendidos.remove(proc.ID);
            }                        
            actualizaEstadisticas();
        }
    }        

    public void bloquearProceso(int ID)
    {
        Proceso proc=null;
        if(procesos_listos.containsKey(ID))
            proc=procesos_listos.get(ID);
        else if(procesos_listos_suspendidos.containsKey(ID))
            proc=procesos_listos_suspendidos.get(ID);
        else  // ID no encontrada en los procesos listos o listos suspendidos
        {
            JOptionPane.showMessageDialog(simgui,
                    "El Proceso ya esta bloqueado.",
                    "Error bloqueando proceso",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        proc.bloquear();
        if(procesos_listos.containsKey(ID))
        {
            procesos_bloqueados.put(proc.ID,proc);
            procesos_listos.remove(proc.ID);
        }
        else
        {
            procesos_bloqueados_suspendidos.put(proc.ID,proc);
            procesos_listos_suspendidos.remove(proc.ID);
        }                
        actualizaEstadisticas();
    }        

    public void desbloquearProceso(int ID)
    {
        Proceso proc=null;
        if(procesos_bloqueados.containsKey(ID))
            proc=procesos_bloqueados.get(ID);
        else if(procesos_bloqueados_suspendidos.containsKey(ID))
            proc=procesos_bloqueados_suspendidos.get(ID);
        else  // ID no encontrada en los procesos bloqueados o bloq. suspendidos
        {
            JOptionPane.showMessageDialog(simgui,
                    "El Proceso no esta bloqueado.",
                    "Error desbloqueando proceso",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        proc.desbloquear();
        if(procesos_bloqueados.containsKey(ID))
        {
            procesos_listos.put(proc.ID,proc);
            procesos_bloqueados.remove(proc.ID);
        }
        else
        {
            procesos_listos_suspendidos.put(proc.ID,proc);
            procesos_bloqueados_suspendidos.remove(proc.ID);
        }        
        actualizaEstadisticas();       
    }        
    
    public Proceso getProceso(int ID)
    {
        if(procesos_listos.containsKey(ID))
            return procesos_listos.get(ID);
        else if(procesos_listos_suspendidos.containsKey(ID))
            return procesos_listos_suspendidos.get(ID);
        else if(procesos_bloqueados.containsKey(ID))
            return procesos_bloqueados.get(ID);
        else if(procesos_bloqueados_suspendidos.containsKey(ID))
            return procesos_bloqueados_suspendidos.get(ID);
        else 
            return null;
    }

    public void borrarProceso(int ID)
    {
        if(procesos_listos.containsKey(ID))
            procesos_listos.remove(ID);
        else if(procesos_listos_suspendidos.containsKey(ID))
            procesos_listos_suspendidos.remove(ID);
        else if(procesos_bloqueados.containsKey(ID))
            procesos_bloqueados.remove(ID);
        else if(procesos_bloqueados_suspendidos.containsKey(ID))
            procesos_bloqueados_suspendidos.remove(ID);
    }
    
    public SimuGUI getSimuGUI()
    {
        return this.simgui;
    }
    
    public void actualizaEstadisticas()
    {
        simgui.setMemPrincipal(memPrincipalLibre.size()*tamPagina);
        simgui.setMemSecundaria(memSecundariaLibre.size()*tamPagina);
        simgui.setnPagLibresPrincipal(memPrincipalLibre.size());
        simgui.setnPagLibresSecundaria(memSecundariaLibre.size());
        simgui.setnPagOcupadasPrincipal(nPagMemPrincipal-memPrincipalLibre.size());
        simgui.setnPagOcupadasSecundaria(nPagMemSecundaria-memSecundariaLibre.size());       
        simgui.setnProcCreados(cuentaID);
        simgui.setnProcSistema(procesos_listos.size()+procesos_listos_suspendidos.size()
                +procesos_bloqueados.size()+procesos_bloqueados_suspendidos.size());
        
        simgui.setnProcListos(procesos_listos.size());
        simgui.setnProcBloqueados(procesos_bloqueados.size());
        simgui.setnProcListosSusp(procesos_listos_suspendidos.size());
        simgui.setnProcBloqSusp(procesos_bloqueados_suspendidos.size());
        simgui.actualiza();        
    }
    
    
    public void eliminarProceso(int ID,ProcesoGUI pgui)
    {
        Proceso proc=getProceso(ID);
        for(int j=0; j<proc.paginas.size(); j++)
        {
            Pagina pagina=proc.paginas.get(j);
            if (pagina.disponible)
                memPrincipalLibre.add(pagina.nMarco);
            else
                memSecundariaLibre.add(pagina.nMarco);    
        }
        borrarProceso(ID);
        simgui.eliminaProceso(pgui);
        for(Proceso proceso : procesos_listos_suspendidos.values())
        {
            activarProceso(proceso.ID);
        }
        for(Proceso proceso : procesos_bloqueados_suspendidos.values())
        {
            activarProceso(proceso.ID);
        }
        simgui.actualizaProcesos();
        actualizaEstadisticas();
    }

    public int getBitsDesplazamiento()
    {
        return bitsDesplazamiento;       
    }

    public int getBitsPagina()
    {
        return bitsPagina;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MemSimu sim=new MemSimu();
    }
}
