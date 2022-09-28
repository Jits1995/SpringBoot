package com.springboot.workers.jdbcexample.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.workers.jdbcexample.daos.WrokerDao;
import com.springboot.workers.jdbcexample.models.Worker;

@Service
public class WorkerService {

	@Autowired
	private WrokerDao workerRepository;

	public WorkerService() {
		super();
	}

	public List<Worker> getAllWorkers() throws SQLException {
		return this.workerRepository.getAllWorkers();
	}

	public List<Worker> getWorker(Worker worker) throws SQLException {
		return this.workerRepository.getWorker(worker);
	}

	public Boolean createWorker(Worker worker) throws SQLException {
		return (this.workerRepository.createWorker(worker) > 0) ? true : false;
	}

	public Boolean updateWorker(Worker worker) throws SQLException {
		return (this.workerRepository.updateWorker(worker) > 0) ? true : false;
	}

	public Object deleteWorker(Worker worker) throws SQLException {
		return (this.workerRepository.deleteWorker(worker) > 0) ? true : false;
	}
	
}
