package entities;

import annotattions.FrontDisplay;
import annotattions.InputType;
import annotattions.SetterOptions;
import jakarta.persistence.*;
import utils.ParseType;

import java.util.List;

@Entity
@Table(name = "student")
public class Student extends UserBase {

    @Column(name = "characteristic")
    public String characteristic;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student")
    private List<LessonMeeting> lessonMeetings;

    @FrontDisplay(name = "Characteristic",
            inputType = InputType.Text,
            orderPlace = 8,
            dataType = String.class,
            isRequired = false)
    public String getCharacteristic() {
        return characteristic;
    }

    @SetterOptions(name = "Characteristic", parseType = ParseType.String)
    public void setCharacteristic(String name) {
        this.characteristic = name;
    }

    public List<LessonMeeting> getLessonMeetings() {
        return lessonMeetings;
    }

    public void setLessonMeetings(List<LessonMeeting> lessonMeetings) {
        this.lessonMeetings = lessonMeetings;
    }
}
