package com.springboot.workers.jdbcexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.jdbcexample.models.Worker;
import com.springboot.workers.jdbcexample.services.WorkerService;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {

	@Autowired
	private WorkerService workerService;

	public WorkerController() {
		super();
	}

	@GetMapping("/")
	public String homeController() {
		return "Hello visitor!\\nVisiting time: ${CURRENT_TIMESTAMP}";
	}

	@GetMapping("/showWorker")
	public ResponseEntity<List<Worker>> getWorker(@RequestBody Worker worker){
		try {
			List<Worker> workerList = this.workerService.getWorker(worker);
			return workerList.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(workerList, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/all/showWorkers")
	public ResponseEntity<List<Worker>> getAllWorkers() {
		try {
			List<Worker> workers = this.workerService.getAllWorkers();
			return workers.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(workers, HttpStatus.OK);
		}catch(Exception e) {
			System.out.println("Error Occured = " + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<String> createWorker(@RequestBody Worker worker) {
		try {
			 return Boolean.TRUE.equals(this.workerService.createWorker(worker)) ? new ResponseEntity<>("Worker added Successfully", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/update")
	public ResponseEntity<String> updateWorker(@RequestBody Worker worker) {
		try {
			return Boolean.TRUE.equals(this.workerService.updateWorker(worker)) ? new ResponseEntity<>("Worker Details updated successfully", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> deleteWorker(@RequestBody Worker worker){
		try {
			return Boolean.TRUE.equals(this.workerService.deleteWorker(worker)) ? new ResponseEntity<>("Worker Deleted Successfully", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
}
