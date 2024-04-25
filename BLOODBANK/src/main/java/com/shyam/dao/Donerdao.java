package com.shyam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.shyam.dto.Blood_Group;
import com.shyam.dto.Doner;

public class Donerdao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("shyam");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void Save(Doner d) {
		et.begin();
		em.persist(d);
		et.commit();
	}

	public void update(Doner d) {
		et.begin();
		em.merge(d);
		et.commit();
	}

	// Doner authontication
	public Doner findbyemail(String email) {
		Query q = em.createQuery("select s from Doner s where email =?1");
		q.setParameter(1, email);
		List<Doner> doner = q.getResultList();
		if (!doner.isEmpty()) {
			return doner.get(0);
		} else {
			return null;
		}

	}

	public void SAve(Blood_Group b) {

		et.begin();
		em.persist(b);
		et.commit();
	}

	public List<Doner> FindbyBgroup(String d, String a) {
		Query q = em.createQuery("select s from Doner s where blood_group =?1 and status= ?2");
		q.setParameter(1, d);
		q.setParameter(2, a);
		List<Doner> list = q.getResultList();
		if (!list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}

	public List<Doner> findal() {
		Query q = em.createQuery("select s from Doner s");
		List<Doner> doner = q.getResultList();
		if (!doner.isEmpty()) {
			return doner;
		} else {
			return null;
		}

	}

	public Doner findbyid(int id) {
		Query q = em.createQuery("select s from Doner s where id =?1");
		q.setParameter(1, id);
		List<Doner> doner = q.getResultList();
		if (!doner.isEmpty()) {
			return doner.get(0);
		} else {
			return null;
		}
	}

	public void Delete(Doner ee) {
		et.begin();
		em.remove(ee);
		et.commit();
	}

	public Doner findbyBloodid(int id) {
		Query q = em.createQuery("select s from Doner s where bloodgroup_id =?1 ");
		q.setParameter(1, id);
		List<Doner> list = q.getResultList();
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

}
