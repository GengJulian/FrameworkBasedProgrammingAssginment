package uni.eszterhazy.keretrendszer.serviceImpl;

import uni.eszterhazy.keretrendszer.dao.RelationshipDAO;
import uni.eszterhazy.keretrendszer.model.Relationship;
import uni.eszterhazy.keretrendszer.service.RelationshipService;

import java.util.Collection;

public class RelationshipServiceImpl implements RelationshipService {
    RelationshipDAO dao;

    public RelationshipServiceImpl(RelationshipDAO dao){
        this.dao = dao;
    }


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
        return null;
    }

    @Override
    public Collection<Relationship> getAllRelationShipByMemory(String memoryId) {
        return null;
    }

    @Override
    public Collection<Relationship> getAllOwnerTypeOfRelationship(String userId) {
        return null;
    }

    @Override
    public Collection<Relationship> getAllParticipantTypeOfRelationship(String memoryId) {
        return null;
    }


}
