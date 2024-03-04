/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.Course;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author syl
 */
public class CourseComboboxModel extends AbstractListModel<Course> implements ComboBoxModel<Course>{
    
    private Course selectedCourse;
    private ArrayList<Course> courses;
    
    public CourseComboboxModel(ArrayList<Course> courses) {
        this.courses = courses;
    }
    
    @Override
    public int getSize() {
        return courses.size();
    }

    @Override
    public Course getElementAt(int index) {
        return courses.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedCourse = (Course) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedCourse;
    }
    
}
