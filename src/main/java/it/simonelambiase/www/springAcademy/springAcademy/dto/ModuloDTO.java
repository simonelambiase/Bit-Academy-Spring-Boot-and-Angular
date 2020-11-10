package it.simonelambiase.www.springAcademy.springAcademy.dto;

import it.simonelambiase.www.springAcademy.springAcademy.model.exception.Modulo;

public class ModuloDTO {
    private String nome;
    private String descrizione;
    private int numeroOre;
    private int numeroModulo;
    private int idCorso;
    private int idProfessore;
    private String nomeCorso;

    public ModuloDTO () {

    }

    public ModuloDTO (Modulo m ) {
        this.nome = m.getNome();
        this.descrizione = m.getDescrizione();
        this.numeroOre = m.getNumeroOre();
        this.numeroModulo = m.getNumeroModulo();
        this.idCorso = m.getCourse().getId();
        this.nomeCorso = m.getCourse().getNome();
    }

    public ModuloDTO(String nome, String descrizione, int numeroOre, int numeroModulo, int idCorso, int idProfessore, String nomeCorso) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.numeroOre = numeroOre;
        this.numeroModulo = numeroModulo;
        this.idCorso = idCorso;
        this.idProfessore = idProfessore;
        this.nomeCorso = nomeCorso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getNumeroOre() {
        return numeroOre;
    }

    public void setNumeroOre(int numeroOre) {
        this.numeroOre = numeroOre;
    }

    public int getNumeroModulo() {
        return numeroModulo;
    }

    public void setNumeroModulo(int numeroModulo) {
        this.numeroModulo = numeroModulo;
    }

    public int getIdCorso() {
        return idCorso;
    }

    public void setIdCorso(int idCorso) {
        this.idCorso = idCorso;
    }

    public int getIdProfessore() {
        return idProfessore;
    }

    public void setIdProfessore(int idProfessore) {
        this.idProfessore = idProfessore;
    }

    public String getNomeCorso() {
        return nomeCorso;
    }

    public void setNomeCorso(String nomeCorso) {
        this.nomeCorso = nomeCorso;
    }
}
