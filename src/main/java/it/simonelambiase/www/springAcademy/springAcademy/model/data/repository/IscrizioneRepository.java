package it.simonelambiase.www.springAcademy.springAcademy.model.data.repository;

import it.simonelambiase.www.springAcademy.springAcademy.model.Iscrizione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface IscrizioneRepository extends JpaRepository<Iscrizione, Integer> {
    List<Iscrizione> findAll();
    Collection<Iscrizione> findById (int id );
    Collection<Iscrizione> findByData ( LocalDate date );
    Collection<Iscrizione> findByRitirato ( boolean flag );
    Collection<Iscrizione> findByStudent ( int id );
}
