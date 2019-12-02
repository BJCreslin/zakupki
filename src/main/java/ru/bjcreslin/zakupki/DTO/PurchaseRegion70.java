package ru.bjcreslin.zakupki.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PurchaseRegion70 {
    private String customerName;
    private Integer inn;
    private String adress;
    private String purchaseName;
    private String Status;
    private BigDecimal purchaseCost;
    private String contactPerson;
    private String contactPhone;
    private String deliveryDate;
    private String deliveryPlace;
    private String termsOfPayment;
    private String description;
    private String filingDate;
    private String contractDate;

}
