package uni.eszterhazy.keretrendszer.service;

import uni.eszterhazy.keretrendszer.exceptions.MemoryAlreadyExist;
import uni.eszterhazy.keretrendszer.model.Memory;
import uni.eszterhazy.keretrendszer.model.MemoryType;

import java.util.Collection;

public interface MemoryService {
    void addMemory(Memory memory) throws MemoryAlreadyExist;
    void editMemory(Memory memory);
    void removeMemory(String memoryId);
    Memory getLatestMemoryOfOwner(String userId);
    Memory getMemoryByMemoryId(String memoryId);
    Collection<Memory> getAllMemory();
    Collection<Memory> getAllMemoryOfOwner(String userId);
    Collection<Memory> getAllMemoryOfType(MemoryType type);
}
