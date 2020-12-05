package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uni.eszterhazy.keretrendszer.exceptions.MemoryAlreadyExist;
import uni.eszterhazy.keretrendszer.model.Memory;
import uni.eszterhazy.keretrendszer.service.MemoryService;

@Component
public class MemoryController {


    MemoryService memoryService;

    @Autowired
    public MemoryController(MemoryService memoryService){
        this.memoryService = memoryService;
    }

    public void addNewMemory(Memory memory) throws MemoryAlreadyExist {
        memoryService.addMemory(memory);
    }

}
