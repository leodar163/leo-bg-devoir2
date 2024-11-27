package cours.controle2.services;

import cours.controle2.dto.AcheterDTO;
import cours.controle2.entities.Acheter;
import cours.controle2.entities.AcheterId;
import cours.controle2.entities.Trader;
import cours.controle2.repositories.AcheterRepository;
import cours.controle2.repositories.ActionRepository;
import cours.controle2.repositories.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public AcheterDTO SellActions(Integer traderId, Integer actionId, Integer quantite)
    {
        AcheterId achatId = new AcheterId();
        achatId.setTrader(traderId);
        achatId.setAction(actionId);

        Acheter achat = acheterRepository.findById(achatId).orElse(null);

        if (achat == null) return null;

        achat.setQuantite(achat.getQuantite() - quantite);
        acheterRepository.save(achat);

        if (achat.getQuantite() <= 0)
        {
            acheterRepository.delete(achat);
            acheterRepository.flush();
            return null;
        }

        return new AcheterDTO(
                traderRepository.findById(traderId).orElse(null),
                actionRepository.findById(achat.getId().getAction()).orElse(null),
                achat.getQuantite(),
                achat.getPrix()
        );
    }
}
