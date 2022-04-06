package servlets.course;

import entities.Course;
import servlets.ientity.UpdateIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/course/update")
public class UpdateServlet extends UpdateIEntityServlet<Course> {

    public UpdateServlet() {
        super(Course.class,
                "../WEB-INF/templates/course/update.jsp",
                "course",
                "/course/list");
    }
}