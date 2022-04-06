package servlets.teacher;

import entities.Teacher;
import servlets.ientity.UpdateIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/teacher/update")
public class UpdateServlet extends UpdateIEntityServlet<Teacher> {

    public UpdateServlet() {
        super(Teacher.class,
                "../WEB-INF/templates/teacher/update.jsp",
                "teacher",
                "/teacher/list");
    }
}
