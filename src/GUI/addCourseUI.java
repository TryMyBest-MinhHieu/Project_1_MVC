
package GUI;

import BUS.CourseBLL;
import DTO.Course;
import DTO.OnlineCourse;
import DTO.OnsiteCourse;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class addCourseUI extends javax.swing.JFrame {
    
    CourseBLL courseBLL = new CourseBLL();
    private CourseUI parentGUI;
    public addCourseUI(CourseUI parentGUI) {
        this.parentGUI = parentGUI;
        initComponents();
        setup();
        loadCbxDepartment();
    }

    ArrayList<String> nameList = courseBLL.getNameDepartment();
    public void loadCbxDepartment(){
        txtDepartmentID.removeAllItems();
        for (String name : nameList){
            txtDepartmentID.addItem(name);
        }
    }
    
    public void setup(){
        txtLocation.setVisible(false);
        txtDay.setVisible(false);
        txtTime.setVisible(false);
        lbTime.setVisible(false);
        lbLocation.setVisible(false);
        lbDay.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCourseID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCredit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDepartmentID = new javax.swing.JComboBox<>();
        lbUrl = new javax.swing.JLabel();
        txtUrl = new javax.swing.JTextField();
        chbCourse = new javax.swing.JCheckBox();
        txtLocation = new javax.swing.JTextField();
        lbDay = new javax.swing.JLabel();
        txtDay = new javax.swing.JTextField();
        lbTime = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        lbLocation = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("CourseID");

        jLabel2.setText("Title");

        jLabel3.setText("Credits");

        jLabel4.setText("DepartmentID");

        txtDepartmentID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbUrl.setText("Url");

        chbCourse.setText("Onsite Course");
        chbCourse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbCourseItemStateChanged(evt);
            }
        });

        lbDay.setText("Days");

        lbTime.setText("Time");

        lbLocation.setText("Location");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
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
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCourseID)
                            .addComponent(txtTitle)
                            .addComponent(txtCredit)
                            .addComponent(txtDepartmentID, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLocation)
                            .addComponent(lbTime)
                            .addComponent(lbDay)
                            .addComponent(lbUrl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtUrl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDepartmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(chbCourse)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUrl)
                    .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLocation))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDay)
                    .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTime)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeAddGUI(){
        dispose();
    }
    private void chbCourseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbCourseItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            txtLocation.setVisible(true);
            txtDay.setVisible(true);
            txtTime.setVisible(true);
            lbTime.setVisible(true);
            lbLocation.setVisible(true);
            lbDay.setVisible(true);
            txtUrl.setVisible(false);
            lbUrl.setVisible(false);
        } else {
            txtLocation.setVisible(false);
            txtDay.setVisible(false);
            txtTime.setVisible(false);
            lbTime.setVisible(false);
            lbLocation.setVisible(false);
            lbDay.setVisible(false);
            txtUrl.setVisible(true);
            lbUrl.setVisible(true);
        }
    }//GEN-LAST:event_chbCourseItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int courseid = Integer.parseInt(txtCourseID.getText());
        String title = txtTitle.getText();
        int credit = Integer.parseInt(txtCredit.getText());
        int departmentid = courseBLL.getIDByName((String) txtDepartmentID.getSelectedItem());
        if (courseBLL.checkCourseID(courseid) == false) { // kiểm tra courseid tồn tại
            // thêm Course onsite
            if (chbCourse.isSelected()) {
                String location = txtLocation.getText();
                String day = txtDay.getText();
                String time = txtTime.getText();
                OnsiteCourse onsiteCourse = new OnsiteCourse(courseid, title, credit, departmentid, location, day, time);
                if(courseBLL.addCourse(onsiteCourse)){
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    parentGUI.loadTableCourse();
                    closeAddGUI();
                }else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }

            } else { // Thêm Course online
                String url = txtUrl.getText();
                OnlineCourse onlineCourse = new OnlineCourse(courseid, title, credit, departmentid, url);               
                if (courseBLL.addCourse(onlineCourse)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    parentGUI.loadTableCourse();
                    closeAddGUI();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Course ID đã tồn tại");
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chbCourse;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbDay;
    private javax.swing.JLabel lbLocation;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbUrl;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtCredit;
    private javax.swing.JTextField txtDay;
    private javax.swing.JComboBox<String> txtDepartmentID;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtUrl;
    // End of variables declaration//GEN-END:variables
}
