
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
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
    Conexion mConexion = new Conexion();
    Conexion2 mConexion2 = new Conexion2();
    public TableRowSorter<TableModel> modeloOrdenado;
    ArrayList<String> Hora = new ArrayList();
    ArrayList<String> Materia = new ArrayList();
    ArrayList<String> Maestro = new ArrayList();
    ArrayList<String> Aula = new ArrayList();
    ArrayList<String> Grado = new ArrayList();
    ArrayList<String> Grupo = new ArrayList();
    ArrayList<String> Carrera = new ArrayList();
    ArrayList<String> Disponible = new ArrayList();
    ArrayList<String> Suplente = new ArrayList();
    ArrayList<String> ID_Class = new ArrayList();
    String DateToday = "";

    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

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

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("Hora");
        modelo.addColumn("Materia");
        modelo.addColumn("Maestro");
        modelo.addColumn("Aula");
        modelo.addColumn("Grado");
        modelo.addColumn("Grupo");
        modelo.addColumn("Carrera");
        modelo.addColumn("Disp");
        modelo.addColumn("Suplente");
        modelo.addColumn("ID_Class");

        Hora.clear();
        Materia.clear();
        Maestro.clear();
        Aula.clear();
        Grado.clear();
        Grupo.clear();
        Carrera.clear();
        Disponible.clear();
        Suplente.clear();
        ID_Class.clear();

        for (Object mClaseArrays : mArrayList) {
            Datos = new String[10];
            mClase = (Clase) mClaseArrays;
            Datos[0] = Integer.toString(mClase.getHora());
            Datos[1] = mClase.getMateria();
            Datos[2] = mClase.getMaestro();
            Datos[3] = mClase.getAula();
            Datos[4] = Integer.toString(mClase.getGrado());
            Datos[5] = mClase.getGrupo();
            Datos[6] = mClase.getCarrera();
            Datos[7] = mClase.getDisponible();
            Datos[8] = mClase.getSuplente();
            Datos[9] = Integer.toString(mClase.getID_Clase());

            Hora.add("" + mClase.getHora());
            Materia.add("" + mClase.getMateria());
            Maestro.add("" + mClase.getMaestro());
            Aula.add("" + mClase.getAula());
            Grado.add("" + mClase.getGrado());
            Grupo.add("" + mClase.getGrupo());
            Carrera.add("" + mClase.getCarrera());
            Disponible.add("" + mClase.getDisponible());
            Suplente.add("" + mClase.getSuplente());
            ID_Class.add("" + mClase.getID_Clase());

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
        this.TablaHorario.getColumnModel().getColumn(7).setPreferredWidth(5);
        this.TablaHorario.getColumnModel().getColumn(9).setPreferredWidth(5);

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

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("Hora");
        modelo.addColumn("Materia");
        modelo.addColumn("Maestro");
        modelo.addColumn("Dia");
        modelo.addColumn("Grado");
        modelo.addColumn("Grupo");
        modelo.addColumn("Carrera");
        modelo.addColumn("Disponible");
        modelo.addColumn("Suplente");
        modelo.addColumn("ID_Class");

        for (Object mClaseArrays : mArrayList) {
            Datos = new String[10];
            mClase = (Clase) mClaseArrays;
            Datos[0] = Integer.toString(mClase.getHora());
            Datos[1] = mClase.getMateria();
            Datos[2] = mClase.getMaestro();
            Datos[3] = mClase.getDia();
            Datos[4] = Integer.toString(mClase.getGrado());
            Datos[5] = mClase.getGrupo();
            Datos[6] = mClase.getCarrera();
            Datos[7] = mClase.getDisponible();
            Datos[8] = mClase.getSuplente();
            Datos[9] = Integer.toString(mClase.getID_Clase());

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
        this.TablaHorario.getColumnModel().getColumn(7).setPreferredWidth(5);
        this.TablaHorario.getColumnModel().getColumn(9).setPreferredWidth(5);

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
        BtnDisponible = new javax.swing.JButton();
        BtnNoDisp = new javax.swing.JButton();
        CBMateriaSuplente = new javax.swing.JComboBox<>();
        LMateria = new javax.swing.JLabel();
        LHora = new javax.swing.JLabel();
        LID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LDisponible = new javax.swing.JLabel();
        BtnSuplente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();

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
        TablaHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaHorarioMouseClicked(evt);
            }
        });
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
                .addContainerGap(356, Short.MAX_VALUE))
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

        BtnDisponible.setText("Disponible");
        BtnDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDisponibleActionPerformed(evt);
            }
        });

        BtnNoDisp.setText("No Disponible");
        BtnNoDisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNoDispActionPerformed(evt);
            }
        });

        LMateria.setForeground(new java.awt.Color(255, 255, 255));

        LHora.setForeground(new java.awt.Color(255, 255, 255));

        LID.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hora:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DISPONIBLE:");

        LDisponible.setForeground(new java.awt.Color(255, 255, 255));

        BtnSuplente.setText("Guardar");
        BtnSuplente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSuplenteActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Materia Suplente");

        jButton1.setText("Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BtnEliminar.setBackground(new java.awt.Color(97, 212, 195));
        BtnEliminar.setText("Eliminar");
        BtnEliminar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnMartes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnMiercoles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnJueves, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnViernes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnLunes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnDisponible)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnNoDisp)
                                .addGap(29, 29, 29)
                                .addComponent(LMateria))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CBMateriaSuplente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(BtnSuplente)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(LHora, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(LID, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(LDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1))
                        .addGap(125, 125, 125)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnLabsol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnLab1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnLab2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnLab3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnMac, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnLunes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnMartes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnMiercoles)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnJueves)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnViernes))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnMac)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnLabsol)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnLab1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnLab2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnLab3)))
                        .addGap(29, 29, 29)
                        .addComponent(BtnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LHora, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(LID, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BtnDisponible)
                                .addComponent(BtnNoDisp)
                                .addComponent(LMateria)
                                .addComponent(jLabel4))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(LDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CBMateriaSuplente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnSuplente)
                        .addComponent(jButton1)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMartesActionPerformed
        DiaSel = "Martes";
        this.CBMateriaSuplente.removeAllItems();
        mConexion.conectar();
        mConexion.CargarMateriaSuplente(CBMateriaSuplente, DiaSel);
        this.LID.setText(null);
        this.LHora.setText(null);
        this.LMateria.setText(null);
        this.LDisponible.setText(null);
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
        this.CBMateriaSuplente.removeAllItems();
        mConexion.conectar();
        mConexion.CargarMateriaSuplente(CBMateriaSuplente, DiaSel);
        this.LID.setText(null);
        this.LHora.setText(null);
        this.LMateria.setText(null);
        this.LDisponible.setText(null);
        LimpiarTabla();
        setFilasDia();
    }//GEN-LAST:event_BtnLunesActionPerformed

    private void BtnMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMiercolesActionPerformed
        DiaSel = "Miercoles";
        this.CBMateriaSuplente.removeAllItems();
        mConexion.conectar();
        mConexion.CargarMateriaSuplente(CBMateriaSuplente, DiaSel);
        this.LID.setText(null);
        this.LHora.setText(null);
        this.LMateria.setText(null);
        this.LDisponible.setText(null);
        LimpiarTabla();
        setFilasDia();
    }//GEN-LAST:event_BtnMiercolesActionPerformed

    private void BtnJuevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnJuevesActionPerformed
        DiaSel = "Jueves";
        this.CBMateriaSuplente.removeAllItems();
        mConexion.conectar();
        mConexion.CargarMateriaSuplente(CBMateriaSuplente, DiaSel);
        this.LID.setText(null);
        this.LHora.setText(null);
        this.LMateria.setText(null);
        this.LDisponible.setText(null);
        LimpiarTabla();
        setFilasDia();
    }//GEN-LAST:event_BtnJuevesActionPerformed

    private void BtnViernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnViernesActionPerformed
        DiaSel = "Viernes";
        this.CBMateriaSuplente.removeAllItems();
        mConexion.conectar();
        mConexion.CargarMateriaSuplente(CBMateriaSuplente, DiaSel);
        this.LID.setText(null);
        this.LHora.setText(null);
        this.LMateria.setText(null);
        this.LDisponible.setText(null);
        LimpiarTabla();
        setFilasDia();
    }//GEN-LAST:event_BtnViernesActionPerformed

    private void BtnMacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMacActionPerformed
        AulaSel = "MAC";
        this.LID.setText(null);
        this.LHora.setText(null);
        this.LMateria.setText(null);
        this.LDisponible.setText(null);
        LimpiarTabla();
        setFilasAula();
    }//GEN-LAST:event_BtnMacActionPerformed

    private void BtnLabsolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLabsolActionPerformed
        AulaSel = "LABSOL";
        this.LID.setText(null);
        this.LHora.setText(null);
        this.LMateria.setText(null);
        this.LDisponible.setText(null);
        LimpiarTabla();
        setFilasAula();
    }//GEN-LAST:event_BtnLabsolActionPerformed

    private void BtnLab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLab1ActionPerformed
        AulaSel = "Lab1";
        this.LID.setText(null);
        this.LHora.setText(null);
        this.LMateria.setText(null);
        this.LDisponible.setText(null);
        LimpiarTabla();
        setFilasAula();
    }//GEN-LAST:event_BtnLab1ActionPerformed

    private void BtnLab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLab2ActionPerformed
        AulaSel = "Lab2";
        this.LID.setText(null);
        this.LHora.setText(null);
        this.LMateria.setText(null);
        this.LDisponible.setText(null);
        LimpiarTabla();
        setFilasAula();
    }//GEN-LAST:event_BtnLab2ActionPerformed

    private void BtnLab3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLab3ActionPerformed
        AulaSel = "Lab3";
        this.LID.setText(null);
        this.LHora.setText(null);
        this.LMateria.setText(null);
        this.LDisponible.setText(null);
        LimpiarTabla();
        setFilasAula();
    }//GEN-LAST:event_BtnLab3ActionPerformed

    private void TablaHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaHorarioMouseClicked
        int rec = this.TablaHorario.getSelectedRow();
        this.LMateria.setText(TablaHorario.getValueAt(rec, 1).toString());
        this.LHora.setText(TablaHorario.getValueAt(rec, 0).toString());
        this.LID.setText(TablaHorario.getValueAt(rec, 9).toString());
        this.LDisponible.setText(TablaHorario.getValueAt(rec, 7).toString());

    }//GEN-LAST:event_TablaHorarioMouseClicked

    private void BtnDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDisponibleActionPerformed
        Clase nClase = new Clase();
        mClase.setID_Clase(Integer.parseInt(this.LID.getText()));
        nClase.setID_Clase(Integer.parseInt(this.LID.getText()));
        nClase.setDisponible("Si");
        //nClase.setSuplente("");
        if (mConexion.conectar()) {
            if (mConexion.Disponibilidad(mClase, nClase)) {
                JOptionPane.showMessageDialog(rootPane, "Materia Modificada Con Éxito");
                //DiaSel = "Lunes";
                this.LID.setText(null);
                this.LHora.setText(null);
                this.LMateria.setText(null);
                this.LDisponible.setText(null);
                LimpiarTabla();
                setFilasDia();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error al Modificar");
            }
        }
    }//GEN-LAST:event_BtnDisponibleActionPerformed

    private void BtnNoDispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNoDispActionPerformed

        Clase nClase = new Clase();
        mClase.setID_Clase(Integer.parseInt(this.LID.getText()));
        nClase.setID_Clase(Integer.parseInt(this.LID.getText()));
        nClase.setDisponible("No");
        if (mConexion.conectar()) {
            if (mConexion.Disponibilidad(mClase, nClase)) {
                JOptionPane.showMessageDialog(rootPane, "Materia Modificada Con Éxito");
                //DiaSel = "Lunes";
                this.LID.setText(null);
                this.LHora.setText(null);
                this.LMateria.setText(null);
                this.LDisponible.setText(null);
                LimpiarTabla();
                setFilasDia();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error al Modificar");
            }
        }


    }//GEN-LAST:event_BtnNoDispActionPerformed

    private void BtnSuplenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSuplenteActionPerformed
        if ("Si".equals(this.LDisponible.getText())) {
            Clase nClase = new Clase();
            mClase.setID_Clase(Integer.parseInt(this.LID.getText()));
            nClase.setID_Clase(Integer.parseInt(this.LID.getText()));
            nClase.setSuplente(this.CBMateriaSuplente.getSelectedItem().toString());// OJO AQUI

            if (mConexion.conectar()) {
                if (mConexion.ActualizarSuplente(mClase, nClase)) {
                    JOptionPane.showMessageDialog(rootPane, "Suplente Agrgado Con Éxito");
                    //DiaSel = "Lunes";
                    this.LID.setText(null);
                    this.LHora.setText(null);
                    this.LMateria.setText(null);
                    this.LDisponible.setText(null);
                    LimpiarTabla();
                    setFilasDia();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Error al Modificar");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "CLASE OCUPADA");
            this.LID.setText(null);
            this.LHora.setText(null);
            this.LMateria.setText(null);
            this.LDisponible.setText(null);
        }


    }//GEN-LAST:event_BtnSuplenteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (DiaSel == "") {
            JOptionPane.showMessageDialog(rootPane, "No ha seleccionado ningún día");

        } else {
            String path = "src/Reporte/";
            String DateTime = Date();

            String Name_Report = DateTime + ".PDF";

            try {
                FileOutputStream FOS = new FileOutputStream(path + Name_Report);
                Document Doc = new Document();
                PdfWriter.getInstance(Doc, FOS);
                Doc.open();

                Doc.add(new Paragraph("\n"));
                Doc.add(new Paragraph("\n"));
                Doc.add(new Paragraph("Fecha " + DateToday + "                       Identificador unico de reporte: " + DateTime));
                Doc.add(new Paragraph("\n"));
                Doc.add(new Paragraph("\n"));
                Doc.add(new Paragraph("\n"));
                Doc.add(new Paragraph("                                                 Horario  " + DiaSel));
                Doc.add(new Paragraph("\n"));
                Doc.add(new Paragraph("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "));
                Doc.add(new Paragraph("\n"));
                Doc.add(new Paragraph("Hora Materia     Maestro       Aula Grado Grupo     Carrera     Disp   3Suplente"));
                Doc.add(new Paragraph("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "));
                for (int i = 0; i < ID_Class.size(); i++) {

                    Doc.add(new Paragraph("\n"));
                    Doc.add(new Paragraph(Hora.get(i) + "     " + Materia.get(i) + "     " + Maestro.get(i) + "     " + Aula.get(i) + "     " + Grado.get(i) + "     " + Grupo.get(i) + "     " + Carrera.get(i) + "     " + Disponible.get(i) + "     " + Suplente.get(i)));
                    Doc.add(new Paragraph("_______________________________________________________________________"));
                }

                Doc.close();
                try {
                    File R = new File(path + "/" + Name_Report);

                    Desktop.getDesktop().open(R);
                    System.out.println(path + "/" + Name_Report);
                } catch (Exception E) {

                    JOptionPane.showMessageDialog(null, "Error al abrir");
                    System.out.println(path + "/" + Name_Report);

                }

            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, "No se pudo generar");
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        if (this.LID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "No Ha Seleccionado Ningúna Clase");
            this.LID.setText(null);
            this.LHora.setText(null);
            this.LMateria.setText(null);
            this.LDisponible.setText(null);
        } else {
            mClase.setID_Clase(Integer.parseInt(this.LID.getText()));
            if (mConexion2.conectar()) {
                if (mConexion2.EliminarClase(mClase)) {
                    JOptionPane.showMessageDialog(rootPane, "Clase Eliminada");
                    this.LID.setText(null);
                    this.LHora.setText(null);
                    this.LMateria.setText(null);
                    this.LDisponible.setText(null);
                    LimpiarTabla();
                    setFilasDia();
                }
            }
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private String Date() {
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Calendar fecha = Calendar.getInstance();
        String DateTime = "";
        int Year = fecha.get(Calendar.YEAR);
        int Month = fecha.get(Calendar.MONTH) + 1;
        int Day = fecha.get(Calendar.DAY_OF_MONTH);
        int Hour = fecha.get(Calendar.HOUR);
        int Minute = fecha.get(Calendar.MINUTE);
        int Second = fecha.get(Calendar.SECOND);

        DateTime = "Reporte_de_Horario" + Month + Day + Year + Hour + Minute + Second;
        DateToday = Day + "/" + Month + "/" + Year;
        return DateTime;
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
    private javax.swing.JButton BtnDisponible;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnJueves;
    private javax.swing.JButton BtnLab1;
    private javax.swing.JButton BtnLab2;
    private javax.swing.JButton BtnLab3;
    private javax.swing.JButton BtnLabsol;
    private javax.swing.JButton BtnLunes;
    private javax.swing.JButton BtnMac;
    private javax.swing.JButton BtnMartes;
    private javax.swing.JButton BtnMiercoles;
    private javax.swing.JButton BtnNoDisp;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JButton BtnSuplente;
    private javax.swing.JButton BtnViernes;
    private javax.swing.JComboBox<String> CBMateriaSuplente;
    private javax.swing.JLabel LDisponible;
    private javax.swing.JLabel LHora;
    private javax.swing.JLabel LID;
    private javax.swing.JLabel LMateria;
    private javax.swing.JTable TablaHorario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
