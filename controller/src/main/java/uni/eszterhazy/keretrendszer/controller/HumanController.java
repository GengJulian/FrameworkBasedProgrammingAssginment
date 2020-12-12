package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uni.eszterhazy.keretrendszer.model.Human;
import uni.eszterhazy.keretrendszer.service.HumanService;
import uni.eszterhazy.keretrendszer.service.MemoryService;

import java.util.UUID;

@Controller
public class HumanController {
    HumanService humanService;
    MemoryService memoryService;

    @Autowired
    public HumanController(HumanService service,MemoryService memoryService){
        this.humanService = service;
        this.memoryService = memoryService;
    }

    @ExceptionHandler(Exception.class)
    public String foundException(Exception e){
        System.out.println(e.getMessage());
        return e.getMessage();
    }

    @GetMapping(value="/humans")
    public String getHumans(Model model){
        model.addAttribute("humans",humanService.getAllHumans());
        return "humanList.jsp";
    }

    @GetMapping(value="/human/{id}")
    public String getHumanById(@PathVariable String id, Model model){
        model.addAttribute("human", humanService.getHumanById(id));
        model.addAttribute("memories", memoryService.getAllMemoryOfOwner(id));
        return "humanDetails.jsp";
    }

    @GetMapping(value="/addHuman")
    public String addHumanForm(Model model){
        model.addAttribute("human",new Human());
        return "humanForm.jsp";
    }

    @PostMapping(value = "addHuman")
    public String addHuman(@ModelAttribute("human") Human human){
        human.setUserId(UUID.randomUUID().toString());
        humanService.addHuman(human);
        return "redirect:humans/";
    }

}
