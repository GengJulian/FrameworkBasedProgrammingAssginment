package uni.eszterhazy.keretrendszer.dao.relational;

import org.junit.BeforeClass;
import org.junit.Test;
import uni.eszterhazy.keretrendszer.exceptions.HumanAlreadyCreated;
import uni.eszterhazy.keretrendszer.exceptions.HumanNotFound;
import uni.eszterhazy.keretrendszer.model.Human;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

public class HumanDAORelationalTest {
    static HumanDAORelational dao;
    static Human human;

    @BeforeClass
    public static void init(){
        dao = new HumanDAORelational();
        human = new Human();
        human.setFirstName("John");
        human.setLastName("Wick");
        human.setUserId(UUID.randomUUID().toString());
    }

    @Test
    public void createHuman() throws HumanAlreadyCreated {
        System.out.println("Create "+ human);
        dao.createHuman(human);
    }

    @Test
    public void readAllHuman() {
        ArrayList<Human> humans = (ArrayList<Human>) dao.readAllHuman();
        assertNotEquals(0,humans.size());
    }

    @Test
    public void readHuman() throws HumanNotFound, HumanAlreadyCreated {
        //dao.createHuman(human);
        System.out.println("Read "+ human);
        Human result = dao.readHuman(human.getUserId());
        assertNotEquals(null,result);
    }

    @Test
    public void updateHuman() throws HumanNotFound {
        human.setFirstName("Lorenz");
        dao.updateHuman(human);
        Human updated = dao.readHuman(human.getUserId());
        assertEquals("Lorenz",updated.getFirstName());
    }

    @Test
    public void deleteHuman() throws HumanNotFound {
        dao.deleteHuman(human.getUserId());
        //Human result = dao.readHuman(human.getUserId());
        //assertEquals(null,result);
    }
}