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
        service.delete(productName);
    }

//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") long id, Model model) {
//        Product product = productRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//        userRepository.delete(user);
//        return "redirect:/index";
//    }

//    @DeleteMapping("/delete/{productName}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable String productName) {
//        service.delete(productName);
//        return ResponseEntity.noContent().build();
//    }


//    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//
//        model.addAttribute("user", user);
//        return "update-user";
//    }

    @GetMapping("/edit/{productName}")
    public String editProductPage(@PathVariable String productName, Model model) {
        // Temukan produk berdasarkan nama
        Product product = service.findById(productName);

        // Periksa apakah produk ditemukan
        if (product != null) {
            model.addAttribute("product", product);
            return "EditProduct";
        } else {
            // Produk tidak ditemukan, atur pesan kesalahan atau alihkan ke halaman lain
            return "redirect:/product/list";
        }
    }

    @PostMapping("/edit/{productName}")
    public String editProductPost(@PathVariable String productName, @ModelAttribute Product updatedProduct) {
        // Implementasikan logika pembaruan produk
        service.update(productName, updatedProduct);

        // Redirect ke halaman daftar produk setelah pembaruan
        return "redirect:/product/list";
    }
}
