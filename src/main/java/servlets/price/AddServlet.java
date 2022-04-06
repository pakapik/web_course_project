package servlets.price;

import entities.Price;
import servlets.ientity.AddIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/price/add")
public class AddServlet extends AddIEntityServlet<Price> {

    public AddServlet() {
        super(Price.class, "../WEB-INF/templates/price/add.jsp");
    }
}