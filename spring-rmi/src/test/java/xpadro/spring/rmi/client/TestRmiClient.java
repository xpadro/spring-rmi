package xpadro.spring.rmi.client;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xpadro.spring.rmi.model.Employee;
import xpadro.spring.rmi.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:xpadro/spring/rmi/test/config/client-config.xml"})
public class TestRmiClient {
	@Autowired
	private EmployeeService service;

	@Test
	public void retrieveExistingEmployee() {
		Employee employee = service.retrieveEmployee(1);
		Assert.assertNotNull(employee);
		Assert.assertEquals(1, employee.getId());
		Assert.assertEquals("Mark Knopfler", employee.getName());
	}
	
	@Test
	public void retrieveNonexistingEmployee() {
		try {
			service.retrieveEmployee(9);
			Assert.fail("Employe doesn't exist. Should throw an exception");
		} catch (EmptyResultDataAccessException e) {
			
		}
	}
}
