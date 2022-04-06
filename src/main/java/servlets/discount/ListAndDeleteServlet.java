package servlets.discount;

import entities.Discount;
import servlets.ientity.ListAndDeleteIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/discount/list")
public class ListAndDeleteServlet extends ListAndDeleteIEntityServlet<Discount> {

    public ListAndDeleteServlet() {
        super(Discount.class,
                "../WEB-INF/templates/discount/list.jsp",
                "discount",
                "discounts");
    }
}
