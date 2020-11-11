package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.student;

import it.simonelambiase.www.springAcademy.springAcademy.dto.StudentDTO;
import it.simonelambiase.www.springAcademy.springAcademy.model.Interesse;
import it.simonelambiase.www.springAcademy.springAcademy.model.Student;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.InteresseRepository;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository repo;
    private InteresseRepository interesseRepo;

    @Autowired
    public StudentServiceImpl ( StudentRepository repository, InteresseRepository interesseRepository ) {
        this.repo = repository;
        this.interesseRepo = interesseRepository;

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
    public Collection<Student> findByCognomeLike(String lastnameLike) {
        return repo.findByCognomeLike("%" + lastnameLike + "%");
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
    public Collection<Student> findByListaInteressiNome (String nomeInteresse) {
        return repo.findByListaInteressiNome(nomeInteresse);
    }

    @Override
    public Collection<Student> findByListaInteressiCategoria(String nomeCategoria) {
        return repo.findByListaInteressiCategoria(nomeCategoria);
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
