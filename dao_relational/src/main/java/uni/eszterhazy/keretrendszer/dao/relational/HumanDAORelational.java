package uni.eszterhazy.keretrendszer.dao.relational;

import uni.eszterhazy.keretrendszer.dao.HumanDAO;
import uni.eszterhazy.keretrendszer.exceptions.HumanAlreadyCreated;
import uni.eszterhazy.keretrendszer.exceptions.HumanNotFound;
import uni.eszterhazy.keretrendszer.model.Human;

import java.util.Collection;

public class HumanDAORelational implements HumanDAO {

    @Override
    public void createHuman(Human human) throws HumanAlreadyCreated {

    }

    @Override
    public Collection<Human> readAllHuman() {
        return null;
    }

    @Override
    public Human readHuman(String id) throws HumanNotFound {
        return null;
    }

    @Override
    public void editHuman(Human human) {

    }

    @Override
    public void deleteHuman(String id) {

    }
}
