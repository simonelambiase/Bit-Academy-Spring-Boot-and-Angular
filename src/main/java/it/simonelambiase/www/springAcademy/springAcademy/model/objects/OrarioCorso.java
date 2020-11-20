package it.simonelambiase.www.springAcademy.springAcademy.model.objects;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class OrarioCorso {
    private DayOfWeek giornoSettimana;
    private LocalTime orarioInizio;
    private LocalTime orarioFine;

    public OrarioCorso(DayOfWeek giornoSettimana, LocalTime orarioInizio, LocalTime orarioFine) {
        this.giornoSettimana = giornoSettimana;
        this.orarioInizio = orarioInizio;
        this.orarioFine = orarioFine;
    }

    public DayOfWeek getGiornoSettimana() {
        return giornoSettimana;
    }

    public void setGiornoSettimana(DayOfWeek giornoSettimana) {
        this.giornoSettimana = giornoSettimana;
    }

    public LocalTime getOrarioInizio() {
        return orarioInizio;
    }

    public void setOrarioInizio(LocalTime orarioInizio) {
        this.orarioInizio = orarioInizio;
    }

    public LocalTime getOrarioFine() {
        return orarioFine;
    }

    public void setOrarioFine(LocalTime orarioFine) {
        this.orarioFine = orarioFine;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrarioCorso{");
        sb.append("giornoSettimana=").append(giornoSettimana);
        sb.append(", orarioInizio=").append(orarioInizio);
        sb.append(", orarioFine=").append(orarioFine);
        sb.append('}');
        return sb.toString();
    }
}
