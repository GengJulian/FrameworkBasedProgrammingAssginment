package uni.eszterhazy.keretrendszer.dao;

import uni.eszterhazy.keretrendszer.model.Relationship;

import java.util.Collection;

public interface RelationshipDAO {
    void createRelationship(Relationship relationship);
    Relationship readRelationship(String userId, String memoryId);
    Collection<Relationship> readAllRelationship();
    Collection<Relationship> readAllRelationshipByUserId(String userId);
    Collection<Relationship> readAllRelationshipByMemoryId(String memoryId);
    void updateRelationship(Relationship relationship);
    void deleteRelationship(String userId,String memoryId);
    void deleteRelationshipByUserId(String userId);
    void deleteRelationshipByMemoryId(String memoryId);
}
