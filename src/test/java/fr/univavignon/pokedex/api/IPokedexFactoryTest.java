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
	
	
	@Before
	public void setUp() throws PokedexException
	{
		MockitoAnnotations.initMocks(this);
		Mockito.when(PokedexFactory.createPokedex(provider, factory)).thenReturn(Poke);
	}
	
	@Test
	public void createPokedexTest() throws PokedexException
	{
		assertEquals(PokedexFactory.createPokedex(provider, factory), Poke);
	}
}
