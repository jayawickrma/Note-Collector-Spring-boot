package lk.ijse.note_collector_V2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/welcome")
public class WelcomeController {
    @GetMapping
    public String welcomeVIew(Model model){
        model.addAttribute("message","note-collector-V2");
        return "welcome";
    }
}
