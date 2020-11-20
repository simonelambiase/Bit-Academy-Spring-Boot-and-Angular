package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.lezione;

import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Lezione;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public interface LezioneService {
    Collection<Lezione> findAll();
    Collection<Lezione> findByAulaId ( int idAula );
    Collection<Lezione> findByAulaNomeAula ( String nomeAula );
    Collection<Lezione> findByModuloId( int idModulo );
    Collection<Lezione> findByModuloCourseNomeLike (String nomeCorso );
    Collection<Lezione> findByDataInizioAfter ( LocalDateTime date );
    Collection<Lezione> findByDataInizioBetween ( LocalDate date );
    Collection<Lezione> findByDataFine ( LocalDate date );
    boolean existsByDataInizioBetweenAndAulaId ( LocalDateTime date1, LocalDateTime date2, int idAula );

}
