package it.simonelambiase.www.springAcademy.springAcademy.model.data.repository;

import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Student;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.service.student.customquery.StudentRepositoryCustomQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer>, StudentRepositoryCustomQuery {
    Collection<Student> findByNome (String name );
    Collection<Student> findByCognome ( String lastname );
    Collection<Student> findByCognomeLike ( String lastnameLike );
    Optional<Student> findByCodiceFiscale ( String codiceFiscale );
    Collection<Student> findByDataDiNascita ( LocalDate date );
    Collection<Student> findByIndirizzo ( String indirizzo );
    Optional<Student> findByMail ( String mail );
    Collection<Student> findByListaInteressiNome ( String nomeInteresse );
    Collection<Student> findByListaInteressiCategoria ( String nomeCategoria );
    Collection<Student> customQuerySearch ( TypedQuery<Student> query );

}
