package uni.eszterhazy.keretrendszer.dao;

import uni.eszterhazy.keretrendszer.exceptions.MemoryAlreadyExist;
import uni.eszterhazy.keretrendszer.exceptions.MemoryNotFound;
import uni.eszterhazy.keretrendszer.model.Memory;

import java.util.Collection;

public interface MemoryDAO {
    void createMemory(Memory memory) throws MemoryAlreadyExist;
    Memory readMemory(String id) throws MemoryNotFound;
    Collection<Memory> readAllMemory();
    void updateMemory(Memory memory);
    void deleteMemory(String id);
}
