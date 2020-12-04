package uni.eszterhazy.keretrendszer.dao.relational;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import uni.eszterhazy.keretrendszer.dao.HumanDAO;
import uni.eszterhazy.keretrendszer.exceptions.HumanAlreadyCreated;
import uni.eszterhazy.keretrendszer.exceptions.HumanNotFound;
import uni.eszterhazy.keretrendszer.model.Human;

import java.util.Collection;

public class HumanDAORelational implements HumanDAO {
    private static SessionFactory factory;
    private static Logger logger = Logger.getLogger("daoLogger");

    public HumanDAORelational() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void createHuman(Human human) throws HumanAlreadyCreated {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(human);
        tx.commit();
        session.close();
        logger.info(human.getFirstName() + " " + human.getLastName() + " is saved to the database!");
    }

    @Override
    public Collection<Human> readAllHuman() {
        Session session = factory.openSession();
        Collection<Human> result = session.createQuery("FROM Human").list();
        logger.info(result.size() + " human has been retrieved from the database!");
        return result;
    }

    @Override
    public Human readHuman(String id) throws HumanNotFound {
        Session session= factory.openSession();
        Human result = session.get(Human.class, id);
        //logger.info(result.getFirstName() + " " + result.getLastName()+" is retrieved from the database!");
        return result;
    }

    @Override
    public void updateHuman(Human human) {
        Session session= factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(human);
        tx.commit();
        logger.info(human.getFirstName() + " " + human.getLastName() + "is updated!");
    }

    @Override
    public void deleteHuman(String id) {
        Session session= factory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM Human WHERE id = :human_id";
        //String hql = "DELETE FROM Human WHERE firstname = 'Lorenz'";
        Query query = session.createQuery(hql);
        query.setParameter("human_id",id);
        query.executeUpdate();
        tx.commit();
        logger.info("Human with id:"+ id + " has been deleted from the database!");

    }
}
