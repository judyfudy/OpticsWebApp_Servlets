package com.bubnii.entity;

import java.util.Objects;

public class Lenses {
    private int id;
    private int price;
    private long diameter;
    private String brand;
    private String appointment;

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

    public long getDiameter() {
        return diameter;
    }

    public void setDiameter(long diameter) {
        this.diameter = diameter;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lenses lenses = (Lenses) o;
        return diameter == lenses.diameter &&
                Objects.equals(brand, lenses.brand) &&
                Objects.equals(appointment, lenses.appointment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diameter, brand, appointment);
    }

    @Override
    public String toString() {
        return "Lenses{" +
                "id=" + id +
                ", price=" + price +
                ", diameter=" + diameter +
                ", brand='" + brand + '\'' +
                ", appointment='" + appointment + '\'' +
                '}';
    }
}
