package it.simonelambiase.www.springAcademy.springAcademy.model.data.service;

import it.simonelambiase.www.springAcademy.springAcademy.model.Student;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository repo;

    @Autowired
    public StudentServiceImpl ( StudentRepository repository ) {
        this.repo = repository;
    }

    @Override
    public Collection<Student> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Student> findById ( int id ) {
        return repo.findById(id);
    }

    @Override
    public Collection<Student> findByNome(String name) {
        return repo.findByNome(name);
    }
    


}
