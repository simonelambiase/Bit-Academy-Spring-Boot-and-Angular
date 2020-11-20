package it.simonelambiase.www.springAcademy.springAcademy.dto;

import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Interesse;
import it.simonelambiase.www.springAcademy.springAcademy.model.objects.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDTO {
    private int id;
    private String fullName;
    private String codiceFiscale;
    private LocalDate dataDiNascita;
    private String indirizzo;
    private String mail;
    private String telefono;
    private String titoloDiStudio;
    private boolean sesso;
    private List<IscrizioneDTO> listaIscrizione;
    private List<Interesse> listaInteresse;

    public StudentDTO () {

    }

    public StudentDTO ( Student s ) {
        this.id = s.getId();
        this.fullName = s.getNome() + " " + s.getCognome();
        this.codiceFiscale = s.getCodiceFiscale();
        this.dataDiNascita = s.getDataDiNascita();
        this.indirizzo = s.getIndirizzo();
        this.mail = s.getMail();
        this.telefono = s.getTelefono();
        this.titoloDiStudio = s.getTitoloDiStudio();
        this.sesso = s.isSesso();
        this.listaIscrizione = s.getListaIscrizione().stream().map(IscrizioneDTO::new).collect(Collectors.toList());
        this.listaInteresse = s.getListaInteressi(); // Aggiungere DTO
    }

    public StudentDTO (String fullName, String codiceFiscale, LocalDate dataDiNascita, String indirizzo, String mail, String telefono, String titoloDiStudio, boolean sesso) {
        this.fullName = fullName;
        this.codiceFiscale = codiceFiscale;
        this.dataDiNascita = dataDiNascita;
        this.indirizzo = indirizzo;
        this.mail = mail;
        this.telefono = telefono;
        this.titoloDiStudio = titoloDiStudio;
        this.sesso = sesso;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public boolean isSesso() {
        return sesso;
    }

    public void setSesso(boolean sesso) {
        this.sesso = sesso;
    }

    public List<IscrizioneDTO> getListaIscrizione() {
        return listaIscrizione;
    }

    public void setListaIscrizione(List<IscrizioneDTO> listaIscrizione) {
        this.listaIscrizione = listaIscrizione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public List<Interesse> getListaInteresse() {
        return listaInteresse;
    }

    public void setListaInteresse(List<Interesse> listaInteresse) {
        this.listaInteresse = listaInteresse;
    }

    public Student mapToStudent () {
        String[] nameSplit = fullName.split("\\s+");
        return new Student(nameSplit[0],nameSplit[1],this.codiceFiscale, this.dataDiNascita, this.indirizzo, this.mail, this.telefono, this.titoloDiStudio, this.sesso);
    }
}
