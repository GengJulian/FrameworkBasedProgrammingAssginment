package uni.eszterhazy.keretrendszer.serviceImpl;

import uni.eszterhazy.keretrendszer.dao.HumanDAO;
import uni.eszterhazy.keretrendszer.exceptions.HumanAlreadyCreated;
import uni.eszterhazy.keretrendszer.model.Human;
import uni.eszterhazy.keretrendszer.model.Memory;
import uni.eszterhazy.keretrendszer.service.HumanService;

import java.util.Collection;

public class HumanServiceImpl implements HumanService {
    private HumanDAO dao;

    public HumanServiceImpl(HumanDAO dao){
        this.dao = dao;
    }

    @Override
    public void addHuman(Human human) throws HumanAlreadyCreated {
        dao.createHuman(human);
    }

    @Override
    public void editHuman(Human human) {
        dao.updateHuman(human);
    }

    @Override
    public void removeHuman(String id) {
        dao.deleteHuman(id);
    }

    @Override
    public void addMemory(Memory memory) {

    }

    @Override
    public void forgetMemory(Memory memory) {

    }

    @Override
    public Memory getLatestMemory() {
        return null;
    }

    @Override
    public void forgetAllTheMemories() {

    }

    @Override
    public void forgetBadMemories() {

    }

    @Override
    public Collection<Human> getDepressedHumans() {
        return null;
    }
}
