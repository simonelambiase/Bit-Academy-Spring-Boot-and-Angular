package it.simonelambiase.www.springAcademy.springAcademy.model.data.repository;

import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CourseRepository extends JpaRepository <Course, Integer> {
    Collection<Course> findByNome( String nomeCorso );
    Collection<Course> findByMateria( String materiaCorso );
    Collection<Course> findByMaxIscritti( int maxIscritti );
    Collection<Course> findByCategoria( String categoria );

}
