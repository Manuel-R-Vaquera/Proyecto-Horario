import java.awt.event.KeyEvent;
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
 * @author Aaron
 */
public class ModificarMateria extends javax.swing.JFrame {

    /**
     * Creates new form ModificarMateria
     */
    Conexion mConexion = new Conexion();
    public TableRowSorter<TableModel> modeloOrdenado;
    DefaultTableModel modelo = new DefaultTableModel();
    Materia mMateria = new Materia();

    public ModificarMateria() {
        initComponents();
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(36, 47, 65));
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

        BtnAceptar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TXTnombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TXTcarrera = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaMateria = new javax.swing.JTable();
        BTNborrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        IdText = new javax.swing.JLabel();
        BTNsair = new javax.swing.JButton();
        CBGrado = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        CBGrupo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar Materia");

        BtnAceptar.setBackground(new java.awt.Color(97, 212, 195));
        BtnAceptar.setText("Aceptar");
        BtnAceptar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(97, 212, 195));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/materia.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel8)
                .addGap(39, 39, 39)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("_____________________________________");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");

        TXTnombre.setBackground(new java.awt.Color(36, 47, 65));
        TXTnombre.setForeground(new java.awt.Color(255, 255, 255));
        TXTnombre.setBorder(null);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("_____________________________________");
        jLabel9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabel9KeyTyped(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Carrera:");

        TXTcarrera.setBackground(new java.awt.Color(36, 47, 65));
        TXTcarrera.setForeground(new java.awt.Color(255, 255, 255));
        TXTcarrera.setBorder(null);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Grado:");

        TablaMateria.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaMateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMateriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaMateria);

        BTNborrar.setBackground(new java.awt.Color(97, 212, 195));
        BTNborrar.setText("Eliminar");
        BTNborrar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BTNborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNborrarActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID");

        IdText.setForeground(new java.awt.Color(255, 255, 255));

        BTNsair.setBackground(new java.awt.Color(97, 212, 195));
        BTNsair.setText("Salir");
        BTNsair.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BTNsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNsairActionPerformed(evt);
            }
        });

        CBGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Grupo");

        CBGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));
        CBGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BTNborrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BTNsair, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(TXTnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(TXTcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(IdText)))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(CBGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(CBGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(IdText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CBGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAceptar)
                            .addComponent(BTNborrar)
                            .addComponent(BTNsair)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CBGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarActionPerformed
        Materia nMateria = new Materia();
            
                if(this.TXTnombre.getText().isEmpty())
                {
                        JOptionPane.showMessageDialog(rootPane, "No Ha Seleccionado Ningún Maestro");
                }
                else
                {
                    mMateria.setID_Materia(this.IdText.getText());
                    nMateria.setID_Materia(this.IdText.getText());
                    nMateria.setNombre_Materia(this.TXTnombre.getText());
                    nMateria.setCarrera(this.TXTcarrera.getText());
                    nMateria.setGrupo(this.CBGrupo.getSelectedItem().toString());
                    nMateria.setGrado(Integer.parseInt(this.CBGrado.getSelectedItem().toString()));
                    
                    if(mConexion.conectar())
                        if(mConexion.modificarMateria(mMateria, nMateria))
                        {
                            JOptionPane.showMessageDialog(rootPane, "Materia Modificado Con Éxito");
                            modelo.setColumnCount(0);
                            modelo.setRowCount(0);
                            setFilas();
                        }
                        else
                        {
                           JOptionPane.showMessageDialog(rootPane, "Error al Modificar"); 
                        }
                }
                this.IdText.setText(null);
                this.TXTnombre.setText(null);
                this.TXTcarrera.setText(null);
                this.CBGrado.setSelectedItem(null);
                
    }//GEN-LAST:event_BtnAceptarActionPerformed

    private void BTNsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNsairActionPerformed
        // TODO add your handling code here:
        this.hide();
        MenuMaterias mMA = new MenuMaterias();
        mMA.show();
    }//GEN-LAST:event_BTNsairActionPerformed

    private void TablaMateriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMateriaMouseClicked
        int rec = this.TablaMateria.getSelectedRow();
        this.TXTnombre.setText(TablaMateria.getValueAt(rec, 1).toString());
        //this.CBGrado.setSelectedItem(Integer.parseInt(this.CBGrado.getSelectedItem().toString()));
        //this.CBGrupo.setSelectedItem(this.CBGrupo.getSelectedItem().toString());
        this.TXTcarrera.setText(TablaMateria.getValueAt(rec, 4).toString());
        this.IdText.setText(TablaMateria.getValueAt(rec, 0).toString());
        
    }//GEN-LAST:event_TablaMateriaMouseClicked

    private void BTNborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNborrarActionPerformed
        if (this.TXTnombre.getText().isEmpty() || this.TXTcarrera.getText().isEmpty() || this.IdText.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "No Ha Seleccionado Ningúna Materia");
        } else {
            String nl = System.getProperty("line.separator");

            if (JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar esta materia?"+ nl + "Se eliminaran las clases asignadas a esta materia en el Horario", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)==0) {
                mMateria.setID_Materia(this.IdText.getText());
                if (mConexion.conectar()) {
                    if (mConexion.eliminarMateria(mMateria)) {
                        JOptionPane.showMessageDialog(rootPane, "Materia Eliminada con Éxito");
                        modelo.setColumnCount(0);
                        modelo.setRowCount(0);
                        setFilas();
                    }
                }  
            }
            
        }
        this.IdText.setText(null);
        this.TXTnombre.setText(null);
        this.CBGrado.setSelectedItem(null);
        this.TXTcarrera.setText(null);
    }//GEN-LAST:event_BTNborrarActionPerformed

    private void jLabel9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel9KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9KeyTyped

    private void CBGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBGrupoActionPerformed

    public void setFilas() {
        Materia mMateria;
        mConexion.conectar();
        ArrayList mArrayList = new ArrayList();
        mArrayList = mConexion.consultarMateria();
        String[] Datos;

        modelo.addColumn("ID Materia");
        modelo.addColumn("Nombre");
        modelo.addColumn("Grado");
        modelo.addColumn("Grupo");
        modelo.addColumn("Carrera");

        for (Object mMateriaArrays : mArrayList) {
            Datos = new String[5];
            mMateria = (Materia) mMateriaArrays;
            Datos[0] = mMateria.getID_Materia();
            Datos[1] = mMateria.getNombre_Materia();
            Datos[2] = Integer.toString(mMateria.getGrado());
            Datos[3] = mMateria.getGrupo();
            Datos[4] = mMateria.getCarrera();

            modelo.addRow(Datos);
            modeloOrdenado = new TableRowSorter<TableModel>(modelo);
            modeloOrdenado.setRowFilter(RowFilter.regexFilter("^a", 0));
        }

        this.TablaMateria.setModel(modelo);
        this.TablaMateria.getColumnModel().getColumn(0);
        this.TablaMateria.getColumnModel().getColumn(1).setPreferredWidth(220);

        if (this.TablaMateria.getRowCount() > 0) {
            this.TablaMateria.setRowSelectionInterval(0, 0);
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
            java.util.logging.Logger.getLogger(ModificarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarMateria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNborrar;
    private javax.swing.JButton BTNsair;
    private javax.swing.JButton BtnAceptar;
    private javax.swing.JComboBox<String> CBGrado;
    private javax.swing.JComboBox<String> CBGrupo;
    private javax.swing.JLabel IdText;
    private javax.swing.JTextField TXTcarrera;
    private javax.swing.JTextField TXTnombre;
    private javax.swing.JTable TablaMateria;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
