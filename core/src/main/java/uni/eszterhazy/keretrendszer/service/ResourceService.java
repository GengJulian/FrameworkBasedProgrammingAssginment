package uni.eszterhazy.keretrendszer.service;

import uni.eszterhazy.keretrendszer.model.Resource;

import java.util.Collection;

public interface ResourceService {
    void addResource(Resource resource);
    void editResource(Resource resource);
    Resource readResourceById(String resourceId);
    Collection<Resource> readAllResourceOfMemory(String memoryId);
    Collection<Resource> readAllResource();
    void removeResourceById(String resourceId);
    void removeResourcesOfMemory(String memoryId);
    Collection<Resource> returnAllPicturesOfMemory(String memoryId);
    Collection<Resource> returnAllLinksOfMemory(String memoryId);
}
