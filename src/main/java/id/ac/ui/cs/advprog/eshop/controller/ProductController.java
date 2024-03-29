package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.CarServiceImpl;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "createProduct";

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

    @GetMapping("/edit/{productId}")
    public String editProductPage(@PathVariable String productId, Model model){
        Product product = service.findByName(productId);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/edit")
    public String editProductPost(@ModelAttribute Product product, Model model) {
        System.out.println(product.getProductId());
        service.update(product.getProductId(), product);

        return "redirect:list";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("productId") String productId){
        service.deleteProductById(productId);
        return "redirect:list";
    }


//    @DeleteMapping("/delete/{productName}")
//    public void delete(@PathVariable("productName") String productName) {
//        performAdditionalAction(productName);
//        service.delete(productName);
//
//    }
//
//    private void performAdditionalAction(String productName) {
//        // Implementasikan tindakan tambahan di sini
//        // Misalnya, log, kirim notifikasi, atau tindakan lainnya
//        System.out.println("Product with name " + productName + " has been deleted.");
//    }
//
//    @GetMapping("/edit/{productName}")
//    public String editProductPage(@PathVariable String productName, Model model) {
//        Product product = service.findByName(productName);
//
//        if (product != null) {
//            model.addAttribute("product", product);
//            return "EditProduct";
//        } else {
//            return "redirect:/product/list";
//        }
//    }
//
//    @PostMapping("/edit/{productName}")
//    public String editProductPost(@PathVariable String productName, @ModelAttribute Product updatedProduct) {
//        service.update(productName, updatedProduct);
//
//        return "redirect:/product/list";
//    }

}

@Controller
@RequestMapping("/car")
class CarController extends ProductController {
    @Autowired
    private CarServiceImpl carservice;

    @GetMapping("/createCar")
    public String createCarPage(Model model){
        Car car = new Car();
        model.addAttribute("car", car);
        return "createCar";
    }

    @PostMapping("/createCar")
    public String createCarPost(@ModelAttribute Car car, Model model){
        carservice.create(car);
        return "redirect:listCar";
    }

    @GetMapping("/listCar")
    public String carListPage(Model model){
        List<Car> allCars = carservice.findAll();
        model.addAttribute("cars", allCars);
        return "carList";
    }

    @GetMapping("/editCar/{carId}")
    public String editCarPage(@PathVariable String carId, Model model){
        Car car = carservice.findById(carId);
        model.addAttribute("car", car);
        return "editCar";
    }

    @PostMapping("/editCar")
    public String  editCarPost(@ModelAttribute Car car, Model model){
        System.out.println(car.getCarId());
        carservice.update(car.getCarId(), car);

        return "redirect:listCar";
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@RequestParam("carId") String carId){
        carservice.deleteCarById(carId);
        return "redirect:listCar";
    }


}
