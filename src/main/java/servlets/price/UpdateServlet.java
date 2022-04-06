package servlets.price;

import entities.Price;
import servlets.ientity.UpdateIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/price/update")
public class UpdateServlet extends UpdateIEntityServlet<Price> {

    public UpdateServlet() {
        super(Price.class,
                "../WEB-INF/templates/price/update.jsp",
                "price",
                "/price/list");
    }
}
