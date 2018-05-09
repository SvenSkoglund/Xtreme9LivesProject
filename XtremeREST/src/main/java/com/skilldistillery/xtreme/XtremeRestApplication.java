package com.skilldistillery.xtreme;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XtremeRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(XtremeRestApplication.class, args);
	}
}
