
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manzana
 */
public class ModificarMaestro extends javax.swing.JFrame {
    
        Maestro mMaestro = new Maestro();
        Conexion mConexion = new Conexion();
        public TableRowSorter<TableModel> modeloOrdenado;
        DefaultTableModel modelo = new DefaultTableModel();

    /**
     * Creates new form ModificarMaestro
     */
    public ModificarMaestro() {
        initComponents();
         this.setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(36,47,65));
        setFilas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BTNaceptar = new javax.swing.JButton();
        BTNsalir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TXTnuevonombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaMaestros = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        IdText = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar Maestro");

        jPanel1.setBackground(new java.awt.Color(97, 212, 195));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/maestro.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel1)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        BTNaceptar.setBackground(new java.awt.Color(97, 212, 195));
        BTNaceptar.setText("Aceptar");
        BTNaceptar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BTNaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNaceptarActionPerformed(evt);
            }
        });

        BTNsalir.setBackground(new java.awt.Color(97, 212, 195));
        BTNsalir.setText("Salir");
        BTNsalir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BTNsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNsalirActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("_____________________________________");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nuevo Nombre");

        TXTnuevonombre.setBackground(new java.awt.Color(36, 47, 65));
        TXTnuevonombre.setForeground(new java.awt.Color(255, 255, 255));
        TXTnuevonombre.setBorder(null);

        TablaMaestros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaMaestros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMaestrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaMaestros);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID");

        IdText.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(BTNaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(BTNsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel7)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                .addComponent(TXTnuevonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(IdText))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton1)))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IdText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TXTnuevonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTNaceptar)
                    .addComponent(BTNsalir))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNaceptarActionPerformed

            Maestro nMaestro = new Maestro();
            
                if(this.TXTnuevonombre.getText().isEmpty())
                {
                        JOptionPane.showMessageDialog(rootPane, "No Ha Seleccionado Ningún Maestro");
                }
                else
                {
                    mMaestro.setID_Maestro(this.IdText.getText());
                    nMaestro.setNombre_Maestro(this.TXTnuevonombre.getText());
                    
                    if(mConexion.conectar())
                        if(mConexion.modificarMaestro(mMaestro, nMaestro))
                        {
                            JOptionPane.showMessageDialog(rootPane, "Maestro Modificado Con Éxito");
                            modelo.setColumnCount(0);
                            modelo.setRowCount(0);
                            setFilas();
                        }
                        else
                        {
                           JOptionPane.showMessageDialog(rootPane, "Error al Modificar"); 
                        }
                }
                this.TXTnuevonombre.setText(null);
                
          
    }//GEN-LAST:event_BTNaceptarActionPerformed

    private void TablaMaestrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMaestrosMouseClicked
        int rec = this.TablaMaestros.getSelectedRow();
        this.TXTnuevonombre.setText(TablaMaestros.getValueAt(rec, 1).toString());
        this.IdText.setText(TablaMaestros.getValueAt(rec, 0).toString());
    }//GEN-LAST:event_TablaMaestrosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.TXTnuevonombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "No Ha Seleccionado Ningún Maestro");
        } else {
            mMaestro.setID_Maestro(this.IdText.getText());
                if (mConexion.conectar()) {
                    if (mConexion.eliminarMaestro(mMaestro)) {
                    JOptionPane.showMessageDialog(rootPane, "Maestro Eliminado con Éxito");
                    modelo.setColumnCount(0);
                    modelo.setRowCount(0);
                    setFilas();
                    }
                }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BTNsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNsalirActionPerformed
          this.hide();
        MenuMaestro mMM = new MenuMaestro();
        mMM.show();
    }//GEN-LAST:event_BTNsalirActionPerformed

    public void setFilas() {
        Maestro mMaestro;
        mConexion.conectar();
        ArrayList mArrayList = new ArrayList();
        mArrayList = mConexion.consultarMaestro();
        String[] Datos;

        modelo.addColumn("ID Maestro");
        modelo.addColumn("Nombre");

        for (Object mMaestroArrays : mArrayList) {
            Datos = new String[2];
            mMaestro = (Maestro) mMaestroArrays;
            Datos[0] = mMaestro.getID_Maestro();
            Datos[1] = mMaestro.getNombre_Maestro();

            modelo.addRow(Datos);
            modeloOrdenado = new TableRowSorter<TableModel>(modelo);
            modeloOrdenado.setRowFilter(RowFilter.regexFilter("^a", 0));
        }

        this.TablaMaestros.setModel(modelo);
        this.TablaMaestros.getColumnModel().getColumn(0);
        this.TablaMaestros.getColumnModel().getColumn(1).setPreferredWidth(220);

        if (this.TablaMaestros.getRowCount() > 0) {
            this.TablaMaestros.setRowSelectionInterval(0, 0);
        }

    }
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
            java.util.logging.Logger.getLogger(ModificarMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarMaestro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNaceptar;
    private javax.swing.JButton BTNsalir;
    private javax.swing.JLabel IdText;
    private javax.swing.JTextField TXTnuevonombre;
    private javax.swing.JTable TablaMaestros;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
