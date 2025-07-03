package api.models;

import java.util.List;

public class Product {
    public Product() {
    }

    public Product(List<Skus> skus, String productId, String productName) {
        this.skus = skus;
        this.productId = productId;
        this.productName = productName;
    }

    private List<Skus> skus;
    private String productId;
    private String productName;

    public List<Skus> getSkus() {
        return skus;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }
}
