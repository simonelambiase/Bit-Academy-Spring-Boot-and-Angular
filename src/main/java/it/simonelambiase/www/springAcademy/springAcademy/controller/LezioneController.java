package it.simonelambiase.www.springAcademy.springAcademy.controller;

import it.simonelambiase.www.springAcademy.springAcademy.dto.LezioneDTO;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.service.lezione.LezioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/lezione")
public class LezioneController {

    LezioneService service;

    @Autowired
    public LezioneController ( LezioneService service ) {
        this.service = service;

    }

    @GetMapping()
    public Collection<LezioneDTO> findAll() {
        return service.findAll().stream().map(LezioneDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/search")
    public Collection<LezioneDTO> search(@RequestParam(defaultValue="") String dataInizio, @RequestParam(defaultValue= "") String data, @RequestParam(defaultValue = "") String nomeAula, @RequestParam(defaultValue = "") String nomeCorso) {
        if ( dataInizio.length() > 0 ) {
            return service.findByDataInizioAfter(LocalDate.parse(dataInizio).atStartOfDay()).stream().map(LezioneDTO::new).collect(Collectors.toList());
        } else if ( nomeAula.length() > 0 ) {
            return service.findByAulaNomeAula(nomeAula).stream().map(LezioneDTO::new).collect(Collectors.toList());
        } else if ( nomeCorso.length() > 0 ) {
            return service.findByModuloCourseNomeLike(nomeCorso).stream().map(LezioneDTO::new).collect(Collectors.toList());
        } else if ( data.length() > 0 ) {
            return service.findByDataInizioBetween(LocalDate.parse(data)).stream().map(LezioneDTO::new).collect(Collectors.toList());
        } else {
            return service.findByDataInizioBetween(LocalDate.now()).stream().map(LezioneDTO::new).collect(Collectors.toList());
        }
    }


}
