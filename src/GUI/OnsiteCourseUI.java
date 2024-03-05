/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.CourseBLL;
import BUS.OnlineCourseBLL;
import BUS.OnsiteCourseBLL;
import DTO.CourseInfo;
import DTO.OnlineCourse;
import DTO.OnsiteCourse;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
//import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class OnsiteCourseUI extends javax.swing.JFrame {

    /**
     * Creates new form OnlineCourseUI
     */
    private OnsiteCourseBLL ocBLL = new OnsiteCourseBLL();
    private CourseBLL cBLL = new CourseBLL();
    public OnsiteCourseUI() {
        initComponents();
//        loadTable();
//        loadCbxSearch();
//        loadCbx();
        
        
    }
    
//    private void loadTable(){
//        DefaultTableModel dtm = new DefaultTableModel();
//        dtm.addColumn("CourseID");
//        dtm.addColumn("Location");
//        dtm.addColumn("Day");
//        dtm.addColumn("Time");
//        tableOnlCourse.setModel(dtm);
//        ArrayList<OnsiteCourse> list = new ArrayList<>();
//        list = ocBLL.getAllOnsiteCourse();
//        for(int i = 0;i< list.size();i++){
//            OnsiteCourse oc = list.get(i);
//            dtm.addRow(new Object[]{
//                oc.getCourseID(), oc.getLocation(), oc.getDay(), oc.getTime()
//            });
//        }
//        
//    }

//    private void loadTableSearch(String column, String data){
//        DefaultTableModel dtm = new DefaultTableModel();
//        dtm.addColumn("CourseID");
//        dtm.addColumn("Location");
//        dtm.addColumn("Day");
//        dtm.addColumn("Time");
//        tableOnlCourse.setModel(dtm);
//        ArrayList<OnsiteCourse> list = new ArrayList<>();
//        list = ocBLL.searchOnsiteCourse(column, data);
//        for(int i = 0;i< list.size();i++){
//            OnsiteCourse oc = list.get(i);
//            dtm.addRow(new Object[]{
//                oc.getCourseID(), oc.getLocation(), oc.getDay(), oc.getTime()
//            });
//        }
//    }
//    
//    private void loadCbxSearch(){
//        cbxSearch.removeAllItems();
//        cbxSearch.addItem("CourseID");
//        cbxSearch.addItem("Location");
//        cbxSearch.addItem("Title");
//    }
    
//    private void loadCbxCourseID(){
//        cbxCourseID.removeAllItems();
//        for(int i=0;i<ocBLL.getAllCourseID().size();i++){
//            cbxCourseID.addItem(ocBLL.getAllCourseID().get(i).toString());
//        }
//    }
    
//    ArrayList<CourseInfo> listCourseInfo = cBLL.getCourseInfo();
//    private void loadCbx(){
//        cbxCourseID.removeAllItems();
//        cbxTitle.removeAllItems();
//        for (CourseInfo csinfo : listCourseInfo ) {
//        cbxCourseID.addItem(String.valueOf(csinfo.getCourseID()));
//        cbxTitle.addItem(csinfo.getTitle());
//        }
//        AutoCompleteDecorator.decorate(cbxTitle);
//    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOnlCourse = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbxTitle = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        cbxSearch = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDay = new javax.swing.JTextField();
        txtTime = new javax.swing.JTextField();
        cbxCourseID = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Onsite Course");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setText("Course ID");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setText("Location");

        txtLocation.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        tableOnlCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableOnlCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOnlCourseMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableOnlCourseMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableOnlCourse);

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

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setBorderPainted(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
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

        btnSearch.setBackground(new java.awt.Color(255, 0, 0));
        btnSearch.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.setBorderPainted(false);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
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

        btnExit.setBackground(new java.awt.Color(255, 0, 0));
        btnExit.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Exit");
        btnExit.setBorderPainted(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setText("Search");

        cbxTitle.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cbxTitle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTitle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTitleItemStateChanged(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        cbxSearch.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setText("Day");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setText("Time");

        txtDay.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        txtTime.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        cbxCourseID.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cbxCourseID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCourseIDItemStateChanged(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbxCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cbxTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtLocation)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpdate)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSearch)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cbxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbxCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cbxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(jLabel3)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClear)
                            .addComponent(btnAdd))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit)
                        .addGap(28, 28, 28))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
//        int courseID = Integer.parseInt(cbxTitle.getSelectedItem().toString());
//        String location = txtLocation.getText();
//        String day = txtDay.getText();
//        String time = txtTime.getText();
//        
//        OnsiteCourse oc = new OnsiteCourse(courseID, location, day, time);
//        if(location.trim().equals("")&& day.trim().equals("")&& time.trim().equals("")){
//            JOptionPane.showMessageDialog(this, "");
//        } else if(ocBLL.checkOnsiteCourseID(courseID)==false){
//            if(ocBLL.addOnsiteCourse(oc)){
//                JOptionPane.showMessageDialog(this, "Add Success");
//                loadTable();
//            } else{
//                JOptionPane.showMessageDialog(this, "Add Fail");
//            }
//        } else{
//            JOptionPane.showMessageDialog(this, "CourseID Exist");
//        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
//        int courseID = Integer.parseInt(cbxTitle.getSelectedItem().toString());
//        if(ocBLL.checkOnsiteCourseID(courseID) == false){
//            JOptionPane.showMessageDialog(this, "CourseID doesnt exist");
//        } else if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Warnning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
//            if(ocBLL.deleteOnsiteCourse(courseID)){
//                JOptionPane.showMessageDialog(this, "Delete Success");
//                loadTable();
//            } else {
//                JOptionPane.showMessageDialog(this, "Delete Fail");
//            }
//        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tableOnlCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOnlCourseMouseClicked
//        int i = tableOnlCourse.getSelectedRow();
//        if(i>=0){
//            TableModel model = tableOnlCourse.getModel();
//            txtLocation.setText(model.getValueAt(i, 1).toString());
//            cbxCourseID.setSelectedItem(model.getValueAt(i, 0).toString());
//            txtDay.setText(model.getValueAt(i, 2).toString());
//            txtTime.setText(model.getValueAt(i, 3).toString());
//        }
    }//GEN-LAST:event_tableOnlCourseMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
//       int courseID = Integer.parseInt(cbxTitle.getSelectedItem().toString());
//        String location = txtLocation.getText();
//        String day = txtDay.getText();
//        String time = txtTime.getText();
//        
//        OnsiteCourse oc = new OnsiteCourse(courseID, location, day, time);
//        if(location.trim().equals("")&& day.trim().equals("")&& time.trim().equals("")){
//            JOptionPane.showMessageDialog(this, "");
//        } else if(ocBLL.checkOnsiteCourseID(courseID)){
//            if(ocBLL.updateOnsiteCourse(oc)){
//                JOptionPane.showMessageDialog(this, "Update Success");
//                loadTable();
//            } else{
//                JOptionPane.showMessageDialog(this, "Update Fail");
//            }
//        } else{
//            JOptionPane.showMessageDialog(this, "CourseID doesnt exist");
//        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
//        String data = txtSearch.getText();
//        String selectedSearchType = (String) cbxSearch.getSelectedItem();
//        if("CourseID".equals(selectedSearchType)){
//            loadTableSearch("CourseID", data);
//        } else if("Url".equals(selectedSearchType)){
//            loadTableSearch("OcUrl", data);
//        } else if ("Title".equals(selectedSearchType)){
//            String data1 = String.valueOf(cBLL.getCourseIDByTitle(data));
//            loadTableSearch("CourseID", data1);
//        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
//        txtLocation.setText("");
//        txtDay.setText("");
//        txtTime.setText("");
//        txtSearch.setText("");
//        loadTable();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tableOnlCourseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOnlCourseMousePressed
//        int i = tableOnlCourse.getSelectedRow();
//        JTable table =(JTable) evt.getSource();
//        Point point = evt.getPoint();
//        if(i>=0 && evt.getClickCount()==2){
//            TableModel model = tableOnlCourse.getModel();
//            String location = model.getValueAt(i, 1).toString();
//            int courseID = Integer.parseInt(model.getValueAt(i, 0).toString());
//            String day = model.getValueAt(i, 2).toString();
//            String time = model.getValueAt(i, 3).toString();
//            OnsiteCourse oc = new OnsiteCourse(courseID, location, day, time);
//            new OnsiteCourseDetail(oc).setVisible(true);
//        }
    }//GEN-LAST:event_tableOnlCourseMousePressed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
//        int message = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát!!!", "Quit", JOptionPane.YES_NO_OPTION);
//        if (message == JOptionPane.YES_OPTION) {
//            this.dispose();
//        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void cbxTitleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTitleItemStateChanged
//        if (evt.getStateChange() == ItemEvent.SELECTED) {
//            String selectedTitle = (String) cbxTitle.getSelectedItem();
//            int selectedCourseID = cBLL.getCourseIDByTitle(selectedTitle);
//            if (selectedCourseID != -1) {
//                cbxCourseID.setSelectedItem(String.valueOf(selectedCourseID));
//            }
//        }
    }//GEN-LAST:event_cbxTitleItemStateChanged

    private void cbxCourseIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCourseIDItemStateChanged
//        if (evt.getStateChange() == ItemEvent.SELECTED) {
//            // Lấy courseID được chọn từ cb1
//            int selectedCourseID = Integer.parseInt((String) cbxCourseID.getSelectedItem());
//            String selectedTitle = cBLL.getTitleByCourseID(selectedCourseID);
//            if (selectedTitle != null) {
//                cbxTitle.setSelectedItem(selectedTitle);
//            }
//        }
    }//GEN-LAST:event_cbxCourseIDItemStateChanged

    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbxCourseID;
    private javax.swing.JComboBox<String> cbxSearch;
    private javax.swing.JComboBox<String> cbxTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableOnlCourse;
    private javax.swing.JTextField txtDay;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables
}
