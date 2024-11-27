package cours.controle2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Routing
{
    @GetMapping("/")
    public String GetMainPage()
    {
        return "traders";
    }

    @GetMapping("/trader")
    public String GetActionPage(@RequestParam int id)
    {
        return "acheter";
    }

}
