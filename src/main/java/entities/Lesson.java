package entities;
import annotattions.FrontDisplay;
import annotattions.InputType;
import annotattions.SetterOptions;
import jakarta.persistence.*;
import utils.ParseType;

import java.util.List;

@Entity
public class Lesson implements IEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "duration_in_minutes", nullable = false)
    private int durationInMinutes;

    @Column(name = "lesson_type", nullable = false)
    private LessonType lessonType;

    @Column(name = "name", nullable = false, length = 50)
    private String topic;

    @ManyToOne
    @JoinColumn(name = "course", referencedColumnName = "id", nullable = false)
    private Course course;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lesson")
    private List<LessonMeeting> lessonMeetings;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @FrontDisplay(name = "Topic",
            inputType = InputType.Text,
            orderPlace = 1,
            dataType = String.class)
    public String getTopic() {
        return topic;
    }

    @SetterOptions(name = "Topic", parseType = ParseType.String)
    public void setTopic(String topic) {
        this.topic = topic;
    }

    @FrontDisplay(name = "Course",
            inputType = InputType.SelectEntity,
            orderPlace = 2,
            dataType = Course.class)
    public Course getCourse() {
        return course;
    }

    @SetterOptions(name = "Course", parseType = ParseType.Entity)
    public void setCourse(Course course) {
        this.course = course;
    }

    @FrontDisplay(name = "Lesson type",
            inputType = InputType.SelectEnum,
            orderPlace = 3,
            dataType = LessonType.class)
    public LessonType getLessonType() {
        return lessonType;
    }

    @SetterOptions(name = "Lesson type", parseType = ParseType.EnumTest)
    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    @FrontDisplay(name = "Duration in minutes",
            inputType = InputType.Text,
            orderPlace = 4,
            dataType = Integer.class)
    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    @SetterOptions(name = "Duration in minutes", parseType = ParseType.Integer)
    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public List<LessonMeeting> getLessonMeetings() {
        return lessonMeetings;
    }

    public void setLessonMeetings(List<LessonMeeting> lessonMeetings) {
        this.lessonMeetings = lessonMeetings;
    }

    @Override
    public String getDescription() {
        return getLessonType().name() + ": " + getTopic();
    }
}
