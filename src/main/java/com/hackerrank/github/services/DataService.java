package com.hackerrank.github.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.ActorRepository;
import com.hackerrank.github.repository.EventRepository;
import com.hackerrank.github.repository.RepoRepository;

@Service
public class DataService {
	
	@Autowired
	private EventRepository eventRepo;
	
	@Autowired
	private ActorRepository actorRepo;

	@Autowired
	private RepoRepository repoRepo;
	
	public void deleteAllRecords() {
		eventRepo.deleteAll();
		actorRepo.deleteAll();
		repoRepo.deleteAll();
	}
	
	public boolean addEvent(Event event) {
		
		if (eventRepo.existsById(event.getId())) {
			return false;
		}
		
		if (!actorRepo.existsById(event.getActor().getId())) {
			actorRepo.save(event.getActor());
		}
		
		if (!repoRepo.existsById(event.getRepo().getId())) {
			repoRepo.save(event.getRepo());
		}
		
		eventRepo.save(event);
		return true;
	}

	public Event getEventById(long id) {
		return eventRepo.findById(id).orElse(null);
	}

	public List<Event> getAllEventsByRepoId(Long repoId) {		
		return eventRepo.findByRepoId(repoId);
	}
	
	public List<Event> getAllEventsByActorId(Long actorId) {
		return eventRepo.findByActorId(actorId);
	}
	
	public List<Event> getAllEventsByRepoAndActorId(Long repoId, Long actorId) {
		return eventRepo.findByRepoIdAndActorId(repoId, actorId);
	}

	public List<Event> getAllEvents() {
		return eventRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

}
