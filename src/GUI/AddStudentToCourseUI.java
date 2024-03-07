package GUI;

import BUS.CourseInstructorBLL;
import BUS.StudentGradeBLL;
import DTO.Course;
import DTO.Person;
import DTO.StudentGrade;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class AddStudentToCourseUI extends javax.swing.JFrame {

    private StudentGradeBLL sgBLL = new StudentGradeBLL();
    private CourseInstructorBLL ciBLL = new CourseInstructorBLL();
    private DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            // Đặt kiểu dữ liệu của cột 1 là Boolean để hiển thị JCheckBox
            return columnIndex == 4 ? Boolean.class : Object.class;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Chỉ cho phép chỉnh sửa ô trong cột cuối cùng (Grade)
            return column == getColumnCount() - 1;
        }
    };

    public AddStudentToCourseUI() {
        initComponents();

        jlabel_studentID.setText("");
        jlable_Day.setText("");
        loadCbxCourseID();
        loadTable();
        UpdateCheckboxOnTableEvent();
        AddSearchEvent();

    }

    private void SearchTextChange() {
        dtm.setRowCount(0);
        dtm.setColumnCount(0);
        dtm.addColumn("Student ID");
        dtm.addColumn("First Name");
        dtm.addColumn("Last Name");
        dtm.addColumn("Enrollment Date");
        dtm.addColumn("In Course");
        tableStudentInCourse.setModel(dtm);
        ArrayList<Person> list = new ArrayList<>();
        list = sgBLL.searchStudent(txtSearch.getText());
        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            dtm.addRow(new Object[]{
                person.getPersonID(), person.getFirstname(), person.getLastname(),
                person.getEnrollmentDate(),
                sgBLL.StudentAlreadyInCourse(Integer.toString(((Course) cbxCourse.getSelectedItem()).getCourseID()),
                Integer.toString(person.getPersonID()))
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

    private void UpdateCheckboxOnTableEvent() {
        dtm.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int col = e.getColumn();
                    if (row != -1 && col != -1) {
                        String studentId = dtm.getValueAt(row, 0).toString();
                        boolean addStudentToCourse = dtm.getValueAt(row, col).toString().equals("true") ? true : false;
                        String courseId = Integer.toString(((Course) cbxCourse.getSelectedItem()).getCourseID());
                        if (addStudentToCourse) { // add student to course
                            String enrollmentId = Integer.toString(sgBLL.GetMaxId() + 1);
                            if (sgBLL.Add(enrollmentId, courseId, studentId, -1)) {
                                JOptionPane.showMessageDialog(null,
                                        "Add success!",
                                        "Notification",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else { //remove student from course
                            if (sgBLL.StudentAlreadyHaveGrade(courseId, studentId)) {
                                JOptionPane.showMessageDialog(null,
                                        "Student already have grade, Can't remove Student from Course!",
                                        "Error",
                                        JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                if (sgBLL.removeStudentFromCourse(courseId, studentId)) {
                                    JOptionPane.showMessageDialog(null,
                                            "Remove Success!",
                                            "Notification",
                                            JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        }
                        loadTable();
                    }
                }
            }
        }
        );
    }

    private void loadCbxCourseID() {
        cbxCourse.removeAllItems();
        CourseComboboxModel courseCbxModel = new CourseComboboxModel(ciBLL.getAllCourse());
        cbxCourse.setModel(courseCbxModel);
        cbxCourse.setSelectedIndex(0);
    }

    private void loadTable() {
        dtm.setRowCount(0);
        dtm.setColumnCount(0);
        dtm.addColumn("Student ID");
        dtm.addColumn("First Name");
        dtm.addColumn("Last Name");
        dtm.addColumn("Enrollment Date");
        dtm.addColumn("In Course");
        tableStudentInCourse.setModel(dtm);
        ArrayList<Person> list = new ArrayList<>();
        list = sgBLL.getAllStudent();
        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            dtm.addRow(new Object[]{
                person.getPersonID(), person.getFirstname(), person.getLastname(),
                person.getEnrollmentDate(),
                sgBLL.StudentAlreadyInCourse(Integer.toString(((Course) cbxCourse.getSelectedItem()).getCourseID()),
                Integer.toString(person.getPersonID()))
            });
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStudentInCourse = new javax.swing.JTable();
        btn_newStudent = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        cbxCourse = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jlable_Day = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jlabel_studentID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Student To Course");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setText("Course: ");

        tableStudentInCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableStudentInCourse);

        btn_newStudent.setBackground(new java.awt.Color(255, 0, 0));
        btn_newStudent.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn_newStudent.setForeground(new java.awt.Color(255, 255, 255));
        btn_newStudent.setText("New Student");
        btn_newStudent.setBorderPainted(false);
        btn_newStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newStudentActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setText("Search");

        txtSearch.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        cbxCourse.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cbxCourse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCourseItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("List Student In Course");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setText("Student ID: ");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setText("FirstName");

        txtFirstName.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtFirstName.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel8.setText("LastName");

        txtLastName.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtLastName.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel9.setText("Enrollment Date:");

        jlable_Day.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jlable_Day.setForeground(new java.awt.Color(255, 0, 0));
        jlable_Day.setText("31-02-2023");

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

        jlabel_studentID.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jlabel_studentID.setForeground(new java.awt.Color(255, 0, 0));
        jlabel_studentID.setText("11");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlable_Day))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlabel_studentID)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnCancel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btn_newStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlabel_studentID)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jlable_Day)
                            .addComponent(jLabel8)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_newStudent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnCancel))))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCourseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCourseItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            loadTable();
        }
    }//GEN-LAST:event_cbxCourseItemStateChanged

    private void btn_newStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newStudentActionPerformed
        btn_newStudent.setEnabled(false);
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
        txtFirstName.setEnabled(true);
        txtLastName.setEnabled(true);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);
        jlable_Day.setText(formattedDate);

        int nextId = sgBLL.GetMaxIdPerson() + 1;
        jlabel_studentID.setText("" + nextId);
    }//GEN-LAST:event_btn_newStudentActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        btn_newStudent.setEnabled(true);
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
        txtFirstName.setEnabled(false);
        txtLastName.setEnabled(false);
        txtFirstName.setText("");
        txtLastName.setText("");
        jlabel_studentID.setText("");
        jlable_Day.setText("");
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (sgBLL.addNewStudent(
                jlabel_studentID.getText(),
                txtFirstName.getText(),
                txtLastName.getText(),
                jlable_Day.getText())) {
            JOptionPane.showMessageDialog(null,
                    "Add New Student Success!",
                    "Notification",
                    JOptionPane.INFORMATION_MESSAGE);
            btn_newStudent.setEnabled(true);
            btnSave.setEnabled(false);
            btnCancel.setEnabled(false);
            txtFirstName.setEnabled(false);
            txtLastName.setEnabled(false);
            txtFirstName.setText("");
            txtLastName.setText("");
            jlabel_studentID.setText("");
            jlable_Day.setText("");
            loadTable();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Add New Student Fail!",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(AddStudentToCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStudentToCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStudentToCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStudentToCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new AddStudentToCourseUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btn_newStudent;
    private javax.swing.JComboBox<Course> cbxCourse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel_studentID;
    private javax.swing.JLabel jlable_Day;
    private javax.swing.JTable tableStudentInCourse;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
