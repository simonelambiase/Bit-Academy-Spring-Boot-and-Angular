package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.student;


import it.simonelambiase.www.springAcademy.springAcademy.dto.StudentDTO;
import it.simonelambiase.www.springAcademy.springAcademy.model.Interesse;
import it.simonelambiase.www.springAcademy.springAcademy.model.Student;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface StudentService {
    Collection<Student> findAll();
    Optional<Student> findById(int id );
    Collection<Student> findByNome ( String name );
    Collection<Student> findByCognome(String lastname);
    Collection<Student> findByCognomeLike ( String lastnameLike );
    Optional<Student> findByCodiceFiscale ( String codiceFiscale );
    Collection<Student> findBydataDiNascita ( LocalDate date );
    Collection<Student> findByIndirizzo ( String indirizzo );
    Collection<Student> findByListaInteressiNome ( String nomeInteresse );
    Collection<Student> findByListaInteressiCategoria ( String nomeCategoria );
    Student add( Student s );
    Student put ( Student s );
    Student delete ( int id );
    Collection<Student> customQuerySearch( String queryString );
}
