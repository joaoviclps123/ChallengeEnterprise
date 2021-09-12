package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.entity.LojaDao;
import br.com.fiap.tds.dao.gereneric.mpl.GenericDaoImpl;
import br.com.fiap.tds.entity.LojaEntity;

public class LojaDaoiplm extends GenericDaoImpl<LojaEntity, Integer> implements LojaDao{

	public LojaDaoiplm(EntityManager em) {
		super(em);
	}

}
