package com.niit.shopping.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niit.shopping.model.Cart;
import com.niit.shopping.model.ProductDetails;
import com.niit.shopping.model.UserDetails;
import com.niit.shopping.service.ProductService;
import com.niit.shopping.service.RegisterService;


@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	RegisterService registerService;
	
	

	@RequestMapping({ "/", "/index" })
	public String index(HttpSession session,Principal activeuser){
		session.setAttribute("listbrand", productService.listBrands()); 
		if(activeuser != null){
		session.setAttribute("cartNumber",productService.cartNumber(activeuser.getName()));	
		}
		session.setAttribute("listproduct",productService.listProducts());
		return "index";
		
		
		
	}
	
	/*@RequestMapping("/brand")
	public @ResponseBody List<ProductDetails> brand() {
		return productService.listBrands();
		
	}*/
	
	/*
	 * @RequestMapping(value = "/login") public String getlogin() { return
	 * "login"; }
	 */

	/*
	 * @RequestMapping(value = "/submit") public String submit() { return
	 * "index"; }/*
	 * 
	 * /*@RequestMapping(value = "/signup") public String signup() { return
	 * "index"; }
	 */
	
	

	@RequestMapping(value ="/brand/{product_brand}")
		public String productBrand(@PathVariable("product_brand") String brand_name,HttpSession session){
		session.setAttribute("brand1",brand_name);	
		System.out.println(brand_name);
		return "brand";
		}
	
	
		
	
	@RequestMapping(value ="/brand1/{brand}")
public @ResponseBody List<ProductDetails>  brand(@PathVariable("brand") String product_brand) {
	return productService.getProductByBrand(product_brand);
	
	}
	

	
	
	
	
	@RequestMapping("/addtocart/{product_id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public String addtocart1(@PathVariable("product_id") int product_id,Principal activeuser,HttpSession session) {
		
		if(activeuser.getName()==null){
			return "redirect:/login";
		}
		else{
		boolean isValid=false;
		
		Cart cart=new Cart();
		cart.setProduct_id(product_id);
		cart.setCheckUser(activeuser.getName());
		
		isValid=productService.checkProduct(cart);
		
		if(isValid==false){
			
		
		
		ProductDetails productDetails=(productService. getProductById(product_id));
		
		
		
		
		
		UserDetails userDetails=registerService.getUserByUsername(activeuser.getName());
		
		
		
		Cart userCart=new Cart();
		
		userCart.setUserDetails(userDetails);
		userCart.setProductName(productDetails.getProduct_name());
		userCart.setProductbrand(productDetails.getProduct_brand());
		userCart.setProductPrice(productDetails.getProduct_price());
		userCart.setImagename(productDetails.getImage_name());
		userCart.setProduct_id(productDetails.getProduct_id());
		
		userCart.setQuantity(1);
		
		productService.addCartProduct(userCart);
		session.setAttribute("cartNumber",productService.cartNumber(activeuser.getName()));
		}
		/*cart.setProductList(productService.getViewProductById(product_id));*/
		
		/*productDetails.setProductList(productService.getViewProductById(product_id));*/
		
		/*cart.setProductDetails(productDetails);*/
		
		/*Cart cart=new Cart();
		cart.setProductName(productDetails.getProduct_name());
		cart.setProductbrand(productDetails.getProduct_brand());
		cart.setProductPrice(productDetails.getProduct_price());
		cart.setImagename(productDetails.getImage_name());
		cart.setProduct_id(productDetails.getProduct_id());
		
		cart.setQuantity(1);
		
		productService.addCartProduct(cart);
		*/
		return "mycart";
		}
	}

	
	
	@RequestMapping("/mycart")
	public String viewmycart(Principal activeuser,HttpSession session){
		

		return "mycart";
	}
	
	
	@RequestMapping("/mycartlist")
	public @ResponseBody List<Cart> mycart(Principal activeuser,HttpSession session){
		
		/*List<Cart> cart;

		cart=(productService.getTotalPrice(activeuser.getName()));*/
		
		return productService.getCartByUser(activeuser.getName());
		
		 
		}
		
	
	
	@RequestMapping("/removecartproduct/{cart_id}")
	public String removefromcart(@PathVariable("cart_id") int cart_id,Principal activeuser,HttpSession session) {
		
		productService.removeCartProduct(cart_id);
		
/*boolean isValid=false;
		
		isValid=productService.checkCart();
		
		if(isValid==true){
		
		session.setAttribute("totalamount",(productService.getTotalPrice(activeuser.getName())));
		}
		
		session.setAttribute("cartlist",productService.getCartByUser(activeuser.getName()));*/
		
		session.setAttribute("cartNumber",productService.cartNumber(activeuser.getName()));
		
		return "redirect:/mycart";
		
		
	}
	
	@RequestMapping("/clearall")
	public String clearall(HttpSession session,Principal activeuser) {

		
         productService.clearall(activeuser.getName());

		/*session.setAttribute("cartlist",productService.getCartByUser(activeuser.getName()));*/
         session.setAttribute("cartNumber",productService.cartNumber(activeuser.getName()));
         
		return "redirect:/mycart";
	}
	
	@RequestMapping("/logout/clearall")
	/*@ResponseStatus(value = HttpStatus.NO_CONTENT)*/
	public String logoutClearall(Principal activeuser){
		 productService.clearall(activeuser.getName());
		
		 return "redirect:/logout";
	}
	
	
	
	
	@RequestMapping("/view/{product_id}")
	public  String viewProduct(@PathVariable("product_id") int product_id,HttpSession session){
		
		session.setAttribute("productViewById", product_id);
		System.out.println(product_id);
		return "viewproductbyid";
	}
	
		
	@RequestMapping("/viewProduct/{product_id}")
	public @ResponseBody List<ProductDetails>  editProduct(@PathVariable("product_id") int product_id) {
		return productService.getViewProductById(product_id);
		
	}
	
	
	@RequestMapping("/checkout")
	public String cartItem(HttpSession session,Principal activeuser)
	{
		session.setAttribute("cartItem", productService.getCartByUser(activeuser.getName()));
		return "redirect:/cartcheckout";
	}
	
	
	
	@RequestMapping(value = "/shippingaddress")
	public String shippingaddress() {
		return "shippingaddress";
	}
	
	
	
	
	
	/*@RequestMapping(value = "/viewall")
	public String viewall() {
		return "viewall";
	}*/
	
	@RequestMapping(value = "/motobrand")
	public String motobrand() {
		return "motobrand";
	}

	@RequestMapping(value = "/sportwatch")
	public String sportwatch() {
		return "sportwatch";
	}

	@RequestMapping(value = "/huaweibrand")
	public String huaweibrand() {
		return "huaweibrand";
	}

	@RequestMapping(value = "/asusbrand")
	public String asusbrand() {
		return "asusbrand";
	}

	@RequestMapping(value = "/samsungbrand")
	public String samsungbrand() {
		return "samsungbrand";
	}

	@RequestMapping(value = "/intex")
	public String intex() {
		return "intex";
	}

	@RequestMapping(value = "/samsung")
	public String samsung() {
		return "samsung";
	}

	@RequestMapping(value = "/alcatel")
	public String alcatel() {
		return "alcatel";
	}

	@RequestMapping(value = "/apple")
	public String apple() {
		return "apple";
	}

	@RequestMapping(value = "/asus")
	public String asus() {
		return "asus";
	}

	@RequestMapping(value = "/sony")
	public String sony() {
		return "sony";
	}
	
	@RequestMapping(value = "/manage")
	public String manage() {
		return "manage";
	}
	
	@RequestMapping(value = "/loginerror")
	public String loginerror() {
		return "loginerror";
	}
	
	@RequestMapping(value = "/403")
	public String loginerror403() {
		return "403";
	}
	
	/*ProductDetails productDetails=new ProductDetails();
	productDetails.setCartlist(productService.addtocart(product_id));
	session.setAttribute("cartlist",productService.addtocart(product_id));
	
	return "mycart";*/
	
	/*@RequestMapping(value = "/admin")
	public String admin() {
		return "admin";
	}*/
}
