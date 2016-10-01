package com.niit.shopping.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopping.model.Cart;
import com.niit.shopping.model.ProductDetails;
import com.niit.shopping.model.ShippingAddress;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory session;

	@Override
	public void addProduct(ProductDetails productDetails) {
		session.getCurrentSession().save(productDetails);

	}

	@Override
	public void updateProduct(ProductDetails productDetails) {
		session.getCurrentSession().update(productDetails);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDetails> listProducts() {

		return (List<ProductDetails>) session.getCurrentSession().createQuery("from ProductDetails").list();

	}

	@Override
	public ProductDetails getProductById(int product_id) {

		return (ProductDetails) session.getCurrentSession().get(ProductDetails.class, product_id);
	}

	@Override
	public void removeProduct(int product_id) {
		session.getCurrentSession().delete(getProductById(product_id));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDetails> listBrands() {

		return (List<ProductDetails>) session.getCurrentSession()
				.createQuery("select distinct product_brand from ProductDetails").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDetails> getProductByBrand(String product_brand) {
		String hql = "from ProductDetails where product_brand=" + "'" + product_brand + "'";
		Query query = session.getCurrentSession().createQuery(hql);
		List<ProductDetails> getProductByBrand = (List<ProductDetails>) query.list();
		return getProductByBrand;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDetails> getViewProductById(int product_id) {
		String hql = "from ProductDetails where product_id=" + "'" + product_id + "'";
		Query query = session.getCurrentSession().createQuery(hql);
		List<ProductDetails> getViewProductById = (List<ProductDetails>) query.list();
		return getViewProductById;

	}

	@Override
	public void addCartProduct(Cart cart) {
		session.getCurrentSession().save(cart);
		

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> getCartByUser(String username) {
		String hql = "from Cart where mail_id=" + "'" + username + "'";
		Query query = session.getCurrentSession().createQuery(hql);
		List<Cart> getCartByUser = (List<Cart>) query.list();
		return getCartByUser;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> getTotalPrice(String username) {
		String hql = "select sum(productPrice) from Cart where mail_id=" + "'" + username + "'";
		Query query = session.getCurrentSession().createQuery(hql);
		List<Cart> getTotalPrice = (List<Cart>) query.list();
		return getTotalPrice;

		
	}

	@Override
	public void removeCartProduct(int cart_id) {
	
		session.getCurrentSession().delete(getCartById(cart_id));
	}

	
	@Override
	public Cart getCartById(int cart_id) {

		return (Cart) session.getCurrentSession().get(Cart.class, cart_id);
	}

	@Override
	public void clearall(String username) {
		  session.getCurrentSession().createQuery("delete from Cart where mail_id="+"'"+username+"'").executeUpdate();
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public Set<ProductDetails> getCartProductById(int product_id) {
		String hql = "from ProductDetails where product_id=" + "'" + product_id + "'";
		Query query = session.getCurrentSession().createQuery(hql);
		Set<ProductDetails> getCartProductById =  (Set<ProductDetails>) query.list();
		return getCartProductById;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean checkProduct(Cart cart) {
		boolean isvalid=false;
		
		Query q=session.openSession().createQuery("from Cart where product_id='"+cart.getProduct_id()+"' and mail_id='"+cart.getCheckUser()+"'");
		
		List<Cart> ul= q.list();
		int s=ul.size();
		if(s==1)
		{
			isvalid=true;
		}
		
		return isvalid;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkProduct() {
boolean isvalid=false;
		
		Query q=session.openSession().createQuery("from Cart");
		
		List<Cart> ul= q.list();
		int s=ul.size();
		if(s==1)
		{
			isvalid=true;
		}
		
		return isvalid;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public int cartNumber(String username) {
		Query q=session.openSession().createQuery("from Cart where mail_id="+"'"+username+"'");
		List<Cart> ul= q.list();
		int s=ul.size();
		return s;
	}

	@Override
	public void saveAddress(ShippingAddress shippingaddress) {
		session.getCurrentSession().save(shippingaddress);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDetails> listsmartnotifiers() {
		String hql = "from ProductDetails where product_category='Smart Notifiers'";
		Query query = session.getCurrentSession().createQuery(hql);
		List<ProductDetails> getProductByBrand = (List<ProductDetails>) query.list();
		return getProductByBrand;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDetails> listwatchphones() {
		
		String hql = "from ProductDetails where product_category='Watch Phones'";
		Query query = session.getCurrentSession().createQuery(hql);
		List<ProductDetails> getProductByBrand = (List<ProductDetails>) query.list();
		return getProductByBrand;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDetails> listhealth() {
		
		String hql = "from ProductDetails where product_category='Health & Medical'";
		Query query = session.getCurrentSession().createQuery(hql);
		List<ProductDetails> getProductByBrand = (List<ProductDetails>) query.list();
		return getProductByBrand;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDetails> listfitness() {
		
		String hql = "from ProductDetails where product_category='Fitness & Outdoor'";
		Query query = session.getCurrentSession().createQuery(hql);
		List<ProductDetails> getProductByBrand = (List<ProductDetails>) query.list();
		return getProductByBrand;
	}

	
	}
