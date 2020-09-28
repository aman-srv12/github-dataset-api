package com.hackerrank.github.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hackerrank.github.model.Event;

public interface EventRepository 
extends JpaRepository<Event, Long> {

@Query("Select e from Event e where e.repo.id=:repoId order by e.id")
public List<Event> findByRepoId(@Param("repoId")Long repoId);

@Query("Select e from Event e where e.actor.id=:actorId order by e.id")
public List<Event> findByActorId(@Param("actorId")Long actorId);

@Query("Select e from Event e where e.repo.id=:repoId and e.actor.id=:actorId order by e.id")
public List<Event> findByRepoIdAndActorId(@Param("repoId")Long repoId, @Param("actorId")Long actorId);

}
