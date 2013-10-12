package xpadro.spring.rmi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xpadro.spring.rmi.model.Employee;
import xpadro.spring.rmi.repository.EmployeeRepository;

@Service("defaultEmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee retrieveEmployee(int id) {
		return employeeRepository.getEmployee(id);
	}

}
