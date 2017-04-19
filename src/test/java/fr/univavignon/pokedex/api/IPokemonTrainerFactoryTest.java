package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokemonTrainerFactoryTest {
	
	@Mock
	public IPokemonTrainerFactory trainer;
	
	private Team team;
	private IPokedexFactory factory;
	private PokemonTrainer PokeTrainer;
	
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		Mockito.when(trainer.createTrainer("ONE", team, factory)).thenReturn(PokeTrainer);
	}
	
	@Test
	public void createPokedexTest()
	{
		assertEquals(trainer.createTrainer("allez", team, factory), PokeTrainer);
	}
}
