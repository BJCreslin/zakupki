package ru.bjcreslin.zakupki.classes.sites;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

public class Region70OptionsRequest {
    public HttpClient getHttpClient() {
        return httpClient;
    }

    public HttpOptions getHttpOptions() {
        return httpOptions;
    }

    private HttpClient httpClient;
    private HttpOptions httpOptions;

    /*    User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:71.0) Gecko/20100101 Firefox/71.0
        Accept: *"/*
    Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3
    Accept-Encoding: gzip, deflate, br
    Access-Control-Request-Method: POST
    Access-Control-Request-Headers: content-type,xxx-tenantid-header
    Referer: https://region70.rts-tender.ru/
    Origin: https://region70.rts-tender.ru
    DNT: 1
    Connection: keep-alive
        */
    public Region70OptionsRequest() {
        String requestUrl = "https://zmo-new-webapi.rts-tender.ru/api/Trade/GetTradesForParticipantOrAnonymous";
        httpOptions = new HttpOptions(requestUrl);
        httpOptions.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:71.0) Gecko/20100101 Firefox/71.0");
        httpOptions.setHeader("Host", "zmo-new-webapi.rts-tender.ru");
        httpOptions.setHeader("Accept", "*/*");
        httpOptions.setHeader("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3");
        httpOptions.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpOptions.setHeader("Access-Control-Request-Method", "POST");
        httpOptions.setHeader("Access-Control-Request-Headers", "content-type,xxx-tenantid-header");
        httpOptions.setHeader("Referer", "https://region70.rts-tender.ru/");
        httpOptions.setHeader("Origin", "https://region70.rts-tender.ru");
        httpOptions.setHeader("DNT", "1");
        httpOptions.setHeader("Connection", "keep-alive");

        SSLContext sslContext = null;
        try {
            sslContext = SSLContexts.custom()
                    .loadKeyMaterial(readStore(), null) // use null as second param if you don't have a separate key password
                    .build();

        } catch (KeyManagementException | UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException e) {
            e.printStackTrace();
        }
        this.httpClient = HttpClients.custom().setSSLContext(sslContext).build();

    }


    /**
     * Метод для "общения" по https
     */
    private static final String KEYSTOREPATH = "/clientkeystore.jks"; // or .p12

    KeyStore readStore() {
        InputStream keyStoreStream = this.getClass().getResourceAsStream(KEYSTOREPATH);
        KeyStore keyStore = null; // or "PKCS12"
        try {
            keyStore = KeyStore.getInstance("JKS");
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try {
            keyStore.load(keyStoreStream, null);
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }
        return keyStore;
    }


}
