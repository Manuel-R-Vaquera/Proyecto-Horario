
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

    public Horario() {
        initComponents();
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(36, 47, 65));
        setFilasLunes();

    }
    public void LimpiarTabla() {
        DefaultTableModel Tabla = (DefaultTableModel) this.TablaHorario.getModel();
        int a = this.TablaHorario.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            Tabla.removeRow(Tabla.getRowCount() - 1);
        }
        Tabla.removeTableModelListener(TablaHorario);
    }

    public void setFilasLunes() {
        Clase mClase;
        mConexion2.conectar();
        ArrayList mArrayList = new ArrayList();
        mArrayList = mConexion2.consultarClaseLunes();
        String[] Datos;

        modelo.addColumn("Hora");
        modelo.addColumn("Materia");
        modelo.addColumn("Maestro");
        modelo.addColumn("Aula");

        for (Object mClaseArrays : mArrayList) {
            Datos = new String[4];
            mClase = (Clase) mClaseArrays;
            Datos[0] = Integer.toString(mClase.getHora());
            Datos[1] = mClase.getMateria();
            Datos[2] = mClase.getMaestro();
            Datos[3] = mClase.getAula();

            modelo.addRow(Datos);
            modeloOrdenado = new TableRowSorter<TableModel>(modelo);
            modeloOrdenado.setRowFilter(RowFilter.regexFilter("^a", 0));
        }

        this.TablaHorario.setModel(modelo);
        this.TablaHorario.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.TablaHorario.getColumnModel().getColumn(1).setPreferredWidth(220);

        if (this.TablaHorario.getRowCount() > 0) {
            this.TablaHorario.setRowSelectionInterval(0, 0);
        }

    }

    public void setFilasMartes() {
        Clase mClase;
        mConexion2.conectar();
        ArrayList mArrayList = new ArrayList();
        mArrayList = mConexion2.consultarClaseMartes();
        String[] Datos;

        modelo.addColumn("Hora");
        modelo.addColumn("Materia");
        modelo.addColumn("Maestro");
        modelo.addColumn("Aula");

        for (Object mClaseArrays : mArrayList) {
            Datos = new String[4];
            mClase = (Clase) mClaseArrays;
            Datos[0] = Integer.toString(mClase.getHora());
            Datos[1] = mClase.getMateria();
            Datos[2] = mClase.getMaestro();
            Datos[3] = mClase.getAula();

            modelo.addRow(Datos);
            modeloOrdenado = new TableRowSorter<TableModel>(modelo);
            modeloOrdenado.setRowFilter(RowFilter.regexFilter("^a", 0));
        }

        this.TablaHorario.setModel(modelo);
        this.TablaHorario.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.TablaHorario.getColumnModel().getColumn(1).setPreferredWidth(220);

        if (this.TablaHorario.getRowCount() > 0) {
            this.TablaHorario.setRowSelectionInterval(0, 0);
        }

    }
    
    public void setFilasMiercoles() {
        Clase mClase;
        mConexion2.conectar();
        ArrayList mArrayList = new ArrayList();
        mArrayList = mConexion2.consultarClaseMiercoles();
        String[] Datos;

        modelo.addColumn("Hora");
        modelo.addColumn("Materia");
        modelo.addColumn("Maestro");
        modelo.addColumn("Aula");

        for (Object mClaseArrays : mArrayList) {
            Datos = new String[4];
            mClase = (Clase) mClaseArrays;
            Datos[0] = Integer.toString(mClase.getHora());
            Datos[1] = mClase.getMateria();
            Datos[2] = mClase.getMaestro();
            Datos[3] = mClase.getAula();

            modelo.addRow(Datos);
            modeloOrdenado = new TableRowSorter<TableModel>(modelo);
            modeloOrdenado.setRowFilter(RowFilter.regexFilter("^a", 0));
        }

        this.TablaHorario.setModel(modelo);
        this.TablaHorario.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.TablaHorario.getColumnModel().getColumn(1).setPreferredWidth(220);

        if (this.TablaHorario.getRowCount() > 0) {
            this.TablaHorario.setRowSelectionInterval(0, 0);
        }

    }
    
    public void setFilasJueves() {
        Clase mClase;
        mConexion2.conectar();
        ArrayList mArrayList = new ArrayList();
        mArrayList = mConexion2.consultarClaseJueves();
        String[] Datos;

        modelo.addColumn("Hora");
        modelo.addColumn("Materia");
        modelo.addColumn("Maestro");
        modelo.addColumn("Aula");

        for (Object mClaseArrays : mArrayList) {
            Datos = new String[4];
            mClase = (Clase) mClaseArrays;
            Datos[0] = Integer.toString(mClase.getHora());
            Datos[1] = mClase.getMateria();
            Datos[2] = mClase.getMaestro();
            Datos[3] = mClase.getAula();

            modelo.addRow(Datos);
            modeloOrdenado = new TableRowSorter<TableModel>(modelo);
            modeloOrdenado.setRowFilter(RowFilter.regexFilter("^a", 0));
        }

        this.TablaHorario.setModel(modelo);
        this.TablaHorario.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.TablaHorario.getColumnModel().getColumn(1).setPreferredWidth(220);

        if (this.TablaHorario.getRowCount() > 0) {
            this.TablaHorario.setRowSelectionInterval(0, 0);
        }

    }
    
    public void setFilasViernes() {
        Clase mClase;
        mConexion2.conectar();
        ArrayList mArrayList = new ArrayList();
        mArrayList = mConexion2.consultarClaseViernes();
        String[] Datos;

        modelo.addColumn("Hora");
        modelo.addColumn("Materia");
        modelo.addColumn("Maestro");
        modelo.addColumn("Aula");

        for (Object mClaseArrays : mArrayList) {
            Datos = new String[4];
            mClase = (Clase) mClaseArrays;
            Datos[0] = Integer.toString(mClase.getHora());
            Datos[1] = mClase.getMateria();
            Datos[2] = mClase.getMaestro();
            Datos[3] = mClase.getAula();

            modelo.addRow(Datos);
            modeloOrdenado = new TableRowSorter<TableModel>(modelo);
            modeloOrdenado.setRowFilter(RowFilter.regexFilter("^a", 0));
        }

        this.TablaHorario.setModel(modelo);
        this.TablaHorario.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.TablaHorario.getColumnModel().getColumn(1).setPreferredWidth(220);

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
                .addContainerGap(255, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnMartes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnMiercoles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnJueves, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnViernes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnLunes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(BtnSalir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMartesActionPerformed
        LimpiarTabla();
        setFilasMartes();
    }//GEN-LAST:event_BtnMartesActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        // TODO add your handling code here:
        this.hide();
        MenuInicio mMI = new MenuInicio();
        mMI.show();
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void BtnLunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLunesActionPerformed
        LimpiarTabla();
        setFilasLunes();
    }//GEN-LAST:event_BtnLunesActionPerformed

    private void BtnMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMiercolesActionPerformed
        LimpiarTabla();
        setFilasMiercoles();
    }//GEN-LAST:event_BtnMiercolesActionPerformed

    private void BtnJuevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnJuevesActionPerformed
        LimpiarTabla();
        setFilasJueves();
    }//GEN-LAST:event_BtnJuevesActionPerformed

    private void BtnViernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnViernesActionPerformed
        LimpiarTabla();
        setFilasViernes();
    }//GEN-LAST:event_BtnViernesActionPerformed

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
    private javax.swing.JButton BtnLunes;
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
