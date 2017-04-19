package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokedexTest {
	
	@Mock
	public IPokedex pokedex;
	
	Pokemon bulbizarre = new Pokemon(0, "Bulbi", 613, 64, 4000, 4, 126, 126, 90, 56);
	ArrayList<Pokemon> al = new ArrayList() {{ add(bulbizarre); }};

	@Before
	public void setUp() throws PokedexException
	{
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokedex.size()).thenReturn(1);
		Mockito.when(pokedex.addPokemon(bulbizarre)).thenReturn(1);
		Mockito.when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
		Mockito.when(pokedex.getPokemons()).thenReturn();
	}
	
	@Test
	public void sizeTest()
	{
		assertEquals(pokedex.size(), 1);
	}
	
	@Test
	public void addPokemonTest()
	{
		assertEquals(pokedex.addPokemon(bulbizarre), 1);
	}
	
	@Test
	public void getPokemonTest() throws PokedexException
	{
		assertEquals(pokedex.getPokemon(0), bulbizarre);
	}
	
	@Test
	public void getPokemonsTest()
	{
		assertEquals(pokedex.getPokemons(), al);
	}
	
	
}
