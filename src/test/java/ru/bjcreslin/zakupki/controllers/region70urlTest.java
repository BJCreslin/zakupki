package ru.bjcreslin.zakupki.controllers;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class region70urlTest {
    private String urlTestRegion701 = "https://region70.rts-tender.ru/Trade/ViewTrade?id=1295698";

    private Region70UrlController region70UrlController;


    /*
    Визуальный тест
     */
    @Test
    void testGetPurchaseFromRegion70() {
        region70UrlController = new Region70UrlController();
        try {
            System.out.println(region70UrlController.getPurchaseFromRegion70(urlTestRegion701));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}