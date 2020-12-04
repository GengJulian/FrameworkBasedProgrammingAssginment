package uni.eszterhazy.keretrendszer.dao.relational;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import uni.eszterhazy.keretrendszer.dao.RelationshipDAO;
import uni.eszterhazy.keretrendszer.model.Relationship;

import java.util.Collection;

public class RelationshipDAORelational implements RelationshipDAO {
    private static SessionFactory factory;

    public RelationshipDAORelational() {
        factory = new Configuration().configure().buildSessionFactory();
    }


    @Override
    public void createRelationship(Relationship relationship) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(relationship);
        tx.commit();
        session.close();
    }

    @Override
    public Relationship readRelationship(String userId, String memoryId) {
        Session session= factory.openSession();
        String hql = "FROM Relationship WHERE userId = :userId AND memoryId = :memoryId";
        Query query = session.createQuery(hql);
        query.setParameter("userId",userId);
        query.setParameter("memoryId",memoryId);
        Relationship result = (Relationship) query.list();
        session.close();
        return result;
    }

    @Override
    public Collection<Relationship> readAllRelationship() {
        Session session= factory.openSession();
        Collection<Relationship> result = session.createQuery("FROM Relationship").list();
        session.close();
        return result;
    }

    @Override
    public Collection<Relationship> readAllRelationshipByUserId(String userId) {
        Session session= factory.openSession();
        String hql = "FROM Relationship WHERE userId = :userId";
        Query query = session.createQuery(hql);
        query.setParameter("userId",userId);
        Collection<Relationship> result = (Collection<Relationship>) query.list();
        session.close();
        return result;
    }

    @Override
    public Collection<Relationship> readAllRelationshipByMemoryId(String memoryId) {
        Session session= factory.openSession();
        String hql = "FROM Relationship WHERE memoryId = :memoryId";
        Query query = session.createQuery(hql);
        query.setParameter("memoryId",memoryId);
        Collection<Relationship> result = (Collection<Relationship>) query.list();
        session.close();
        return result;
    }

    @Override
    public void updateRelationship(Relationship relationship) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(relationship);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteRelationship(String userId, String memoryId) {
        Session session= factory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM Relationship WHERE userId = :user_id AND memoryId = :memory_id";
        Query query = session.createQuery(hql);
        query.setParameter("memory_id",memoryId);
        query.setParameter("user_id",userId);
        query.executeUpdate();
        tx.commit();
        session.close();
    }

    @Override
    public void deleteRelationshipByUserId(String userId) {
        Session session= factory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM Relationship WHERE userId = :user_id";
        Query query = session.createQuery(hql);
        query.setParameter("user_id",userId);
        query.executeUpdate();
        tx.commit();
        session.close();
    }

    @Override
    public void deleteRelationshipByMemoryId(String memoryId) {
        Session session= factory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM Relationship WHERE memoryId = :memory_id";
        Query query = session.createQuery(hql);
        query.setParameter("memory_id",memoryId);
        query.executeUpdate();
        tx.commit();
        session.close();
    }
}
