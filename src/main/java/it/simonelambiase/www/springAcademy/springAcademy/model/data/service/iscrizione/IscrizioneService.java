package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.iscrizione;

import it.simonelambiase.www.springAcademy.springAcademy.model.Iscrizione;

import java.time.LocalDate;
import java.util.Collection;

public interface IscrizioneService {
    Collection<Iscrizione> findAll();
    Collection<Iscrizione> findById ( int id );
    Collection<Iscrizione> findByData ( LocalDate date );
    Collection<Iscrizione> findByRitirato ( boolean flag );
    Collection<Iscrizione> findByStudent ( int id );
    Iscrizione iscriviStudente ( int idStudente, int idCorso );

}
