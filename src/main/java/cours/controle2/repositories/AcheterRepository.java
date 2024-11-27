package cours.controle2.repositories;

import cours.controle2.entities.Acheter;
import cours.controle2.entities.AcheterId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcheterRepository extends JpaRepository<Acheter, AcheterId>
{
}
