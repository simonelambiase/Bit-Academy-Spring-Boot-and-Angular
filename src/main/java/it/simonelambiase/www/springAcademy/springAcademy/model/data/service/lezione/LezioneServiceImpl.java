package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.lezione;

import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Lezione;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.LezioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;


@Service
public class LezioneServiceImpl implements LezioneService {

    LezioneRepository repo;

    @Autowired
    public LezioneServiceImpl(LezioneRepository repo) {
        this.repo = repo;
    }

    @Override
    public Collection<Lezione> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Lezione> findByAulaId(int idAula) {
        return repo.findByAulaId(idAula);
    }

    @Override
    public Collection<Lezione> findByAulaNomeAula(String nomeAula) {
        return repo.findByAulaNomeAula(nomeAula);
    }

    @Override
    public Collection<Lezione> findByModuloId(int idModulo) {
        return repo.findByModuloId(idModulo);
    }

    @Override
    public Collection<Lezione> findByModuloCourseNomeLike(String nomeCorso) {
        return repo.findByModuloCourseNomeLike( "%" + nomeCorso + "%");
    }

    @Override
    public Collection<Lezione> findByDataInizioAfter( LocalDateTime date) {
        return repo.findByDataInizioAfter(date);
    }

    @Override
    public Collection<Lezione> findByDataInizioBetween( LocalDate date) {
        return repo.findByDataInizioBetween(date.minusYears(1).atStartOfDay(), date.plusYears(1).atStartOfDay());
    }

    @Override
    public Collection<Lezione> findByDataFine(LocalDate date) {
        return repo.findByDataFine(date);
    }

    @Override
    public boolean existsByDataInizioBetweenAndAulaId (LocalDateTime date1, LocalDateTime date2, int idAula ) {
        return repo.existsByDataInizioBetweenAndAulaId(date1,date2, idAula);
    }
}


