package uni.eszterhazy.keretrendszer.service;

import uni.eszterhazy.keretrendszer.exceptions.HumanAlreadyCreated;
import uni.eszterhazy.keretrendszer.model.Human;
import uni.eszterhazy.keretrendszer.model.Memory;

import java.util.Collection;

public interface HumanService {
    void addHuman(Human human) throws HumanAlreadyCreated;
    void editHuman(Human human);
    void removeHuman(String id);
    void addMemory(Memory memory);
    void forgetMemory(Memory memory);
    Memory getLatestMemory();
    void forgetAllTheMemories();
    void forgetBadMemories();
    Collection<Human> getDepressedHumans();
}
