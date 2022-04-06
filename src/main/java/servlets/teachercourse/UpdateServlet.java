package servlets.teachercourse;

import entities.TeacherCourse;
import servlets.ientity.UpdateIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/teachercourse/update")
public class UpdateServlet extends UpdateIEntityServlet<TeacherCourse> {

    public UpdateServlet() {
        super(TeacherCourse.class,
                "../WEB-INF/templates/teachercourse/update.jsp",
                "teachercourse",
                "/teachercourse/list");
    }
}
