package entities;

import annotattions.FrontDisplay;
import annotattions.InputType;
import annotattions.SetterOptions;
import jakarta.persistence.*;
import utils.ParseType;

import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher extends UserBase {

    @Column(name = "experience_hours")
    private Integer experienceHours;

    @Column(name = "academic_degree", length = 50)
    private String academicDegree;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TeacherCourse> teacherCours;

    @FrontDisplay(name = "Academic degree",
            inputType = InputType.Text,
            orderPlace = 8,
            dataType = String.class,
            isRequired = false)
    public String getAcademicDegree() {
        return academicDegree;
    }

    @SetterOptions(name = "Academic degree", parseType = ParseType.String)
    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    @FrontDisplay(name = "Experience hours",
            inputType = InputType.Text,
            orderPlace = 9,
            dataType = Integer.class,
            isRequired = false)
    public Integer getExperienceHours() {
        return experienceHours;
    }

    @SetterOptions(name = "Experience hours", parseType = ParseType.Integer)
    public void setExperienceHours(Integer experienceHours) {
        this.experienceHours = experienceHours;
    }

    public List<TeacherCourse> getUserTeacherCourses() {
        return teacherCours;
    }

    public void setUserTeacherCourses(List<TeacherCourse> teacherCours) {
        this.teacherCours = teacherCours;
    }
}
