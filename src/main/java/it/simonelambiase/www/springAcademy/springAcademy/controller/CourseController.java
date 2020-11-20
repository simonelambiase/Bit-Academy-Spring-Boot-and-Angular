package it.simonelambiase.www.springAcademy.springAcademy.controller;

import it.simonelambiase.www.springAcademy.springAcademy.dto.CourseDTO;
import it.simonelambiase.www.springAcademy.springAcademy.dto.LezioneDTO;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.service.course.CourseService;
import it.simonelambiase.www.springAcademy.springAcademy.model.objects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/corso")
@CrossOrigin ( origins = "http://localhost:4200")
public class CourseController {

    CourseService service;


    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping()
    public Collection<CourseDTO> getAll() {
        return service.findAll().stream().map(CourseDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/preferenze")
    public Collection<PreferenzeCorso> getCalendario () {
        List<OrarioCorso> oc = new ArrayList<OrarioCorso>();
        oc.add(new OrarioCorso(DayOfWeek.MONDAY, LocalTime.parse("10:00"), LocalTime.parse("12:00")));
        oc.add(new OrarioCorso(DayOfWeek.MONDAY, LocalTime.parse("13:00"), LocalTime.parse("15:00")));
        oc.add(new OrarioCorso(DayOfWeek.MONDAY, LocalTime.parse("14:00"), LocalTime.parse("17:00")));
        oc.add(new OrarioCorso(DayOfWeek.MONDAY, LocalTime.parse("19:00"), LocalTime.parse("21:00")));
        PreferenzeCorso pc = new PreferenzeCorso(1,oc);
        PreferenzeCorso pc2 = new PreferenzeCorso(2,oc);
        List<PreferenzeCorso> prefs = new ArrayList<PreferenzeCorso>();
        prefs.add(pc); prefs.add(pc2);
        return prefs;
    }

    @PostMapping("/calendario")
    public Collection<LezioneDTO> createCalendar (@RequestBody PreferenzeCorso preferenze ) {
        return service.createCalendar(preferenze).stream().map(LezioneDTO::new).collect(Collectors.toList());
    }


    @PostMapping()
    public Course addCourse ( @RequestBody CourseDTO c ) {
        return service.save(c);
    }


}
