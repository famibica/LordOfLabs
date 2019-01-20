package com.sap.lord.of.labs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sap.lord.of.labs.dao.EventDAO;
import com.sap.lord.of.labs.model.Event;

@Controller
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventDAO eventDao;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Event findById(@PathVariable long id) {
		return eventDao.getEventById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Event create(@RequestBody Event event) {
		return eventDao.createEvent(event);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		eventDao.deleteEvent(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Event setOccupied(@PathVariable long id, @RequestBody Event event) {
		return eventDao.updateEvent(id, event);
	}

}
