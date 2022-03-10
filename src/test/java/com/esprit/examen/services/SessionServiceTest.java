package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.SessionRepository;

@SpringBootTest
public class SessionServiceTest {
	@Autowired
	SessionRepository sessionRepository ;
	
	@Test
	public void testAddSession() throws ParseException {
		Session session = new Session();
		session.setDateDebut("11/12/2022");
		session.setDateFin("20/12/2022");
		session.setDescription("Session Principale");
		session.setDuree(30L);
		
		Long dataBeforeTest = sessionRepository.count();
		sessionRepository.save(session);
		Long dataAfterTest = sessionRepository.count();
		assertThat(dataBeforeTest).isEqualTo(dataAfterTest -1);
		sessionRepository.delete(session);
		
	}
}
