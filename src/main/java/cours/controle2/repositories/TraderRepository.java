package cours.controle2.repositories;

import cours.controle2.entities.Trader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraderRepository extends JpaRepository<Trader, Integer>
{
}
