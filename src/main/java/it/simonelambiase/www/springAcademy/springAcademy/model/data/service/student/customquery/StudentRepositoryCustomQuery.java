package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.student.customquery;

import it.simonelambiase.www.springAcademy.springAcademy.model.Student;

import javax.persistence.EntityManager;
import java.util.Collection;

public interface StudentRepositoryCustomQuery {
    Collection<Student> customQuerySearch(String queryString );
}
