import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import uni.eszterhazy.keretrendszer.dao.HumanDAO;
import uni.eszterhazy.keretrendszer.dao.MemoryDAO;
import uni.eszterhazy.keretrendszer.dao.RelationshipDAO;
import uni.eszterhazy.keretrendszer.dao.ResourceDAO;
import uni.eszterhazy.keretrendszer.dao.relational.HumanDAORelational;
import uni.eszterhazy.keretrendszer.dao.relational.MemoryDAORelational;
import uni.eszterhazy.keretrendszer.dao.relational.RelationshipDAORelational;
import uni.eszterhazy.keretrendszer.dao.relational.ResourceDAORelational;
import uni.eszterhazy.keretrendszer.model.Relationship;
import uni.eszterhazy.keretrendszer.model.Resource;
import uni.eszterhazy.keretrendszer.service.MemoryService;
import uni.eszterhazy.keretrendszer.service.RelationshipService;
import uni.eszterhazy.keretrendszer.service.ResourceService;
import uni.eszterhazy.keretrendszer.serviceImpl.MemoryServiceImpl;
import uni.eszterhazy.keretrendszer.serviceImpl.RelationshipServiceImpl;
import uni.eszterhazy.keretrendszer.serviceImpl.ResourceServiceImpl;

@Configuration
@ComponentScan("uni.eszterhazy.keretrendszer.controller")
public class Config {
    @Bean
    public HumanDAO humanDAORelational(){
        try {
            return new HumanDAORelational();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return null;
    }

    @Bean
    public MemoryDAO memoryDAORelational(){
        try {
            return new MemoryDAORelational();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return null;
    }

    @Bean
    public RelationshipDAO relationshipDAORelational(){
        try {
            return new RelationshipDAORelational();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return null;
    }

    @Bean
    public ResourceDAO ResourceDAORelational(){
        try {
            return new ResourceDAORelational();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return null;
    }

    @Bean
    public MemoryService memoryService(MemoryDAO dao,
                                                     ResourceService resourceService,
                                                     RelationshipService relationshipService){
        try{
            return new MemoryServiceImpl(dao,resourceService,relationshipService);
        }catch (Exception exception){
            exception.printStackTrace();
        }

        return null;
    }

    @Bean
    public ResourceService resourceService(ResourceDAO dao){
        try{
            return new ResourceServiceImpl(dao);
        }catch (Exception exception){
            exception.printStackTrace();
        }

        return null;
    }

    @Bean
    public RelationshipService relationshipService(RelationshipDAO dao){
        try{
            return new RelationshipServiceImpl(dao);
        }catch (Exception exception){
            exception.printStackTrace();
        }

        return null;
    }
}
