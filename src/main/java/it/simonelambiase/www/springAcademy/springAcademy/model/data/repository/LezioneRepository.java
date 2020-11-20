package it.simonelambiase.www.springAcademy.springAcademy.model.data.repository;

import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Lezione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public interface LezioneRepository extends JpaRepository<Lezione, Integer> {
    Collection<Lezione> findByAulaId ( int idAula );
    Collection<Lezione> findByAulaNomeAula ( String nomeAula );
    Collection<Lezione> findByModuloId( int idModulo );
    Collection<Lezione> findByModuloCourseNomeLike ( String nomeCorso );
    Collection<Lezione> findByDataInizioAfter (LocalDateTime date );
    Collection<Lezione> findByDataFine( LocalDate date );
    Collection<Lezione> findByDataInizioBetween ( LocalDateTime date1, LocalDateTime date2 );
    boolean existsByDataInizioBetweenAndAulaId ( LocalDateTime date1, LocalDateTime date2, int idAula );



}
