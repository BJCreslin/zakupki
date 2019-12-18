package ru.bjcreslin.zakupki.classes;

/**
 * Класс для объекта - сайт region70.ru
 */
public class Region70Site {
    //Часть адреса, для поиска
    private static String partOfWebAddress = "/Trade/ViewTrade?id=";
    //Адрес сайта
    private static String url = "https://region70.rts-tender.ru";


    //Адрес сайта для запросов
    private static String requestUrl = "https://zmo-new-webapi.rts-tender.ru/api/Trade/GetTradesForParticipantOrAnonymous";


    public static String getUrl() {
        return url;
    }

    public static String getPartOfWebAddress() {
        return partOfWebAddress;
    }


    public static String getRequestUrl() {
        return requestUrl;
    }
}
