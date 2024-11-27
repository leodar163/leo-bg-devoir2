package cours.controle2.services;

import cours.controle2.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService
{
    @Autowired
    private ActionRepository actionRepository;
}
