package ui.model;

import java.util.Objects;

public class Product {

    public Product(String color, String size, String quantity, String price) {
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    private String color;
    private String size;
    private String quantity;
    private String price;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(color, product.color) && Objects.equals(size, product.size) && Objects.equals(quantity, product.quantity) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size, quantity, price);
    }
}
