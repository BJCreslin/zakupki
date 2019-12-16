package ru.bjcreslin.zakupki.DTO;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Объекты этого класса получаются со страницы https://region70.rts-tender.ru/ с помощью Region70UrlController
 */
@Entity(name = "region70_purchase")
@Table
@Data
public class PurchaseRegion70 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    //Полное наименование
    private String customerName;
    //ИНН
    private Long inn;
    //Адрес места нахождения
    private String adress;
    //Наименование
    private String purchaseName;
    //Статус
    private String Status;
    //Статус
    private BigDecimal purchaseCost;
    //ФИО контактного лица
    private String contactPerson;
    //Контактный телефон
    private String contactPhone;
    //Сроки поставки
    private String deliveryDate;
    //Место поставки
    private String deliveryPlace;
    //Условия оплаты
    private String termsOfPayment;
    //Описание
    private String description;
    //Дата окончания подачи предложений
    private String filingDate;
    //Плановая дата заключения контракта
    private String contractDate;

}
