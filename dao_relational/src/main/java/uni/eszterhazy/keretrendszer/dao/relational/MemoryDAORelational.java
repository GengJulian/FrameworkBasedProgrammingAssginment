package uni.eszterhazy.keretrendszer.dao.relational;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import uni.eszterhazy.keretrendszer.dao.MemoryDAO;
import uni.eszterhazy.keretrendszer.exceptions.MemoryAlreadyExist;
import uni.eszterhazy.keretrendszer.exceptions.MemoryNotFound;
import uni.eszterhazy.keretrendszer.model.Memory;

import java.util.Collection;

public class MemoryDAORelational implements MemoryDAO {
    private static SessionFactory factory;
    private static Logger logger = Logger.getLogger("daoLogger");

    public MemoryDAORelational() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void createMemory(Memory memory) throws MemoryAlreadyExist {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(memory);
        tx.commit();
        session.close();
        logger.info(memory.getId()+ " is saved to the database!");
    }

    @Override
    public Memory readMemory(String id) throws MemoryNotFound {
        Session session= factory.openSession();
        Memory result = session.get(Memory.class, id);
        //logger.info(result.getFirstName() + " " + result.getLastName()+" is retrieved from the database!");
        return result;
    }

    @Override
    public Collection<Memory> readAllMemory() {
        Session session = factory.openSession();
        Collection<Memory> result = session.createQuery("FROM Memory").list();
        logger.info(result.size() + " memory has been retrieved from the database!");
        return result;
    }

    @Override
    public void updateMemory(Memory memory) {
        Session session= factory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(memory);
        tx.commit();
        logger.info("Memory with id: "+memory.getId() + " is updated!");
    }

    @Override
    public void deleteMemory(String id) {
        Session session= factory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM Memory WHERE id = :memory_id";
        Query query = session.createQuery(hql);
        query.setParameter("memory_id",id);
        query.executeUpdate();
        tx.commit();
        logger.info("Memory with id:"+ id + " has been deleted from the database!");
    }
}
