package servlets.lesson;

import entities.Lesson;
import servlets.ientity.UpdateIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/lesson/update")
public class UpdateServlet extends UpdateIEntityServlet<Lesson> {

    public UpdateServlet() {
        super(Lesson.class,
                "../WEB-INF/templates/lesson/update.jsp",
                "lesson",
                "/lesson/list");
    }
}
