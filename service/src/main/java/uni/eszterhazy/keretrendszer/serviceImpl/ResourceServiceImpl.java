package uni.eszterhazy.keretrendszer.serviceImpl;

import uni.eszterhazy.keretrendszer.dao.ResourceDAO;
import uni.eszterhazy.keretrendszer.model.Resource;
import uni.eszterhazy.keretrendszer.model.ResourceType;
import uni.eszterhazy.keretrendszer.service.ResourceService;

import java.util.Collection;
import java.util.stream.Collectors;

public class ResourceServiceImpl implements ResourceService {
    ResourceDAO dao;

    public ResourceServiceImpl(ResourceDAO dao){
        this.dao = dao;
    }

    @Override
    public void addResource(Resource resource) {
        dao.createResource(resource);
    }

    @Override
    public void editResource(Resource resource) {
        dao.updateResource(resource);
    }

    @Override
    public Resource readResourceById(String resourceId) {
        return dao.readResourceByResourceID(resourceId);
    }

    @Override
    public Collection<Resource> readAllResourceOfMemory(String memoryId) {
        return dao.readAllResourcesOfMemory(memoryId);
    }

    @Override
    public Collection<Resource> readAllResource() {
        return dao.readAllResource();
    }

    @Override
    public void removeResourceById(String resourceId) {
        dao.deleteResourceByResourceID(resourceId);
    }

    @Override
    public void removeResourcesOfMemory(String memoryId) {
        dao.deleteResourceByMemoryID(memoryId);
    }

    @Override
    public Collection<Resource> returnAllPicturesOfMemory(String memoryId) {
        Collection<Resource> resources = dao.readAllResourcesOfMemory(memoryId);
        Collection<Resource> pictures = resources
                .stream()
                .filter(resource -> resource.getType() == ResourceType.PICTURE)
                .collect(Collectors.toList());

        return  pictures;
    }

    @Override
    public Collection<Resource> returnAllLinksOfMemory(String memoryId) {
        Collection<Resource> resources = dao.readAllResourcesOfMemory(memoryId);
        Collection<Resource> links = resources
                .stream()
                .filter(resource -> resource.getType() == ResourceType.LINK)
                .collect(Collectors.toList());

        return  links;
    }
}
