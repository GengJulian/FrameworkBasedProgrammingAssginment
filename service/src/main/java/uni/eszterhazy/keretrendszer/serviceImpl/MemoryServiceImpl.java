package uni.eszterhazy.keretrendszer.serviceImpl;

import uni.eszterhazy.keretrendszer.dao.MemoryDAO;
import uni.eszterhazy.keretrendszer.exceptions.MemoryAlreadyExist;
import uni.eszterhazy.keretrendszer.model.*;
import uni.eszterhazy.keretrendszer.service.MemoryService;
import uni.eszterhazy.keretrendszer.service.RelationshipService;
import uni.eszterhazy.keretrendszer.service.ResourceService;

import java.time.LocalDate;
import java.util.Collection;

public class MemoryServiceImpl implements MemoryService {
    MemoryDAO dao;
    ResourceService resourceService;
    RelationshipService relationshipService;

    public MemoryServiceImpl(MemoryDAO dao,
                             ResourceService resourceService,
                             RelationshipService relationshipService){
        this.dao = dao;
        this.resourceService = resourceService;
        this.relationshipService = relationshipService;
    }

    @Override
    public void addMemory(Memory memory) throws MemoryAlreadyExist {
        dao.createMemory(memory);
        Relationship relationship = new Relationship(
                memory.getOwner().getUserId(),
                memory.getId(),
                RelationshipType.OWNER);
        relationshipService.addRelationship(relationship);

        for (Resource resource: memory.getResources()){
            resourceService.addResource(resource);
        }

        //TODO resource elhelyezése típus alapján a megfelelő mappába
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
