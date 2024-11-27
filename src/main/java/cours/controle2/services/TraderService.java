package cours.controle2.services;

import cours.controle2.entities.Trader;
import cours.controle2.repositories.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraderService
{
    @Autowired
    private TraderRepository traderRepository;

    public List<Trader> GetAllTraders()
    {
        return traderRepository.findAll();
    }

    public Trader GetTraderById(Integer id)
    {
        return traderRepository.findById(id).orElse(null);
    }
}
