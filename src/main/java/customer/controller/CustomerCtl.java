package customer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import customer.common.RestResponse;
import customer.dto.CustomerDto;
import customer.service.CustomerSvc;



@RestController
public class CustomerCtl {
		
	@Autowired
	CustomerSvc customerSvc;
	
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public RestResponse findAllCustomer(HttpServletRequest request) {
		RestResponse restResponse = new RestResponse();
		
		try {
			List<CustomerDto> customerDtos = customerSvc.findAll();
			
			if(customerDtos.size() > 0) {
				restResponse.setStatus(100);
				restResponse.setMessage("Success");
				restResponse.setDatas(customerDtos);
			}else {
				restResponse.setStatus(10);
				restResponse.setMessage("Data Customer Not Found");
			}
		} catch (Exception e) {
			restResponse.setStatus(0);
			restResponse.setMessage("Process Failed");
			e.printStackTrace();
		}

		return restResponse;
	}
	
}
