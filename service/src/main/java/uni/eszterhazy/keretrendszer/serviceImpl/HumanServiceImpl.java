package uni.eszterhazy.keretrendszer.serviceImpl;

import uni.eszterhazy.keretrendszer.dao.HumanDAO;
import uni.eszterhazy.keretrendszer.model.Human;
import uni.eszterhazy.keretrendszer.model.Relationship;
import uni.eszterhazy.keretrendszer.service.HumanService;
import uni.eszterhazy.keretrendszer.service.RelationshipService;

import java.util.ArrayList;
import java.util.Collection;

public class HumanServiceImpl implements HumanService {
    private HumanDAO dao;
    private RelationshipService relationshipService;

    public HumanServiceImpl(HumanDAO dao,RelationshipService relationshipService){
        this.dao = dao;
        this.relationshipService = relationshipService;
    }

    @Override
    public void addHuman(Human human){
        dao.createHuman(human);
    }

    @Override
    public void editHuman(Human human) {
        dao.updateHuman(human);
    }

    @Override
    public void removeHuman(java.lang.String id) {
        dao.deleteHuman(id);
    }

    @Override
    public Human getHumanById(java.lang.String id){
        Human human = dao.readHuman(id);
        ArrayList<Relationship> ownerships = (ArrayList<Relationship>) relationshipService.getAllOwnershipByUser(human.getUserId());
        if(ownerships == null){
            human.setNumberOfMemories(0);
        }else{
            human.setNumberOfMemories(ownerships.size());
        }
        return human;
    }

    @Override
    public Collection<Human> getAllHumans() {
        Collection<Human> humans = dao.readAllHuman();
        for (Human human : humans){
            ArrayList<Relationship> ownerships = (ArrayList<Relationship>) relationshipService.getAllOwnershipByUser(human.getUserId());
            if(  ownerships == null){
                human.setNumberOfMemories(0);
            }else{
                human.setNumberOfMemories(ownerships.size());
            }

        }
        return humans;

        //return dao.readAllHuman();
    }
}
