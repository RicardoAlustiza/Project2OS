/*
 * TraducirGUI.java
 *
 * Contiene la interfase de usuario para traducir direcciones logicas de memoria
 * a direcciones fisicas de memoria para los procesos activos
 */
package memsimu.GUI;

import javax.swing.JOptionPane;
import memsimu.MemSimu;
import memsimu.Proceso;

/**
 *
 * @author Ivan Arno y Ricardo Alustiza
 */
public class TraducirGUI extends javax.swing.JDialog {
    int bitsDesp;
    int bitsPagina;
    int procID;
    int tamDirLogica;
    int procPaginas;
    MemSimu sim;
    /** Creates new form TraducirGUI */
    public TraducirGUI(java.awt.Frame parent, boolean modal,MemSimu sim) {
        super(parent, modal);
        this.sim=sim;
        initComponents();
        pack();
        setLocationRelativeTo(null);                
    }
    
    public void actualizaInfo()
    {
        jlBitsDesp.setText(Integer.toString(bitsDesp));
        jlBitsPagina.setText(Integer.toString(bitsPagina));
        jlProcID.setText(Integer.toString(procID));
        jlProcPaginas.setText(Integer.toString(procPaginas));
        jlTamDirLogica.setText(Integer.toString(tamDirLogica));
        String bitstr="";
        for(int i=0; i<tamDirLogica; i++)
            bitstr+='0';
        jtDirLogica.setText(bitstr);
        jtDirFisica.setText(bitstr);
        bitstr="";
        for(int i=0; i<tamDirLogica/4; i++)
            bitstr+='0';
        if(tamDirLogica%4!=0)
            bitstr+='0';
        jtDirFisicaHex.setText(bitstr);      
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
        jlProcPaginas = new javax.swing.JLabel();
        jlBitsDesp = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlTamDirLogica = new javax.swing.JLabel();
        jlBitsPagina = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlProcID = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jtDirLogica = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtDirFisica = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtDirFisicaHex = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Traducir direcciones");
        setModal(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Info"));

        jlProcPaginas.setText("0000");

        jlBitsDesp.setText("0000");

        jLabel7.setText("Bits necesarios para pagina:");

        jLabel3.setText("Paginas:");

        jLabel9.setText("Bits necesarios para desplazamiento:");

        jLabel5.setText("Tamaño de direccion logica:");

        jlTamDirLogica.setText("0000");

        jlBitsPagina.setText("0000");

        jLabel1.setText("Proceso:");

        jlProcID.setText("XXXX");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlProcPaginas)
                    .addComponent(jlProcID)
                    .addComponent(jlTamDirLogica)
                    .addComponent(jlBitsPagina)
                    .addComponent(jlBitsDesp))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlProcID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlProcPaginas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlTamDirLogica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlBitsPagina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlBitsDesp))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addContainerGap())
        );

        jButton1.setText("Traducir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtDirLogica.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtDirLogica.setText("0");
        jtDirLogica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDirLogicaActionPerformed(evt);
            }
        });

        jLabel11.setText("Direccion logica en binario:");

        jLabel12.setText("Direccion fisica en binario:");

        jtDirFisica.setEditable(false);
        jtDirFisica.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtDirFisica.setText("0");

        jLabel13.setText("Direccion fisica en hexadecimal:");

        jtDirFisicaHex.setEditable(false);
        jtDirFisicaHex.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtDirFisicaHex.setText("0");

        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtDirLogica, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                        .addComponent(jtDirFisicaHex, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtDirFisica, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDirLogica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDirFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jtDirFisicaHex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean validaBinario(String bin)
    {
        for(int i=0; i<bin.length(); i++)
            if(bin.charAt(i)!='0' && bin.charAt(i)!='1')
                return false;
        return true;
    }
    
    private String enteroABinario(int entero,int nbits)
    {
        String bin="";
        for(int i=0; i<nbits; i++)
        {
            int bit=entero&1;
            bin = (char)(bit+'0')+ bin;
            entero=entero>>1;
        }            
        return bin;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String binstr=jtDirLogica.getText();
        Proceso proc=sim.getProceso(procID);
        if(validaBinario(binstr))
        {
            if(binstr.length()!=tamDirLogica)
                JOptionPane.showMessageDialog(this,
                        "El numero debe ser de "+tamDirLogica+" bits",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);            
            else
            {
                int pagina=Integer.parseInt(binstr.substring(0,bitsPagina), 2);                
                if(pagina>=procPaginas)
                    JOptionPane.showMessageDialog(this,
                            "El numero de pagina debe estar entre 0 y "+(procPaginas-1),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);            
                else {
                    int marco=proc.paginas.get(pagina).getnMarco();
                    int desp=Integer.parseInt(binstr.substring(bitsPagina), 2);                
                    int direccionFisica = (marco << sim.getBitsDesplazamiento()) | desp; // < no es una suma, sino una concatenacion...
                    jtDirFisica.setText(enteroABinario(direccionFisica, tamDirLogica));
                    jtDirFisicaHex.setText(Integer.toString(direccionFisica, 16));
                    if(!proc.paginas.get(pagina).isDisponible())
                        JOptionPane.showMessageDialog(this,
                                "La pagina correspondiente a la direccion logica\nesta en memoria secundaria.",
                                "Informacion",
                                JOptionPane.INFORMATION_MESSAGE);                                    
                }
            }                                
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "El numero introducido no es un numero binario valido.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtDirLogicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDirLogicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDirLogicaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlBitsDesp;
    private javax.swing.JLabel jlBitsPagina;
    private javax.swing.JLabel jlProcID;
    private javax.swing.JLabel jlProcPaginas;
    private javax.swing.JLabel jlTamDirLogica;
    private javax.swing.JTextField jtDirFisica;
    private javax.swing.JTextField jtDirFisicaHex;
    private javax.swing.JTextField jtDirLogica;
    // End of variables declaration//GEN-END:variables
}
