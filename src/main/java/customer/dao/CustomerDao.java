package customer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import customer.entity.Customer;
import customer.entity.CustomerPK;


@Repository
public interface CustomerDao extends JpaRepository<Customer, CustomerPK>{
	
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE TBL_CUSTOMER SET STATUS = ? WHERE ID = ?", nativeQuery= true)
	public Integer deleteCustomer(Integer id, Integer status);
}
