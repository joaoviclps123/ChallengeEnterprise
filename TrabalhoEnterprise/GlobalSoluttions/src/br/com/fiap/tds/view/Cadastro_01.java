package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.entity.LojaDao;
import br.com.fiap.tds.dao.impl.LojaDaoiplm;
import br.com.fiap.tds.entity.FuncionarioEntity;
import br.com.fiap.tds.entity.LojaEntity;
import br.com.fiap.tds.entity.ProdutoEntity;
import br.com.fiap.tds.enun.CategoriaLoja;
import br.com.fiap.tds.enun.CategoriaProduto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Cadastro_01 {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		LojaDao lojadao = new LojaDaoiplm(em);
		
		
		LojaEntity loja = new LojaEntity("Teste Loja", "22222222222", "Jaiba", 1, CategoriaLoja.AUTOS);
		
		
		
		ProdutoEntity prod1 = new ProdutoEntity("Gol", CategoriaProduto.AUTOS, 2312312, loja);
		FuncionarioEntity func = new FuncionarioEntity("Victor", 85058, "14782156669", "gerente", loja);
		
		loja.addProdutoEntity(prod1);
		loja.addFuncionarioEntity(func);
		
		lojadao.create(loja);
		
		try {
			lojadao.commit();
			System.out.println("Loja cadastrada!....");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
}
