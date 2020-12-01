package uni.eszterhazy.keretrendszer.serviceImpl;

import uni.eszterhazy.keretrendszer.model.Human;
import uni.eszterhazy.keretrendszer.model.Memory;
import uni.eszterhazy.keretrendszer.model.MemoryType;
import uni.eszterhazy.keretrendszer.service.MemoryService;

import java.time.LocalDate;
import java.util.Collection;

public class MemoryServiceImpl implements MemoryService {
    @Override
    public void addMemory(Memory memory) {

    }

    @Override
    public void editMemory(Memory memory) {

    }

    @Override
    public void removeMemory(Memory memory) {

    }

    @Override
    public Memory getLatestMemoryOfOwner(Human owner) {
        return null;
    }

    @Override
    public Collection<Memory> getAllMemory() {
        return null;
    }

    @Override
    public Collection<Memory> getAllMemoryByOwner(Human owner) {
        return null;
    }

    @Override
    public Collection<Memory> getAllMemoryByParticipants(Collection<Human> participants) {
        return null;
    }

    @Override
    public Collection<Memory> getAllMemoryByType(MemoryType type) {
        return null;
    }

    @Override
    public Memory getConnectedMemories(LocalDate createdAt, Collection<Human> participants) {
        return null;
    }
}
