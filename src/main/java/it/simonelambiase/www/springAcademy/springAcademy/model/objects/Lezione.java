package it.simonelambiase.www.springAcademy.springAcademy.model.objects;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lezione")
public class Lezione {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column ( name = "id")
    private Integer id;
    @Column ( name = "data_inizio")
    LocalDateTime dataInizio;
    @Column ( name = "data_fine")
    LocalDateTime dataFine;
    @ManyToOne
    @JoinColumn( name = "id_aula" )
    private Aula aula;
    @ManyToOne
    @JoinColumn( name = "id_modulo")
    private Modulo modulo;

    public Lezione() {

    }

    public Lezione( LocalDateTime dataInizio, LocalDateTime dataFine) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Lezione(Integer id, LocalDateTime dataInizio, LocalDateTime dataFine) {
        this.id = id;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Lezione( LocalDateTime dataInizio, LocalDateTime dataFine, Aula aula, Modulo modulo) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.aula = aula;
        this.modulo = modulo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Lezione{");
        sb.append("id=").append(id);
        sb.append(", dataInizio=").append(dataInizio);
        sb.append(", dataFine=").append(dataFine);
        sb.append(", aula=").append(aula);
        sb.append(", modulo=").append(modulo);
        sb.append('}');
        return sb.toString();
    }
}
