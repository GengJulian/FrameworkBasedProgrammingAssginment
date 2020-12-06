package uni.eszterhazy.keretrendszer.serviceImpl;

import uni.eszterhazy.keretrendszer.dao.RelationshipDAO;
import uni.eszterhazy.keretrendszer.model.Relationship;
import uni.eszterhazy.keretrendszer.model.RelationshipType;
import uni.eszterhazy.keretrendszer.service.RelationshipService;

import java.util.Collection;
import java.util.stream.Collectors;

public class RelationshipServiceImpl implements RelationshipService {
    RelationshipDAO dao;


    public RelationshipServiceImpl(RelationshipDAO dao){
        this.dao = dao;
    }

    public RelationshipServiceImpl(){}

    @Override
    public void addRelationship(Relationship relationship) {
        dao.createRelationship(relationship);
    }

    @Override
    public void editRelationship(Relationship relationship) {
        dao.updateRelationship(relationship);
    }

    @Override
    public void deleteRelationship(String userId, String memoryId) {
        dao.deleteRelationship(userId,memoryId);
    }

    @Override
    public Relationship getRelationship(String userId, String memoryId) {
        return dao.readRelationship(userId,memoryId);
    }

    @Override
    public Collection<Relationship> getAllRelationship() {
        return dao.readAllRelationship();
    }

    @Override
    public Collection<Relationship> getAllRelationshipByUser(String userId) {
        return dao.readAllRelationshipByUserId(userId);
    }

    @Override
    public Collection<Relationship> getAllRelationShipByMemory(String memoryId) {
        return dao.readAllRelationshipByMemoryId(memoryId);
    }

    @Override
    public Collection<Relationship> getAllOwnershipByUser(String userId) {
        Collection<Relationship> relationshipsOfUser = dao.readAllRelationshipByUserId(userId);

        return relationshipsOfUser
                .stream()
                .filter(relationship -> relationship.getType() == RelationshipType.owner)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Relationship> getAllParticipationByMemory(String memoryId) {
        Collection<Relationship> relationshipsOfMemory = dao.readAllRelationshipByMemoryId(memoryId);

        return relationshipsOfMemory
                .stream()
                .filter(relationship -> relationship.getType() == RelationshipType.participant)
                .collect(Collectors.toList());
    }
}
