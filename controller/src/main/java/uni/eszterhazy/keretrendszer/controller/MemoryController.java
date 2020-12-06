package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uni.eszterhazy.keretrendszer.exceptions.MemoryAlreadyExist;
import uni.eszterhazy.keretrendszer.model.Human;
import uni.eszterhazy.keretrendszer.model.Memory;
import uni.eszterhazy.keretrendszer.model.RelationshipType;
import uni.eszterhazy.keretrendszer.service.MemoryService;

import java.time.LocalDateTime;
import java.util.Collection;

//@Component
@Controller
public class MemoryController {


    MemoryService memoryService;

    @Autowired
    public MemoryController(MemoryService memoryService){
        this.memoryService = memoryService;
    }

    public void addNewMemory(Memory memory) throws MemoryAlreadyExist {
        memoryService.addMemory(memory);
    }

    public Collection<Memory> getMemoriesOfUser(String id){
        return memoryService.getAllMemoryOfOwner(id);
    }

    @GetMapping(value="/memory/{id}")
    public String getMemory(@PathVariable String id, Model model){
        model.addAttribute("memory",memoryService.getMemoryByMemoryId(id));
        return "memoryDetails.jsp";
    }

    @GetMapping(value = "/addMemory/{id}")
    public String addMemoryForm(@PathVariable String id, Model model){
        model.addAttribute("memory", new Memory());
        model.addAttribute("types", RelationshipType.values());
        model.addAttribute("owner",id);
        return "memoryForm.jsp";
    }

    @PostMapping(value = "addMemory")
    public String addMemory(@ModelAttribute("memory") Memory memory){
        try {
            Human owner = new Human();
            owner.setUserId(memory.getOwnerId());
            memory.setOwner(owner);
            memory.setCreatedAt(LocalDateTime.now());
            memoryService.addMemory(memory);
        } catch (MemoryAlreadyExist memoryAlreadyExist) {
            memoryAlreadyExist.printStackTrace();
        }
        return "redirect:human/"+memory.getOwnerId();
    }
}
