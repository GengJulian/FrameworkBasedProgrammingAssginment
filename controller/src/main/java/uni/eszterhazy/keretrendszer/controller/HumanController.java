package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uni.eszterhazy.keretrendszer.model.Human;
import uni.eszterhazy.keretrendszer.service.HumanService;
import uni.eszterhazy.keretrendszer.service.MemoryService;

@Controller
public class HumanController {
    HumanService humanService;
    MemoryService memoryService;

    @Autowired
    public HumanController(HumanService service,MemoryService memoryService){
        this.humanService = service;
        this.memoryService = memoryService;
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

    @GetMapping(value="/deleteMemory/{id}")
    public String deleteMemory(@PathVariable String id, Model model){
        memoryService.removeMemory(id);

        return "redirect:/humans";
    }
}
