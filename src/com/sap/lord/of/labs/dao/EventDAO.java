package com.sap.lord.of.labs.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sap.lord.of.labs.model.Event;

@Repository
public class EventDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Collection<Event> getAllTasks(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Event> criteria = cb.createQuery(Event.class);
		Collection<Event> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public Event getEventById(long id){
		Event event = em.find(Event.class, id);
		return event;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public Event createEvent(Event event){
		em.persist(event);
		return event;
	}
	
	@Transactional
	public void deleteEvent(long id) {
		Event event = getEventById(id);

		if (event != null) {
			em.remove(event);
		}
	}
	
	@Transactional
	public Event updateEvent(long id, Event newEvent){
		Event event = getEventById(id);
		
		//TODO Define Update Fields
		
		em.merge(event);
		return event;
	}
}
