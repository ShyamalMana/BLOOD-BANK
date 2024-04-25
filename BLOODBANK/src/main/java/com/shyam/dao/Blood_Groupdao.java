package com.shyam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.shyam.dto.Blood_Group;


public class Blood_Groupdao 
{
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("shyam");
	EntityManager  em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();


	public List<Blood_Group> findbyid(int id) {
		Query q=em.createQuery("select s from Blood_Group s where id =?1");
		q.setParameter(1, id);
		List<Blood_Group> bg=q.getResultList();
		if(!bg.isEmpty())
		{
			return bg;
		}else {
		return null;
		}		
	}


	public void save(Blood_Group blood) {
		et.begin();
		em.persist(blood);
		et.commit();
		
	}


	public void update(Blood_Group blood) {
		et.begin();
		em.merge(blood);
		et.commit();
		
	}


	public void Delete(List<Blood_Group> blood) {
		et.begin();
		em.remove(blood);
		et.commit();
		
	}

}
