package GUI;

import BUS.StudentGradeBLL;
import DTO.StudentGrade;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StudentGradeUI extends javax.swing.JFrame {

    private StudentGradeBLL sgBLL = new StudentGradeBLL();

    private enum Status {
        ADD, UPDATE
    }
    private Status status;
    private DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Chỉ cho phép chỉnh sửa ô trong cột cuối cùng (Grade)
            return column == getColumnCount() - 1;
        }
    };

    public StudentGradeUI() {
        initComponents();
        loadTable();
        AddSearchEvent();
        UpdateGradeOnTableEvent();
    }

    private boolean CheckGrade(String grade) {
        // Biểu thức chính quy kiểm tra số thực từ 0 đến 4
        String regex = "^(?:[0-4](?:\\.\\d+)?|4(?:\\.0)?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(grade);
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null,
                    "Grade is real number, range from about 0 to 4!",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (grade.length() > 4) {
            JOptionPane.showMessageDialog(null,
                    "Grade is invalid!",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    private void UpdateGradeOnTableEvent() {
        dtm.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int col = e.getColumn();
                    if (row != -1 && col != -1) {
                        String enrollmentId = dtm.getValueAt(row, 0).toString();
                        String gradeString = dtm.getValueAt(row, col).toString();
                        if (CheckGrade(gradeString)) {
                            float grade = Float.parseFloat(gradeString);
                            if (sgBLL.Update(enrollmentId, grade)) {
                                JOptionPane.showMessageDialog(null,
                                        "Update Success!",
                                        "Notification",
                                        JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Update Fail!",
                                        "Notification",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                            System.out.println(row + " " + col);
                        }
                        loadTable();
                    }
                }
            }
        }
        );
    }

    private void SearchTextChange() {
        dtm.setRowCount(0);
        dtm.setColumnCount(0);
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
            if (oc.getGrade() == -1) {
                dtm.addRow(new Object[]{
                    oc.getEnrollmentID(), oc.getCourseID(), oc.getTitle(),
                    oc.getStudentID(), oc.getFirstName(), oc.getLastName()
                });
            } else {
                dtm.addRow(new Object[]{
                    oc.getEnrollmentID(), oc.getCourseID(), oc.getTitle(),
                    oc.getStudentID(), oc.getFirstName(), oc.getLastName(), oc.getGrade()
                });
            }
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
        dtm.setRowCount(0);
        dtm.setColumnCount(0);
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
            if (oc.getGrade() == -1) {
                dtm.addRow(new Object[]{
                    oc.getEnrollmentID(), oc.getCourseID(), oc.getTitle(),
                    oc.getStudentID(), oc.getFirstName(), oc.getLastName()
                });
            } else {
                dtm.addRow(new Object[]{
                    oc.getEnrollmentID(), oc.getCourseID(), oc.getTitle(),
                    oc.getStudentID(), oc.getFirstName(), oc.getLastName(), oc.getGrade()
                });
            }
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStudentGrade = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

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
                .addGap(337, 337, 337))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

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
        btnAdd.setText("Add Student To Course");
        btnAdd.setBorderPainted(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setText("Search");

        txtSearch.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("List Student Grade");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(322, 322, 322)
                            .addComponent(jLabel10))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddStudentToCourseUI newFrame = new AddStudentToCourseUI();
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setVisible(true);
//        status = Status.ADD;
//        btnAdd.setEnabled(false);
//        btnUpdate.setEnabled(false);
//        btnClear.setEnabled(false);
//        tableStudentGrade.setEnabled(false);
//        btnSave.setEnabled(true);
//        btnCancel.setEnabled(true);
//        cbxStudentID.setEnabled(true);
//        cbxCourseID.setEnabled(true);
//        txtGrade.setEnabled(true);
//        txtGrade.setText("");
//        txtSearch.setText("");
//        txtFirstName.setText("");
//        txtLastName.setText("");
//        txtTitle.setText("");
//        cbxCourseID.setSelectedIndex(-1);
//        cbxStudentID.setSelectedIndex(-1);
//        loadTable();
//        int nextId = sgBLL.GetMaxId() + 1;
//        txtEnrollmentID.setText("" + nextId);
    }//GEN-LAST:event_btnAddActionPerformed

    private void tableStudentGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStudentGradeMouseClicked
//        int i = tableStudentGrade.getSelectedRow();
//        if (i >= 0) {
//            TableModel model = tableStudentGrade.getModel();
//            txtEnrollmentID.setText(model.getValueAt(i, 0).toString());
//            cbxCourseID.setSelectedItem(model.getValueAt(i, 1).toString());
//            txtTitle.setText(model.getValueAt(i, 2).toString());
//            cbxStudentID.setSelectedItem(model.getValueAt(i, 3).toString());
//            txtFirstName.setText(model.getValueAt(i, 4).toString());
//            txtLastName.setText(model.getValueAt(i, 5).toString());
//            txtGrade.setText(model.getValueAt(i, 6).toString());
//        }
    }//GEN-LAST:event_tableStudentGradeMouseClicked

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
            java.util.logging.Logger.getLogger(StudentGradeUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentGradeUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentGradeUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentGradeUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableStudentGrade;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
