package edu.javavt17.controllers;

import edu.javavt17.model.Order;
import edu.javavt17.model.Product;
import edu.javavt17.service.OrderService;
import edu.javavt17.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class JpaController {
    private static final String INSTRUMENT = "jpa";
    private static final String TITLE = "JPA";
    @Autowired
    @Qualifier("orderHibernateService")
    private OrderService orderService;
    @Autowired
    @Qualifier("productHibernateService")
    private ProductService productService;
    @RequestMapping(value = "/"+INSTRUMENT+"", method = RequestMethod.GET)
    public String printJdbc(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("instrument", INSTRUMENT);
        List<Order> listOrder = orderService.list();
        List<Product> listProduct = productService.list();
        model.addAttribute("listProduct",listProduct);
        model.addAttribute("listOrder",listOrder);
        return "content";
    }
    //CRUD operations with CarBrand entity
    @RequestMapping(value = "/"+INSTRUMENT+"/newProduct", method = RequestMethod.GET)
    public String addBrand(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Add new");
        Product product = new Product();
        model.addAttribute("product", product);
        return "productForm";
    }
    @RequestMapping(value = { "/"+INSTRUMENT+"/newProduct" }, method = RequestMethod.POST)
    public String saveBrand(Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/"+INSTRUMENT;
    }
    @RequestMapping(value = { "/"+INSTRUMENT+"/delete-product/{idProduct}" }, method = RequestMethod.GET)
    public String deleteBrand(@PathVariable int idProduct) {
        productService.delete(idProduct);
        return "redirect:/"+INSTRUMENT;
    }
    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-product/{idProduct}" }, method = RequestMethod.GET)
    public String editBrand(@PathVariable int idProduct, ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Edit");
        Product product = productService.get(idProduct);
        model.addAttribute("product", product);
        model.addAttribute("edit", true);
        return "productForm";
    }
    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-product/{idProduct}" }, method = RequestMethod.POST)
    public String updateBrand(Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/"+INSTRUMENT;
    }
    //CRUD operations with CarModel entity
    @RequestMapping(value = "/"+INSTRUMENT+"/newOrder", method = RequestMethod.GET)
    public String addModel(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Add new");
        List<Product> listProduct = productService.list();
        System.out.println(listProduct);
        Order order = new Order();
        model.addAttribute("listProduct", listProduct);
        model.addAttribute("order", order);
        return "orderForm";
    }
    @RequestMapping(value = { "/"+INSTRUMENT+"/newOrder" }, method = RequestMethod.POST)
    public String saveModel(Order order) {
        int idProduct = order.getIdProduct();
        order.setProduct(productService.get(idProduct));
        orderService.saveOrUpdate(order);
        return "redirect:/"+INSTRUMENT;
    }
    @RequestMapping(value = { "/"+INSTRUMENT+"/delete-order/{idOrder}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable int idOrder) {
        orderService.delete(idOrder);
        return "redirect:/"+INSTRUMENT;
    }
    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-order/{idOrder}" }, method = RequestMethod.GET)
    public String editModel(@PathVariable int idOrder, ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Edit");
        Order order = orderService.get(idOrder);
        List<Product> listProduct = productService.list();
        model.addAttribute("order", order);
        model.addAttribute("listProduct", listProduct);
        return "orderForm";
    }
    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-order/{idOrder}" }, method = RequestMethod.POST)
    public String updateModel(Order order) {

        int idProduct = order.getIdProduct();
        order.setProduct(productService.get(idProduct));
        orderService.saveOrUpdate(order);
        return "redirect:/"+INSTRUMENT;
    }
    @RequestMapping(value = {"/"+INSTRUMENT+"/pdfReport", "/"+INSTRUMENT+"/xlsxReport.xlsx"}, method = RequestMethod.GET)
    public ModelAndView downloadReport(@RequestParam("view") String view) {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> listProduct = productService.list();
        List<Order> listOrder = orderService.list();
        // return a view which will be resolved by a ResourceBundleViewResolver
        modelAndView.addObject("products", listProduct);
        modelAndView.addObject("orders", listOrder);
        modelAndView.setViewName(view);
        return modelAndView;
    }
}
