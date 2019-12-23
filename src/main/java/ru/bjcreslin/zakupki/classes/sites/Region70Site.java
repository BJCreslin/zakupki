package ru.bjcreslin.zakupki.classes.sites;

import lombok.extern.java.Log;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import ru.bjcreslin.zakupki.DTO.RequestRegion70;

import javax.net.ssl.SSLContext;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

/**
 * Класс для объекта - сайт region70.ru
 */
@Log
public class Region70Site extends AbstractSite {

    // данные для POST запроса, передаваемые в теле.
    RequestRegion70 requestRegion70;

    public Region70Site() {
        url = "https://region70.rts-tender.ru";
        requestUrl = "https://zmo-new-webapi.rts-tender.ru/api/Trade/GetTradesForParticipantOrAnonymous";
        partOfWebAddress = "/Trade/ViewTrade?id=";
        httpPost = new HttpPost(requestUrl);
        httpPost.setEntity(getHttpEntity(1, 10));
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:71.0) Gecko/20100101 Firefox/71.0");
        httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
        httpPost.setHeader("Host", "zmo-new-webapi.rts-tender.ru");
        httpPost.setHeader("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3");
        httpPost.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpPost.setHeader("XXX-TenantId-Header", "126");
        httpPost.setHeader("Origin", "https://region70.rts-tender.ru");
        httpPost.setHeader("DNT", "1");
        httpPost.setHeader("Accept", "*/*");
        httpPost.setHeader("Connection", "keep-alive");
        httpPost.setHeader("Referer", "https://region70.rts-tender.ru/");


        SSLContext sslContext = null;
        try {
            sslContext = SSLContexts.custom()
                    .loadKeyMaterial(readStore(), null) // use null as second param if you don't have a separate key password
                    .build();

        } catch (KeyManagementException | UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException e) {
            e.printStackTrace();
        }
        httpClient = HttpClients.custom().setSSLContext(sslContext).build();
        requestRegion70 = new RequestRegion70();
    }

    @Override
    public HttpEntity getHttpEntity(int page, int numberPerPage) {
        requestRegion70 = new RequestRegion70(page, numberPerPage);
        log.info(requestRegion70.toString());
        return new StringEntity(requestRegion70.toString(), StandardCharsets.UTF_8);
    }
}
