
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
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
 * @author manzana
 */
public class AgregarClase extends javax.swing.JFrame {

    public TableRowSorter<TableModel> modeloOrdenado;
    DefaultTableModel modelo = new DefaultTableModel();

    Conexion mConexion = new Conexion();
    Conexion2 mConexion2 = new Conexion2();
    Clase mClase = new Clase();
    int VHora = 1;

    public AgregarClase() {
        initComponents();
        mConexion.conectar();
        mConexion.CargarMateria(CBMateria);
        mConexion.CargarAula(CBAula);
        mConexion.CargarMaestros(CBMaestro);
        this.CBMateria.add(new JSeparator(SwingConstants.VERTICAL));
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(36, 47, 65));

        setFilasTodas();

    }

    public void setFilasTodas() {
        Clase mClase;
        mConexion2.conectar();
        ArrayList mArrayList = new ArrayList();
        mArrayList = mConexion2.consultarClaseTodas();
        String[] Datos;

        modelo.addColumn("Hora");
        modelo.addColumn("Dia");
        modelo.addColumn("Materia");
        modelo.addColumn("Maestro");
        modelo.addColumn("Aula");

        for (Object mClaseArrays : mArrayList) {
            Datos = new String[5];
            mClase = (Clase) mClaseArrays;
            Datos[0] = Integer.toString(mClase.getHora());
            Datos[1] = mClase.getDia();
            Datos[2] = mClase.getMateria();
            Datos[3] = mClase.getMaestro();
            Datos[4] = mClase.getAula();

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

    public void LimpiarTabla() {
        DefaultTableModel Tabla = (DefaultTableModel) this.TablaHorario.getModel();
        int a = this.TablaHorario.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            Tabla.removeRow(Tabla.getRowCount() - 1);
        }
        Tabla.removeTableModelListener(TablaHorario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CBMateria = new javax.swing.JComboBox<>();
        CBAula = new javax.swing.JComboBox<>();
        CBMaestro = new javax.swing.JComboBox<>();
        CBDia = new javax.swing.JComboBox<>();
        CBHora = new javax.swing.JComboBox<>();
        BtnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaHorario = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Materia");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Maestro");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Aula");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dia");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hora");

        CBDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes" }));

        CBHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17" }));

        BtnGuardar.setBackground(new java.awt.Color(97, 212, 195));
        BtnGuardar.setText("Guardar");
        BtnGuardar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

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

        jButton1.setBackground(new java.awt.Color(97, 212, 195));
        jButton1.setText("Salir");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CBMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CBMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CBAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CBDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CBHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(BtnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        if (this.CBMaestro.getSelectedItem() == "Seleccione un Maestro") {
            JOptionPane.showMessageDialog(rootPane, "Asegurese de llenar todos los campos");
        } else {

            mClase.setMaestro(this.CBMaestro.getSelectedItem().toString());
            mClase.setAula(this.CBAula.getSelectedItem().toString());
            mClase.setMateria(this.CBMateria.getSelectedItem().toString());
            mClase.setDia(this.CBDia.getSelectedItem().toString());
            mClase.setHora(Integer.parseInt(this.CBHora.getSelectedItem().toString()));

            if (mConexion.conectar()) {
                if (this.CBDia.getSelectedItem().toString() == "Lunes") {
                    switch (mConexion.GuardarClaseLunes(mClase)) {
                        case 1:
                            JOptionPane.showMessageDialog(rootPane, "Clase Guardada con Exito");
                            LimpiarTabla();
                            setFilasTodas();
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(rootPane, "Ya hay una clase asignada en esta HORA y a esta AULA");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(rootPane, "ERROR");
                            break;
                    }

                    /*if (mConexion.GuardarClaseLunes(mClase)== 1) {
                        JOptionPane.showMessageDialog(rootPane, "Clase Guardada con Exito");
                    }
                    if (mConexion.GuardarClaseLunes(mClase)== 2) {
                        JOptionPane.showMessageDialog(rootPane, "Ya hay una clase asignada en esta hora");
                    }*/
                }
                if (this.CBDia.getSelectedItem().toString() == "Martes") {
                    switch (mConexion.GuardarClaseMartes(mClase)) {
                        case 1:
                            JOptionPane.showMessageDialog(rootPane, "Clase Guardada con Exito");
                            LimpiarTabla();
                            setFilasTodas();
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(rootPane, "Ya hay una clase asignada en esta HORA y a esta AULA");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(rootPane, "ERROR");
                            break;
                    }

                    /*if (mConexion.GuardarClaseMartes(mClase)) {
                        JOptionPane.showMessageDialog(rootPane, "Clase Guardada con Exito");
                    }*/
                }
                if (this.CBDia.getSelectedItem().toString() == "Miercoles") {
                    switch (mConexion.GuardarClaseMiercoles(mClase)) {
                        case 1:
                            JOptionPane.showMessageDialog(rootPane, "Clase Guardada con Exito");
                            LimpiarTabla();
                            setFilasTodas();
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(rootPane, "Ya hay una clase asignada en esta HORA y a esta AULA");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(rootPane, "ERROR");
                            break;
                    }
                }
                if (this.CBDia.getSelectedItem().toString() == "Jueves") {
                    switch (mConexion.GuardarClaseJueves(mClase)) {
                        case 1:
                            JOptionPane.showMessageDialog(rootPane, "Clase Guardada con Exito");
                            LimpiarTabla();
                            setFilasTodas();
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(rootPane, "Ya hay una clase asignada en esta HORA y a esta AULA");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(rootPane, "ERROR");
                            break;
                    }
                }
                if (this.CBDia.getSelectedItem().toString() == "Viernes") {
                    switch (mConexion.GuardarClaseViernes(mClase)) {
                        case 1:
                            JOptionPane.showMessageDialog(rootPane, "Clase Guardada con Exito");
                            LimpiarTabla();
                            setFilasTodas();
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(rootPane, "Ya hay una clase asignada en esta HORA y a esta AULA");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(rootPane, "ERROR");
                            break;
                    }
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Error al conectar");
            }

            /*if (Integer.parseInt(this.CBHora.getSelectedItem().toString()) ==  ) {
                JOptionPane.showMessageDialog(rootPane, "Iguales");
            }*/
        }
        LimpiarTabla();
        setFilasTodas();

    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.hide();
        MenuInicio mMI = new MenuInicio();
        mMI.show();
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
            java.util.logging.Logger.getLogger(AgregarClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarClase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JComboBox<String> CBAula;
    private javax.swing.JComboBox<String> CBDia;
    private javax.swing.JComboBox<String> CBHora;
    private javax.swing.JComboBox<String> CBMaestro;
    private javax.swing.JComboBox<String> CBMateria;
    private javax.swing.JTable TablaHorario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
