package com.hackerrank.github.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.github.services.DataService;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {

	@Autowired
	private DataService resourcesService;

	@DeleteMapping(value = "")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> getBuildDataByType () {
		resourcesService.deleteAllRecords();
		return new ResponseEntity<String>("Erased All Data", new HttpHeaders(), HttpStatus.OK);
	}
}