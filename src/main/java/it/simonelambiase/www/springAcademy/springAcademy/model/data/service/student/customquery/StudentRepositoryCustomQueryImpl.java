package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.student.customquery;

import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Student;

import javax.persistence.TypedQuery;
import java.util.List;

public class StudentRepositoryCustomQueryImpl implements StudentRepositoryCustomQuery {


    @Override
    public List<Student> customQuerySearch ( TypedQuery<Student> query) {
            return query.getResultList();
    }
}
