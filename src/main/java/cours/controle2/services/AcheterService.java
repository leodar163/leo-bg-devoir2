package cours.controle2.services;

import cours.controle2.dto.AcheterDTO;
import cours.controle2.entities.Acheter;
import cours.controle2.entities.Trader;
import cours.controle2.repositories.AcheterRepository;
import cours.controle2.repositories.ActionRepository;
import cours.controle2.repositories.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcheterService
{
    @Autowired
    private AcheterRepository acheterRepository;
    @Autowired
    private TraderRepository traderRepository;
    @Autowired
    private ActionRepository actionRepository;

    public List<AcheterDTO> GetActionsOfTrader(Integer traderId)
    {
        Trader trader = traderRepository.findById(traderId).orElse(null);
        if (trader == null) return null;

        return acheterRepository.findAll().stream().filter(acheter -> acheter.getId().getTrader().equals(traderId))
                .map(acheter -> new AcheterDTO(
                        trader,
                        actionRepository.findById(acheter.getId().getAction()).orElse(null),
                        acheter.getQuantite(),
                        acheter.getPrix())).toList();
    }
}
