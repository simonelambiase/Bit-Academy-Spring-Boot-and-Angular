package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.student.customquery;

import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Student;

import javax.persistence.TypedQuery;
import java.util.Collection;

public interface StudentRepositoryCustomQuery {
    Collection<Student> customQuerySearch( TypedQuery<Student> query );
}
