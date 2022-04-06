package servlets.lessonmeeting;

import entities.LessonMeeting;
import servlets.ientity.AddIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/lessonmeeting/add")
public class AddServlet extends AddIEntityServlet<LessonMeeting> {

    public AddServlet() {
        super(LessonMeeting.class, "../WEB-INF/templates/lessonmeeting/add.jsp");
    }
}