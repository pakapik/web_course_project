package utils;

import entities.IEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try {
            return new Configuration()
                    .configure()
                    .buildSessionFactory();
        }
        catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw  new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }

    public static <T> List<T> getAll(Class<T> type) {
        var session = sessionFactory.openSession();
        session.beginTransaction();

        var cb = session.getCriteriaBuilder();
        var cq = cb.createQuery(type);
        var rootEntry = cq.from(type);
        var all = cq.select(rootEntry);
        var allQuery = session.createQuery(all);
        var list = allQuery.getResultList();

        session.getTransaction().commit();
        session.close();

        // TODO: мб, имеет смысл HashSet бахнуть.
        return list;
    }

    public static <T> T getById(Class<T> type, Serializable id){
        var session = sessionFactory.openSession();
        session.beginTransaction();
        var item = session.get(type, id);
        session.getTransaction().commit();
        session.close();

        return item;
    }

    public static void execute(Consumer<Session> consumer) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        consumer.accept(session);
        session.getTransaction().commit();
        session.close();
    }

    public static <T extends IEntity> void delete(T entity) {
        execute(session ->
        {
            var entityWithId = session.get(entity.getClass(), entity.getId());
            session.delete(entityWithId);
        });
    }

    public static <T extends IEntity> void update(T entity) { execute(session -> session.update(entity)); }

    public static <T> void add(T entity) {
        execute(session -> session.saveOrUpdate(entity));
    }
}
