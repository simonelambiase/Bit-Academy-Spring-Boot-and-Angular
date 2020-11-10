package it.simonelambiase.www.springAcademy.springAcademy.controller;

import it.simonelambiase.www.springAcademy.springAcademy.dto.ProfessorDTO;
import it.simonelambiase.www.springAcademy.springAcademy.dto.StudentDTO;
import it.simonelambiase.www.springAcademy.springAcademy.model.Professor;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.service.professor.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    ProfessorService service;

    @Autowired
    public ProfessorController (  ProfessorService service ) {
        this.service = service;
    }

    @GetMapping()
    public Collection<ProfessorDTO> findAll() {
        return service.findAll().stream().map(ProfessorDTO::new).collect(Collectors.toList());
    }

    @GetMapping("id/{id}")
    public ProfessorDTO findById (@PathVariable int id ) {
        Optional<Professor> p = service.findById(id);
        return new ProfessorDTO(p.get());
    }

    @GetMapping("nome/{nome}")
    public Collection<ProfessorDTO> findByNome(@PathVariable String nome ) {
        return service.findByNome(nome).stream().map(ProfessorDTO::new).collect(Collectors.toList());
    }

    @GetMapping("cognome/{cognome}")
    public Collection<ProfessorDTO> findByCognome ( @PathVariable String cognome ) {
        return service.findByCognome(cognome).stream().map(ProfessorDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public void add ( @RequestBody ProfessorDTO p ) {
        service.add(p.mapToProfessor());
    }

    @PutMapping("id/{id}")
    public void put (@RequestBody ProfessorDTO p, @PathVariable int id ) {
        service.put(p.mapToProfessor().setId(id));

    }

    @DeleteMapping("id/{id}")
    public void delete ( @PathVariable int id ) {
        service.delete(id);
    }

}
