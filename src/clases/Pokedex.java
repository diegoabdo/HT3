/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author dennys
 */
public class Pokedex {
    private static final String POKEMON_API_URL = "https://pokeapi.co/api/v2/pokemon/";
    private String nombrePokemon;
    
    public Pokedex(){
    }

    public Pokemon buscarPokemon(String pokeABuscar) throws IOException, InterruptedException{
            System.out.println("Conectando a la API...");
            // Código para conectarse a la API y descargar los datos.
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                        .GET()
                        .header("Accept", "application/json")
                        .uri(URI.create(POKEMON_API_URL+pokeABuscar))
                        .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("¡Conexión exitosa! Descargando datos...");
            ObjectMapper mapper = new ObjectMapper();
            // Obtener los datos del pokémon en el objeto correspondiente
            return mapper.readValue(response.body(), Pokemon.class);

        }
 
}
