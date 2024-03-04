/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.StudentGradeBLL;
import DTO.StudentGrade;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StudentGradeUI extends javax.swing.JFrame {

    /**
     * Creates new form OnlineCourseUI
     */
    private StudentGradeBLL sgBLL = new StudentGradeBLL();

    private enum Status {
        ADD, UPDATE
    }
    private Status status;

    public StudentGradeUI() {
        initComponents();
        loadTable();
        loadCbxCourseID();
        loadCbxStudentID();
        AddSearchEvent();
    }

    private void SearchTextChange() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Enrollment ID");
        dtm.addColumn("Course ID");
        dtm.addColumn("Title");
        dtm.addColumn("Student ID");
        dtm.addColumn("FirstName");
        dtm.addColumn("LastName");
        dtm.addColumn("Grade");
        tableStudentGrade.setModel(dtm);
        ArrayList<StudentGrade> list = new ArrayList<>();
        list = sgBLL.searchStudentGrade(txtSearch.getText());
        for (int i = 0; i < list.size(); i++) {
            StudentGrade oc = list.get(i);
            dtm.addRow(new Object[]{
                oc.getEnrollmentID(), oc.getCourseID(), oc.getTitle(),
                oc.getStudentID(), oc.getFirstName(), oc.getLastName(), oc.getGrade()
            });
        }
    }

    private void AddSearchEvent() {
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SearchTextChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                SearchTextChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    private void loadTable() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Enrollment ID");
        dtm.addColumn("Course ID");
        dtm.addColumn("Title");
        dtm.addColumn("Student ID");
        dtm.addColumn("FirstName");
        dtm.addColumn("LastName");
        dtm.addColumn("Grade");
        tableStudentGrade.setModel(dtm);
        ArrayList<StudentGrade> list = new ArrayList<>();
        list = sgBLL.getAllStudentGrade();
        for (int i = 0; i < list.size(); i++) {
            StudentGrade oc = list.get(i);
            dtm.addRow(new Object[]{
                oc.getEnrollmentID(), oc.getCourseID(), oc.getTitle(),
                oc.getStudentID(), oc.getFirstName(), oc.getLastName(), oc.getGrade()
            });
        }

    }

    private void loadCbxCourseID() {
        cbxCourseID.removeAllItems();
        for (int i = 0; i < sgBLL.getAllCourseID().size(); i++) {
            cbxCourseID.addItem(sgBLL.getAllCourseID().get(i).toString());
        }
        cbxCourseID.setSelectedIndex(-1);
        txtTitle.setText("");
    }

    private void loadCbxStudentID() {
        cbxStudentID.removeAllItems();
        for (int i = 0; i < sgBLL.getAllStudentID().size(); i++) {
            cbxStudentID.addItem(sgBLL.getAllStudentID().get(i).toString());
        }
        cbxStudentID.setSelectedIndex(-1);
        txtFirstName.setText("");
        txtLastName.setText("");
    }

    private boolean CheckInput() {
        if (cbxStudentID.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null,
                    "Please enter Student ID!",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (cbxCourseID.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null,
                    "Please enter Course ID!",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (txtGrade.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Please enter Grade!",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        // Biểu thức chính quy kiểm tra số thực từ 0 đến 10
        String regex = "^(?:[0-4](?:\\.\\d+)?|4(?:\\.0)?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txtGrade.getText());
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null,
                    "Grade is real number, range from about 0 to 4!",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (txtGrade.getText().length() > 4) {
            JOptionPane.showMessageDialog(null,
                    "Grade is invalid!",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStudentGrade = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxStudentID = new javax.swing.JComboBox<>();
        cbxCourseID = new javax.swing.JComboBox<>();
        txtGrade = new javax.swing.JTextField();
        txtEnrollmentID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtTitle = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Grade");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(376, 376, 376))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setText("Enrollment ID");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setText("Course ID");

        tableStudentGrade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableStudentGrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStudentGradeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableStudentGrade);

        btnAdd.setBackground(new java.awt.Color(255, 0, 0));
        btnAdd.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.setBorderPainted(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 0, 0));
        btnUpdate.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setBorderPainted(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(255, 0, 0));
        btnClear.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.setBorderPainted(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setText("Search");

        txtSearch.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setText("Student ID");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setText("Grade");

        cbxStudentID.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cbxStudentID.setEnabled(false);
        cbxStudentID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxStudentIDItemStateChanged(evt);
            }
        });

        cbxCourseID.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cbxCourseID.setEnabled(false);
        cbxCourseID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCourseIDItemStateChanged(evt);
            }
        });

        txtGrade.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtGrade.setEnabled(false);

        txtEnrollmentID.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtEnrollmentID.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setText("FirstName");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel8.setText("LastName");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel9.setText("Title");

        txtLastName.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtLastName.setEnabled(false);

        txtFirstName.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtFirstName.setEnabled(false);

        txtTitle.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtTitle.setEnabled(false);

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.setBorderPainted(false);
        btnCancel.setEnabled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(255, 0, 0));
        btnSave.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setBorderPainted(false);
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGrade, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(txtEnrollmentID))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLastName))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEnrollmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbxCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        status = Status.ADD;
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnClear.setEnabled(false);
        tableStudentGrade.setEnabled(false);
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
        cbxStudentID.setEnabled(true);
        cbxCourseID.setEnabled(true);
        txtGrade.setEnabled(true);
        txtGrade.setText("");
        txtSearch.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtTitle.setText("");
        cbxCourseID.setSelectedIndex(-1);
        cbxStudentID.setSelectedIndex(-1);
        loadTable();
        int nextId = sgBLL.GetMaxId() + 1;
        txtEnrollmentID.setText("" + nextId);
    }//GEN-LAST:event_btnAddActionPerformed

    private void tableStudentGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStudentGradeMouseClicked
        int i = tableStudentGrade.getSelectedRow();
        if (i >= 0) {
            TableModel model = tableStudentGrade.getModel();
            txtEnrollmentID.setText(model.getValueAt(i, 0).toString());
            cbxCourseID.setSelectedItem(model.getValueAt(i, 1).toString());
            txtTitle.setText(model.getValueAt(i, 2).toString());
            cbxStudentID.setSelectedItem(model.getValueAt(i, 3).toString());
            txtFirstName.setText(model.getValueAt(i, 4).toString());
            txtLastName.setText(model.getValueAt(i, 5).toString());
            txtGrade.setText(model.getValueAt(i, 6).toString());
        }
    }//GEN-LAST:event_tableStudentGradeMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        status = Status.UPDATE;
        int selectedRow = tableStudentGrade.getSelectedRow();
        if (selectedRow >= 0) {
            btnAdd.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnClear.setEnabled(false);
            tableStudentGrade.setEnabled(false);
            btnSave.setEnabled(true);
            btnCancel.setEnabled(true);
            txtGrade.setEnabled(true);
            txtSearch.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Please choose a record!",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtEnrollmentID.setText("");
        txtGrade.setText("");
        txtSearch.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtTitle.setText("");
        cbxCourseID.setSelectedIndex(-1);
        cbxStudentID.setSelectedIndex(-1);
        loadTable();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(true);
        btnClear.setEnabled(true);
        tableStudentGrade.setEnabled(true);
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
        cbxStudentID.setEnabled(false);
        cbxCourseID.setEnabled(false);
        txtGrade.setEnabled(false);
        txtSearch.setEnabled(true);
        txtEnrollmentID.setText("");
        txtGrade.setText("");
        txtSearch.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtTitle.setText("");
        cbxCourseID.setSelectedIndex(-1);
        cbxStudentID.setSelectedIndex(-1);
        loadTable();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (status == Status.ADD) {
            if (CheckInput()) {
                String enrollmentId = txtEnrollmentID.getText();
                String courseId = (String) cbxCourseID.getSelectedItem();
                String studentId = (String) cbxStudentID.getSelectedItem();
                float grade = Float.parseFloat(txtGrade.getText());
                if (sgBLL.GradeIsExist(courseId, studentId)) {
                    JOptionPane.showMessageDialog(null,
                            "Students already have a grade for this course!",
                            "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (sgBLL.Add(enrollmentId, courseId, studentId, grade)) {
                        JOptionPane.showMessageDialog(null,
                                "Add Success!",
                                "Error",
                                JOptionPane.INFORMATION_MESSAGE);
                        btnCancel.doClick();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Add Fail!",
                                "Error",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } else if (status == Status.UPDATE) {
            if (CheckInput()) {
                String enrollmentId = txtEnrollmentID.getText();
                float grade = Float.parseFloat(txtGrade.getText());
                if (sgBLL.Update(enrollmentId, grade)) {
                    JOptionPane.showMessageDialog(null,
                            "Update Success!",
                            "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                    btnCancel.doClick();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Update Fail!",
                            "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbxStudentIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxStudentIDItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            // Lấy giá trị được chọn
            int selectedId = Integer.parseInt((String) evt.getItem());
            txtFirstName.setText(sgBLL.GetFirstNameById(selectedId));
            txtLastName.setText(sgBLL.GetLastNameById(selectedId));
        }
    }//GEN-LAST:event_cbxStudentIDItemStateChanged

    private void cbxCourseIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCourseIDItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            // Lấy giá trị được chọn
            int selectedId = Integer.parseInt((String) evt.getItem());
            txtTitle.setText(sgBLL.GetTitleById(selectedId));
        }
    }//GEN-LAST:event_cbxCourseIDItemStateChanged

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
            java.util.logging.Logger.getLogger(StudentGradeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentGradeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentGradeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentGradeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentGradeUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbxCourseID;
    private javax.swing.JComboBox<String> cbxStudentID;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableStudentGrade;
    private javax.swing.JTextField txtEnrollmentID;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtGrade;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
