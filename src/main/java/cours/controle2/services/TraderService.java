package cours.controle2.services;

import cours.controle2.repositories.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraderService
{
    @Autowired
    private TraderRepository traderRepository;
}
