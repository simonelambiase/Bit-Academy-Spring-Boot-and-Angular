package it.simonelambiase.www.springAcademy.springAcademy.controller;

import it.simonelambiase.www.springAcademy.springAcademy.dto.StudentDTO;
import it.simonelambiase.www.springAcademy.springAcademy.model.Student;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.StudentRepository;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    StudentService service;

    @Autowired
    public StudentController ( StudentService service ) {
        this.service = service;
    }

    @GetMapping()
    public Collection<StudentDTO> getAllStudent() {
        return service.findAll().stream().map(StudentDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    public StudentDTO getStudentById( @PathVariable int id ) {
        Optional<Student> s = service.findById(id);
        if ( s.isPresent() == true ) {
            return new StudentDTO(s.get());
        } else {
            return null;
        }
    }

    @GetMapping("/name/{name}")
    public Collection<StudentDTO> getStudentByName ( @PathVariable String name ) {
        return service.findByNome(name).stream().map(StudentDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/lastname/{lastname}")
    public Collection<StudentDTO> getStudentByLastName ( @PathVariable String lastname ) {
        return service.findByCognome(lastname).stream().map(StudentDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/codicefiscale/{codicefiscale}")
    public StudentDTO getStudentByCodiceFiscale ( @PathVariable String codicefiscale ) {
        Optional<Student> s = service.findByCodiceFiscale(codicefiscale);
        if ( s.isPresent() == true ) {
            return new StudentDTO(s.get());
        } else {
            return null;
        }
    }

    @GetMapping("/datadinascita/{datadinascita}")
    public Collection<StudentDTO> getStudentByDataDiNascita( @PathVariable String datadinascita ) {
        return service.findBydataDiNascita(LocalDate.parse(datadinascita)).stream().map(StudentDTO::new).collect(Collectors.toList());
    }

    @GetMapping("indirizzo/{indirizzo}")
    public Collection<StudentDTO> getStudentByIndirizzo ( @PathVariable String indirizzo ) {
        return service.findByIndirizzo(indirizzo).stream().map(StudentDTO::new).collect(Collectors.toList());
    }

    @PostMapping()
    public void add( @RequestBody StudentDTO s ) {
        service.add(s.mapToStudent());
    }

    @PutMapping("id/{id}")
    public void put ( @RequestBody StudentDTO s, @PathVariable int id ) {
        service.put(s.mapToStudent().setId(id));

    }

    @DeleteMapping("id/{id}")
    public void delete ( @PathVariable int id ) {
        service.delete(id);
    }



}
