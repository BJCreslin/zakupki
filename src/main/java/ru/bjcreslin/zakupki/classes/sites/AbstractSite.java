package ru.bjcreslin.zakupki.classes.sites;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpOptions;
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
    //httpClient
    HttpClient httpClient;
    // текущая страница
    Integer currentPage;

    public void setPurchasesOnPage(Integer purchasesOnPage) {
        this.purchasesOnPage = purchasesOnPage;
    }

    //всего закупок на странице
    Integer purchasesOnPage;

    public Integer getMaxPages() {
        return maxPages;
    }

    public void setMaxPages(Integer maxPages) {
        this.maxPages = maxPages;
    }

    //максимальное количество страниц
    Integer maxPages;

    abstract public HttpPost getHttpPost();

    abstract public HttpOptions getHttpOptions();


    public String getUrl() {
        return url;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * Делает HttpEntity сущность
     * для каждого класса сайта свой
     *
     * @param page        текущая траница
     * @param pagePerPage -количество торговых процедур на страницу
     * @return HttpEntity
     */
    public abstract HttpEntity getHttpEntity(int page, int pagePerPage);


    private static final String KEYSTOREPATH = "/clientkeystore.jks"; // or "PKCS12"

    /**
     * Метод для "общения" по https
     */
    KeyStore readStore() {
        InputStream keyStoreStream = this.getClass().getResourceAsStream(KEYSTOREPATH);
        KeyStore keyStore = null; // or "PKCS12"
        try {
            keyStore = KeyStore.getInstance("JKS");
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try {
            if (keyStore != null) {
                keyStore.load(keyStoreStream, null);
            }
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }
        return keyStore;
    }

    /**
     * Увеличиваем номер просматриваемой страницы, если возможно
     */
    public void nextPage() {
        if (currentPage >= maxPages) {
            currentPage = maxPages;
            return;
        }
        currentPage++;

    }

    /**
     * Уменьшаем номер просматриваемой страницы, если возможно
     */
    public void prevPage() {
        if (currentPage <= 1) {
            currentPage = maxPages;
            return;
        }
        currentPage++;
    }
}
