package com.hackerrank.github.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="event")
public class Event {

	@Id
    private Long id;
	
    private String type;

    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "id")
    private Actor actor;
    
    @ManyToOne
    @JoinColumn(name = "repo_id", referencedColumnName = "id")
    private Repo repo;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp created_at;
        
	public Event() {
		super();
	}

	public Event(Long id, String type, Actor actor, Repo repo, Timestamp created_at) {
		super();
		this.id = id;
		this.type = type;
		this.actor = actor;
		this.repo = repo;
		this.created_at = created_at;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Repo getRepo() {
		return repo;
	}

	public void setRepo(Repo repo) {
		this.repo = repo;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.created_at = createdAt;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", type=" + type + ", actor=" + actor + ", repo=" + repo + ", createdAt=" + created_at
				+ "]";
	}
}