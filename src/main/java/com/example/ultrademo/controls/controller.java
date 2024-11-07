package com.example.ultrademo.controls;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ultrademo.object.order;
import com.example.ultrademo.repos.orderRepos;

import ch.qos.logback.core.model.Model;



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
                                @RequestParam String user,
                                Model model) {
        
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


}
