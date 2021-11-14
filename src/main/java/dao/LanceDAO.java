package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import entidades.Lance;
import util.JPAUtil;

//item c
public class LanceDAO {

	EntityManager em;

	public LanceDAO() {

	}

	public LanceDAO(EntityManager em) {
		this.em = em;
	}

	public void salvar(Lance lance) {
		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		em.getTransaction().begin();
		em.persist(lance);
		em.getTransaction().commit();
		em.close();
	}

	public void editar(Lance lance) {
		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		em.getTransaction().begin();
		this.em.merge(lance);
		em.getTransaction().commit();
		em.close();
	}

	public void merge(Lance lance) {
		em.getTransaction().begin();
		em.merge(lance);
		em.getTransaction().commit();
		em.close();

	}

	public void remover(Lance lance) {

		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		em.getTransaction().begin();
		lance = em.merge(lance);
		this.em.remove(lance);
		em.getTransaction().commit();
		em.close();
	}

	public ArrayList<Lance> listar() {
		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		String jpql = "SELECT c FROM Lance c ORDER BY c.id DESC";
		return (ArrayList<Lance>) em.createQuery(jpql, Lance.class).getResultList();
	}

}
