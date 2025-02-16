package rut.miit.dto;

public class ShowTeacherDto {

    private String teacherName;
    private Integer teacherNumber;
    private String department;

    public String getTeacherName() {return teacherName;}
    public void setTeacherName(String teacherName) {this.teacherName = teacherName;}

    public Integer getTeacherNumber() {return teacherNumber;}
    public void setTeacherNumber(Integer teacherNumber) {this.teacherNumber = teacherNumber;}

    public String getDepartment() {return department;}
    public void setDepartment(String department) {this.department = department;}
}
