package it.simonelambiase.www.springAcademy.springAcademy.controller;

import it.simonelambiase.www.springAcademy.springAcademy.dto.StudentDTO;
import it.simonelambiase.www.springAcademy.springAcademy.model.Student;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.repository.StudentRepository;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
