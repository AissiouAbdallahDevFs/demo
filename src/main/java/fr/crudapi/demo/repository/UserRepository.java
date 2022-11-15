package fr.crudapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.crudapi.demo.model.User;

public interface UserRepository extends JpaRepository <User,Long>{
		
}
