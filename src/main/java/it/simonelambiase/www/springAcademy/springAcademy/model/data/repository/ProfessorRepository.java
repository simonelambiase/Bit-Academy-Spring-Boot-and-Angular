package it.simonelambiase.www.springAcademy.springAcademy.model.data.repository;

import it.simonelambiase.www.springAcademy.springAcademy.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    List<Professor> findAll();
    Optional<Professor> findById(int id );
    Collection<Professor> findByNome ( String nome );
    Collection<Professor> findByCognome ( String cognome );
    Optional<Professor> findByEmail ( String mail );
    Collection<Professor> findByCostoOrario ( long id );
    Optional<Professor> findByPartitaIva ( String partitaIva );
    Collection<Professor> findByTitoloDiStudio ( String titolodistudio );

}
