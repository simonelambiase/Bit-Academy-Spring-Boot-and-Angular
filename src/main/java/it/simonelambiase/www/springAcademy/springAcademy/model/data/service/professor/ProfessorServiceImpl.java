package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.professor;

import it.simonelambiase.www.springAcademy.springAcademy.dto.ProfessorDTO;
import it.simonelambiase.www.springAcademy.springAcademy.model.Professor;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private ProfessorRepository repo;

    @Autowired
    public ProfessorServiceImpl ( ProfessorRepository repository ) {
        this.repo = repository;
    }

    public Collection<Professor> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Professor> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Collection<Professor> findByNome(String nome) {
        return repo.findByNome(nome);
    }

    @Override
    public Collection<Professor> findByCognome(String cognome) {
        return repo.findByCognome(cognome);
    }

    @Override
    public Optional<Professor> findByEmail(String mail) {
        return repo.findByEmail(mail);
    }

    @Override
    public Optional<Professor> findByPartitaIva(String partitaIva) {
        return repo.findByPartitaIva(partitaIva);
    }

    @Override
    public Collection<Professor> findByTitoloDiStudio(String titolodistudio) {
        return repo.findByTitoloDiStudio(titolodistudio);
    }

    @Override
    public Professor add(Professor p) {
        return repo.save(p);
    }

    @Override
    public Professor put(Professor p) {
        return repo.save(p);
    }

    @Override
    public Professor delete(int id) {
        Optional<Professor> p = repo.findById(id);
        repo.delete(p.get()); return p.get();
    }
}
