package cours.controle2.repositories;

import cours.controle2.entities.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Integer>
{
}
