package cours.controle2.controllers;

import cours.controle2.services.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/trader")
public class TraderController
{
    @Autowired
    private TraderService traderService;
}
