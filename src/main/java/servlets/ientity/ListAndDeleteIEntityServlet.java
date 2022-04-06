package servlets.ientity;

import entities.IEntity;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListAndDeleteIEntityServlet<T extends IEntity> extends HttpServlet {

    protected final Class<T> type;
    protected final String listJspPath;
    protected final String entityAttributeName;
    protected final String entitiesAttributeName;

    public ListAndDeleteIEntityServlet(Class<T> type,
                                       String listJspPath,
                                       String entityAttributeName,
                                       String entitiesAttributeName) {
        this.type = type;
        this.listJspPath = listJspPath;
        this.entityAttributeName = entityAttributeName;
        this.entitiesAttributeName = entitiesAttributeName;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        var entities = HibernateUtil.getAll(type);
        req.setAttribute(entitiesAttributeName, entities);
        req.getRequestDispatcher(listJspPath).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        var param = req.getParameter("id");
        if(param == null || param.isEmpty()) {
            doGet(req, resp);
            return;
        }

        var id = Long.parseLong(param);
        var entity = HibernateUtil.getById(type, id);

        var action = req.getParameter("action");
        switch (action) {
            case "update" -> {
                req.setAttribute(entityAttributeName, entity);
                req.getRequestDispatcher("/" + entityAttributeName + "/update").forward(req, resp);
                break;
            }
            case "delete" -> {
                HibernateUtil.delete(entity);
                doGet(req, resp);
                break;
            }
        }
    }
}