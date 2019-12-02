package ru.bjcreslin.zakupki.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "region70_purchase")
@Table
public class Purchase {
    @Id
    Long id;

    @Column(name = "inn")
    Integer inn;

    @Column(name = "name")
    String name;


}
