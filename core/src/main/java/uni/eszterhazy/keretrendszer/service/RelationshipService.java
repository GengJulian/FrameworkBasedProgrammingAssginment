package uni.eszterhazy.keretrendszer.service;

import uni.eszterhazy.keretrendszer.model.Relationship;

import java.util.Collection;

public interface RelationshipService {
    void addRelationship(Relationship relationship);
    void editRelationship(Relationship relationship);
    void deleteRelationship(String userId,String memoryId);
    Relationship getRelationship(String userId,String memoryId);
    Collection<Relationship> getAllRelationship();
    Collection<Relationship> getAllRelationshipByUser(String userId);
    Collection<Relationship> getAllRelationShipByMemory(String memoryId);
    Collection<Relationship> getAllOwnershipByUser(String userId);
    Collection<Relationship> getAllParticipationByMemory(String memoryId);
}
