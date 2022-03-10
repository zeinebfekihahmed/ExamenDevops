package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Contrat;
import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Poste;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.FormateurRepository;

@SpringBootTest
public class FormateurServiceTest {
	
	private static final Logger logger = LogManager.getLogger(FormateurServiceTest.class);
	
	@Autowired
	FormateurRepository formateurRepository ;
	@Test
	public void testAddFormateur() {
		long start = System.currentTimeMillis();
		logger.info("start test");
		Formateur formateur = new Formateur();
		formateur.setAdmin(true);
		formateur.setContrat(Contrat.CDI);
		formateur.setEmail("ahmedzeineb.benfekih@esprit.tn");
		formateur.setNom("Ben Fekih Ahmed");
		formateur.setPassword("password");
		formateur.setPoste(Poste.Ingénieur);
		formateur.setPrenom("Zeineb");
		
		Long dataBeforeTest = formateurRepository.count();
		formateurRepository.save(formateur);
		Long dataAfterTest = formateurRepository.count();
		assertThat(dataBeforeTest).isEqualTo(dataAfterTest -1);
		Formateur formateurExpected = formateurRepository.findOne(formateur
		assertThat(formateur.getAdmin()).isEqualTo(true); 
		//formateurRepository.delete(formateur);
		Long time = System.currentTimeMillis() - start;
		logger.info(formateur);
		logger.info("final test");
		logger.info("Method execution time: " + time + " milliseconds.");


		
		
	}
	
	@Test
	public void modifierFormateur() {
		Formateur formateur =formateurRepository.findById(9L).get();
		formateur.setEmail("zeineb.benfekihahmed@esprit.tn");
		formateurRepository.save(formateur);	
	}
	//@Test
	//public void supprimerFormateur() {
	//	formateurRepository.deleteById(38L);;
		
	//}
	@Test
	public void TrouverFormateur() {
		Formateur formateur =formateurRepository.findById(15L).get();
		System.out.println(formateur.getId());
	}
	
	@Test
public void TesterlistFormateurs() {
		List<Formateur> listFormateurs=formateurRepository.findAll();	
	for (Formateur formateur : listFormateurs)
	{System.out.println(formateur.getId());}
	
	}
	@Test
	public long countFormateurs() {
		return formateurRepository.count();
		 
	 }
	
}
