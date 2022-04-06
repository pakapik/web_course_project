package servlets.ientity;

import entities.IEntity;
import org.postgresql.util.PSQLException;
import servlets.PropertiesSetter;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLIntegrityConstraintViolationException;

public class AddIEntityServlet<T extends IEntity> extends HttpServlet {

    protected final Class<T> type;
    protected final String addJspPath;

    protected AddIEntityServlet(Class<T> type, String addJspPath) {
        this.type = type;
        this.addJspPath = addJspPath;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(addJspPath).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            var constructor = type.getConstructor( null);
            var entity = constructor.newInstance(null);
            PropertiesSetter.set(entity, req);
            HibernateUtil.add(entity);
            doGet(req, resp);
        }
        catch(Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("../WEB-INF/templates/errors/error.jsp").forward(req, resp);
        }
    }
}