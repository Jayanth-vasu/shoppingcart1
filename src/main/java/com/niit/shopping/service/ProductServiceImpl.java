package com.niit.shopping.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopping.dao.ProductDAO;
import com.niit.shopping.model.Cart;
import com.niit.shopping.model.ProductDetails;
import com.niit.shopping.model.ShippingAddress;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired ProductDAO productDAO;
	
	@Transactional
	public void addProduct(ProductDetails productDetails) {
		productDAO.addProduct(productDetails);

	}

	@Transactional
	public void updateProduct(ProductDetails productDetails) {
		productDAO.updateProduct(productDetails);

	}

	@Transactional
	public List<ProductDetails> listProducts() {
		
		return productDAO.listProducts();
	}

	@Transactional
	public ProductDetails getProductById(int product_id) {
		
		return productDAO.getProductById(product_id);
	}

	@Transactional
	public void removeProduct(int product_id) {
		productDAO.removeProduct(product_id);

	}

	@Override
	public List<ProductDetails> listBrands() {
		
		return productDAO.listBrands();
	}

	@Override
	public List<ProductDetails> getProductByBrand(String product_brand) {
		
		return productDAO.getProductByBrand(product_brand);
	}
	
	@Override
	public List<ProductDetails> getViewProductById(int product_id) {
		
		return productDAO.getViewProductById(product_id);
	}



	/*@Override
	public void addcart(int product_id) {
		 productDAO.addcart(product_id);
		
	}*/

	@Override
	public void addCartProduct(Cart cart) {
		productDAO.addCartProduct(cart);
		
	}

	@Override
	public List<Cart> getCartByUser(String username) {
		
		return productDAO.getCartByUser(username);
	}

	@Override
	public List<Cart> getTotalPrice(String username) {
		
		return productDAO.getTotalPrice(username);
	}

	@Override
	public void removeCartProduct(int cart_id) {
		
		productDAO.removeCartProduct(cart_id);
	}

	@Override
	public Cart getCartById(int cart_id) {
		
		return productDAO.getCartById(cart_id);
	}

	@Override
	public void clearall(String username) {
		productDAO.clearall(username);
		
	}

	@Override
	public Set<ProductDetails> getCartProductById(int product_id) {
		
		return productDAO.getCartProductById(product_id);
	}

	@Override
	public boolean checkProduct(Cart cart) {
		boolean check=false;
	    check=productDAO.checkProduct(cart);
	    if(check==true){
	    	check=true;
	    }
	    return check;
	}

	@Override
	public boolean checkCart() {
		boolean check=false;
	    check=productDAO.checkProduct();
	    if(check==true){
	    	check=true;
	    }
	    return check;

	}

	@Override
	public int cartNumber(String username) {
		
		return productDAO.cartNumber(username);
	}

	@Override
	public void saveAddress(ShippingAddress shippingaddress) {
		
		productDAO.saveAddress(shippingaddress);
	}

	@Override
	public List<ProductDetails> listsmartnotifiers() {
		
		return productDAO.listsmartnotifiers() ;
	}

	@Override
	public List<ProductDetails> listwatchphones() {
		
		return productDAO.listwatchphones() ;
	}

	@Override
	public List<ProductDetails> listhealth() {
		
		return productDAO.listhealth();
	}

	@Override
	public List<ProductDetails> listfitness() {
		// TODO Auto-generated method stub
		return productDAO.listfitness();
	}

	

}
