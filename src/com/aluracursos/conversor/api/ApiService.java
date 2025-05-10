package com.aluracursos.conversor.api;

import com.aluracursos.conversor.Config;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
    public String getDataCurrency (String base, String target) {
        String apikey = Config.getApiKey();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/" + apikey + "/pair/" + base + "/" + target))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("An error ocurred");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
