package servlets.student;

import entities.Student;
import servlets.ientity.ListAndDeleteIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/student/list")
public class ListAndDeleteServlet extends ListAndDeleteIEntityServlet<Student> {

    public ListAndDeleteServlet() {
        super(Student.class,
                "../WEB-INF/templates/student/list.jsp",
                "student",
                "students");
    }
}
