//package com.bae.springboot.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.bae.springboot.entities.Movies;
//import com.bae.springboot.repo.MoviesRepo;
//
//@SpringBootTest
//public class MoviesServicesUnitTest {
//	@Autowired
//	private MoviesServices service; 
//	
//	@MockBean
//	private MoviesRepo repo;
//	
//	@Test
//	public void createTest() {
//		// creating an object for saving
//		Movies input = new Movies( 2L, "The Lion King", "Animation", 1994, 8.5f );
//	
//		// creating an object for the result
//		Movies result = new Movies(2L,"The Lion King", "Animation", 1994, 8.5f);
//		
//		Mockito.when(repo.saveAndFlush(input)).thenReturn(result);
//		
//		//assertEquals(expected, actual)
//		assertEquals(result,service.create(input));
//	
//	}
//	@Test
//	public void getAllTest() {
//		//creating an object for saving
//		List<Movies> result = new ArrayList<>();
//		result.add(new Movies(1L, "The Lion King", "Animation", 1994, 8.5f));
//		
//		Mockito.when(repo.findAll()).thenReturn(result);
//		assertEquals(result, service.getALL());
//		
//	}
//	
//	@Test 
//	public void getByIdTest() {
//		Optional<Movies> OptionalOutput = Optional.of(new Movies(1L, "The Lion King", "Animation",1994, 8.5f));
//		Movies output = new Movies(1L, "The Lion King", "Animation",1994, 8.5f);
//		
//		Mockito.when(repo.findById(1L)).thenReturn(OptionalOutput);
//		
//		assertEquals(output, service.getByID(1L));
//	}
//	@Test
//	public void getByIdFailTest() {
//		Optional<Movies> OptionalOutput = Optional.empty();
//		
//		Mockito.when(repo.findById(1L)).thenReturn(OptionalOutput);
//		
//		assertThrows(MoviesNotFoundException.class, () -> service.getByID(1L));
//		
//	}
//	@Test
//	public void updateTest() {
//		Movies input = new Movies(1L,"Spiderman: No Way Home", "Action", 2021,8.3f);
//		Optional<Movies> existing = Optional.of(new Movies(1L, "The Lion King", "Animation",1994, 8.5f));
//		Movies output = new Movies(1L,"Spiderman: No Way Home", "Action", 2021,8.3f);
//		
//		Mockito.when(this.repo.findById(1L)).thenReturn(existing);
//		Mockito.when(this.repo.saveAndFlush(output)).thenReturn(output);
//		
//		assertEquals(output, this.service.update(1L, input));
//
//	}
//	
//	@Test
//	public void deleteTrueTest() {
//		Mockito.when(this.repo.existsById(1L)).thenReturn(false);
//		
//		assertTrue(this.service.delete(1L));
//	}
//	
//	@Test
//	public void deleteFalseTest() {
//		Mockito.when(this.repo.existsById(1L)).thenReturn(true);
//		
//		assertFalse(this.service.delete(1L));
//	}
//}
