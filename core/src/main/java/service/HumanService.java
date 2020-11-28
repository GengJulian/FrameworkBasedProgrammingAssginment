package service;

import model.Human;
import model.Memory;

import java.util.Collection;

public interface HumanService {
    void addHuman(Human human);
    void editHuman(Human human);
    void removeHuman(Human human);
    void addMemory(Memory memory);
    void forgetMemory(Memory memory);
    Memory getLatestMemory();
    void forgetAllTheMemories();
    void forgetBadMemories();
    Collection<Human> getDepressedHumans();
}
