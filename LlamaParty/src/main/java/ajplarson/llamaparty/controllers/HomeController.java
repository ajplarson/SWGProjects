/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.llamaparty.controllers;

import ajplarson.llamaparty.models.RSVP;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ajplarson
 */
@Controller
public class HomeController {

    List<String> guests = new ArrayList<>();
    Integer sumOfLlamas = 0;

    @GetMapping("/PartyApp")
    public String getHome() {
        return "index";
    }

    @GetMapping("/PartyApp/RSVP")
    public String getRSVP() {
        return "rsvp";
    }

    @PostMapping("/PartyApp/RSVP")
    public String submitRSVP(Model model, RSVP rsvp) {
        model.addAttribute("rsvp", rsvp);
        Integer average = 0;
        if (!(rsvp.isIsGoing())) {
            return "decline";
        } else if (rsvp.getName().isBlank() || rsvp.getNumberOfLlamas() <= 0) {
            return "error";
        }
        sumOfLlamas += rsvp.getNumberOfLlamas();
        guests.add(rsvp.getName());
        if (guests.size() > 1) {
            average = sumOfLlamas / guests.size();
        } else {
            average = rsvp.getNumberOfLlamas();
        }
        model.addAttribute("average", average);
        model.addAttribute("guests", guests);
        model.addAttribute("sumOfLlamas", sumOfLlamas);
        return "success";
    }

}
