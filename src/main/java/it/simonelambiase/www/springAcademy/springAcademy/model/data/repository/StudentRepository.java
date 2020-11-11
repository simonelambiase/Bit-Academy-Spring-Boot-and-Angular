package it.simonelambiase.www.springAcademy.springAcademy.model.data.repository;

import it.simonelambiase.www.springAcademy.springAcademy.model.Interesse;
import it.simonelambiase.www.springAcademy.springAcademy.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Collection<Student> findByNome (String name );
    Collection<Student> findByCognome ( String lastname );
    Collection<Student> findByCognomeLike ( String lastnameLike );
    Optional<Student> findByCodiceFiscale ( String codiceFiscale );
    Collection<Student> findByDataDiNascita ( LocalDate date );
    Collection<Student> findByIndirizzo ( String indirizzo );
    Optional<Student> findByMail ( String mail );
    Collection<Student> findByListaInteressiNome ( String nomeInteresse );
    Collection<Student> findByListaInteressiCategoria ( String nomeCategoria );

}
