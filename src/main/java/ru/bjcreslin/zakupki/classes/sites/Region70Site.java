package ru.bjcreslin.zakupki.classes.sites;

import lombok.extern.java.Log;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import ru.bjcreslin.zakupki.DTO.RequestRegion70;
import ru.bjcreslin.zakupki.classes.exceptions.CreateNewRegion70SiteObjectException;

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

    // Httpoptions доступ
    private HttpOptions httpOptions;

    //headers для Post запроса к сайту
    private HttpPost httpPost;

    @Override
    public HttpPost getHttpPost() {
        httpPost.setEntity(getHttpEntity(currentPage, purchasesOnPage));
        return httpPost;
    }

    public HttpOptions getHttpOptions() {
        return httpOptions;
    }

    public Region70Site() throws CreateNewRegion70SiteObjectException {
        currentPage=1;
        purchasesOnPage=10;
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
        SSLContext sslContext;
        try {
            sslContext = SSLContexts.custom()
                    .loadKeyMaterial(readStore(), null) // use null as second param if you don't have a separate key password
                    .build();

        } catch (KeyManagementException | UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException e) {
            log.severe("Не удалось создать объект Region70Site. Ошибка в создании SslContext");
            throw new CreateNewRegion70SiteObjectException();
        }
        httpClient = HttpClients.custom().setSSLContext(sslContext).build();
        requestRegion70 = new RequestRegion70();
    }


    @Override
    public HttpEntity getHttpEntity(int page, int numberPerPage) {
        requestRegion70 = new RequestRegion70(page, numberPerPage);
        return new StringEntity(requestRegion70.toString(), StandardCharsets.UTF_8);
    }
}
