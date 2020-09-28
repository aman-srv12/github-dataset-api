package com.hackerrank.github.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackerrank.github.model.Actor;

public interface ActorRepository 
extends JpaRepository<Actor, Long> {

}
