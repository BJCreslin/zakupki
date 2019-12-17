package ru.bjcreslin.zakupki.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import ru.bjcreslin.zakupki.DTO.PurchaseRegion70;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.function.BiConsumer;

@Service
public class Region70UrlService {
    private HashMap<String, BiConsumer<PurchaseRegion70, Element>> operatorForRecogniseRegion70FieldsMap;

    public Region70UrlService() {
        operatorForRecogniseRegion70FieldsMap = new HashMap<>();
        operatorForRecogniseRegion70FieldsMap.put("Полное наименование", this::setFullCustomerName);
        operatorForRecogniseRegion70FieldsMap.put("ИНН", this::setInn);
        operatorForRecogniseRegion70FieldsMap.put("Адрес места нахождения", this::setAddress);
        operatorForRecogniseRegion70FieldsMap.put("Наименование", this::setName);
        operatorForRecogniseRegion70FieldsMap.put("Статус", this::setStatus);
        operatorForRecogniseRegion70FieldsMap.put("НМЦК, руб.", this::setCost);
        operatorForRecogniseRegion70FieldsMap.put("ФИО контактного лица", this::setContact);
        operatorForRecogniseRegion70FieldsMap.put("Контактный телефон", this::setPhone);
        operatorForRecogniseRegion70FieldsMap.put("Сроки поставки", this::setDeliveryDate);
        operatorForRecogniseRegion70FieldsMap.put("Место поставки", this::setDeliveryPlace);
        operatorForRecogniseRegion70FieldsMap.put("Условия оплаты", this::setTerms);
        operatorForRecogniseRegion70FieldsMap.put("Дата окончания подачи предложений", this::setDeadLine);
        operatorForRecogniseRegion70FieldsMap.put("Описание", this::setDescription);
        operatorForRecogniseRegion70FieldsMap.put("Плановая дата заключения контракта", this::setContractDate);

    }

    /*
                 Записывает в объект PurchaseRegion70     Дата заключения контракта
 */
    private void setContractDate(PurchaseRegion70 purchaseRegion70, Element element) {
        purchaseRegion70.setContractDate(getTextFromHtmlData(element));
    }

    /*
              Записывает в объект PurchaseRegion70     Дата окончания подачи предложений
   */
    private void setDeadLine(PurchaseRegion70 purchaseRegion70, Element element) {
        purchaseRegion70.setFilingDate(getTextFromHtmlData(element));
    }

    /*
            Записывает в объект PurchaseRegion70    Описание
    */
    private void setDescription(PurchaseRegion70 purchaseRegion70, Element element) {
        purchaseRegion70.setDescription(getTextFromHtmlData(element));
    }

    /*
             Записывает в объект PurchaseRegion70    Условия оплаты
    */
    private void setTerms(PurchaseRegion70 purchaseRegion70, Element element) {
        purchaseRegion70.setTermsOfPayment(getTextFromHtmlData(element));
    }


    /*
           Записывает в объект PurchaseRegion70   Место поставки
    */
    private void setDeliveryPlace(PurchaseRegion70 purchaseRegion70, Element element) {
        purchaseRegion70.setDeliveryPlace(getTextFromHtmlData(element));
    }

    /*
             Записывает в объект PurchaseRegion70  Сроки поставки
    */
    private void setDeliveryDate(PurchaseRegion70 purchaseRegion70, Element element) {
        purchaseRegion70.setDeliveryDate(getTextFromHtmlData(element));
    }

    /*
           Записывает в объект PurchaseRegion70  Контактный телефон
    */
    private void setPhone(PurchaseRegion70 purchaseRegion70, Element element) {
        purchaseRegion70.setContactPhone(getTextFromHtmlData(element));
    }

    /*
        Записывает в объект PurchaseRegion70  ФИО контактного лица
     */
    private void setContact(PurchaseRegion70 purchaseRegion70, Element element) {
        purchaseRegion70.setContactPerson(getTextFromHtmlData(element));
    }

    /*
         Записывает в объект PurchaseRegion70  максимальную стоимость закупки
     */
    private void setCost(PurchaseRegion70 purchaseRegion70, Element element) {
        purchaseRegion70.setPurchaseCost(new BigDecimal(getNormalTypeOfNumber(element)));
    }


    /*
          Записывает в объект PurchaseRegion70  статус закупки
    */
    private void setStatus(PurchaseRegion70 purchaseRegion70, Element element) {
        purchaseRegion70.setStatus(getTextFromHtmlData(element));
    }


    /*
           Записывает в объект PurchaseRegion70  название закупки
    */
    private void setName(PurchaseRegion70 purchaseRegion70, Element element) {
        purchaseRegion70.setPurchaseName(getTextFromHtmlData(element));
    }


    /*
        Записывает в объект PurchaseRegion70  адрес
     */
    private void setAddress(PurchaseRegion70 purchaseRegion70, Element element) {
        purchaseRegion70.setAdress(getTextFromHtmlData(element));
    }

    /*
    Записывает в объект PurchaseRegion70  ИНН
    */
    private void setInn(PurchaseRegion70 purchaseRegion70, Element element) {
        purchaseRegion70.setInn(Long.parseUnsignedLong(getTextFromHtmlData(element)));
    }

    /*
        Записывает в объект PurchaseRegion70  Название заказчика
     */
    private void setFullCustomerName(PurchaseRegion70 purchaseRegion70, Element element) {
        purchaseRegion70.setCustomerName(getTextFromHtmlData(element));
    }


    /**
     * С помощью диспатчера, построенного на мапе парсит объект
     *
     * @param region70URL - String url страницы парсинга
     * @return объект PurchaseRegion70
     * @throws IOException выбрасывает исключение, в случае если не может обработать запрос.
     */
    public PurchaseRegion70 getPurchaseFromRegion70(String region70URL) throws IOException {
        Document document = Jsoup.connect(region70URL).get();
        PurchaseRegion70 purchaseRegion70 = new PurchaseRegion70();
        purchaseRegion70.setSiteId(Long.parseUnsignedLong(region70URL.
                replace("https://region70.rts-tender.ru/Trade/ViewTrade?id=", "")));
        for (Element element : document.getElementsByTag("label")) {
            String key = element.text();
            if (operatorForRecogniseRegion70FieldsMap.containsKey(key)) {
                operatorForRecogniseRegion70FieldsMap.get(key).accept(purchaseRegion70, element);
            }
        }
        return purchaseRegion70;
    }


    /*
         <tr>
                 <td><label for="ContactInfo_Fio">ФИО контактного лица</label></td>
             <td>Крепица Наталия Валериевна</td>
         </tr>
         По имеющейся <td><label for="ContactInfo_Fio">ФИО контактного лица</label></td>
         выходим на родителя (<td> ) и у него берем родного брата
  */
    private String getTextFromHtmlData(Element element) {
        return element.parent().nextElementSibling().text();
    }

    /*
    Делает форму числа пригодную ля парсинга из "95 757,93" в 95757.93
     */
    private String getNormalTypeOfNumber(Element element) {
        return getTextFromHtmlData(element).replace(" ", "").replace(",", ".");
    }


}
