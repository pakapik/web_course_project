package servlets.teacher;

import entities.Teacher;
import servlets.ientity.AddIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/teacher/add")
public class AddServlet extends AddIEntityServlet<Teacher> {

    public AddServlet() {
        super(Teacher.class, "../WEB-INF/templates/teacher/add.jsp");
    }
}