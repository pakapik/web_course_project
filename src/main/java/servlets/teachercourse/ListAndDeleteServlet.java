package servlets.teachercourse;

import entities.TeacherCourse;
import servlets.ientity.ListAndDeleteIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/teachercourse/list")
public class ListAndDeleteServlet extends ListAndDeleteIEntityServlet<TeacherCourse> {

    public ListAndDeleteServlet() {
        super(TeacherCourse.class,
                "../WEB-INF/templates/teachercourse/list.jsp",
                "teachercourse",
                "teachercourses");
    }
}
