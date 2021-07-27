package com.zadatak.zadatakshop.beans;

import com.zadatak.zadatakshop.entity.Product;
import com.zadatak.zadatakshop.entity.facade.ProductFacadeLocal;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named (value = "productManagedBean")
@SessionScoped
public class ProductManagedBean implements Serializable{
    private List<Product> _productList;
    private Integer productId = null;
    private String name;
    private BigDecimal price;
    private int quantity;
    
    @Inject
    ProductFacadeLocal productFacadeLocal;
    @PostConstruct
    private void init(){
        _productList = productFacadeLocal.findAll();
    }
    
    public String addProduct(){
        Product product = new Product(null, name, price, quantity);
        productFacadeLocal.create(product);
        init();
        return "write";
    }
    
    public String removeProduct(Integer productId){
        Product product = productFacadeLocal.find(productId);
        productFacadeLocal.remove(product);
        init();
        return "write";
    }
    
    public String updateProduct(){
        Product product = productFacadeLocal.find(productId);
        if(product != null){
            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity);
            productFacadeLocal.edit(product);
            init();
        }
        return "write";
    }

    public ProductManagedBean() {
    }

    public List<Product> getProductList() {
        return _productList;
    }

    public void setProductList(List<Product> _productList) {
        this._productList = _productList;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
