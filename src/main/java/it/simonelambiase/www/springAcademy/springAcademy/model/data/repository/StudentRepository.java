package it.simonelambiase.www.springAcademy.springAcademy.model.data.repository;

import it.simonelambiase.www.springAcademy.springAcademy.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Collection<Student> findByNome (String name );
}
