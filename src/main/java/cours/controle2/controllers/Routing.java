package cours.controle2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Routing
{
    @GetMapping("/")
    public String GetMainPage()
    {
        return "index";
    }
}
