package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;

    @Mock
    Model model;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testCreateProductPage() {
        String viewName = productController.createProductPage(model);
        assertEquals("CreateProduct", viewName);
    }
    @Test
    void testCreateProductPost() {
        Product product = new Product();

        String viewName = productController.createProductPost(product, model);

        verify(productService, times(1)).create(product);

        assertEquals("redirect:list", viewName);
    }


    @Test
    void testProductListPage() {
        List<Product> productList = new ArrayList<>();
        when(productService.findAll()).thenReturn(productList);
        when(model.addAttribute("products", productList)).thenReturn(model);

        String viewName = productController.productListPage(model);

        assertEquals("productList", viewName);
        verify(productService, times(1)).findAll();
        verify(model, times(1)).addAttribute("products", productList);
    }

    @Test
    void testDelete() {
        String productName = "SampleProduct";

        productController.deleteProduct(productName);

        verify(productService, times(1)).delete(productName);
    }


@Test
void testEditProductPage_ProductNotFound() {
    String productName = "NonExistentProduct";
    when(productService.findByName(productName)).thenReturn(null);

    String viewName = productController.editProductPage(productName, model);

    verify(productService, times(1)).findByName(productName);

    assertEquals("redirect:/product/list", viewName);
}

    @Test
    void testEditProductPage_ProductFound() {
        String productName = "SampleProduct";
        Product product = new Product();
        when(productService.findByName(productName)).thenReturn(product);

        String viewName = productController.editProductPage(productName, model);

        verify(productService, times(1)).findByName(productName);

        assertEquals("EditProduct", viewName);
        verify(model, times(1)).addAttribute("product", product);
    }


    @Test
    void testEditProductPost() {
        String productName = "SampleProduct";
        Product updatedProduct = new Product();

        String viewName = productController.editProductPost(productName, updatedProduct);

        verify(productService, times(1)).update(productName, updatedProduct);
        assertEquals("redirect:/product/list", viewName);
    }
}
