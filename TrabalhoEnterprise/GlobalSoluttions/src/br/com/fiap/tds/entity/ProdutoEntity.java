package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fiap.tds.enun.CategoriaProduto;

@Entity
@Table(name = "TB_PRODUTO")
@SequenceGenerator(name = "produto", sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
public class ProdutoEntity {

	@Id
	@Column(name = "cd_produto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	private int id;

	@Column(name = "nm_nome", length = 150, nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(name = "ct_categoria", length = 50, nullable = false)
	private CategoriaProduto categoria;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_valid")
	private Calendar dtValidade;

	@Column(name = "qc_qrcode", nullable = true)
	private int qrcode;

	@ManyToOne
	@JoinColumn(name = "cd_loja", nullable = false)
	private LojaEntity loja;

	public ProdutoEntity() {

	}

	

	public ProdutoEntity(String nome, CategoriaProduto categoria, Calendar dtValidade, int qrcode, LojaEntity loja) {
		this.nome = nome;
		this.categoria = categoria;
		this.dtValidade = dtValidade;
		this.qrcode = qrcode;
		this.loja = loja;
	}
	
	public ProdutoEntity(String nome, CategoriaProduto categoria, int qrcode, LojaEntity loja) {
		this.nome = nome;
		this.categoria = categoria;
		this.qrcode = qrcode;
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

	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}

	public Calendar getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(Calendar dtValidade) {
		this.dtValidade = dtValidade;
	}

	public int getQrcode() {
		return qrcode;
	}

	public void setQrcode(int qrcode) {
		this.qrcode = qrcode;
	}

	public LojaEntity getLoja() {
		return loja;
	}

	public void setLoja(LojaEntity loja) {
		this.loja = loja;
	}

}
