/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.projectpony.controllers;

import ajplarson.projectpony.models.Pony;
import ajplarson.projectpony.service.TheStable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import javax.validation.Valid;
import javax.validation.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ajplarson
 */
@Controller
public class TheBrainsOfTheBrony {

    private final TheStable stable;

    public TheBrainsOfTheBrony(TheStable stable) {
        this.stable = stable;
    }

    @GetMapping("/pony")
    public String home(Model model) {
        model.addAttribute("ponies", stable.allPonies());
        model.addAttribute("colors", stable.allColors());
        return "index";
    }

    @GetMapping("/pony/add")
    public String displayAdd(Pony p, Model model) {
        model.addAttribute("colors", stable.allColors());
        return "pony-add";
    }

    @PostMapping("/pony/add")
    public String add(@Valid Pony p, BindingResult result, Model model) {
        model.addAttribute("colors", stable.allColors());

        if (result.hasErrors()) {
            return "pony-add";
        }
        Pony existing = stable.findPonyByName(p.getPonyName());
        if (existing != null) {
            model.addAttribute("colors", stable.allColors());
            result.addError(new FieldError("pony", "ponyName", "Duplicate Name"));
            return "pony-add";
        }
        stable.addPony(p);
        return "redirect:/pony";
    }

}
