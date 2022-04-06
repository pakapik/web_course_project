package servlets.student;

import entities.Student;
import servlets.ientity.UpdateIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/student/update")
public class UpdateServlet extends UpdateIEntityServlet<Student> {

    public UpdateServlet() {
        super(Student.class,
                "../WEB-INF/templates/student/update.jsp",
                "student",
                "/student/list");
    }
}
