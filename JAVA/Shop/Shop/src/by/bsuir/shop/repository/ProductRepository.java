package by.bsuir.shop.repository;

import java.util.List;
import java.util.Set;

import by.bsuir.shop.model.Product;

public interface ProductRepository {

	public void addProduct(Product product);

	public Product getProduct(String productName);

	public List<Product> getAllProducts();

	public Set<String> getProductNames();

	public double getProductPrice(String productName);
}
