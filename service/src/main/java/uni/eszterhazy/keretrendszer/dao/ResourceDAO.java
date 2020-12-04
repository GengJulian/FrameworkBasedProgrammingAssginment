package uni.eszterhazy.keretrendszer.dao;

import uni.eszterhazy.keretrendszer.model.Resource;

import java.util.Collection;

public interface ResourceDAO {
    void createResource(Resource resource);
    Resource readResource(String id);
    Collection<Resource> readAllResource();
    void updateResource(Resource resource);
    void deleteResource(String id);
}
