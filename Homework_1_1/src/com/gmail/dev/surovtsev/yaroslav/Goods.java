package com.gmail.dev.surovtsev.yaroslav;

public class Goods {
    private int code;
    private String name;
    private String description;
    private double price;
    private double weight;
    private String barcode;
    private String vendorCode;
    private boolean imported;

    public Goods() {
    }

    public Goods(int code, String name, String description, double price, double weight, String barcode,
                 String vendorCode, boolean imported) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.barcode = barcode;
        this.vendorCode = vendorCode;
        this.imported = imported;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", barcode='" + barcode + '\'' +
                ", vendorCode='" + vendorCode + '\'' +
                ", imported=" + imported +
                '}';
    }
}
