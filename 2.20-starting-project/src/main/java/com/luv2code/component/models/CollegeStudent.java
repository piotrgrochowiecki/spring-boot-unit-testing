package com.luv2code.component.models;

public class CollegeStudent implements Student {

    private Long id;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private StudentGrades studentGrades;

    public CollegeStudent() {
    }

    public CollegeStudent(String firstname, String lastname, String emailAddress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailAddress = emailAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public StudentGrades getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(StudentGrades studentGrades) {
        this.studentGrades = studentGrades;
    }

    @Override
    public String toString() {
        return "CollegeStudent{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", studentGrades=" + studentGrades +
                '}';
    }

    @Override
    public String studentInformation() {
        return getFullName() + " " + getEmailAddress();
    }

    @Override
    public String getFullName() {
        return getFirstname() + " " + getLastname();
    }

    public String getFirstnameAndId() {
        return getFirstname() + " " + getId();
    }
}
