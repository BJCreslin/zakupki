package ru.bjcreslin.zakupki.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bjcreslin.zakupki.DTO.PurchaseRegion70;
import ru.bjcreslin.zakupki.DTO.RequestRegion70;
import ru.bjcreslin.zakupki.classes.DataJSONFromServer;
import ru.bjcreslin.zakupki.classes.Region70Site;
import ru.bjcreslin.zakupki.repositories.PurchaseRegion70Repo;
import ru.bjcreslin.zakupki.services.Purchaseregion70ToDBaseService;
import ru.bjcreslin.zakupki.services.Region70UrlService;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateException;


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
    String testerone() throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
        SSLContext sslContext = null;
        try {
            sslContext = SSLContexts.custom()
                    .loadKeyMaterial(readStore(), null) // use null as second param if you don't have a separate key password
                    .build();

        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        HttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();
        HttpPost httpPost = new HttpPost(Region70Site.getRequestUrl());
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:71.0) Gecko/20100101 Firefox/71.0");
        httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
        httpPost.setHeader("Host", "zmo-new-webapi.rts-tender.ru");
        httpPost.setHeader("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3");
        httpPost.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpPost.setHeader("XXX-TenantId-Header", "126");
        //   httpPost.setHeader("Content-Length", "524");
        httpPost.setHeader("Origin", "https://region70.rts-tender.ru");
        httpPost.setHeader("DNT", "1");
        httpPost.setHeader("Accept", "*/*");
        httpPost.setHeader("Connection", "keep-alive");
        httpPost.setHeader("Referer", "https://region70.rts-tender.ru/");
//        HttpEntity httpEntity = new StringEntity("{\"page\":1,\"itemsPerPage\":10,\"tradeState\":\"\",\"OnlyTradesWithMyApplications\"" +
//                ":false,\"filterPriceMin\":\"\",\"filterPriceMax\":\"\",\"filterDateFrom\":null,\"filterDateTo\":null," +
//                "\"filterFillingApplicationEndDateFrom\":null,\"FilterFillingApplicationEndDateTo\":null,\"filterTradeEasuzNumber\":\"\"," +
//                "\"showOnlyOwnTrades\":true,\"IsImmediate\":false,\"UsedClassificatorType\":5,\"classificatorCodes\":[]," +
//                "\"CustomerFullNameOrInn\":\"\",\"CustomerAddress\":\"\",\"ParticipantHasApplicationsOnTrade\":\"\"," +
//                "\"UseCustomerInn\":false,\"UseCustomerName\":true,\"TradeSearchType\":50}", StandardCharsets.UTF_8);
        RequestRegion70 requestRegion70=new RequestRegion70(1,10);
        HttpEntity httpEntity= null;
        try {
            httpEntity = new StringEntity(requestRegion70.getNewJson(1), StandardCharsets.UTF_8);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        httpPost.setEntity(httpEntity);
        try {
            HttpResponse response = httpClient.execute(httpPost);
            log.info("code: " + response.getStatusLine().getStatusCode());
            log.info("Msg: " + response.getStatusLine().getReasonPhrase());

            String textFromResponse = EntityUtils.toString(response.getEntity());

            //   log.info(EntityUtils.toString(response.getEntity()));

            ObjectMapper objectMapper = new ObjectMapper();
            DataJSONFromServer dataJSONFromServer = objectMapper.readValue(textFromResponse, DataJSONFromServer.class);
            System.out.println(dataJSONFromServer.toString());
            for (int i = 0; i < dataJSONFromServer.invdata.size(); i++) {
                System.out.println(dataJSONFromServer.invdata.get(i).toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    private static final String KEYSTOREPATH = "/clientkeystore.jks"; // or .p12
    private static final String KEYSTOREPASS = "keystorepass";
    private static final String KEYPASS = "keypass";

    private KeyStore readStore() {
        InputStream keyStoreStream = this.getClass().getResourceAsStream(KEYSTOREPATH);
        KeyStore keyStore = null; // or "PKCS12"
        try {
            keyStore = KeyStore.getInstance("JKS");
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try {
            keyStore.load(keyStoreStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        return keyStore;
    }

}
