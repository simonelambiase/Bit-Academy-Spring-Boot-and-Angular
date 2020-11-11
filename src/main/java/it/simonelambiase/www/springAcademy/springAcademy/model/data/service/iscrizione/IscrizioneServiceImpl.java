package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.iscrizione;

import it.simonelambiase.www.springAcademy.springAcademy.model.Iscrizione;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.CourseRepository;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.IscrizioneRepository;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.ProfessorRepository;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
public class IscrizioneServiceImpl implements IscrizioneService {

    IscrizioneRepository iscrRepository;
    StudentRepository studentRepo;
    CourseRepository courseRepo;

    @Autowired
    public IscrizioneServiceImpl ( IscrizioneRepository repository, StudentRepository studentRepo, CourseRepository courseRepo ) {
        this.iscrRepository = repository;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public Collection<Iscrizione> findAll() {
        return iscrRepository.findAll();
    }

    @Override
    public Optional<Iscrizione> findById(int id) {
        return iscrRepository.findById(id);
    }

    @Override
    public Collection<Iscrizione> findByData(LocalDate date) {
        return iscrRepository.findByData(date);
    }

    @Override
    public Collection<Iscrizione> findByRitirato(boolean flag) {
        return iscrRepository.findByRitirato(flag);
    }

    @Override
    public Collection<Iscrizione> findByStudent(int id) {
        return iscrRepository.findByStudent(id);
    }

    @Override
    public Iscrizione iscriviStudente( int idStudente, int idCorso ) {
        if ( studentRepo.findById(idStudente).isPresent() && courseRepo.findById(idCorso).isPresent()) {
            return iscrRepository.save(new Iscrizione(studentRepo.findById(idStudente).get(),courseRepo.findById(idCorso).get()));
        }
        return null;
    }

    @Override
    public Iscrizione cancellaIscrizione(int idIscrizione) {
        Iscrizione i = iscrRepository.findById(idIscrizione).get();
        iscrRepository.delete(i);
        return i;
    }

    @Override
    public void ritiraStudente(int idIscrizione) {
        Iscrizione i = iscrRepository.findById(idIscrizione).get();
        i.setRitirato(true);
        iscrRepository.save(i);
    }
}
