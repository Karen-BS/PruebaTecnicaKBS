package com.example.pruebatecnicakbs.service;

import com.example.pruebatecnicakbs.model.Consulta;
import com.example.pruebatecnicakbs.repository.ConsultaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PokemonServiceTest {
    @Mock
    private ConsultaRepository consultaRepository;

    @InjectMocks
    private PokemonService pokemonService;

    @Spy
    private RestTemplate restTemplate = new RestTemplate();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // inicializa los mocks
    }

    @Test
    void testObtenerListadoPokemon() {
        String respuestaMock = "{\"results\": [{\"name\": \"pikachu\"}]}";
        String urlEsperada = "https://pokeapi.co/api/v2/pokemon?limit=10&offset=0";

        RestTemplate mockRestTemplate = mock(RestTemplate.class);
        ConsultaRepository mockRepository = mock(ConsultaRepository.class);

        when(mockRestTemplate.getForObject(urlEsperada, String.class)).thenReturn(respuestaMock);

        PokemonService servicio = new PokemonService(mockRestTemplate, mockRepository);

        String resultado = servicio.obtenerListadoPokemon(10, 0);

        assertNotNull(resultado);
        assertTrue(resultado.contains("pikachu"));
        verify(mockRepository, times(1)).save(any(Consulta.class));
    }

    @Test
    void testObtenerDetallePokemon() {
        // Simular la respuesta esperada
        String respuestaMock = "{\"name\": \"bulbasaur\"}";
        String urlEsperada = "https://pokeapi.co/api/v2/pokemon/bulbasaur";

        // Mocks
        RestTemplate restTemplate = mock(RestTemplate.class);
        ConsultaRepository consultaRepository = mock(ConsultaRepository.class);

        when(restTemplate.getForObject(urlEsperada, String.class)).thenReturn(respuestaMock);

        // Inyectar mocks en el servicio real
        PokemonService servicio = new PokemonService(restTemplate, consultaRepository);

        // Ejecutar
        String resultado = servicio.obtenerDetallePokemon("bulbasaur");

        // Verificar resultado y que se guardó la consulta
        assertEquals(respuestaMock, resultado);
        verify(consultaRepository, times(1)).save(any(Consulta.class));
    }
}
