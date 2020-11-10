package it.simonelambiase.www.springAcademy.springAcademy.dto;

import it.simonelambiase.www.springAcademy.springAcademy.model.Professor;
import it.simonelambiase.www.springAcademy.springAcademy.model.exception.Modulo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProfessorDTO {
    private Integer id;
    private String fullName;
    private String codiceFiscale;
    private String indirizzo;
    private String partitaIva;
    private LocalDate dataDiNascita;
    private String email;
    private String telefono;
    private String titoloDiStudio;
    private List<ModuloDTO> listaModuli;

    public ProfessorDTO () {

    }

    public ProfessorDTO ( Professor p ) {
        this.id = p.getId();
        this.fullName = p.getNome() + " " + p.getCognome();
        this.codiceFiscale = p.getCodiceFiscale();
        this.indirizzo = p.getIndirizzo();
        this.partitaIva = p.getPartitaIva();
        this.dataDiNascita = p.getDataDiNascita();
        this.email = p.getEmail();
        this.telefono = p.getTelefono();
        this.titoloDiStudio = p.getTitoloDiStudio();
        this.listaModuli = p.getListaModuli().stream().map(ModuloDTO::new).collect(Collectors.toList());
    }

    public ProfessorDTO(String fullName, String codiceFiscale, String indirizzo, String partitaIva, LocalDate dataDiNascita, String email, String telefono, String titoloDiStudio) {
        this.fullName = fullName;
        this.codiceFiscale = codiceFiscale;
        this.indirizzo = indirizzo;
        this.partitaIva = partitaIva;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.telefono = telefono;
        this.titoloDiStudio = titoloDiStudio;
    }

    public ProfessorDTO(Integer id, String fullName, String codiceFiscale, String indirizzo, String partitaIva, LocalDate dataDiNascita, String email, String telefono, String titoloDiStudio) {
        this.id = id;
        this.fullName = fullName;
        this.codiceFiscale = codiceFiscale;
        this.indirizzo = indirizzo;
        this.partitaIva = partitaIva;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.telefono = telefono;
        this.titoloDiStudio = titoloDiStudio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTitoloDiStudio() {
        return titoloDiStudio;
    }

    public void setTitoloDiStudio(String titoloDiStudio) {
        this.titoloDiStudio = titoloDiStudio;
    }

    public List<ModuloDTO> getListaModuli() {
        return listaModuli;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public void setListaModuli(List<ModuloDTO> listaModuli) {
        this.listaModuli = listaModuli;
    }

    public Professor mapToProfessor ( ) {
        String[] splitName = this.getFullName().split("\\s+");
        return new Professor(splitName[0],splitName[1],this.indirizzo, this.partitaIva, this.codiceFiscale, this.dataDiNascita, this.email, this.telefono, this.titoloDiStudio);
    }
}
