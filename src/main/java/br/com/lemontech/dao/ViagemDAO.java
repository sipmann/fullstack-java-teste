package br.com.lemontech.dao;

import org.springframework.stereotype.Repository;

import br.com.lemontech.model.Viagem;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ViagemDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Viagem obj) {
		manager.merge(obj);
	}
	
	public void gravar(List<Viagem> obj) {
		for (Viagem viagem : obj) {
			// already have an ID.. so merge.
			manager.merge(viagem);
		}
	}
	
	public List<Viagem> listar() {
		return manager.createQuery("SELECT v FROM Viagem v", Viagem.class).getResultList();
	}
	
}
