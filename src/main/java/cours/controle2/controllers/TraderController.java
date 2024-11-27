package cours.controle2.controllers;

import cours.controle2.entities.Trader;
import cours.controle2.services.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/trader")
public class TraderController
{
    @Autowired
    private TraderService traderService;

    @RequestMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Trader>> GetAllTrader()
    {
        return new ResponseEntity<>(traderService.GetAllTraders(), HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Trader> GetTrader(@PathVariable int id)
    {
        Trader trader = traderService.GetTraderById(id);

        return new ResponseEntity<>(trader, trader == null ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }

}
