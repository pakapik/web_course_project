package servlets.lessonmeeting;

import entities.LessonMeeting;
import servlets.ientity.ListAndDeleteIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/lessonmeeting/list")
public class ListAndDeleteServlet extends ListAndDeleteIEntityServlet<LessonMeeting> {

    public ListAndDeleteServlet() {
        super(LessonMeeting.class,
                "../WEB-INF/templates/lessonmeeting/list.jsp",
                "lessonmeeting",
                "lessonmeetings");
    }
}
