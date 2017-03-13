package com.camille.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by lizhihui on 13/03/2017.
 *
 */
enum Season{
    None,
    Spring,
    Summer,
    Autumn,
    Winter,
}

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    public String uuid;
    public String name;
    public String brand;
    public String unit;
    public Integer count;
    public Float price;
    public Float money;
    public String inventory;
    public Season season;
    public Date inDate;

    public Product() {
    }

    public Product(String name, String brand, String unit, Integer count, Float price, Float money, String inventory, Season season, Date inDate) {
        this.name = name;
        this.brand = brand;
        this.unit = unit;
        this.count = count;
        this.price = price;
        this.money = money;
        this.inventory = inventory;
        this.season = season;
        this.inDate = inDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }
}
