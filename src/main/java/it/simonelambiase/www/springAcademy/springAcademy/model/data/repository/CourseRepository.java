package it.simonelambiase.www.springAcademy.springAcademy.model.data.repository;

import it.simonelambiase.www.springAcademy.springAcademy.model.Course;
import it.simonelambiase.www.springAcademy.springAcademy.model.Iscrizione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface CourseRepository extends JpaRepository <Course, Integer> {

}
