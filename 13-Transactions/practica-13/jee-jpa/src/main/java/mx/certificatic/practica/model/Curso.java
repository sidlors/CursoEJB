package mx.certificatic.practica.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="nombre_oficial")
	private String nombreOficial;

	private String vendor;

	//bi-directional many-to-one association to Grupo
	@OneToMany(mappedBy="curso")
	private List<Grupo> grupo;

	public Curso() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreOficial() {
		return this.nombreOficial;
	}

	public void setNombreOficial(String nombreOficial) {
		this.nombreOficial = nombreOficial;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public List<Grupo> getGrupo() {
		return this.grupo;
	}

	public void setGrupo(List<Grupo> grupo) {
		this.grupo = grupo;
	}

	public Grupo addGrupo(Grupo grupo) {
		getGrupo().add(grupo);
		grupo.setCurso(this);

		return grupo;
	}

	public Grupo removeGrupo(Grupo grupo) {
		getGrupo().remove(grupo);
		grupo.setCurso(null);

		return grupo;
	}

}