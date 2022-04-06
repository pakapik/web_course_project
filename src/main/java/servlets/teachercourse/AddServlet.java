package servlets.teachercourse;

import entities.TeacherCourse;
import servlets.ientity.AddIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/teachercourse/add")
public class AddServlet extends AddIEntityServlet<TeacherCourse> {

    public AddServlet() {
        super(TeacherCourse.class, "../WEB-INF/templates/teachercourse/add.jsp");
    }
}