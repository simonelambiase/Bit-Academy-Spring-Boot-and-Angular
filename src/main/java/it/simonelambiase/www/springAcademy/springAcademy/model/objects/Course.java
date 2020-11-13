package it.simonelambiase.www.springAcademy.springAcademy.model.objects;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table ( name = "corso")
public class Course {
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name ="id")
	private Integer id;
	@Column ( name = "nome")
	private String nome; 
	@Column ( name="materia")
	private String materia;
	@Column ( name="max_iscritti")
	private int maxIscritti; 
	@Column ( name="categoria")
	private String categoria; 
	@Column ( name="data_inizio")
	private LocalDate dataInizio;
	@Column ( name="durata_corso")
	private int durataCorso; 
	@Column ( name="orario_min")
	private int orarioMinimo; 
	@Column ( name = "ente")
	private String ente;
	@Column ( name ="azienda")
	private String azienda;
	@ManyToOne
	@JoinColumn ( name = "id_aula_preferita")
	private Aula aulaPreferita;
	
	@OneToMany( mappedBy="course", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Iscrizione> listaIscrizione;
	@OneToMany ( mappedBy = "course", fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	private Set<Modulo> listaModuli;

	public int getMaxIscritti() {
		return maxIscritti;
	}

	public void setMaxIscritti(int maxIscritti) {
		this.maxIscritti = maxIscritti;
	}

	public Set<Iscrizione> getListaIscrizione() {
		return listaIscrizione;
	}

	public void setListaIscrizione(Set<Iscrizione> listaIscrizione) {
		this.listaIscrizione = listaIscrizione;
	}

	public Course() {
		
	}
	public void addNewIscrizione(Iscrizione i) {
		if(listaIscrizione== null) {
			listaIscrizione=new HashSet();
		}
		listaIscrizione.add(i);
		
	}

	
	
	public Course( String nome, String materia, int max_iscritti, String categoria, int durataCorso, LocalDate dataInizio,
			int orarioMinimo) {
		this.nome = nome;
		this.materia = materia;
		this.maxIscritti = max_iscritti;
		this.dataInizio = dataInizio;
		this.categoria = categoria;
		this.durataCorso = durataCorso;
		this.orarioMinimo = orarioMinimo;
	}

	public Course(int id, String nome, String materia, int max_iscritti, String categoria, LocalDate dataInizio,
			int durataCorso, int orarioMinimo, String ente, String azienda) {
		this.id = id;
		this.nome = nome;
		this.materia = materia;
		this.maxIscritti = max_iscritti;
		this.categoria = categoria;
		this.dataInizio = dataInizio;
		this.durataCorso = durataCorso;
		this.orarioMinimo = orarioMinimo;
		this.ente = ente;
		this.azienda = azienda;
	}

	public Course(String nome, String materia, int maxIscritti, String categoria, LocalDate dataInizio, int durataCorso, Aula aulaPreferita ) {
		this.nome = nome;
		this.materia = materia;
		this.maxIscritti = maxIscritti;
		this.categoria = categoria;
		this.dataInizio = dataInizio;
		this.durataCorso = durataCorso;
		this.aulaPreferita = aulaPreferita;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public int getMax_iscritti() {
		return maxIscritti;
	}

	public void setMax_iscritti(int max_iscritti) {
		this.maxIscritti = max_iscritti;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public int getOrarioMinimo() {
		return orarioMinimo;
	}

	public void setOrarioMinimo(int orarioMinimo) {
		this.orarioMinimo = orarioMinimo;
	}

	public String getEnte() {
		return ente;
	}

	public void setEnte(String ente) {
		this.ente = ente;
	}

	public String getAzienda() {
		return azienda;
	}

	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}

	public Aula getAulaPreferita() {
		return aulaPreferita;
	}

	public void setAulaPreferita(Aula aulaPreferita) {
		this.aulaPreferita = aulaPreferita;
	}

	public Set<Modulo> getListaModuli() {
		return listaModuli;
	}

	public void setListaModuli(Set<Modulo> listaModuli) {
		this.listaModuli = listaModuli;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", nome=" + nome + ", materia=" + materia + ", max_iscritti=" + maxIscritti
				+ ", categoria=" + categoria + ", dataInizio=" + dataInizio + ", durataCorso=" + durataCorso
				+ ", orarioMinimo=" + orarioMinimo + ", ente=" + ente + ", azienda=" + azienda + "]";
	}   

}
