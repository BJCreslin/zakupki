package ru.bjcreslin.zakupki.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bjcreslin.zakupki.DTO.PurchaseRegion70;
import ru.bjcreslin.zakupki.classes.DataJSONFromServer;
import ru.bjcreslin.zakupki.classes.sites.AbstractSite;
import ru.bjcreslin.zakupki.classes.sites.Region70OptionsRequest;
import ru.bjcreslin.zakupki.classes.sites.Region70Site;
import ru.bjcreslin.zakupki.repositories.PurchaseRegion70Repo;
import ru.bjcreslin.zakupki.services.Purchaseregion70ToDBaseService;
import ru.bjcreslin.zakupki.services.Region70UrlService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


@Log
@Controller
public class InputURLWebController {
    final
    Region70UrlService region70UrlService;
    final
    PurchaseRegion70Repo purchaseRegion70repo;
    final
    Purchaseregion70ToDBaseService purchaseregion70ToDBaseService;
    //Сайт с данными
    AbstractSite siteWithDate;


    public InputURLWebController(Region70UrlService region70UrlService, PurchaseRegion70Repo purchaseRegion70repo, Purchaseregion70ToDBaseService purchaseregion70ToDBaseService) {
        this.region70UrlService = region70UrlService;
        this.purchaseRegion70repo = purchaseRegion70repo;
        this.purchaseregion70ToDBaseService = purchaseregion70ToDBaseService;
    }

    @GetMapping("")
    String indexPage() {

        return "index";
    }

    @PostMapping("/addurl")
    String addURL(@RequestParam(name = "url", required = false, defaultValue = "")
                          String nameURL, Model model) {
        log.info(nameURL);
        if (nameURL.startsWith("https://region70.rts-tender.ru/")) {
            try {
                PurchaseRegion70 purchaseRegion70 = region70UrlService.getPurchaseFromRegion70(nameURL);
                log.info(purchaseRegion70.toString());
                purchaseregion70ToDBaseService.save(purchaseRegion70);

            } catch (IOException e) {
                log.severe("Невозможно распознать " + nameURL);
            }
        }
        return "index";
    }

    @GetMapping("/testerone")
    String testerone() {
        //Пока один сайт выставляем его жёстко
        siteWithDate = new Region70Site();
        HttpClient httpClient = siteWithDate.getHttpClient();
        HttpPost httpPost = siteWithDate.getHttpPost();
        logRequest(httpPost);

        try {
            getOptions();
            doResponse(httpClient, httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }


    /**
     * выполнение Options запроса
     */
    private void getOptions() {
        Region70OptionsRequest region70OptionsRequest = new Region70OptionsRequest();
        try {
            HttpResponse response = region70OptionsRequest.getHttpClient().execute(region70OptionsRequest.getHttpOptions());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Выполнение запроса
     *
     * @param httpClient httpClient
     * @param httpPost   httpPost
     * @return Объект класса  DataJSONFromServer
     * @throws IOException ---
     */
    private DataJSONFromServer doResponse(HttpClient httpClient, HttpPost httpPost) throws IOException {
        HttpResponse response = httpClient.execute(httpPost);
        String textFromResponse = EntityUtils.toString(response.getEntity());
        ObjectMapper objectMapper = new ObjectMapper();
        DataJSONFromServer dataJSONFromServer = objectMapper.readValue(textFromResponse, DataJSONFromServer.class);
        logAnswer(response, dataJSONFromServer);
        return dataJSONFromServer;
    }

    /**
     * Логирование запроса
     *
     * @param response           HttpResponse
     * @param dataJSONFromServer DataJSONFromServer
     */
    private void logAnswer(HttpResponse response, DataJSONFromServer dataJSONFromServer) {
        log.info("Всего данных на сервере: " + dataJSONFromServer.totalrecords + ", всего на " + dataJSONFromServer.totalpages + " страниц.");
        for (int i = 0; i < dataJSONFromServer.invdata.size(); i++) {
            log.info("Answer Purchase " + dataJSONFromServer.invdata.get(i).toString());
        }
        for (Header header : response.getAllHeaders()) {
            log.info("Answer Header " + header.getName() + ": " + header.getValue());
        }
    }

    /**
     * Логирование ответа
     *
     * @param httpPost httpPost
     */
    private void logRequest(HttpPost httpPost) {
        for (Header header : httpPost.getAllHeaders()) {
            log.info("Request Header: " + header.getName() + ": " + header.getValue());
        }
        try {
            log.info("Request Entity: " + EntityUtils.toString(httpPost.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
