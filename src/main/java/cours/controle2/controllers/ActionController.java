package cours.controle2.controllers;

import cours.controle2.dto.AcheterDTO;
import cours.controle2.entities.Acheter;
import cours.controle2.entities.Action;
import cours.controle2.services.AcheterService;
import cours.controle2.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/action")
public class ActionController
{
    @Autowired
    private ActionService actionService;
    @Autowired
    private AcheterService acheterService;


    @RequestMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Action>> GetAllActions()
    {
        return new ResponseEntity<>(actionService.GetAllActions(), HttpStatus.OK);
    }

    @RequestMapping("/of-trader/{idTrader}")
    @ResponseBody
    public ResponseEntity<List<Action>> GetActionsOfTrader(@PathVariable int idTrader)
    {
        List<Integer> achats = acheterService.GetAchatsOfTrader(idTrader).stream().map(acheterDTO ->
                acheterDTO.action.getId()).toList();
        return new ResponseEntity<>(actionService.GetAllActions().stream()
                .filter(action -> achats.contains(action.getId())).toList(), HttpStatus.OK);
    }

    @RequestMapping("/not-of-trader/{idTrader}")
    @ResponseBody
    public ResponseEntity<List<Action>> GetActionsNotOfTrader(@PathVariable int idTrader)
    {
        List<Integer> achats = acheterService.GetAchatsOfTrader(idTrader).stream().map(acheterDTO ->
                acheterDTO.action.getId()).toList();
        return new ResponseEntity<>(actionService.GetAllActions().stream()
                .filter(action -> !achats.contains(action.getId())).toList(), HttpStatus.OK);
    }
}
