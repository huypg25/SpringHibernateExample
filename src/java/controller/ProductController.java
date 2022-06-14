/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDao;
import entity.Product;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ADMIN
 */
@Controller
public class ProductController {

    ProductDao dao;

    public ProductController() {
        dao = new ProductDao();
    }

    @RequestMapping(value = "listProducts", method = RequestMethod.GET)
    public String getData(Model model, String keyword) {
        keyword = keyword != null ? keyword : "";
        List<Product> listProducts = dao.getData(keyword);
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    @RequestMapping(value = "get-product-by-id", method = RequestMethod.GET)
    public String getDataById(Model model, String productId) {
        Product p = dao.getDataById(productId);
        model.addAttribute("product", p);
        model.addAttribute("isInsert", false);
        return "productView";
    }

    @RequestMapping(value = "openForm", method = RequestMethod.GET)
    public String open(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("isInsert", true);
        return "productView";
    }

    @RequestMapping(value = "saveProduct", method = RequestMethod.POST)
    public String saveData(Model model, Product product, boolean isInsert) {
        if (isInsert) {
            if (dao.insertData(product) == 0) {
                model.addAttribute("error", "insertFalse");
                return "productView";
            }
        } else {
            if (dao.updateData(product) == 0) {
                model.addAttribute("error", "updateFalse");
                return "productView";
            }
        }
        model.addAttribute("error", "insertSuccess");
        return "redirect:listProducts.htm";
    }

    @RequestMapping(value = "deleteProduct", method = RequestMethod.GET)
    public String deleteProduct(Model model, String productId) {
        if (dao.deleteData(productId) != 1) {
            model.addAttribute("error", "deleteFalse");
            return "productView";
        }
        model.addAttribute("error", "deleteSuccess");
        return "redirect:listProducts.htm";
    }
}
