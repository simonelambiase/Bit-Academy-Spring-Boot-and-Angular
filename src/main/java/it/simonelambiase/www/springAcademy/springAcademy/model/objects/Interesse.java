package it.simonelambiase.www.springAcademy.springAcademy.model.objects;

import javax.persistence.*;

@Entity
@Table ( name = "interessi")
public class Interesse {
	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO )
	@Column ( name = "id")
	private int id;
	@Column ( name = "nome_interesse")
	private String nome;
	@Column ( name = "descrizione_interesse")
	private String descrizione;
	@Column ( name = "categoria_interesse")
	private String categoria;

	public Interesse() {

	}

	public Interesse(String nome) {
		this.nome = nome;
	}

	public Interesse(String nome, String descrizione, String categoria, boolean certificata) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.categoria = categoria;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Area [nome=" + nome + ", descrizione=" + descrizione + ", categoria=" + categoria + ", certificata="
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Interesse))
			return false;
		Interesse other = (Interesse) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	} 
	
	
	
	
}
