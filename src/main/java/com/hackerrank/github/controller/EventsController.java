package com.hackerrank.github.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.services.DataService;

@RestController
@RequestMapping(value = "/events")
public class EventsController {
		
	@Autowired
	private DataService dataService;

	@PostMapping(value = "")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String>  addEvent(RequestEntity<Event> event) {
		
		boolean status = dataService.addEvent(event.getBody());

		if (status) {
			return new ResponseEntity<String>("Added", new HttpHeaders(), HttpStatus.CREATED);
		}		

		return new ResponseEntity<String>("Already exists", new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Event> getEvent(@PathVariable("id") final long id) {

		Event event = dataService.getEventById(id);

		if (event == null) {
			return new ResponseEntity<Event>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}	

		return new ResponseEntity<Event>(event, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Event>> getAllEvents() {

		List<Event> eventList = dataService.getAllEvents();

		if (eventList == null) {
			return new ResponseEntity<List<Event>>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}	

		return new ResponseEntity<List<Event>>(eventList, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/repos/{repoId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Event>> getAllEventsByRepoId(@PathVariable("repoId") final long repoId) {

		List<Event> eventList = dataService.getAllEventsByRepoId(repoId);

		if (eventList == null || eventList.isEmpty()) {
			return new ResponseEntity<List<Event>>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Event>>(eventList, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/actors/{actorId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Event>> getAllEventsByActorId(@PathVariable("actorId") final Long actorId) {

		List<Event> eventList = dataService.getAllEventsByActorId(actorId);

		if (eventList == null || eventList.isEmpty()) {
			return new ResponseEntity<List<Event>>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}	

		return new ResponseEntity<List<Event>>(eventList, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/repos/{repoId}/actors/{actorId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Event>> getAllEventsByRepoAndActorId(@PathVariable("repoId") final Long repoId,
			@PathVariable("actorId") final Long actorId) {

		List<Event> eventList = dataService.getAllEventsByRepoAndActorId(repoId, actorId);

		if (eventList == null || eventList.isEmpty()) {
			return new ResponseEntity<List<Event>>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}	

		return new ResponseEntity<List<Event>>(eventList, new HttpHeaders(), HttpStatus.OK);
	}

}