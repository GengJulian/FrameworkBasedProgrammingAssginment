package uni.eszterhazy.keretrendszer.dao.relational;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import uni.eszterhazy.keretrendszer.dao.ResourceDAO;
import uni.eszterhazy.keretrendszer.model.Relationship;
import uni.eszterhazy.keretrendszer.model.Resource;

import java.util.Collection;

public class ResourceDAORelational implements ResourceDAO {
    private static SessionFactory factory;

    public ResourceDAORelational() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void createResource(Resource resource) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(resource);
        tx.commit();
        session.close();
    }

    @Override
    public Resource readResourceByResourceID(String resourceId) {
        Session session= factory.openSession();
        String hql = "FROM Resource WHERE id = :resourceId";
        Query query = session.createQuery(hql);
        query.setParameter("resourceId",resourceId);
        Resource result = (Resource) query.list();
        session.close();
        return result;
    }

    @Override
    public Collection<Resource> readAllResourcesOfMemory(String memoryId) {
        Session session= factory.openSession();
        String hql = "FROM Resource WHERE memoryId = :resourceId";
        Query query = session.createQuery(hql);
        query.setParameter("resourceId",memoryId);
        Collection<Resource> result = query.list();
        session.close();
        return result;
    }

    @Override
    public Collection<Resource> readAllResource() {
        Session session = factory.openSession();
        Collection<Resource> result = session.createQuery("FROM Resource").list();
        session.close();
        return result;
    }

    @Override
    public void updateResource(Resource resource) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(resource);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteResourceByResourceID(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        String queryString = "DELETE FROM Resource WHERE id = :parameter_id";
        Query query = session.createQuery(queryString);
        query.setParameter("parameter_id",id);
        query.executeUpdate();
        tx.commit();
        session.close();
    }

    @Override
    public void deleteResourceByMemoryID(String memoryId) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        String queryString = "DELETE FROM Resource WHERE memoryId = :parameter_id";
        Query query = session.createQuery(queryString);
        query.setParameter("parameter_id",memoryId);
        query.executeUpdate();
        tx.commit();
        session.close();
    }
}
