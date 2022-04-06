package servlets.discount;

import entities.Discount;
import servlets.ientity.UpdateIEntityServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/discount/update")
public class UpdateServlet extends UpdateIEntityServlet<Discount> {

    public UpdateServlet() {
        super(Discount.class,
                "../WEB-INF/templates/discount/update.jsp",
                "discount",
                "/discount/list");
    }
}
