package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;

@Controller
@RequestMapping("/product")

public class ProductController{

    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model){
        Product product = new Product();
        model.addAttribute("product", product);

        return "CreateProduct";

    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model){
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model){
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }


    @DeleteMapping("/delete/{productName}")
    public void delete(@PathVariable("productName") String productName) {
        performAdditionalAction(productName);
        service.delete(productName);

    }

    private void performAdditionalAction(String productName) {
        // Implementasikan tindakan tambahan di sini
        // Misalnya, log, kirim notifikasi, atau tindakan lainnya
        System.out.println("Product with name " + productName + " has been deleted.");
    }

    @GetMapping("/edit/{productName}")
    public String editProductPage(@PathVariable String productName, Model model) {
        Product product = service.findByName(productName);

        if (product != null) {
            model.addAttribute("product", product);
            return "EditProduct";
        } else {
            return "redirect:/product/list";
        }
    }

    @PostMapping("/edit/{productName}")
    public String editProductPost(@PathVariable String productName, @ModelAttribute Product updatedProduct) {
        service.update(productName, updatedProduct);

        return "redirect:/product/list";
    }

}
