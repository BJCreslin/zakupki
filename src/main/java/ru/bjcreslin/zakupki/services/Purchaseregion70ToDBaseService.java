package ru.bjcreslin.zakupki.services;

import org.springframework.stereotype.Service;
import ru.bjcreslin.zakupki.DTO.PurchaseRegion70;
import ru.bjcreslin.zakupki.repositories.PurchaseRegion70Repo;

@Service
public class Purchaseregion70ToDBaseService {
    final
    PurchaseRegion70Repo purchaseRegion70Repo;

    public Purchaseregion70ToDBaseService(PurchaseRegion70Repo purchaseRegion70Repo) {
        this.purchaseRegion70Repo = purchaseRegion70Repo;
    }

    /**
     * Сохраняет данные в базу
     *
     * @param purchaseRegion70 полученный объект
     */
    public void save(PurchaseRegion70 purchaseRegion70) {
        purchaseRegion70Repo.saveAndFlush(purchaseRegion70);

    }
}
