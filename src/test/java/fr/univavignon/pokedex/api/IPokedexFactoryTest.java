package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokedexFactoryTest {
	
	@Mock
	public IPokedexFactory PokedexFactory;
	
	private IPokemonMetadataProvider provider;
	private IPokemonFactory factory;
	private IPokedex Poke;
	private Pokemon bulbizarre = new Pokemon(0, "Bulbi", 613, 64, 4000, 4, 126, 126, 90, 56);
	private ArrayList<Pokemon> test = new ArrayList() {{ add(bulbizarre); }};
	
	
	@Before
	public void setUp() throws PokedexException
	{
		MockitoAnnotations.initMocks(this);
		Mockito.when(PokedexFactory.createPokedex(provider, factory)).thenReturn(Poke);
		//Mockito.when(PokedexFactory.createPokedex(provider, factory).getPokemon(0)).thenReturn(bulbizarre);
		Mockito.when(PokedexFactory.createPokedex(provider, factory).getPokemons()).thenReturn(test);
		Mockito.when(PokedexFactory.createPokedex(provider, factory).size()).thenReturn(1);
		Mockito.when(PokedexFactory.createPokedex(provider, factory).addPokemon(bulbizarre)).thenReturn(2);
	}
	
	@Test
	public void createPokedexTest() throws PokedexException
	{
		assertEquals(PokedexFactory.createPokedex(provider, factory).getPokemons(), Poke.getPokemons());
		
			/*try {
				assertEquals(PokedexFactory.createPokedex(provider, factory).getPokemon(0), Poke.getPokemon(0));
			} catch (PokedexException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		assertEquals(PokedexFactory.createPokedex(provider, factory).size(), Poke.size());
		assertEquals(PokedexFactory.createPokedex(provider,factory).addPokemon(bulbizarre), Poke.addPokemon(bulbizarre));
	}
}
