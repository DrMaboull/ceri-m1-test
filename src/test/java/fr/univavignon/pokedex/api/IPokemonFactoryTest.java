package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokemonFactoryTest {
	
	@Mock
	public IPokemonFactory PokeFactory;
	
	Pokemon Poke = new Pokemon(0, "Bulbi", 613, 64, 4000, 4, 126, 126, 90, 56);
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(PokeFactory);
		Mockito.when(PokeFactory.createPokemon(0, 0, 0, 0, 0)).thenReturn(Poke);
	}
	
	@Test
	public void createPokemonTest()
	{
		assertEquals(PokeFactory.createPokemon(0, 0, 0, 0, 0).getIndex(), Poke.getIndex());
		assertEquals(PokeFactory.createPokemon(0, 0, 0, 0, 0).getName(), Poke.getName());
		assertEquals(PokeFactory.createPokemon(0, 0, 0, 0, 0).getAttack(), Poke.getAttack());
		assertEquals(PokeFactory.createPokemon(0, 0, 0, 0, 0).getDefense(), Poke.getDefense());
		assertEquals(PokeFactory.createPokemon(0, 0, 0, 0, 0).getStamina(), Poke.getStamina());
	}
}
