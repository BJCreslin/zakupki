package ru.bjcreslin.zakupki.classes.sites;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;


public abstract class AbstractSite {
    //Адрес сайта для запросов
    String requestUrl;
    //Часть адреса, для поиска
    String partOfWebAddress;
    //Адрес сайта
    String url;
    //headers для сайта
    HttpPost httpPost;
    //httpClient
    HttpClient httpClient;


    public HttpPost getHttpPost() {
        httpPost.setEntity(getHttpEntity(1, 10));
        return httpPost;
    }

    public String getUrl() {
        return url;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * Делает HttpEntity
     * для каждого класса сайта свой
     *
     * @param page        текущая траница
     * @param pagePerPage -количество торговых процедур на страницу
     * @return HttpEntity
     */
    public abstract HttpEntity getHttpEntity(int page, int pagePerPage);


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
