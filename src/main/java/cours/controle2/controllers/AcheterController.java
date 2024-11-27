package cours.controle2.controllers;

import cours.controle2.services.AcheterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcheterController {
    @Autowired
    private AcheterService service;
}
