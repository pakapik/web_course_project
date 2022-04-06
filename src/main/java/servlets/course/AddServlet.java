package servlets.course;

import entities.Course;
import servlets.ientity.AddIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/course/add")
public class AddServlet extends AddIEntityServlet<Course> {

    public AddServlet() {
        super(Course.class, "../WEB-INF/templates/course/add.jsp");
    }
}