package servlets.lesson;

import entities.Lesson;
import servlets.ientity.ListAndDeleteIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/lesson/list")
public class ListAndDeleteServlet extends ListAndDeleteIEntityServlet<Lesson> {

    public ListAndDeleteServlet() {
        super(Lesson.class,
                "../WEB-INF/templates/lesson/list.jsp",
                "lesson",
                "lessons");
    }
}
