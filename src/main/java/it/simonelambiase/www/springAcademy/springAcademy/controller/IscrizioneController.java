package it.simonelambiase.www.springAcademy.springAcademy.controller;

import it.simonelambiase.www.springAcademy.springAcademy.dto.IscrizioneDTO;
import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Iscrizione;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.service.iscrizione.IscrizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/iscrizione")
@CrossOrigin ( origins = "http://localhost:4200")
public class IscrizioneController {

    IscrizioneService service;

    @Autowired
    public IscrizioneController ( IscrizioneService service ) {
        this.service = service;
    }

    @GetMapping()
    public Collection<IscrizioneDTO> findAll() {
        return service.findAll().stream().map(IscrizioneDTO::new).collect(Collectors.toList());
    }

    @PostMapping()
    public Iscrizione iscriviStudente ( @RequestBody IscrizioneDTO i ) {
        if ( service.iscriviStudente(i.getStudentId(),i.getCourseId()) != null ) {
            System.out.println("Studente iscritto");
        } else {
            System.out.println("Corso o studente non esistente");
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Iscrizione eliminaStudente ( @PathVariable int id ) {
        return service.cancellaIscrizione(id);
    }

    @PatchMapping("/{id}")
    public void ritiraStudente ( @PathVariable int id ) {
        service.ritiraStudente(id);
    }

}
