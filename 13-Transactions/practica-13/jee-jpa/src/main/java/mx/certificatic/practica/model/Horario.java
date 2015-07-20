package mx.certificatic.practica.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date inicio;

	@Temporal(TemporalType.DATE)
	private Date termino;

	//bi-directional many-to-one association to Grupo
	@OneToMany(mappedBy="horario")
	private List<Grupo> grupo;

	public Horario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return this.termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public List<Grupo> getGrupo() {
		return this.grupo;
	}

	public void setGrupo(List<Grupo> grupo) {
		this.grupo = grupo;
	}

	public Grupo addGrupo(Grupo grupo) {
		getGrupo().add(grupo);
		grupo.setHorario(this);

		return grupo;
	}

	public Grupo removeGrupo(Grupo grupo) {
		getGrupo().remove(grupo);
		grupo.setHorario(null);

		return grupo;
	}

}