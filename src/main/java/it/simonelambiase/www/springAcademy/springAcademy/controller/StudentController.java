package it.simonelambiase.www.springAcademy.springAcademy.controller;

import it.simonelambiase.www.springAcademy.springAcademy.dto.StudentDTO;
import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Student;
import it.simonelambiase.www.springAcademy.springAcademy.model.data.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/studente")
@CrossOrigin ( origins = "http://localhost:4200")
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


    // Ricordarsi di usare i parametri al posto della concatenazione
    @GetMapping("/search")
    public Collection<StudentDTO> getStudents ( @RequestParam(defaultValue = "") String lastname, @RequestParam(defaultValue = "") String data, @RequestParam(defaultValue = "") String sesso, @RequestParam(defaultValue="") String titolostudio ) {
        if ( lastname.length() > 0 ) {
            return service.findByCognomeLike(lastname).stream().map(StudentDTO::new).collect(Collectors.toList());
        }
        Map<String,String> args = new HashMap<>();
        args.put("titolodistudio", titolostudio); args.put("data", data); args.put("sesso", sesso);
        return service.customQuerySearch(args).stream().map(StudentDTO::new).collect(Collectors.toList());

    }


    @GetMapping("/{id}")
    public StudentDTO getStudentById( @PathVariable int id ) {
        Optional<Student> s = service.findById(id);
        if ( s.isPresent() ) {
            return new StudentDTO(s.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
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

    @GetMapping("/lastnamelike/{lastnamelike}")
    public Collection<StudentDTO> getStudentByLastNameLike ( @PathVariable String lastnamelike ) {
        return service.findByCognomeLike(lastnamelike).stream().map(StudentDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/codicefiscale/{codicefiscale}")
    public StudentDTO getStudentByCodiceFiscale ( @PathVariable String codicefiscale ) {
        Optional<Student> s = service.findByCodiceFiscale(codicefiscale);
        if ( s.isPresent() ) {
            return new StudentDTO(s.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
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

    @GetMapping("interesse/{interesse}")
    public Collection<StudentDTO> getStudentByInteresseName ( @PathVariable String interesse ) {
        return service.findByListaInteressiNome(interesse).stream().map(StudentDTO::new).collect(Collectors.toList());
    }

    @GetMapping("categoria/{categoria}")
    public Collection<StudentDTO> getStudentByCategoriaName ( @PathVariable String categoria ) {
        return service.findByListaInteressiCategoria(categoria).stream().map(StudentDTO::new).collect(Collectors.toList());
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
