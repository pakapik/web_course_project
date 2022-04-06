package entities;

import annotattions.FrontDisplay;
import annotattions.InputType;
import annotattions.SetterOptions;
import jakarta.persistence.*;
import utils.ParseType;

import java.sql.Date;
import java.util.List;

@Entity
public class Course implements IEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "subject_area", nullable = false, length = 50)
    private String subjectArea;

    @Column(name = "duration_in_days", nullable = false)
    private int durationInDays;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "name", unique = true, nullable = false, length = 100)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
    private List<Price> prices;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Lesson> lessons;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<TeacherCourse> teacherCours;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @FrontDisplay(name = "Name",
            inputType = InputType.Text,
            orderPlace = 2,
            dataType = String.class)
    public String getName() {
        return name;
    }

    @SetterOptions(name = "Name", parseType = ParseType.String)
    public void setName(String name) {
        this.name = name;
    }

    @FrontDisplay(name = "Subject area",
            inputType = InputType.Text,
            orderPlace = 3,
            dataType = String.class)
    public String getSubjectArea() {
        return subjectArea;
    }

    @SetterOptions(name = "Subject area", parseType = ParseType.String)
    public void setSubjectArea(String subjectArea) {
        this.subjectArea = subjectArea;
    }

    @FrontDisplay(name = "Start date",
            inputType = InputType.Date,
            orderPlace = 4,
            dataType = Date.class)
    public Date getStartDate() {
        return startDate;
    }

    @SetterOptions(name = "Start date", parseType = ParseType.SqlDate)
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @FrontDisplay(name = "Duration in days",
            inputType = InputType.Text,
            orderPlace = 5,
            dataType = Integer.class,
            min = 1, max = 365)
    public int getDurationInDays() {
        return durationInDays;
    }

    @SetterOptions(name = "Duration in days", parseType = ParseType.Integer)
    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<TeacherCourse> getUserTeacherCourses() {
        return teacherCours;
    }

    public void setUserTeacherCourses(List<TeacherCourse> teacherCours) {
        this.teacherCours = teacherCours;
    }

    @Override
    public String getDescription() {
        return getName();
    }
}
