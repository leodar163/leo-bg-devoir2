package cours.controle2.services;

import cours.controle2.entities.Action;
import cours.controle2.entities.Trader;
import cours.controle2.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActionService
{
    @Autowired
    private ActionRepository actionRepository;

    public List<Action> GetAllActions()
    {
        return actionRepository.findAll();
    }
}
