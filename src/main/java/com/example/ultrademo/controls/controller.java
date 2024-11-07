package com.example.ultrademo.controls;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ultrademo.object.order;
import com.example.ultrademo.repos.orderRepos;




@Controller
public class controller {

    private orderRepos or;

    @GetMapping("/add")
    public String addPage(){
        return "add";
    }
    
    @PostMapping("/add")
    public String createObject( @RequestParam String oborudovanie,
                                @RequestParam String typeProblem,
                                @RequestParam String description,
                                @RequestParam String user) {
        
        order a = new order();
        a.setOborudovanie(oborudovanie);
        a.setTypeProblem(typeProblem);
        a.setDescription(description);
        a.setDayStart(LocalDate.now());
        a.setUser(user);
        a.setStatus("в ожидании");
        or.save(a);

        return "redirect:/";
    }

       @GetMapping("/rdact{id}")
    public String radactPage(@PathVariable(value = "id") int id,Model model){
        order z = or.findById(id);
        model.addAttribute("zaja", z);
        
        return "redact";
    }
    @PostMapping("/rdact{id}")
    public String radactObject( @RequestParam String status,
                                @RequestParam String description,
                                @RequestParam String worcer,
                                @PathVariable(value = "id") int id,
                                Model model) {
        
        order a = or.findById(id);
        a.setDescription(description);
        a.setStatus(status);
        a.setWorcer(worcer);
        or.save(a);

        return "redirect:/all";
    }
    

}
