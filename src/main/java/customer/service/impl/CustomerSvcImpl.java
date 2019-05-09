package customer.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import customer.dao.CustomerDao;
import customer.dto.CustomerDto;
import customer.entity.Customer;
import customer.entity.CustomerPK;
import customer.service.CustomerSvc;



@Service("customerSvc")
@Transactional
public class CustomerSvcImpl implements CustomerSvc{
	
	@Autowired
	CustomerDao customerDao;
	
	//@Autowired
	//CustomerSvc customerSvc;
	
	@Override
	public List<CustomerDto> findAll() {
		List<CustomerDto> customerDtos = new ArrayList<>();
		List<Customer> customer = customerDao.findAll();
		
		for(Customer data: customer) {
			CustomerDto customerDto = new CustomerDto();
			
			customerDto.setId(data.getId());
			customerDto.setName(data.getName());
			customerDto.setAddress(data.getAddress());
			customerDto.setGender(data.getGender());
			customerDto.setNoHp(data.getNoHp());
			customerDto.setStatus(data.getStatus());
			
			customerDtos.add(customerDto);
		}
		
		return customerDtos;
	}

	@Override
	public CustomerDto findOne(int id) {		
		CustomerDto customerDto = new CustomerDto();
		CustomerPK pk = new CustomerPK();
		pk.setId(id);
		Customer customer = customerDao.getOne(pk);
		
		if(customer != null) {
			customerDto.setId(customer.getId());
			customerDto.setName(customer.getName());
			customerDto.setAddress(customer.getAddress());
			customerDto.setGender(customer.getGender());
			customerDto.setNoHp(customer.getNoHp());
			customerDto.setStatus(customer.getStatus());
		}
		return customerDto;
	}

	@Override
	public void save(CustomerDto customerDto) {
		Customer customer = new Customer();
		
		customer.setId(customerDto.getId());
		customer.setName(customerDto.getName());
		customer.setAddress(customerDto.getAddress());
		customer.setGender(customerDto.getGender());
		customer.setNoHp(customerDto.getNoHp());
		customer.setStatus(customerDto.getStatus());
		
	}

	@Override
	public String deleteCustomer(Integer id) {
		String resultDelete = "";
		try {
			int status= 0;
			resultDelete = String.valueOf(customerDao.deleteCustomer(id, status));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Delete Customer : " + e.getMessage());
		}
		
		return resultDelete;
	}

	@Override
	public void update(CustomerDto customerDto, Integer id) {
		Customer customer = new Customer();
		
		customer.setId(id);
		customer.setName(customerDto.getName());
		customer.setAddress(customerDto.getAddress());
		customer.setGender(customerDto.getGender());
		customer.setNoHp(customerDto.getNoHp());
		customer.setStatus(customerDto.getStatus());
		
	}

	

}
