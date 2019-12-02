package ru.bjcreslin.zakupki.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class region70urlTest {
    private String urlTestRegion701 = "https://region70.rts-tender.ru/Trade/ViewTrade?id=1290191";

    private Region70url region70url;

    @Test
    void action() {
        region70url = new Region70url();
        try {
            region70url.action(urlTestRegion701);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}