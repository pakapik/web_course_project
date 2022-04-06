package servlets.course;

import entities.Course;
import servlets.ientity.ListAndDeleteIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/course/list")
public class ListAndDeleteServlet extends ListAndDeleteIEntityServlet<Course> {

    public ListAndDeleteServlet() {
        super(Course.class,
                "../WEB-INF/templates/course/list.jsp",
                "course",
                "courses");
    }
}
