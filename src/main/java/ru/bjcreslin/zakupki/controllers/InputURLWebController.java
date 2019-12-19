package ru.bjcreslin.zakupki.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.java.Log;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import ru.bjcreslin.zakupki.DTO.PurchaseRegion70;
import ru.bjcreslin.zakupki.DTO.RequestRegion70;
import ru.bjcreslin.zakupki.classes.Region70Site;
import ru.bjcreslin.zakupki.repositories.PurchaseRegion70Repo;
import ru.bjcreslin.zakupki.services.Purchaseregion70ToDBaseService;
import ru.bjcreslin.zakupki.services.Region70UrlService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Log
@Controller
public class InputURLWebController {
    final
    Region70UrlService region70UrlService;
    final
    PurchaseRegion70Repo purchaseRegion70repo;
    final
    Purchaseregion70ToDBaseService purchaseregion70ToDBaseService;

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
    String testerOne(Model model) {
//
        String requ = "";
        RequestRegion70 requestRegion70 = new RequestRegion70();
        final RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        //HttpEntity<RequestRegion70> httpEntity = new HttpEntity<>(requestRegion70, headers);
//        requ = restTemplate.postForObject(Region70Site.getRequestUrl(), httpEntity, String.class);
//        log.info(requ);

//       Host: zmo-new-webapi.rts-tender.ru
//        User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:71.0) Gecko/20100101 Firefox/71.0
//        Accept: */*
//Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3
//Accept-Encoding: gzip, deflate, br
//Content-Type: application/json; charset=utf-8
//XXX-TenantId-Header: 126
//Content-Length: 524
//Origin: https://region70.rts-tender.ru
//DNT: 1
//Connection: keep-alive
//Referer: https://region70.rts-tender.ru/
//        log.info("Адрес сайта:" + Region70Site.getRequestUrl());
//        HttpPost httpPost = new HttpPost(Region70Site.getRequestUrl());
//        try {
//            HttpEntity httpEntity = new StringEntity("{\"page\":2,\"itemsPerPage\":10,\"tradeState\":\"\",\"OnlyTradesWithMyApplications\":false,\"filterPriceMin\":\"\",\"filterPriceMax\":\"\",\"filterDateFrom\":null,\"filterDateTo\":null,\"filterFillingApplicationEndDateFrom\":null,\"FilterFillingApplicationEndDateTo\":null,\"filterTradeEasuzNumber\":\"\",\"showOnlyOwnTrades\":true,\"IsImmediate\":false,\"UsedClassificatorType\":5,\"classificatorCodes\":[],\"CustomerFullNameOrInn\":\"\",\"CustomerAddress\":\"\",\"ParticipantHasApplicationsOnTrade\":\"\",\"UseCustomerInn\":false,\"UseCustomerName\":true,\"TradeSearchType\":50}");
//                    //requestRegion70.getNewJson(1));
//            httpPost.setEntity(httpEntity);
//            httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:71.0) Gecko/20100101 Firefox/71.0");
//            httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
//            httpPost.setHeader("Host", "zmo-new-webapi.rts-tender.ru");
//            httpPost.setHeader("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3");
//            httpPost.setHeader("Accept-Encoding", "gzip, deflate, br");
//            httpPost.setHeader("XXX-TenantId-Header", "126");
//            httpPost.setHeader("Content-Length", "524");
//            httpPost.setHeader("Origin", "https://region70.rts-tender.ru");
//            httpPost.setHeader("DNT", "1");
//            httpPost.setHeader("Accept", "*/*");
//            httpPost.setHeader("Connection", "keep-alive");
//            httpPost.setHeader("Referer", "https://region70.rts-tender.ru/");
//
//
//            try (CloseableHttpClient httpClient = HttpClients.createDefault();
//                 CloseableHttpResponse response = httpClient.execute(httpPost)) {
//
//                System.out.println(EntityUtils.toString(response.getEntity()));
//            } catch (ClientProtocolException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }


        try {
            log.info("Адрес сайта:" + Region70Site.getRequestUrl());
            Content postResult = Request.Post("Region70Site.getRequestUrl()")
//
//                    .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:71.0) Gecko/20100101 Firefox/71.0")
//                    .addHeader("Content-Type", "application/json; charset=utf-8")
//                    .addHeader("Host", "zmo-new-webapi.rts-tender.ru")
//                    .addHeader("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
//                    .addHeader("Accept-Encoding", "gzip, deflate, br")
//                    .addHeader("XXX-TenantId-Header", "126")
//                    .addHeader("Content-Length", "524")
//                    .addHeader("Origin", "https://region70.rts-tender.ru")
//                    .addHeader("DNT", "1")
//                    .addHeader("Accept", "*/*")
//                    .addHeader("Connection", "keep-alive")
//                    .addHeader("Referer", "https://region70.rts-tender.ru/")
//                    .bodyString("", ContentType.APPLICATION_JSON)
                    .execute().
                            returnContent();
            System.out.println(postResult.asString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "index";


    }
}
