package it.simonelambiase.www.springAcademy.springAcademy.dto;

import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Aula;
import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Course;

import java.time.LocalDate;

public class CourseDTO {
    private String nomeCorso;
    private String materiaCorso;
    private String categoriaCorso;
    private int maxIscritti;
    private LocalDate dataInizio;
    private int durataCorso;
    private Integer aulaPreferita;

    public CourseDTO () {

    }

    public CourseDTO ( Course c ) {
        this.nomeCorso = c.getNome();
        this.materiaCorso = c.getMateria();
        this.categoriaCorso = c.getCategoria();
        this.maxIscritti = c.getMaxIscritti();
        this.dataInizio = c.getDataInizio();
        this.durataCorso = c.getDurataCorso();
        this.aulaPreferita = c.getAulaPreferita().getId();
    }

    public CourseDTO(String nomeCorso, String materiaCorso, String categoriaCorso, int maxIscritti, LocalDate dataInizio, int durataCorso, int aulaPreferita ) {
        this.nomeCorso = nomeCorso;
        this.materiaCorso = materiaCorso;
        this.categoriaCorso = categoriaCorso;
        this.maxIscritti = maxIscritti;
        this.dataInizio = dataInizio;
        this.durataCorso = durataCorso;
        this.aulaPreferita = aulaPreferita;
    }

    public String getNomeCorso() {
        return nomeCorso;
    }

    public void setNomeCorso(String nomeCorso) {
        this.nomeCorso = nomeCorso;
    }

    public String getMateriaCorso() {
        return materiaCorso;
    }

    public void setMateriaCorso(String materiaCorso) {
        this.materiaCorso = materiaCorso;
    }

    public String getCategoriaCorso() {
        return categoriaCorso;
    }

    public void setCategoriaCorso(String categoriaCorso) {
        this.categoriaCorso = categoriaCorso;
    }

    public int getMaxIscritti() {
        return maxIscritti;
    }

    public void setMaxIscritti(int maxIscritti) {
        this.maxIscritti = maxIscritti;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public int getDurataCorso() {
        return durataCorso;
    }

    public void setDurataCorso(int durataCorso) {
        this.durataCorso = durataCorso;
    }

    public Integer getAulaPreferita() {
        return aulaPreferita;
    }

    public void setAulaPreferita(Integer aulaPreferita) {
        this.aulaPreferita = aulaPreferita;
    }



    public Course mapToCourse( Aula aula ) {
        return new Course(this.nomeCorso,this.materiaCorso,this.maxIscritti,this.categoriaCorso,this.dataInizio,this.durataCorso, aula);
    }
}
