package uni.eszterhazy.keretrendszer.dao;

import uni.eszterhazy.keretrendszer.exceptions.HumanAlreadyCreated;
import uni.eszterhazy.keretrendszer.exceptions.HumanNotFound;
import uni.eszterhazy.keretrendszer.model.Human;

import java.util.Collection;

public interface HumanDAO{
    void createHuman(Human human) throws HumanAlreadyCreated;
    Collection<Human> readAllHuman();
    Human readHuman(String id) throws HumanNotFound;
    void editHuman(Human human);
    void deleteHuman(String id);
}
