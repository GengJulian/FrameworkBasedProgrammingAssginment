package uni.eszterhazy.keretrendszer.dao;

import uni.eszterhazy.keretrendszer.model.Resource;

import java.util.Collection;

public interface ResourceDAO {
    void createResource(Resource resource);
    Resource readResourceByResourceID(String resourceId);
    Collection<Resource> readAllResourcesOfMemory(String memoryId);
    Collection<Resource> readAllResource();
    void updateResource(Resource resource);
    void deleteResourceByResourceID(String resourceId);
    void deleteResourceByMemoryID(String memoryId);
}
