/*
 * Proceso.java
 * Contiene la definicion de la clase que modela un proceso de programa en el
 * simulador
 */
package memsimu;

import java.util.ArrayList;

/**
 *
 * @author Ivan Arno y Ricardo Alustiza
 */
public class Proceso {
    public static final int LISTO = 1;
    public static final int BLOQUEADO = 2;
    public static final int SUSPENDIDO = 4;
    public int ID;
    private int estado;
    private int nPaginas;
    
    public ArrayList<Pagina> paginas; // paginas del proceso
    
    MemSimu sim;
    
    public int getEstado()
    {
        return estado;
    }
    public int getnPaginas()
    {
        return nPaginas;
    }
    public Proceso(int ID,int nPaginas)
    {
        this.ID=ID;
        this.nPaginas=nPaginas;
        estado = LISTO;
        paginas=new ArrayList();
    }
       
    public void bloquear()
    {
        estado|=BLOQUEADO;
        estado&=~LISTO;     // limpia el bit de listo ya que se bloqueo
    }
    public void desbloquear()
    {
        estado&=~BLOQUEADO; // limpia el bit de bloqueado
        estado|=LISTO;     // pon el bit de listo ya que se desbloqueo
    }
    public void activar()
    {
        estado&=~SUSPENDIDO; // borra el bit de suspendido 
    }

    public void suspender()
    {
        estado|=SUSPENDIDO; // pon el bit de suspendido
    }
    
    @Override
    public String toString() {      
        String str;
        str="Proceso "+ID+"  [";
        if((estado&LISTO)!=0)
            str+="Listo";
        else
            str+="Bloq.";
        if((estado&SUSPENDIDO)!=0)
            str+="/Susp.";
        str+="]";
        return str;
    }
    
}
