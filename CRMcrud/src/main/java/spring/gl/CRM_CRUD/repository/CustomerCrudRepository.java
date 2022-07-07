package spring.gl.CRM_CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.gl.CRM_CRUD.entity.Customer;

@Repository
public interface CustomerCrudRepository extends JpaRepository<Customer, Long>{

}
