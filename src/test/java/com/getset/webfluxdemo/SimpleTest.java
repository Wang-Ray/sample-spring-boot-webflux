package com.getset.webfluxdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebfluxDemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleTest {
    static Logger logger = LoggerFactory.getLogger(SimpleTest.class);

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testHelloController() {
        webTestClient.get().uri("/hello/hello")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Welcome to reactive world!");
    }

}
