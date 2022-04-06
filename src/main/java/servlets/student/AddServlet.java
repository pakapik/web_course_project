package servlets.student;

import entities.Student;
import servlets.ientity.AddIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/student/add")
public class AddServlet extends AddIEntityServlet<Student> {

    public AddServlet() {
        super(Student.class, "../WEB-INF/templates/student/add.jsp");
    }
}