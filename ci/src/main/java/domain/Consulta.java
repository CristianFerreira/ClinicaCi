package main.java.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="consulta")
public class Consulta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_consulta")
	private Long idConsulta;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
	private Usuario medico;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente", nullable = false)
	private Paciente paciente;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_plano", referencedColumnName = "id_plano")
	private PlanoDeSaude plano;
	
	private Date data;
	private Date hora;

	//Teste
	
	
	public Long getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Long idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Usuario getMedico() {
		return medico;
	}

	public void setMedico(Usuario medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public PlanoDeSaude getPlano() {
		return plano;
	}

	public void setPlano(PlanoDeSaude plano) {
		this.plano = plano;
	}
}
