package servlets.lessonmeeting;

import entities.LessonMeeting;
import servlets.ientity.UpdateIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/lessonmeeting/update")
public class UpdateServlet extends UpdateIEntityServlet<LessonMeeting> {

    public UpdateServlet() {
        super(LessonMeeting.class,
                "../WEB-INF/templates/lessonmeeting/update.jsp",
                "lessonmeeting",
                "/lessonmeeting/list");
    }
}
