package entities;

import annotattions.FrontDisplay;
import annotattions.InputType;
import annotattions.SetterOptions;
import jakarta.persistence.*;
import utils.ParseType;

import java.sql.Date;

@Entity
public class TeacherCourse implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "end_date_for_teacher")
    private Date endDateForTeacher;

    @ManyToOne
    @JoinColumn(name = "course",  referencedColumnName = "id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "teacher", referencedColumnName = "id")
    private Teacher teacher;

    public long getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return course.getDescription() + teacher.getDescription();
    }

    public void setId(long id) {
        this.id = id;
    }

    @FrontDisplay(name = "Course",
            inputType = InputType.SelectEntity,
            orderPlace = 1,
            dataType = Course.class)
    public Course getCourse() {
        return course;
    }

    @SetterOptions(name = "Course", parseType = ParseType.Entity)
    public void setCourse(Course course) {
        this.course = course;
    }

    @FrontDisplay(name = "Teacher",
            inputType = InputType.SelectEntity,
            orderPlace = 2,
            dataType = Teacher.class)
    public Teacher getTeacher() {
        return teacher;
    }

    @SetterOptions(name = "Teacher", parseType = ParseType.Entity)
    public void seTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @FrontDisplay(name = "End date of teaching",
            inputType = InputType.Text,
            orderPlace = 3,
            dataType = Date.class,
            isRequired = false)
    public Date getEndDateForTeacher() {
        return endDateForTeacher;
    }

    @SetterOptions(name = "End date of teaching", parseType = ParseType.SqlDate)
    public void setEndDateForTeacher(Date endDateForTeacher) {
        this.endDateForTeacher = endDateForTeacher;
    }
}
