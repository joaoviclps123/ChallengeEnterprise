package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_FUNCIONARIO")
@SequenceGenerator(name="funcionario", sequenceName = "SQ_TB_FUNCIONARIO", allocationSize = 1)
public class FuncionarioEntity {
	
	@Id
	@Column(name="cd_funcionario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario")
	private  int id;
	
	@Column(name="nm_funcionario", length = 100, nullable = false)
	private String nome;
	
	@Column(name="rm_rm", nullable = false)
	private int rm;
	
	@Column(name="cpf_cpf", length = 12)
	private String cpf;
	
	@Column(name="fc_funcao", length = 50)
	private String funcao;
	
	@ManyToOne
	@JoinColumn(name="cd_loja", nullable = false)
	private LojaEntity loja;
	
	
	public FuncionarioEntity() {
		
	}

	

	public FuncionarioEntity(String nome, int rm, String cpf, String funcao, LojaEntity loja) {
		this.nome = nome;
		this.rm = rm;
		this.cpf = cpf;
		this.funcao = funcao;
		this.loja = loja;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getRm() {
		return rm;
	}


	public void setRm(int rm) {
		this.rm = rm;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getFuncao() {
		return funcao;
	}


	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}


	public LojaEntity getLoja() {
		return loja;
	}


	public void setLoja(LojaEntity loja) {
		this.loja = loja;
	}
	
	
}
