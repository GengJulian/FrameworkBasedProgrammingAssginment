package uni.eszterhazy.keretrendszer.serviceImpl;

import uni.eszterhazy.keretrendszer.dao.MemoryDAO;
import uni.eszterhazy.keretrendszer.exceptions.MemoryAlreadyExist;
import uni.eszterhazy.keretrendszer.model.*;
import uni.eszterhazy.keretrendszer.model.Human;
import uni.eszterhazy.keretrendszer.service.HumanService;
import uni.eszterhazy.keretrendszer.service.MemoryService;
import uni.eszterhazy.keretrendszer.service.RelationshipService;
import uni.eszterhazy.keretrendszer.service.ResourceService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;


public class MemoryServiceImpl implements MemoryService {
    MemoryDAO dao;
    ResourceService resourceService;
    RelationshipService relationshipService;
    HumanService humanService;

    public MemoryServiceImpl(MemoryDAO dao,
                             ResourceService resourceService,
                             RelationshipService relationshipService,
                             HumanService humanService){
        this.dao = dao;
        this.resourceService = resourceService;
        this.relationshipService = relationshipService;
        this.humanService = humanService;
    }

    @Override
    public void addMemory(Memory memory) throws MemoryAlreadyExist {
        dao.createMemory(memory);

        if(humanService.getHumanById(memory.getOwner().getUserId()) == null){
            humanService.addHuman(memory.getOwner());
        }

        Relationship ownership = new Relationship(
                memory.getOwner().getUserId(),
                memory.getId(),
                RelationshipType.owner);
        relationshipService.addRelationship(ownership);

        for(Human participant: memory.getParticipants()){
            if(humanService.getHumanById(participant.getUserId()) == null){
                humanService.addHuman(participant);
            }
            Relationship participation = new Relationship(
                    participant.getUserId(),
                    memory.getId(),
                    RelationshipType.participant);
            relationshipService.addRelationship(participation);

        }

        for (Resource resource: memory.getResources()){
            resourceService.addResource(resource);
        }

        //TODO resource elhelyezése típus alapján a megfelelő mappába
    }

    @Override
    public void editMemory(Memory memory) {
        dao.updateMemory(memory);
    }

    @Override
    public void removeMemory(String memoryId) {
        dao.deleteMemory(memoryId);
    }

    @Override
    public Memory getLatestMemoryOfOwner(String userId) {
        Collection<Memory> memories = this.getAllMemoryOfOwner(userId);
        ArrayList<Memory> sorted = (ArrayList<Memory>) memories
                .stream()
                .sorted(Comparator.comparing(Memory::getCreatedAt))
                .collect(Collectors.toList());

        return sorted.get(0);
    }

    @Override
    public Memory getMemoryByMemoryId(String memoryId) {
        return dao.readMemory(memoryId);
    }

    @Override
    public Collection<Memory> getAllMemory() {
        return dao.readAllMemory();
    }


    @Override
    public Collection<Memory> getAllMemoryOfOwner(String userId) {
        Collection<Relationship> ownershipsOfUser = relationshipService.getAllOwnershipByUser(userId);
        System.out.println(ownershipsOfUser);
        Collection<Memory> memories = new ArrayList<Memory>();
        for(Relationship relationship: ownershipsOfUser){
            memories.add(dao.readMemory(relationship.getMemoryId()));
        }

        return memories;
    }


    @Override
    public Collection<Memory> getAllMemoryOfType(MemoryType type) {
        Collection<Memory> memories = dao.readAllMemory();
        return memories.
                stream().
                filter(memory -> memory.getType() == type).
                collect(Collectors.toList());
    }

}
