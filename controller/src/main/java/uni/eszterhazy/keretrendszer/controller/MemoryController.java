package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uni.eszterhazy.keretrendszer.exceptions.MemoryAlreadyExist;
import uni.eszterhazy.keretrendszer.model.Human;
import uni.eszterhazy.keretrendszer.model.Memory;
import uni.eszterhazy.keretrendszer.model.MemoryType;
import uni.eszterhazy.keretrendszer.model.RelationshipType;
import uni.eszterhazy.keretrendszer.service.MemoryService;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

//@Component
@Controller
public class MemoryController {
    MemoryService memoryService;

    @Autowired
    public MemoryController(MemoryService memoryService){
        this.memoryService = memoryService;
    }

    /*
    @ModelAttribute(value = "memory")
    public Memory createMemory(){
        return new Memory();
    }*/
    @ExceptionHandler(Exception.class)
    public String foundException(Exception e){
        System.out.println(e.getMessage());
        return e.getMessage();
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
        model.addAttribute("types", MemoryType.values());
        model.addAttribute("owner",id);
        return "memoryForm.jsp";
    }

    @PostMapping(value = "addMemory")
    public String addMemory(@ModelAttribute("memory") Memory memory){
        System.out.println(memory);
        try {
            Human owner = new Human();
            owner.setUserId(memory.getOwnerId());
            System.out.println(owner.getUserId());
            memory.setOwner(owner);
            memory.setCreatedAt(LocalDateTime.now());
            memory.setId(UUID.randomUUID().toString());
            memoryService.addMemory(memory);
        } catch (MemoryAlreadyExist memoryAlreadyExist) {
            memoryAlreadyExist.printStackTrace();
        }
        return "redirect:human/"+memory.getOwnerId();
    }

    @GetMapping(value="/deleteMemory/{id}")
    public String deleteMemory(@PathVariable String id, Model model){
        Memory memory = memoryService.getMemoryByMemoryId(id);
        String humanId = memory.getOwnerId();
        memoryService.removeMemory(id);

        return "redirect:../human/"+humanId;
    }

    @GetMapping(value = "/editMemory/{id}")
    public String editMemoryForm(@PathVariable String id, Model model){
        //model.addAttribute("memory", new Memory());
        Memory editable = memoryService.getMemoryByMemoryId(id);
        model.addAttribute("memory",editable);
        model.addAttribute("types", MemoryType.values());
        return "memoryEdit.jsp";
    }

    @PostMapping(value = "editMemory")
    public String editMemory(@ModelAttribute("memory") Memory memory){
        try {
            memory.setCreatedAt(LocalDateTime.now());
            memoryService.editMemory(memory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:memory/"+memory.getId();
    }


}
