package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.course;

import it.simonelambiase.www.springAcademy.springAcademy.dto.CourseDTO;
import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Course;
import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Lezione;
import it.simonelambiase.www.springAcademy.springAcademy.model.objects.PreferenzeCorso;

import java.util.Collection;

public interface CourseService {
    Collection<Course> findByNome( String nomeCorso );
    Collection<Course> findByMateria( String materiaCorso );
    Collection<Course> findByMaxIscritti( int maxIscritti );
    Collection<Course> findByCategoria( String categoriaCorso );
    Collection<Course> findAll();
    Collection<Lezione> createCalendar( PreferenzeCorso pc );
    Course save( CourseDTO course );
}
