package unmsm.fisi.calidad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashController {
    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        int horas[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        model.addAttribute("name", name);
        model.addAttribute("hours", horas);
        return "inicio";
    }

}
