package it.simonelambiase.www.springAcademy.springAcademy.model.data.repository;

import it.simonelambiase.www.springAcademy.springAcademy.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Collection<Student> findByNome (String name );
    Collection<Student> findByCognome ( String lastname );
    Optional<Student> findByCodiceFiscale ( String codiceFiscale );
    Collection<Student> findByDataDiNascita ( LocalDate date );
    Collection<Student> findByIndirizzo ( String indirizzo );
    Optional<Student> findByMail ( String mail );
}
