package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.student;

import it.simonelambiase.www.springAcademy.springAcademy.model.Student;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Override
    public Collection<Student> findByCognome ( String lastname ) {
        return repo.findByCognome(lastname);
    }

    @Override
    public Optional<Student> findByCodiceFiscale(String codiceFiscale) {
        return repo.findByCodiceFiscale(codiceFiscale);
    }

    @Override
    public Collection<Student> findBydataDiNascita(LocalDate date) {
        return repo.findByDataDiNascita(date);
    }

    @Override
    public Collection<Student> findByIndirizzo(String indirizzo) {
        return repo.findByIndirizzo(indirizzo);
    }

    @Override
    public Student add(Student s) {
        return repo.save(s);
    }

    @Override
    public Student put (Student s )  {
        return repo.save(s);
    }

    @Override
    public Student delete( int id ) {
        Student s = repo.findById(id).get();
        repo.delete(s);
        return s;
    }


}
