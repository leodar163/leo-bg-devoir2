package cours.controle2.services;

import cours.controle2.repositories.AcheterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcheterService
{
    @Autowired
    private AcheterRepository acheterRepository;
}
