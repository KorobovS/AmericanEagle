package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sku {
    public Sku() {
    }

    public Sku(String size, int unitSalePrice, String sku, int unitListPrice) {
        this.size = size;
        this.unitSalePrice = unitSalePrice;
        this.sku = sku;
        this.unitListPrice = unitListPrice;
    }

    private String size;
    private int unitSalePrice;
    private String sku;
    private int unitListPrice;

    public String getSize() {
        return size;
    }

    public int getUnitSalePrice() {
        return unitSalePrice;
    }

    public String getSku() {
        return sku;
    }

    public int getUnitListPrice() {
        return unitListPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sku sku1 = (Sku) o;
        return unitSalePrice == sku1.unitSalePrice && unitListPrice == sku1.unitListPrice && Objects.equals(size, sku1.size) && Objects.equals(sku, sku1.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, unitSalePrice, sku, unitListPrice);
    }
}
