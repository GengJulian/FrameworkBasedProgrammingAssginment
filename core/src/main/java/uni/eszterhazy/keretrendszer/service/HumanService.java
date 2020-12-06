package uni.eszterhazy.keretrendszer.service;

import uni.eszterhazy.keretrendszer.model.Human;

import java.util.Collection;

public interface HumanService {
    void addHuman(Human human);
    void editHuman(Human human);
    void removeHuman(java.lang.String id);
    Human getHumanById(java.lang.String id);
    Collection<Human> getAllHumans();
}
