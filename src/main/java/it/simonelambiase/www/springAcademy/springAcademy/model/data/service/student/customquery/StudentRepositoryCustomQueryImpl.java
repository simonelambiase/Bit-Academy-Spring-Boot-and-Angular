package it.simonelambiase.www.springAcademy.springAcademy.model.data.service.student.customquery;

import it.simonelambiase.www.springAcademy.springAcademy.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentRepositoryCustomQueryImpl implements StudentRepositoryCustomQuery {

    private EntityManager em;

    @Autowired
    public StudentRepositoryCustomQueryImpl (EntityManager em) {
        this.em = em;
    }


    @Override
    public List<Student> customQuerySearch (String queryString) {
        return em.createQuery(queryString).getResultList();
    }
}
