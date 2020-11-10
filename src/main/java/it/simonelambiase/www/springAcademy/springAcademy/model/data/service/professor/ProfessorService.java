package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.professor;

import it.simonelambiase.www.springAcademy.springAcademy.dto.ProfessorDTO;
import it.simonelambiase.www.springAcademy.springAcademy.model.Professor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

public interface ProfessorService {
    Collection<Professor> findAll();
    Optional<Professor> findById( int id );
    Collection<Professor> findByNome ( String nome );
    Collection<Professor> findByCognome ( String cognome );
    Optional<Professor> findByEmail ( String mail );
    Optional<Professor> findByPartitaIva ( String partitaIva );
    Collection<Professor> findByTitoloDiStudio ( String titolodistudio );
    Professor add ( Professor p );
    Professor put ( Professor p );
    Professor delete ( int id );
}
