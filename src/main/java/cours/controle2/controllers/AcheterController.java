package cours.controle2.controllers;

import cours.controle2.dto.AcheterDTO;
import cours.controle2.services.AcheterService;
import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/acheter")
public class AcheterController {

    @Autowired
    private AcheterService acheterService;

    @RequestMapping("/of-trader/{traderId}")
    @ResponseBody
    public ResponseEntity<List<AcheterDTO>> GetAchetersOfTrader(@PathVariable Integer traderId)
    {
        return new ResponseEntity<>(acheterService.GetAchatsOfTrader(traderId), HttpStatus.OK);
    }

    @RequestMapping("/vendre")
    @ResponseBody
    public ResponseEntity<AcheterDTO> SellActions(@RequestBody Map<String,Object> body)
    {
        Integer traderId = (Integer) body.get("traderId");
        Integer actionId = (Integer) body.get("actionId");
        Integer quantity = (Integer) body.get("quantity");

        AcheterDTO achat = acheterService.SellActions(traderId, actionId, quantity);

        return new ResponseEntity<>(achat, HttpStatus.OK);
    }

    @RequestMapping("/acheter")
    @ResponseBody
    public ResponseEntity<AcheterDTO> BuyActions(@RequestBody Map<String,Object> body)
    {
        Integer traderId = (Integer) body.get("traderId");
        Integer actionId = (Integer) body.get("actionId");
        Integer price = (Integer)body.get("price");
        Integer quantity = (Integer) body.get("quantity");

        AcheterDTO achat = acheterService.BuyAction(traderId, actionId, price, quantity);

        return new ResponseEntity<>(achat, HttpStatus.OK);
    }


}
