package it.simonelambiase.www.springAcademy.springAcademy.model.data.service;


import it.simonelambiase.www.springAcademy.springAcademy.model.Student;

import java.util.Collection;
import java.util.Optional;

public interface StudentService {
    Collection<Student> findAll();
    Optional<Student> findById(int id );
    Collection<Student> findByNome ( String name );
}
