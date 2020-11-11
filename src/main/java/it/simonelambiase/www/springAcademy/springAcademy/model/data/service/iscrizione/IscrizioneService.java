package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.iscrizione;

import it.simonelambiase.www.springAcademy.springAcademy.model.Iscrizione;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface IscrizioneService {
    Collection<Iscrizione> findAll();
    Optional<Iscrizione> findById (int id );
    Collection<Iscrizione> findByData ( LocalDate date );
    Collection<Iscrizione> findByRitirato ( boolean flag );
    Collection<Iscrizione> findByStudent ( int id );
    Iscrizione iscriviStudente ( int idStudente, int idCorso );
    Iscrizione cancellaIscrizione ( int idIscrizione );
    void ritiraStudente ( int idIscrizione );


}
