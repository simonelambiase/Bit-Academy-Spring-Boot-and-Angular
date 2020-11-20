package it.simonelambiase.www.springAcademy.springAcademy.model.objects;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table ( name = "iscrizione")
public class Iscrizione {
	
	
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name ="id")
	private Integer id;
	@Column(name="data")
	private LocalDate data;
	@Column(name="valutazione")
	private Integer valutazione;
	@Column(name="ritirato")
	private Boolean ritirato;
	@Transient
	private Integer studentId;
	@Transient
	private Integer courseId;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_studente")
	private Student student;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_corso")
	private Course course ;
	
	public Iscrizione() {
		
	}
	
	public Iscrizione ( Student s, Course c ) {
		this.student = s;
		this.course = c;
	}

	public Iscrizione(Integer id, LocalDate data, Integer valutazione, Boolean ritirato, Integer studentid ) {
		this.id = id;
		this.data = data;
		this.valutazione = valutazione;
		this.ritirato = ritirato;
		this.studentId = studentid;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getRitirato() {
		return ritirato;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
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

	public Boolean isRitirato() {
		return ritirato;
	}

	public void setRitirato(Boolean ritirato) {
		this.ritirato = ritirato;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent( Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse( Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Iscrizione{" +
				"id=" + id +
				", data=" + data +
				", valutazione=" + valutazione +
				", ritirato=" + ritirato +
				", student=" + student +
				", course=" + course +
				'}';
	}
}
