package com.springboot.workers.jdbcexample.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.workers.jdbcexample.daos.WrokerDao;
import com.springboot.workers.jdbcexample.models.Worker;
import com.springboot.workers.jdbcexample.utils.DatabaseConnection;

@Repository
public class WorkerRepository implements WrokerDao {
	private final Connection connection;

	@Autowired
	public WorkerRepository(DatabaseConnection connection) {
		super();
		this.connection = connection.getConnection();
	}

	@Override
	public List<Worker> getWorker(Worker worker) throws SQLException {

		List<Worker> workerList = new ArrayList<>();
		String getWorkerFormat = "SELECT * FROM WORKER WHERE WORKER_ID = ?";

		PreparedStatement stmt = connection.prepareStatement(getWorkerFormat);
		stmt.setInt(1, worker.getWorkerID());

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Worker workerDetail = new Worker();

			workerDetail.setWorkerID(rs.getInt("WORKER_ID"));
			workerDetail.setFirstName(rs.getString("FIRST_NAME"));
			workerDetail.setLastName(rs.getString("LAST_NAME"));
			workerDetail.setSalary(rs.getInt("SALARY"));
			workerDetail.setJoiningDate(rs.getTimestamp("JOINING_DATE"));
			workerDetail.setDepartment(rs.getString("DEPARTMENT"));

			workerList.add(workerDetail);
		}

		return workerList;
	}

	@Override
	public List<Worker> getAllWorkers() throws SQLException {

		List<Worker> workerDetails = new ArrayList<>();
		String getWorkerFormat = "SELECT * FROM WORKER";

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(getWorkerFormat);

		while (rs.next()) {

			Worker worker = new Worker();

			worker.setWorkerID(rs.getInt("WORKER_ID"));
			worker.setFirstName(rs.getString("FIRST_NAME"));
			worker.setLastName(rs.getString("LAST_NAME"));
			worker.setSalary(rs.getInt("SALARY"));
			worker.setJoiningDate(rs.getTimestamp("JOINING_DATE"));
			worker.setDepartment(rs.getString("DEPARTMENT"));

			workerDetails.add(worker);
		}

		return workerDetails;

	}

	@Override
	public Integer createWorker(Worker worker) throws SQLException {
		String createWorkerFormat = "INSERT INTO Worker (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES(?,?,?,?,?,?)";

		PreparedStatement stmt = connection.prepareStatement(createWorkerFormat);
		stmt.setInt(1, worker.getWorkerID());
		stmt.setString(2, worker.getFirstName());
		stmt.setString(3, worker.getLastName());
		stmt.setInt(4, worker.getSalary());
		stmt.setTimestamp(5, worker.getJoiningDate());
		stmt.setString(6, worker.getDepartment());

		int result = stmt.executeUpdate();
		return result;
	}

	@Override
	public Integer updateWorker(Worker worker) throws SQLException {
		String updateWorkerFormat = "Update Worker SET SALARY = ? WHERE WORKER_ID = ?";
		
		PreparedStatement stmt = connection.prepareStatement(updateWorkerFormat);
		stmt.setInt(1, worker.getSalary());
		stmt.setInt(2, worker.getWorkerID());
		
		int result = stmt.executeUpdate();
		return result;
	}

	@Override
	public Integer deleteWorker(Worker worker) throws SQLException {
		String deleteWorkerFormat = "DELETE FROM Worker WHERE WORKER_ID = ?";
		
		PreparedStatement stmt = connection.prepareStatement(deleteWorkerFormat);
		stmt.setInt(1, worker.getWorkerID());
		
		int result = stmt.executeUpdate();
		return result;
	}

}
