package xpadro.spring.rmi.repository;

import xpadro.spring.rmi.model.Employee;

public interface EmployeeRepository {
	public Employee getEmployee(int id);
}
