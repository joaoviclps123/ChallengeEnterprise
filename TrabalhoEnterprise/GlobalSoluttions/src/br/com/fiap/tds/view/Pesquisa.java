package br.com.fiap.tds.view;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.entity.LojaDao;
import br.com.fiap.tds.dao.impl.LojaDaoiplm;
import br.com.fiap.tds.entity.LojaEntity;
import br.com.fiap.tds.entity.ProdutoEntity;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Pesquisa {

	public static void main(String[] args) {
EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		LojaDao lojadao = new LojaDaoiplm(em);
		try {
			LojaEntity loja = lojadao.read(1);
			
			System.out.println("Loja: " + loja.getNome());
			System.out.println("Produtos:" );
			List<ProdutoEntity> prods = loja.getProduto();
				for(ProdutoEntity prod : prods) {
					System.out.println(prod.getNome());
				}
		} catch (br.com.fiap.tds.exception.EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}
