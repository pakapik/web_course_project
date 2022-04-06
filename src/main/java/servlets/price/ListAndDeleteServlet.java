package servlets.price;

import entities.Price;
import servlets.ientity.ListAndDeleteIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/price/list")
public class ListAndDeleteServlet extends ListAndDeleteIEntityServlet<Price> {

    public ListAndDeleteServlet() {
        super(Price.class,
                "../WEB-INF/templates/price/list.jsp",
                "price",
                "prices");
    }
}
