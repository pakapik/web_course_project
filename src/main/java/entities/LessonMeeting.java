package entities;

import annotattions.FrontDisplay;
import annotattions.InputType;
import annotattions.SetterOptions;
import jakarta.persistence.*;
import utils.ParseType;
import utils.Util;

import java.sql.Date;

@Entity
public class LessonMeeting implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "mark")
    private Integer mark;

    @ManyToOne
    @JoinColumn(name = "lesson", referencedColumnName = "id", nullable = false)
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "student", referencedColumnName = "id", nullable = false)
    private Student student;

    @Column(name = "meetingDate")
    private Date meetingDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @FrontDisplay(name = "Lesson",
            inputType = InputType.SelectEntity,
            orderPlace = 1,
            dataType = Lesson.class)
    public Lesson getLesson() {
        return lesson;
    }

    @SetterOptions(name = "Lesson", parseType = ParseType.Entity)
    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @FrontDisplay(name = "Student",
            inputType = InputType.SelectEntity,
            orderPlace = 2,
            dataType = Student.class)
    public Student getStudent() {
        return student;
    }

    @SetterOptions(name = "Student", parseType = ParseType.Entity)
    public void setStudent(Student student) {
        this.student = student;
    }

    @FrontDisplay(name = "Meeting date",
            inputType = InputType.Date,
            orderPlace = 5,
            dataType = Date.class)
    public Date getMeetingDate() {
        return meetingDate;
    }

    @SetterOptions(name = "Meeting date", parseType = ParseType.SqlDate)
    public void setMeetingDate(Date registrationDate) {
        this.meetingDate = registrationDate;
    }


    @FrontDisplay(name = "Mark",
            inputType = InputType.Text,
            orderPlace = 3,
            dataType = Integer.class,
            isRequired = false)
    public Integer getMark() {
        return mark;
    }

    @SetterOptions(name = "Mark", parseType = ParseType.Integer)
    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String getDescription() {
        var sdf = Util.getDefaultSimpleDateFormat();
        return getLesson().getTopic() + " " + sdf.format(getMeetingDate());
    }
}
