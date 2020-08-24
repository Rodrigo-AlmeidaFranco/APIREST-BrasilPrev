package com.register.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.apirest.models.Register;

public interface RegisterRepository extends JpaRepository<Register, Long>{
	Register findById(long id);

}
