package it.simonelambiase.www.springAcademy.springAcademy.model.objects;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "aula")
public class Aula {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column ( name = "id")
    private Integer id;
    @Column ( name = "nome_aula")
    private String nomeAula;
    @Column ( name = "capienza_max")
    private int capienzaMax;
    @Column ( name = "computer_max")
    private int computerMax;
    @Column ( name = "proiettore")
    private boolean proiettore;
    @Column ( name = "piattaforma")
    private String piattaforma;
    @OneToMany ( mappedBy="aula", fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    private Set<Lezione> listaLezioni;
    @OneToMany ( mappedBy="aulaPreferita", fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    private Set<Course> listaCorsi;

    public Aula () {

    }

    public Aula(String nomeAula) {
        this.nomeAula = nomeAula;
    }

    public Aula(String nomeAula, int capienzaMax, int computerMax, boolean proiettore) {
        this.nomeAula = nomeAula;
        this.capienzaMax = capienzaMax;
        this.computerMax = computerMax;
        this.proiettore = proiettore;
    }

    public Aula(String nomeAula, String piattaforma) {
        this.nomeAula = nomeAula;
        this.piattaforma = piattaforma;
    }

    public Aula(int id, String nomeAula, int capienzaMax, int computerMax, boolean proiettore, String piattaforma) {
        this.id = id;
        this.nomeAula = nomeAula;
        this.capienzaMax = capienzaMax;
        this.computerMax = computerMax;
        this.proiettore = proiettore;
        this.piattaforma = piattaforma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeAula() {
        return nomeAula;
    }

    public void setNomeAula(String nomeAula) {
        this.nomeAula = nomeAula;
    }

    public int getCapienzaMax() {
        return capienzaMax;
    }

    public void setCapienzaMax(int capienzaMax) {
        this.capienzaMax = capienzaMax;
    }

    public int getComputerMax() {
        return computerMax;
    }

    public void setComputerMax(int computerMax) {
        this.computerMax = computerMax;
    }

    public boolean isProiettore() {
        return proiettore;
    }

    public void setProiettore(boolean proiettore) {
        this.proiettore = proiettore;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Aula{");
        sb.append("id=").append(id);
        sb.append(", nomeAula='").append(nomeAula).append('\'');
        sb.append(", capienzaMax=").append(capienzaMax);
        sb.append(", computerMax=").append(computerMax);
        sb.append(", proiettore=").append(proiettore);
        sb.append(", piattaforma='").append(piattaforma).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
