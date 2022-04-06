package servlets.discount;

import entities.Discount;
import servlets.ientity.AddIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/discount/add")
public class AddServlet extends AddIEntityServlet<Discount> {

    public AddServlet() {
        super(Discount.class, "../WEB-INF/templates/discount/add.jsp");
    }
}