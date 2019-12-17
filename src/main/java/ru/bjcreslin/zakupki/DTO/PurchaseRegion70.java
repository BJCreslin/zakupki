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
//
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    Long id;
//    // Id на сайте
    @Id
//    @Column(unique = true)
    Long siteId;
    //Полное наименование
    @Column(columnDefinition="text")
    private String customerName;
    //ИНН
    private Long inn;
    //Адрес места нахождения
    @Column(columnDefinition="text")
    private String adress;
    //Наименование
    @Column(columnDefinition="text")
    private String purchaseName;
    //Статус
    @Column(columnDefinition="text")
    private String Status;
    //НМЦК, руб.
    private BigDecimal purchaseCost;
    //ФИО контактного лица
    @Column(columnDefinition="text")
    private String contactPerson;
    //Контактный телефон
    @Column(columnDefinition="text")
    private String contactPhone;
    //Сроки поставки
    @Column(columnDefinition="text")
    private String deliveryDate;
    //Место поставки
    @Column(columnDefinition="text")
    private String deliveryPlace;
    //Условия оплаты
    @Column(columnDefinition="text")
    private String termsOfPayment;
    //Описание
    @Column(columnDefinition="text")
    private String description;
    //Дата окончания подачи предложений
    @Column(columnDefinition="text")
    private String filingDate;
    //Плановая дата заключения контракта
    @Column(columnDefinition="text")
    private String contractDate;

}
