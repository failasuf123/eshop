package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();


    public Product create(Product product){
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }

    public Product findByName(String productName) {
        for (Product product : productData) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }


    public void delete(String productId) {
        productData.removeIf(product -> product.getProductId().equals(productId));
    }



    public Product updateProduct(String productName, Product updatedProduct) {
        for (int i = 0; i < productData.size(); i++) {
            if (productData.get(i).getProductName().equals(productName)) {
                Product existingProduct = productData.get(i);
                existingProduct.setProductName(updatedProduct.getProductName());
                existingProduct.setProductQuantity(updatedProduct.getProductQuantity());

                return existingProduct;
            }
        }


        return null;
    }

}