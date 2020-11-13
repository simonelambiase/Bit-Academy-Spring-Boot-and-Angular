package it.simonelambiase.www.springAcademy.springAcademy.dto;

import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Iscrizione;

import java.time.LocalDate;

public class IscrizioneDTO {
    private Integer id;
    private Integer studentId;
    private LocalDate data;
    private Integer valutazione;
    private Boolean ritirato;
    private Integer courseId;
    private String courseName;

    public IscrizioneDTO ( Iscrizione i ) {
        this.id = i.getId();
        this.studentId = i.getStudent().getId();
        this.data = i.getData();
        this.valutazione = i.getValutazione();
        this.ritirato = i.isRitirato();
        this.courseId = i.getCourse().getId();
        this.courseName = i.getCourse().getNome();

    }

    public IscrizioneDTO ( int idCorso, int idStudent ) {
        this.studentId = idStudent;
        this.courseId = idCorso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getValutazione() {
        return valutazione;
    }

    public void setValutazione(Integer valutazione) {
        this.valutazione = valutazione;
    }

    public Boolean getRitirato() {
        return ritirato;
    }

    public void setRitirato(Boolean ritirato) {
        this.ritirato = ritirato;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Iscrizione mapToIscrizione( Iscrizione i ) {
        return new Iscrizione(this.id, this.data, this.valutazione, this.ritirato, this.studentId);
    }
}
