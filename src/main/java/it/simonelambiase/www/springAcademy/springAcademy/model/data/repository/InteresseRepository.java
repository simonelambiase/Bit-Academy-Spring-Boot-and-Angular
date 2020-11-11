package it.simonelambiase.www.springAcademy.springAcademy.model.data.repository;

import it.simonelambiase.www.springAcademy.springAcademy.model.Interesse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface InteresseRepository extends JpaRepository<Interesse, Integer> {
    Optional<Interesse> findByNome( String name );
    Collection<Interesse> findByCategoria ( String categoria );
    Collection<Interesse> findByDescrizioneLike ( String descrizioneLike );
}
