package service;

import model.Memory;
import model.MemoryType;
import model.Human;

import java.time.LocalDate;
import java.util.Collection;

public interface MemoryService {
    void addMemory(Memory memory);
    void editMemory(Memory memory);
    void removeMemory(Memory memory);
    Memory getLatestMemoryOfOwner(Human owner);
    Collection<Memory> getAllMemory();
    Collection<Memory> getAllMemoryByOwner(Human owner);
    Collection<Memory> getAllMemoryByParticipants(Collection<Human> participants);
    Collection<Memory> getAllMemoryByType(MemoryType type);
    Memory getConnectedMemories(LocalDate createdAt,Collection<Human> participants);
}
