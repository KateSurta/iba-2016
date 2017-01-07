package by.bsuir.shop.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import by.bsuir.shop.model.Product;

public class InMemoryProductRepository implements ProductRepository {

	private List<Product> productList = new ArrayList<Product>();

	@Override
	public void addProduct(Product product) {
		if (null != product) {
			productList.add(product);
		}
	}

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) Collections.unmodifiableCollection(productList);
	}

	@Override
	public Product getProduct(String productName) {
		for (Product product : productList) {
			if (product.getName().equals(productName)) {
				return product;
			}
		}
		return null;
	}

	@Override
	public Set<String> getProductNames() {
		Set<String> productNames = new LinkedHashSet<String>();
		for (Product product : productList) {
			productNames.add(product.getName());
		}
		return productNames;
	}

	@Override
	public double getProductPrice(String productName) {
		Product product = getProduct(productName);
		if (null != product) {
			return product.getPrice();
		}
		return 0.0;
	}

}
