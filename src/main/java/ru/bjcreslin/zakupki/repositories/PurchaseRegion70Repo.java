package ru.bjcreslin.zakupki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bjcreslin.zakupki.DTO.PurchaseRegion70;

public interface PurchaseRegion70Repo extends JpaRepository<PurchaseRegion70, Long> {
    PurchaseRegion70 findBySiteId(Long siteId);
}
