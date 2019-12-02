package ru.bjcreslin.zakupki.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PurchaseRegion70 {
    //Полное наименование
    private String customerName;
    //ИНН
    private Integer inn;
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
