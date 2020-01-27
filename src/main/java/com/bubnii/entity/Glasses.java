package com.bubnii.entity;

import java.util.Objects;

public class Glasses {
    private int id;
    private int price;
    private String type;
    private String form;
    private String sex;
    private String material;
    private String brand;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
        Glasses glasses = (Glasses) o;
        return id == glasses.id &&
                Objects.equals(type, glasses.type) &&
                Objects.equals(form, glasses.form) &&
                Objects.equals(sex, glasses.sex) &&
                Objects.equals(material, glasses.material) &&
                Objects.equals(brand, glasses.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, form, sex, material, brand);
    }

    @Override
    public String toString() {
        return "Glasses{" +
                "id=" + id +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", form='" + form + '\'' +
                ", sex='" + sex + '\'' +
                ", material='" + material + '\'' +
                ", brand='" + brand + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
