package cours.controle2.controllers;

import cours.controle2.entities.Trader;
import cours.controle2.services.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class TraderController
{
    @Autowired
    private TraderService traderService;

    @RequestMapping("trader/all")
    @ResponseBody
    public ResponseEntity<List<Trader>> GetAllTrader()
    {
        return new ResponseEntity<>(traderService.GetAllTraders(), HttpStatus.OK);
    }
}
