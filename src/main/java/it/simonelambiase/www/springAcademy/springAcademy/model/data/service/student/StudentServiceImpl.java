package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.student;

import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Student;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.InteresseRepository;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository repo;
    private InteresseRepository interesseRepo;
    private EntityManager em;

    @Autowired
    public StudentServiceImpl ( StudentRepository repository, InteresseRepository interesseRepository, EntityManager em ) {
        this.repo = repository;
        this.interesseRepo = interesseRepository;
        this.em = em;

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

    @Transactional
    @Override
    public Student add(Student s) {
        return repo.save(s);
    }

    @Transactional
    @Override
    public Student put (Student s )  {
        return repo.save(s);
    }

    @Transactional
    @Override
    public Student delete( int id ) {
        Student s = repo.findById(id).get();
        repo.delete(s);
        return s;
    }

    @Override
    public Collection<Student> customQuerySearch( Map<String,String> args ) {
        String queryString = "select s from Student s where";
        boolean flag = false;
        if ( args.get("data").length() > 0 ) {
            if ( flag ) {
                queryString += " and";
            }
            queryString += " s.dataDiNascita < :data";
            flag = true;
        }
        if ( args.get("sesso").length() > 0 ) {
            if ( flag ) {
                queryString += " and";
            }
            if (args.get("sesso").equalsIgnoreCase("Maschio")) {
                queryString += " s.sesso = 1";
            } else if (args.get("sesso").equalsIgnoreCase("Femmina")) {
                queryString += " s.sesso = 0";
            }
            flag = true;
        }
        if ( args.get("titolodistudio").length() > 0 ) {
            if ( flag ) {
                queryString += " and";
            }
            queryString += " s.titoloDiStudio = :titolodistudio";
            flag = true;
        }
        TypedQuery<Student> query = em.createQuery(queryString, Student.class);
        if ( args.get("data").length() > 0 ) {
            query.setParameter("data", args.get("data"));
        }
        if ( args.get("titolodistudio").length() > 0 ) {
            query.setParameter("titolodistudio", args.get("titolodistudio"));
        }
        return repo.customQuerySearch(query);
    }


}
