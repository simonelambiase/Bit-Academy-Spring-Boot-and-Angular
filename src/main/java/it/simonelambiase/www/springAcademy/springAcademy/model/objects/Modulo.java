package it.simonelambiase.www.springAcademy.springAcademy.model.objects;


import javax.persistence.*;
import java.util.List;

@Entity
@Table ( name = "modulo")
public class Modulo {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    @Column ( name = "id")
    private Integer id;
    @Column ( name = "nome")
    private String nome;
    @Column ( name = "descrizione")
    private String descrizione;
    @Column ( name = "numero_ore")
    private int numeroOre;
    @Column ( name = "numero_modulo")
    private int numeroModulo;
    @ManyToOne ( fetch = FetchType.EAGER, cascade =  CascadeType.ALL )
    @JoinColumn ( name = "id_corso" )
    private Course course;
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name = "id_insegnante" )
    private Professor professore;
    @OneToMany ( mappedBy = "modulo", fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    private List<Lezione> listaLezioni;

    public Modulo() {

    }

    public Modulo(String nome, String descrizione, int numeroOre, int numeroModulo, Course course, Professor professore) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.numeroOre = numeroOre;
        this.numeroModulo = numeroModulo;
        this.course = course;
        this.professore = professore;
    }

    public Modulo(Integer id, String nome, String descrizione, int numeroOre, int numeroModulo, Course course, Professor professore) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.numeroOre = numeroOre;
        this.numeroModulo = numeroModulo;
        this.course = course;
        this.professore = professore;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Professor getProfessore() {
        return professore;
    }

    public void setProfessore(Professor professore) {
        this.professore = professore;
    }

    public int getNumeroModulo() {
        return numeroModulo;
    }

    public void setNumeroModulo(int numeroModulo) {
        this.numeroModulo = numeroModulo;
    }

    public List<Lezione> getListaLezioni() {
        return listaLezioni;
    }

    public void setListaLezioni(List<Lezione> listaLezioni) {
        this.listaLezioni = listaLezioni;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Modulo{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", descrizione='").append(descrizione).append('\'');
        sb.append(", numeroOre=").append(numeroOre);
        sb.append(", numeroModulo=").append(numeroModulo);
        sb.append('}');
        return sb.toString();
    }
}
