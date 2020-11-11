package it.simonelambiase.www.springAcademy.springAcademy.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table ( name = "studente" )
public class Student {
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name ="id")
	private int id; 
	@Column ( name = "nome")
	private String nome; 
	@Column ( name = "cognome")
	private String cognome; 
	@Column ( name = "codice_fiscale")
	private String codiceFiscale;
	@Column ( name = "data_di_nascita")
	private LocalDate dataDiNascita;
	@Column ( name = "indirizzo")
	private String indirizzo;
	@Column ( name= "mail")
	private String mail; 
	@Column ( name= "telefono")
	private String telefono; 
	@Column ( name = "titolo_di_studio")
	private String titoloDiStudio;
	@Column ( name ="sesso")
	private boolean sesso;
	@ManyToMany ( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinTable (
			name = "interessi_studenti",
			joinColumns = @JoinColumn(name = "id_studente"),
			inverseJoinColumns = @JoinColumn(name = "id_interesse")
	)
	private List<Interesse> listaInteressi;

	@OneToMany(mappedBy="student", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Iscrizione> listaIscrizione;
	
	public List<Iscrizione> getListaIscrizione() {
		return listaIscrizione;
	}

	public void setListaIscrizione(List<Iscrizione> listaIscrizione) {
		this.listaIscrizione = listaIscrizione;
	}

	public Student() {
		
	}
	
	public Student( String nome, String cognome, String codiceFiscale, LocalDate dataDiNascita, String indirizzo,
			String mail, String telefono, String titoloDiStudio, boolean sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataDiNascita = dataDiNascita;
		this.indirizzo = indirizzo;
		this.mail = mail;
		this.telefono = telefono;
		this.titoloDiStudio = titoloDiStudio;
		this.sesso = sesso;
	}
	
	

	public Student(int id, String nome, String cognome, String codiceFiscale, LocalDate dataDiNascita, String indirizzo,
			String mail, String telefono, String titoloDiStudio, boolean sesso) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
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

	public Student setId(int id) {
		this.id = id; return this;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
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

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale
				+ ", dataDiNascita=" + dataDiNascita + ", indirizzo=" + indirizzo + ", mail=" + mail + ", telefono="
				+ telefono + ", titoloDiStudio=" + titoloDiStudio + ", sesso=" + sesso + "]";
	}
	
	public void addNewIscrizione(Iscrizione i) {
		if(listaIscrizione== null) {
			listaIscrizione=new ArrayList();
		}
		listaIscrizione.add(i);
		
	}

	public List<Interesse> getListaInteressi() {
		return listaInteressi;
	}

	public void setListaInteressi(List<Interesse> listaInteressi) {
		this.listaInteressi = listaInteressi;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return id == student.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
