package main.java.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planos_de_saude")
public class PlanoDeSaude {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_plano")
	private Long idPlano;
	
	private String nome;

	public Long getIdPlano() {
		return idPlano;
	}

	public void setIdPlano(Long idPlano) {
		this.idPlano = idPlano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "PlanoDeSaude [idPlano=" + idPlano + ", nome=" + nome + "]";
	}
}
