package servlets.teacher;

import entities.Teacher;
import servlets.ientity.ListAndDeleteIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/teacher/list")
public class ListAndDeleteServlet extends ListAndDeleteIEntityServlet<Teacher> {

    public ListAndDeleteServlet() {
        super(Teacher.class,
                "../WEB-INF/templates/teacher/list.jsp",
                "teacher",
                "teachers");
    }
}
