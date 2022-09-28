package com.springboot.workers.jdbcexample.daos;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.jdbcexample.models.Worker;

public interface WrokerDao {
	
	//Get Operation
	List<Worker> getWorker(Worker worker) throws SQLException;
	
	//Get All Operation
	List<Worker> getAllWorkers() throws SQLException;
	
	//Create operation
	Integer createWorker(Worker worker) throws SQLException;
	
	//Update Operation
	Integer updateWorker(Worker worker) throws SQLException;
	
	//Delete Operation
	Integer deleteWorker(Worker worker) throws SQLException;
	
}
