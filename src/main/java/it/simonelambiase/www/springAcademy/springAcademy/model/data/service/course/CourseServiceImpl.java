package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.course;

import it.simonelambiase.www.springAcademy.springAcademy.dto.CourseDTO;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.AulaRepository;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.LezioneRepository;
import it.simonelambiase.www.springAcademy.springAcademy.model.objects.*;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository repo;
    AulaRepository aulaRepo;
    LezioneRepository lezioneRepo;

    @Autowired
    public CourseServiceImpl(CourseRepository repo, AulaRepository aulaRepo, LezioneRepository lezioneRepo ) {
        this.repo = repo;
        this.aulaRepo = aulaRepo;
        this.lezioneRepo = lezioneRepo;

    }

    @Override
    public Collection<Course> findByNome(String nomeCorso) {
        return repo.findByNome(nomeCorso);
    }

    @Override
    public Collection<Course> findByMateria(String materiaCorso) {
        return repo.findByMateria(materiaCorso);
    }


    @Override
    public Collection<Course> findByMaxIscritti(int maxIscritti) {
        return repo.findByMaxIscritti(maxIscritti);
    }

    @Override
    public Collection<Course> findByCategoria(String categoria) {
        return repo.findByCategoria(categoria);
    }

    @Override
    public Collection<Course> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Lezione> createCalendar(PreferenzeCorso pc) {
        Optional<Course> course = repo.findById(pc.getIdCorso());
        int aulaPreferitaId = course.get().getAulaPreferita().getId();
        Aula aulaPreferita = course.get().getAulaPreferita();
        List<OrarioCorso> listaOrarioCorso = pc.getOrariCorso();
        List<Lezione> listaLezioni = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        if ( course.isPresent() ) {
            for (Modulo m : course.get().getListaModuli()) {
                int numeroModulo = m.getNumeroOre();
                while (numeroModulo > 0) {
                    for (OrarioCorso oc : listaOrarioCorso) {
                        if (numeroModulo > 0) {
                            currentDate = currentDate.with(TemporalAdjusters.nextOrSame(oc.getGiornoSettimana()));
                            LocalDateTime inizio = (LocalDateTime.of(currentDate, oc.getOrarioInizio()));
                            LocalDateTime fine = (LocalDateTime.of(currentDate, oc.getOrarioFine()));
                            if (!lezioneRepo.existsByDataInizioBetweenAndAulaId(inizio, fine, aulaPreferitaId)) {
                                Lezione l = new Lezione(inizio, fine, aulaRepo.findById(aulaPreferitaId).get(), m);
                                numeroModulo = (int) (numeroModulo - Duration.between(oc.getOrarioInizio(), oc.getOrarioFine()).toHours());
                                listaLezioni.add(l);
                            } else {
                                Optional<Aula> aulaPapabile = aulaRepo.findFirstByComputerMaxGreaterThanEqualAndCapienzaMaxGreaterThanEqualAndProiettoreEqualsAndIdNot(aulaPreferita.getComputerMax(), aulaPreferita.getCapienzaMax(), aulaPreferita.isProiettore(), aulaPreferitaId);
                                if (aulaPapabile.isPresent()) {
                                    Lezione l = new Lezione(inizio, fine, aulaPapabile.get(), m);
                                    numeroModulo = (int) (numeroModulo - Duration.between(oc.getOrarioInizio(), oc.getOrarioFine()).toHours());
                                    listaLezioni.add(l);
                                }
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        listaLezioni.sort(Comparator.comparing(Lezione::getDataInizio));
        lezioneRepo.saveAll(listaLezioni);
        return listaLezioni;
    }

    @Override
    public Course save( CourseDTO course) {
        return repo.save(course.mapToCourse(aulaRepo.findById(course.getAulaPreferita()).get()));
    }




}
