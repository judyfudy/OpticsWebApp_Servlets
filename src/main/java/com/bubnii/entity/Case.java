package com.bubnii.entity;

import java.util.Objects;

public class Case {
    private int id;
    private int price;
    private String brand;
    private String color;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return id == aCase.id &&
                Objects.equals(brand, aCase.brand) &&
                Objects.equals(color, aCase.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, color);
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
