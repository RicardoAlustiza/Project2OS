/*
 * SimuGUI.java
 *
 * Contiene la interface de usuario principal que muestra las estadisticas del
 * sistema de memoria virtual y permite la creacion de procesos
 */
package memsimu.GUI;

import java.awt.Component;
import memsimu.MemSimu;

/**
 *
 * @author Ivan Arno y Ricardo Alustiza
 */
public class SimuGUI extends javax.swing.JFrame {
    private int memPrincipal;
    private int memSecundaria;
    private int nPagLibresPrincipal;
    private int nPagLibresSecundaria;
    private int nPagOcupadasPrincipal;
    private int nPagOcupadasSecundaria;
    private int nProcCreados;
    private int nProcSistema;
    private int nProcListos;
    private int nProcBloqueados;
    private int nProcListosSusp;   
    private int nProcBloqSusp;
    MemSimu simu;
    
    /** Creates new form SimuGUI */
    public SimuGUI(MemSimu sim) {
        this.simu=sim;
        initComponents();
    }

    public void setMemPrincipal(int memPrincipal) {
        this.memPrincipal = memPrincipal;
    }

    public void setMemSecundaria(int memSecundaria) {
        this.memSecundaria = memSecundaria;
    }

    public void setnPagLibresPrincipal(int nPagLibresPrincipal) {
        this.nPagLibresPrincipal = nPagLibresPrincipal;
    }

    public void setnPagLibresSecundaria(int nPagLibresSecundaria) {
        this.nPagLibresSecundaria = nPagLibresSecundaria;
    }

    public void setnPagOcupadasPrincipal(int nPagOcupadasPrincipal) {
        this.nPagOcupadasPrincipal = nPagOcupadasPrincipal;
    }

    public void setnPagOcupadasSecundaria(int nPagOcupadasSecundaria) {
        this.nPagOcupadasSecundaria = nPagOcupadasSecundaria;
    }

    public void setnProcBloqueados(int nProcBloqueados) {
        this.nProcBloqueados = nProcBloqueados;
    }

    public void setnProcCreados(int nProcCreados) {
        this.nProcCreados = nProcCreados;
    }

    public void setnProcListos(int nProcListos) {
        this.nProcListos = nProcListos;
    }

    public void setnProcSistema(int nProcSistema) {
        this.nProcSistema = nProcSistema;
    }

    public void setnProcBloqSusp(int nProcBloqSusp) {
        this.nProcBloqSusp = nProcBloqSusp;
    }

    public void setnProcListosSusp(int nProcListosSusp) {
        this.nProcListosSusp = nProcListosSusp;
    }

   
    public void actualiza()
    {
        jlMemPrincipal.setText(Integer.toString(memPrincipal));
        jlMemSecundaria.setText(Integer.toString(memSecundaria));
        jlNPagLibresPrincipal.setText(Integer.toString(nPagLibresPrincipal));
        jlNPagLibresSecundaria.setText(Integer.toString(nPagLibresSecundaria));
        jlNPagOcupadasPrincipal.setText(Integer.toString(nPagOcupadasPrincipal));
        jlNPagOcupadasSecundaria.setText(Integer.toString(nPagOcupadasSecundaria));
        jlNProcBloqueados.setText(Integer.toString(nProcBloqueados));
        jlNProcBloqSusp.setText(Integer.toString(nProcBloqSusp));
        jlNProcCreados.setText(Integer.toString(nProcCreados));
        jlNProcListos.setText(Integer.toString(nProcListos));
        jlNProcSistema.setText(Integer.toString(nProcSistema));
        jlNProcListosSusp.setText(Integer.toString(nProcListosSusp));
        jpProcesos.revalidate();
        repaint();
    }
    
    public void nuevoProceso(ProcesoGUI pgui)
    {
        jpProcesos.add(pgui);
        jpProcesos.revalidate();
    }
    
    public void eliminaProceso(ProcesoGUI pgui)
    {
        jpProcesos.remove(pgui);
        jpProcesos.revalidate();
        repaint();
    }

    public void actualizaProcesos()
    {
        Component []  comps=jpProcesos.getComponents();
        for(Component comp : comps)
        {
            ProcesoGUI p=(ProcesoGUI) comp;
            p.actualizaInfo();
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jsProcesos = new javax.swing.JScrollPane();
        jpProcesos = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jlNProcCreados = new javax.swing.JLabel();
        jlNPagLibresPrincipal = new javax.swing.JLabel();
        jlNPagOcupadasSecundaria = new javax.swing.JLabel();
        jlNPagOcupadasPrincipal = new javax.swing.JLabel();
        jlNProcSistema = new javax.swing.JLabel();
        jlNPagLibresSecundaria = new javax.swing.JLabel();
        jlMemPrincipal = new javax.swing.JLabel();
        jlMemSecundaria = new javax.swing.JLabel();
        jlNProcListosSusp = new javax.swing.JLabel();
        jlNProcBloqSusp = new javax.swing.JLabel();
        jlNProcBloqueados = new javax.swing.JLabel();
        jlNProcListos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador de Memoria Paginada");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Procesos"));

        jpProcesos.setLayout(new javax.swing.BoxLayout(jpProcesos, javax.swing.BoxLayout.Y_AXIS));
        jsProcesos.setViewportView(jpProcesos);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
            .addComponent(jsProcesos, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jsProcesos, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estadisticas"));

        jLabel1.setText("Procesos creados:");

        jLabel2.setText("Procesos en el sistema:");

        jLabel3.setText("Marcos de pagina disponibles (mem. principal):");

        jLabel4.setText("Marcos de pagina utilizados (mem. principal):");

        jLabel5.setText("Marcos de pagina utilizados (mem. secundaria):");

        jLabel6.setText("Marcos de pagina disponibles (mem. secundaria):");

        jLabel7.setText("Memoria principal disponible (KB):");

        jLabel8.setText("Memoria secundaria disponible (KB):");

        jLabel9.setText("Procesos bloqueados:");

        jLabel10.setText("Procesos listos/suspendidos:");

        jLabel11.setText("Procesos bloqueados/suspendidos:");

        jLabel12.setText("Procesos listos:");

        jlNProcCreados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNProcCreados.setText("000");

        jlNPagLibresPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNPagLibresPrincipal.setText("000");

        jlNPagOcupadasSecundaria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNPagOcupadasSecundaria.setText("000");

        jlNPagOcupadasPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNPagOcupadasPrincipal.setText("000");

        jlNProcSistema.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNProcSistema.setText("000");

        jlNPagLibresSecundaria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNPagLibresSecundaria.setText("000");

        jlMemPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlMemPrincipal.setText("000");

        jlMemSecundaria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlMemSecundaria.setText("000");

        jlNProcListosSusp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNProcListosSusp.setText("000");

        jlNProcBloqSusp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNProcBloqSusp.setText("000");

        jlNProcBloqueados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNProcBloqueados.setText("000");

        jlNProcListos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNProcListos.setText("000");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlNProcCreados, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlNPagOcupadasSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNPagOcupadasPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlMemPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlMemSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNProcListosSusp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNProcBloqSusp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNProcBloqueados, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNProcListos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jlNProcSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlNPagLibresSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlNPagLibresPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlNProcCreados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlNProcSistema)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlNPagLibresPrincipal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlNPagLibresSecundaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlNPagOcupadasPrincipal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlNPagOcupadasSecundaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlMemPrincipal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlMemSecundaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlNProcListos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlNProcBloqueados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlNProcListosSusp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlNProcBloqSusp)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        simu.nuevoProceso();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SimuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                //new SimuGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlMemPrincipal;
    private javax.swing.JLabel jlMemSecundaria;
    private javax.swing.JLabel jlNPagLibresPrincipal;
    private javax.swing.JLabel jlNPagLibresSecundaria;
    private javax.swing.JLabel jlNPagOcupadasPrincipal;
    private javax.swing.JLabel jlNPagOcupadasSecundaria;
    private javax.swing.JLabel jlNProcBloqSusp;
    private javax.swing.JLabel jlNProcBloqueados;
    private javax.swing.JLabel jlNProcCreados;
    private javax.swing.JLabel jlNProcListos;
    private javax.swing.JLabel jlNProcListosSusp;
    private javax.swing.JLabel jlNProcSistema;
    private javax.swing.JPanel jpProcesos;
    private javax.swing.JScrollPane jsProcesos;
    // End of variables declaration//GEN-END:variables
}
