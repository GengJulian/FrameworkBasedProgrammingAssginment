package uni.eszterhazy.keretrendszer.dao;

import uni.eszterhazy.keretrendszer.model.Human;

import java.util.Collection;

public interface HumanDAO{
    void createHuman(Human human);
    Collection<Human> readAllHuman();
    Human readHuman(java.lang.String id);
    void updateHuman(Human human);
    void deleteHuman(java.lang.String id);
}
