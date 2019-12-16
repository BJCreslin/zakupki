package ru.bjcreslin.zakupki.DTO;

import javax.persistence.Id;


public class Purchase extends PurchaseRegion70 {

    Long id;

    public Purchase(PurchaseRegion70 purchaseRegion70) {
        this.setAdress(purchaseRegion70.getAdress());

    }

    public Purchase() {
    }
}
