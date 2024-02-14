package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateProduct() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);

        assertEquals(product, createdProduct);
        verify(productRepository, times(1)).create(product);
    }


    @Test
    void testFindAllProducts() {
        Iterator<Product> productIterator = Collections.emptyListIterator(); // Create an empty iterator
        when(productRepository.findAll()).thenReturn(productIterator);

        List<Product> allProducts = productService.findAll();

        assertEquals(Collections.emptyList(), allProducts); // Assert the returned list is empty
        verify(productRepository, times(1)).findAll();
    }



    @Test
    void testFindProductByName() {
        String productName = "SampleProduct";
        Product product = new Product();
        when(productRepository.findByName(productName)).thenReturn(product);

        Product foundProduct = productService.findByName(productName);

        assertEquals(product, foundProduct);
        verify(productRepository, times(1)).findByName(productName);
    }

    @Test
    void testDeleteProduct() {
        String productName = "SampleProduct";

        productService.delete(productName);

        verify(productRepository, times(1)).delete(productName);
    }

    @Test
    void testUpdateProduct() {
        String productName = "SampleProduct";
        Product updatedProduct = new Product();
        when(productRepository.updateProduct(productName, updatedProduct)).thenReturn(updatedProduct);

        Product result = productService.update(productName, updatedProduct);

        assertEquals(updatedProduct, result);
        verify(productRepository, times(1)).updateProduct(productName, updatedProduct);
    }
}
