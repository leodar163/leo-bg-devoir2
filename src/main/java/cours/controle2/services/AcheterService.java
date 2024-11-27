package cours.controle2.services;

import cours.controle2.entities.Acheter;
import cours.controle2.repositories.AcheterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcheterService
{
    @Autowired
    private AcheterRepository acheterRepository;

    public List<Acheter> GetActionsOfTrader(Integer traderId)
    {
        return acheterRepository.findAll().stream().filter(action -> action.getId().getTrader().equals(traderId)).toList();
    }
}
