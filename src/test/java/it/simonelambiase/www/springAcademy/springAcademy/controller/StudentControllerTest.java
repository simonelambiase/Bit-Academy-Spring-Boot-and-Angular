package it.simonelambiase.www.springAcademy.springAcademy.controller;

import lombok.SneakyThrows;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudentControllerTest {
    HttpClient http;

    @BeforeAll
    void initHttpClient() {
        http = HttpClient.newHttpClient();
    }

    @Test
    void findByName() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/student/search?name=Mario"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = http.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(200,response.statusCode());
        assertTrue(response.body() != null);
    }

    @Test
    void findByLastname() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/student/search?lastname=Rossi"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = http.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(200,response.statusCode());
        assertTrue(response.body() != null);
    }

    @Test
    void findById() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/student/search?id=16"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = http.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(200,response.statusCode());
        assertTrue(response.body() != null);
    }
}