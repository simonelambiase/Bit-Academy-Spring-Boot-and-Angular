package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.course;

import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.AulaRepository;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.CourseRepository;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.LezioneRepository;
import it.simonelambiase.www.springAcademy.springAcademy.model.objects.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CourseServiceImplTest {
    List<PreferenzeCorso> prefs;
    Set<Lezione> listaLezioni = new HashSet<>();
    CourseRepository repo;
    AulaRepository aulaRepo;
    LezioneRepository lezioneRepo;
    PreferenzeCorso pc;
    PreferenzeCorso pc2;


    @Autowired
    public CourseServiceImplTest(CourseRepository repo, AulaRepository aulaRepo, LezioneRepository lezioneRepo ) {
        this.repo = repo;
        this.aulaRepo = aulaRepo;
        this.lezioneRepo = lezioneRepo;

    }

    @BeforeAll
    void initPreferences() {
        List<OrarioCorso> oc = new ArrayList<OrarioCorso>();
        oc.add(new OrarioCorso(DayOfWeek.MONDAY, LocalTime.parse("10:00"), LocalTime.parse("12:00")));
        oc.add(new OrarioCorso(DayOfWeek.MONDAY, LocalTime.parse("16:00"), LocalTime.parse("18:00")));
        oc.add(new OrarioCorso(DayOfWeek.WEDNESDAY, LocalTime.parse("14:00"), LocalTime.parse("16:00")));
        oc.add(new OrarioCorso(DayOfWeek.WEDNESDAY, LocalTime.parse("12:00"), LocalTime.parse("14:00")));
        oc.add(new OrarioCorso(DayOfWeek.FRIDAY, LocalTime.parse("16:00"), LocalTime.parse("19:00")));
        oc.add(new OrarioCorso(DayOfWeek.FRIDAY, LocalTime.parse("11:00"), LocalTime.parse("13:00")));

        pc = new PreferenzeCorso(2, oc);
        prefs = new ArrayList<PreferenzeCorso>();
        prefs.add(pc);
        prefs.add(pc2);
    }

    @Test
    @Order(1)
    void createCalendar() {
        Optional<Course> course = repo.findById(pc.getIdCorso());
        int aulaPreferitaId = course.get().getAulaPreferita().getId();
        Aula aulaPreferita = course.get().getAulaPreferita();
        List<OrarioCorso> listaOrarioCorso = pc.getOrariCorso();
        // TODO Verifica esistenza del corso
        int durataCorso = course.get().getDurataCorso();
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
                            Lezione l = new Lezione();
                            if (!lezioneRepo.existsByDataInizioBetweenAndAulaId(inizio, fine, aulaPreferitaId)) {
                                l.setAula(aulaRepo.findById(aulaPreferitaId).get());
                                l.setDataInizio(inizio);
                                l.setDataFine(fine);
                                l.setModulo(m);
                                numeroModulo = (int) (numeroModulo - Duration.between(oc.getOrarioInizio(), oc.getOrarioFine()).toHours());
                                listaLezioni.add(l);
                                lezioneRepo.save(l);
                            } else {
                                Optional<Aula> aulaPapabile = aulaRepo.findFirstByComputerMaxGreaterThanEqualAndCapienzaMaxGreaterThanEqualAndProiettoreEqualsAndIdNot(aulaPreferita.getComputerMax(), aulaPreferita.getCapienzaMax(), aulaPreferita.isProiettore(), aulaPreferitaId);
                                if (aulaPapabile.isPresent()) {
                                    l.setAula(aulaPapabile.get());
                                    l.setDataInizio(inizio);
                                    l.setDataFine(fine);
                                    l.setModulo(m);
                                    numeroModulo = (int) (numeroModulo - Duration.between(oc.getOrarioInizio(), oc.getOrarioFine()).toHours());
                                    listaLezioni.add(l);
                                    lezioneRepo.save(l);
                                }
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    @Test
    @Order(2)
    void printAll() {
        List<Lezione> listaLezioniList = new ArrayList<>(listaLezioni);
        listaLezioniList.sort(Comparator.comparing(Lezione::getDataInizio));
        listaLezioniList.forEach(System.out::println);
        System.out.println(listaLezioniList.size());
        System.out.println("Numero Lezioni: " + listaLezioni.size());

    }
}