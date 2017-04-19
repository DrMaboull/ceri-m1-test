package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokemonMetadataProviderTest {
	
	@Mock
	public IPokemonMetadataProvider PokeMetaData;
	
	private PokemonMetadata M1 = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
	private PokemonMetadata M2 = new PokemonMetadata(133, "Aquali", 186, 168, 260);
	
	@Before
	public void setUp() throws PokedexException
	{
		MockitoAnnotations.initMocks(PokeMetaData);
		Mockito.when(PokeMetaData.getPokemonMetadata(-1)).thenThrow(new PokedexException("Error"));
		Mockito.when(PokeMetaData.getPokemonMetadata(0)).thenReturn(M1);
		Mockito.when(PokeMetaData.getPokemonMetadata(133)).thenReturn(M2);
	}
	
	@Test
	public void getPokemonMetadataTest() throws PokedexException
	{
		assertEquals(PokeMetaData.getPokemonMetadata(0).getIndex(), M1.getIndex());
		assertEquals(PokeMetaData.getPokemonMetadata(0).getName(), M1.getName());
		assertEquals(PokeMetaData.getPokemonMetadata(0).getAttack(), M1.getAttack());
		assertEquals(PokeMetaData.getPokemonMetadata(0).getDefense(), M1.getDefense());
		assertEquals(PokeMetaData.getPokemonMetadata(0).getStamina(), M1.getStamina());
		
		assertEquals(PokeMetaData.getPokemonMetadata(1).getIndex(), M2.getIndex());
		assertEquals(PokeMetaData.getPokemonMetadata(1).getName(), M2.getName());
		assertEquals(PokeMetaData.getPokemonMetadata(1).getAttack(), M2.getAttack());
		assertEquals(PokeMetaData.getPokemonMetadata(1).getDefense(), M2.getDefense());
		assertEquals(PokeMetaData.getPokemonMetadata(1).getStamina(), M2.getStamina());
	}

}
