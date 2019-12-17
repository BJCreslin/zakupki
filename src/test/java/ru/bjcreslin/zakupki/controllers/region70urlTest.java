package ru.bjcreslin.zakupki.controllers;

import org.junit.jupiter.api.Test;
import ru.bjcreslin.zakupki.services.Region70UrlService;

import java.io.IOException;

class region70urlTest {
    private String urlTestRegion701 = "https://region70.rts-tender.ru/Trade/ViewTrade?id=1295698";

    private Region70UrlService region70UrlService;


    /*
    Визуальный тест
     */
    @Test
    void testGetPurchaseFromRegion70() {
        region70UrlService = new Region70UrlService();
        try {
            System.out.println(region70UrlService.getPurchaseFromRegion70(urlTestRegion701));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}