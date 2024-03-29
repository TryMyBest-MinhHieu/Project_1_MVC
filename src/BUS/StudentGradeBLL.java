/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.StudentGradeDAL;
import DTO.Person;
import DTO.StudentGrade;
import java.util.ArrayList;

public class StudentGradeBLL {

    private StudentGradeDAL sgDAL = new StudentGradeDAL();

    public ArrayList<StudentGrade> getAllStudentGrade() {
        return sgDAL.getAllStudentGrade();
    }

    public ArrayList<Person> getAllStudent() {
        return sgDAL.getAllStudent();
    }

    public boolean Update(String enrollmentId, float grade) {
        return sgDAL.Update(enrollmentId, grade);
    }

    public boolean Add(String enrollmentId, String courseId, String studentId, float grade) {
        return sgDAL.Add(enrollmentId, courseId, studentId, grade);
    }

    public boolean StudentAlreadyInCourse(String courseId, String studentId) {
        return sgDAL.StudentAlreadyInCourse(courseId, studentId);
    }

    public boolean StudentAlreadyHaveGrade(String courseId, String studentId) {
        return sgDAL.StudentAlreadyHaveGrade(courseId, studentId);
    }

    public boolean removeStudentFromCourse(String courseId, String studentId) {
        return sgDAL.removeStudentFromCourse(courseId, studentId);
    }

    public String GetTitleById(int id) {
        return sgDAL.GetTitleById(id);
    }

    public String GetFirstNameById(int id) {
        return sgDAL.GetFirstNameById(id);
    }

    public String GetLastNameById(int id) {
        return sgDAL.GetLastNameById(id);
    }

    public int GetMaxId() {
        return sgDAL.GetMaxId();
    }

    public int GetMaxIdPerson() {
        return sgDAL.GetMaxIdPerson();
    }

    public boolean checkStudentGradeID(int enrollmentID) {
        return sgDAL.checkStudentGradeID(enrollmentID);
    }

    public ArrayList<Integer> getAllStudentID() {
        return sgDAL.getAllStudentID();
    }

    public ArrayList<Integer> getAllCourseID() {
        return sgDAL.getAllCourseID();
    }

    public boolean addStudentGrade(StudentGrade sg) {
        return sgDAL.addStudentGrade(sg);
    }

    public boolean addNewStudent(String studentId, String firstName, String lastName, String enrollmentDate) {
        return sgDAL.addNewStudent(studentId, firstName, lastName, enrollmentDate);
    }

    public boolean deleteStudentGrade(int enrollmentID) {
        return sgDAL.deleteStudentGrade(enrollmentID);
    }

    public boolean updateStudentGrade(StudentGrade sg) {
        return sgDAL.updateStudentGrade(sg);
    }

    public ArrayList<StudentGrade> searchStudentGrade(String data) {
        return sgDAL.searchStudentGrade(data);
    }

    public ArrayList<Person> searchStudent(String data) {
        return sgDAL.searchStudent(data);
    }
}
