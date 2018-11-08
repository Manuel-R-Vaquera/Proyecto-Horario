
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author manzana
 */
public class Horario extends javax.swing.JFrame {

    Clase mClase = new Clase();
    Conexion2 mConexion2 = new Conexion2();
    public TableRowSorter<TableModel> modeloOrdenado;
    DefaultTableModel modelo = new DefaultTableModel();
    
    String DiaSel = "";
    String AulaSel = "";

    public Horario() {
        initComponents();
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(36, 47, 65));

    }
    public void LimpiarTabla() {
        this.TablaHorario.setModel(new DefaultTableModel());
        /*
        DefaultTableModel Tabla = (DefaultTableModel) this.TablaHorario.getModel();
        int a = this.TablaHorario.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            Tabla.removeRow(Tabla.getRowCount() - 1);
        }
        Tabla.removeTableModelListener(TablaHorario);*/
    }

    public void setFilasDia() {
        Clase mClase;
        mConexion2.conectar();
        ArrayList mArrayList = new ArrayList();
        mArrayList = mConexion2.consultarClasePorDia(DiaSel);
        String[] Datos;

        modelo = new DefaultTableModel();
        modelo.addColumn("Hora");
        modelo.addColumn("Materia");
        modelo.addColumn("Maestro");
        modelo.addColumn("Aula");
        modelo.addColumn("Grado");
        modelo.addColumn("Grupo");
        modelo.addColumn("Carrera");

        for (Object mClaseArrays : mArrayList) {
            Datos = new String[7];
            mClase = (Clase) mClaseArrays;
            Datos[0] = Integer.toString(mClase.getHora());
            Datos[1] = mClase.getMateria();
            Datos[2] = mClase.getMaestro();
            Datos[3] = mClase.getAula();
            Datos[4] = Integer.toString(mClase.getGrado());
            Datos[5] = mClase.getGrupo();
            Datos[6] = mClase.getCarrera();
            

            modelo.addRow(Datos);
            modeloOrdenado = new TableRowSorter<TableModel>(modelo);
            modeloOrdenado.setRowFilter(RowFilter.regexFilter("^a", 0));
        }

        this.TablaHorario.setModel(modelo);
        this.TablaHorario.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.TablaHorario.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.TablaHorario.getColumnModel().getColumn(2).setPreferredWidth(40);
        this.TablaHorario.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.TablaHorario.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.TablaHorario.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.TablaHorario.getColumnModel().getColumn(6).setPreferredWidth(10);

        if (this.TablaHorario.getRowCount() > 0) {
            this.TablaHorario.setRowSelectionInterval(0, 0);
        }

    }
    
    public void setFilasAula() {
        Clase mClase;
        mConexion2.conectar();
        ArrayList mArrayList = new ArrayList();
        mArrayList = mConexion2.consultarClasePorAula(AulaSel);
        String[] Datos;

        modelo = new DefaultTableModel();
        modelo.addColumn("Hora");
        modelo.addColumn("Materia");
        modelo.addColumn("Maestro");
        modelo.addColumn("Dia");
        modelo.addColumn("Grado");
        modelo.addColumn("Grupo");
        modelo.addColumn("Carrera");

        for (Object mClaseArrays : mArrayList) {
            Datos = new String[7];
            mClase = (Clase) mClaseArrays;
            Datos[0] = Integer.toString(mClase.getHora());
            Datos[1] = mClase.getMateria();
            Datos[2] = mClase.getMaestro();
            Datos[3] = mClase.getDia();
            Datos[4] = Integer.toString(mClase.getGrado());
            Datos[5] = mClase.getGrupo();
            Datos[6] = mClase.getCarrera();
            

            modelo.addRow(Datos);
            modeloOrdenado = new TableRowSorter<TableModel>(modelo);
            modeloOrdenado.setRowFilter(RowFilter.regexFilter("^a", 0));
        }

        this.TablaHorario.setModel(modelo);
        this.TablaHorario.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.TablaHorario.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.TablaHorario.getColumnModel().getColumn(2).setPreferredWidth(40);
        this.TablaHorario.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.TablaHorario.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.TablaHorario.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.TablaHorario.getColumnModel().getColumn(6).setPreferredWidth(10);

        if (this.TablaHorario.getRowCount() > 0) {
            this.TablaHorario.setRowSelectionInterval(0, 0);
        }

    }

    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaHorario = new javax.swing.JTable();
        BtnLunes = new javax.swing.JButton();
        BtnMartes = new javax.swing.JButton();
        BtnMiercoles = new javax.swing.JButton();
        BtnJueves = new javax.swing.JButton();
        BtnViernes = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BtnMac = new javax.swing.JButton();
        BtnLabsol = new javax.swing.JButton();
        BtnLab1 = new javax.swing.JButton();
        BtnLab2 = new javax.swing.JButton();
        BtnLab3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaHorario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaHorario);

        BtnLunes.setBackground(new java.awt.Color(97, 212, 195));
        BtnLunes.setText("Lunes");
        BtnLunes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnLunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLunesActionPerformed(evt);
            }
        });

        BtnMartes.setBackground(new java.awt.Color(97, 212, 195));
        BtnMartes.setText("Martes");
        BtnMartes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnMartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMartesActionPerformed(evt);
            }
        });

        BtnMiercoles.setBackground(new java.awt.Color(97, 212, 195));
        BtnMiercoles.setText("Miercoles");
        BtnMiercoles.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnMiercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMiercolesActionPerformed(evt);
            }
        });

        BtnJueves.setBackground(new java.awt.Color(97, 212, 195));
        BtnJueves.setText("Jueves");
        BtnJueves.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnJueves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnJuevesActionPerformed(evt);
            }
        });

        BtnViernes.setBackground(new java.awt.Color(97, 212, 195));
        BtnViernes.setText("Viernes");
        BtnViernes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnViernes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnViernesActionPerformed(evt);
            }
        });

        BtnSalir.setBackground(new java.awt.Color(97, 212, 195));
        BtnSalir.setText("Salir");
        BtnSalir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(97, 212, 195));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/horario.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel3)
                .addContainerGap(261, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(81, 81, 81))
        );

        BtnMac.setBackground(new java.awt.Color(97, 212, 195));
        BtnMac.setText("MAC");
        BtnMac.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnMac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMacActionPerformed(evt);
            }
        });

        BtnLabsol.setBackground(new java.awt.Color(97, 212, 195));
        BtnLabsol.setText("LABSOL");
        BtnLabsol.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnLabsol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLabsolActionPerformed(evt);
            }
        });

        BtnLab1.setBackground(new java.awt.Color(97, 212, 195));
        BtnLab1.setText("Lab1");
        BtnLab1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnLab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLab1ActionPerformed(evt);
            }
        });

        BtnLab2.setBackground(new java.awt.Color(97, 212, 195));
        BtnLab2.setText("Lab2");
        BtnLab2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnLab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLab2ActionPerformed(evt);
            }
        });

        BtnLab3.setBackground(new java.awt.Color(97, 212, 195));
        BtnLab3.setText("Lab3");
        BtnLab3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnLab3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLab3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnMartes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnMiercoles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnJueves, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnViernes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnLunes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnLabsol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnLab1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnLab2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnLab3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnMac, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(BtnLunes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnMartes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnMiercoles)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnJueves)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnViernes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnSalir))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(BtnMac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnLabsol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnLab1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnLab2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnLab3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMartesActionPerformed
        DiaSel = "Martes";
        LimpiarTabla();
        setFilasDia();
    }//GEN-LAST:event_BtnMartesActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        // TODO add your handling code here:
        this.hide();
        MenuInicio mMI = new MenuInicio();
        mMI.show();
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void BtnLunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLunesActionPerformed
        DiaSel = "Lunes";
        LimpiarTabla();
        setFilasDia();
    }//GEN-LAST:event_BtnLunesActionPerformed

    private void BtnMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMiercolesActionPerformed
        DiaSel = "Miercoles";
        LimpiarTabla();
        setFilasDia();
    }//GEN-LAST:event_BtnMiercolesActionPerformed

    private void BtnJuevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnJuevesActionPerformed
        DiaSel = "Jueves";
        LimpiarTabla();
        setFilasDia();
    }//GEN-LAST:event_BtnJuevesActionPerformed

    private void BtnViernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnViernesActionPerformed
        DiaSel = "Viernes";
        LimpiarTabla();
        setFilasDia();
    }//GEN-LAST:event_BtnViernesActionPerformed

    private void BtnMacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMacActionPerformed
        AulaSel = "MAC";
        LimpiarTabla();
        setFilasAula();
    }//GEN-LAST:event_BtnMacActionPerformed

    private void BtnLabsolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLabsolActionPerformed
        AulaSel = "LABSOL";
        LimpiarTabla();
        setFilasAula();
    }//GEN-LAST:event_BtnLabsolActionPerformed

    private void BtnLab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLab1ActionPerformed
        AulaSel = "Lab1";
        LimpiarTabla();
        setFilasAula();
    }//GEN-LAST:event_BtnLab1ActionPerformed

    private void BtnLab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLab2ActionPerformed
        AulaSel = "Lab2";
        LimpiarTabla();
        setFilasAula();
    }//GEN-LAST:event_BtnLab2ActionPerformed

    private void BtnLab3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLab3ActionPerformed
        AulaSel = "Lab3";
        LimpiarTabla();
        setFilasAula();
    }//GEN-LAST:event_BtnLab3ActionPerformed

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
            java.util.logging.Logger.getLogger(Horario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Horario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Horario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Horario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Horario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnJueves;
    private javax.swing.JButton BtnLab1;
    private javax.swing.JButton BtnLab2;
    private javax.swing.JButton BtnLab3;
    private javax.swing.JButton BtnLabsol;
    private javax.swing.JButton BtnLunes;
    private javax.swing.JButton BtnMac;
    private javax.swing.JButton BtnMartes;
    private javax.swing.JButton BtnMiercoles;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JButton BtnViernes;
    private javax.swing.JTable TablaHorario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
