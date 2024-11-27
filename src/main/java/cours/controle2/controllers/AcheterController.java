package cours.controle2.controllers;

import cours.controle2.entities.Acheter;
import cours.controle2.services.AcheterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acheter")
public class AcheterController {

    @Autowired
    private AcheterService acheterService;

    @RequestMapping("/of-trader/{traderId}")
    @ResponseBody
    public ResponseEntity<List<Acheter>> GetAchetersOfTrader(@PathVariable Integer traderId)
    {
        return new ResponseEntity<>(acheterService.GetActionsOfTrader(traderId), HttpStatus.OK);
    }
}
