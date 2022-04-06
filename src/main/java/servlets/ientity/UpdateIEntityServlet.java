package servlets.ientity;

import entities.IEntity;
import servlets.PropertiesSetter;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateIEntityServlet<T extends IEntity> extends HttpServlet {

    protected final Class<T> type;
    protected final String updateJspPath;
    protected final String attributeName;
    protected final String listJspPath;


    protected UpdateIEntityServlet(Class<T> type,
                                   String updateJspPath,
                                   String attributeName,
                                   String listJspPath) {
        this.type = type;
        this.updateJspPath = updateJspPath;
        this.attributeName = attributeName;
        this.listJspPath = listJspPath;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(updateJspPath).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(req.getAttribute(attributeName) != null) {
            doGet(req, resp);
            return;
        }

        var id = req.getParameter("Id");
        if(id != null && !id.isEmpty()) {
            try {
                var entityWithId = HibernateUtil.getById(type, Long.parseLong(id));
                PropertiesSetter.set(entityWithId, req);
                HibernateUtil.update(entityWithId);
            } catch (Throwable e) {
                req.setAttribute("error", e.getMessage());
                req.getRequestDispatcher("../WEB-INF/templates/errors/error.jsp");
            }

            resp.sendRedirect(listJspPath);
        }
    }
}