package it.simonelambiase.www.springAcademy.springAcademy.model.data.repository;

import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface AulaRepository extends JpaRepository<Aula,Integer>, CrudRepository<Aula,Integer> {
    Collection<Aula> findByCapienzaMax( int capienzaMax );
    Collection<Aula> findByComputerMax( int maxComputer );
    Collection<Aula> findByProiettore( boolean flag );
    Collection<Aula> findByPiattaforma( String piattaforma );
    Optional<Aula> findFirstByComputerMaxGreaterThanEqualAndCapienzaMaxGreaterThanEqualAndProiettoreEqualsAndIdNot(int computerMax, int capienzaMax, boolean proiettore, int idAulaPrecedente );
    // computerMax >= {computerMax} and capienzaMax >= {capienzaMax} and proiettore = {proiettore}
}
