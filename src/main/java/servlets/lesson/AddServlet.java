package servlets.lesson;

import entities.Lesson;
import servlets.ientity.AddIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/lesson/add")
public class AddServlet extends AddIEntityServlet<Lesson> {

    public AddServlet() {
        super(Lesson.class, "../WEB-INF/templates/lesson/add.jsp");
    }
}