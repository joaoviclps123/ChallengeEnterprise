package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.fiap.tds.enun.CategoriaLoja;

@Entity
@Table(name = "TB_LOJA")
@SequenceGenerator(name = "loja", sequenceName = "SQ_TB_LOJA", allocationSize = 1)
public class LojaEntity {

	@Id
	@Column(name = "cd_loja")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loja")
	private int id;

	@Column(name = "nm_nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "cn_cnpj", length = 14)
	private String cnpj;

	@Column(name = "lc_localizacao", length = 150, nullable = true)
	private String localizacao;

	@Column(name = "cd_codigo", nullable = false)
	private int codigo;

	@Enumerated(EnumType.STRING)
	@Column(name = "categopria", length = 50)
	private CategoriaLoja categoriaLoja;

	@OneToMany(mappedBy = "loja", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<ProdutoEntity> produto;

	public void addProdutoEntity(ProdutoEntity produt) {
		if (produto == null)
			produto = new ArrayList<>();
		produto.add(produt);
		produt.setLoja(this);
	}

	@OneToMany(mappedBy = "loja", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<FuncionarioEntity> funcionario;

	public void addFuncionarioEntity(FuncionarioEntity func) {
		if (funcionario == null)
			funcionario = new ArrayList<>();
		funcionario.add(func);
		func.setLoja(this);
	}

	public LojaEntity() {
	}

	

	public LojaEntity(String nome, String cnpj, String localizacao, int codigo, CategoriaLoja categoriaLoja) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.localizacao = localizacao;
		this.codigo = codigo;
		this.categoriaLoja = categoriaLoja;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<FuncionarioEntity> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<FuncionarioEntity> funcionario) {
		this.funcionario = funcionario;
	}

	public CategoriaLoja getCategoriaLoja() {
		return categoriaLoja;
	}

	public void setCategoriaLoja(CategoriaLoja categoriaLoja) {
		this.categoriaLoja = categoriaLoja;
	}

	public List<ProdutoEntity> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoEntity> produto) {
		this.produto = produto;
	}

}
