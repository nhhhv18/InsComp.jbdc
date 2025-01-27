package model;
import java.util.ArrayList;
import java.util.List;

import dao.jbdc.*;

public class Main {
	public static void main(String[] args) {
		
		CustomerDAO customerDAO = new CustomerDAO();
		ClaimDAO claimDAO = new ClaimDAO();
		PolicyDAO policyDAO = new PolicyDAO();
		
		
		//select by id
		Customer customer = customerDAO.getEntityById(3);
		System.out.println(customer);
	
		Claim claim = claimDAO.getEntityById(3);
		System.out.println(claim);
	
		Policy policy = policyDAO.getEntityById(4);
		System.out.println(policy);
		
		
		//select entities
		List<Customer> listOfCustomers = new ArrayList<>();
		listOfCustomers = customerDAO.getEntities();
		System.out.println(listOfCustomers);
		
		List<Claim> listOfClaims = new ArrayList<>();
		listOfClaims = claimDAO.getEntities();
		System.out.println(listOfClaims);
		 
		List<Policy> listOfPolicies = new ArrayList<>();
		listOfPolicies = policyDAO.getEntities();
		System.out.println(listOfPolicies);
		
		
		 //delete
		customerDAO.delete(17);
		claimDAO.delete(3);
		policyDAO.delete(20);
		
		
		//insert
		Customer customer1 = new Customer ("Monica", "Vladiu", "1990-05-15", "mo.vla@example.com", "+12345678990", "New York", "10-001", "123 6th Avenue");
		customerDAO.insert(customer1);

		Claim claim1 = new Claim (6, "2025-05-16", 15000, 2, "Home erosion");
		claimDAO.insert(claim1);
		
		Policy policy1 = new Policy(3,3,"2025-02-14","2026-02-14", 120000, 400, 2);
		policyDAO.insert(policy1);
		

		 //update
		Customer customer2 = customerDAO.getEntityById(1);
		customer2.setFirstName("Vasya");
		customerDAO.update(1, customer2);

		Claim claim2 = claimDAO.getEntityById(6);
		claim2.setDescription("NNW - cure costs");
		claimDAO.update(6, claim2);
		
		Policy policy2 = policyDAO.getEntityById(16);
	    policy2.setAgentId(4);
		policyDAO.update(17, policy2);
	}
}
