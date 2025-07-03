package api.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Skus {
    public Skus() {
    }

    public Skus(String size, int salePrice, String skuId, int listPrice) {
        this.size = size;
        this.salePrice = salePrice;
        this.skuId = skuId;
        this.listPrice = listPrice;
    }

    private String size;
    private int salePrice;
    private String skuId;
    private int listPrice;

    public String getSize() {
        return size;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public String getSkuId() {
        return skuId;
    }

    public int getListPrice() {
        return listPrice;
    }
}
