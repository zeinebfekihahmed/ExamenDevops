package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.CoursRepository;


@SpringBootTest
public class CoursServiceTest {

	@Autowired
	CoursRepository coursRepository ;
	
	@Test
	public void testAddCours() {
		Cours cours = new Cours();
		cours.setDescription("Maîtrisez Javascript grâce au cours le plus complet sur internet ! Projets, exercices, quiz, ES8 et bien d’autres !");
		cours.setIntitule("JavaScript : la formation ULTIME");
		cours.setTypeCours(TypeCours.Informatique);
		Long dataBeforeTest = coursRepository.count();
		coursRepository.save(cours);
		Long dataAfterTest = coursRepository.count();
		assertThat(dataBeforeTest).isEqualTo(dataAfterTest -1);
		coursRepository.delete(cours);
		
	}
}
