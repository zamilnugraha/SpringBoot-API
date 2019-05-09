package customer.service;

import java.util.List;

import customer.dto.CustomerDto;



public interface CustomerSvc {

	public List<CustomerDto> findAll();
	public CustomerDto findOne(int id);
	public void save(CustomerDto customerDto);
	public String deleteCustomer(Integer id);
	public void update(CustomerDto customerDto, Integer id);
}
