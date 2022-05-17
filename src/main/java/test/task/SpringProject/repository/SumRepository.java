package test.task.SpringProject.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import test.task.SpringProject.HibernateUtil.HibernateUtil;
import test.task.SpringProject.entity.SumEntity;
import test.task.SpringProject.exception.ServerException;
import test.task.SpringProject.exception.SessionCloseException;


@Repository
public class SumRepository {

    public SumEntity getById(String name) throws ServerException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        SumEntity record = session.get(SumEntity.class, name);
        closeSession(session);

        return record;
    }

    public void save(SumEntity record) throws ServerException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(record);

        session.getTransaction().commit();
        closeSession(session);
    }

    public void delete(SumEntity record) throws ServerException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.remove(record);

        session.getTransaction().commit();
        closeSession(session);
    }

    private static void closeSession(Session session) throws ServerException {
        try {
            session.close();
        } catch (HibernateException e) {
            throw new SessionCloseException();
        }
    }
}
