package main.java.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pacientes")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_paciente")
	private Long codigo;
	
	
	private String nome;
	private String telefone;
	private Date dataNasc;
	private String endereco;
	private String observacao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Override
	public String toString() {
		return "Paciente [codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", dataNasc=" + dataNasc
				+ ", endereco=" + endereco + ", observacao=" + observacao + "]";
	}
}