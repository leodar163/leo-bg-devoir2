package cours.controle2.controllers;

import cours.controle2.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/action")
public class ActionController
{
    @Autowired
    private ActionService actionService;
}
