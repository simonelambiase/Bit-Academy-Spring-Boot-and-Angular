package it.simonelambiase.www.springAcademy.springAcademy.dto;

import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Lezione;

import java.time.LocalDateTime;

public class LezioneDTO {
    private LocalDateTime dataInizio;
    private LocalDateTime dataFine;
    private String nomeAula;
    private String nomeCorso;
    private String nomeModulo;

    public LezioneDTO () {

    }

    public LezioneDTO ( Lezione l ) {
        this.dataInizio = l.getDataInizio();
        this.dataFine = l.getDataFine();
        this.nomeAula = l.getAula().getNomeAula();
        this.nomeCorso = l.getModulo().getCourse().getNome();
        this.nomeModulo = l.getModulo().getNome();
    }

    public LezioneDTO(LocalDateTime dataInizio, LocalDateTime dataFine, String nomeAula, String nomeCorso, String nomeModulo) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.nomeAula = nomeAula;
        this.nomeCorso = nomeCorso;
        this.nomeModulo = nomeModulo;
    }

    public LocalDateTime getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDateTime dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDateTime getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDateTime dataFine) {
        this.dataFine = dataFine;
    }

    public String getNomeAula() {
        return nomeAula;
    }

    public void setNomeAula(String nomeAula) {
        this.nomeAula = nomeAula;
    }

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }

    public Lezione mapToLezione() {
        return new Lezione(this.dataInizio,this.dataFine);
    }

    public String getNomeCorso() {
        return nomeCorso;
    }

    public void setNomeCorso(String nomeCorso) {
        this.nomeCorso = nomeCorso;
    }
}
