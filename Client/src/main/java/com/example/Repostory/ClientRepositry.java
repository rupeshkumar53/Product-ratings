package com.example.Repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Client;

@Repository
public interface ClientRepositry extends JpaRepository<Client, Integer> {

	List<Client> findByUserNameContaining(String name);
	Client findByUserName(String name);

}
