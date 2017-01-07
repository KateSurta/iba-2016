package by.bsuir.shop.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import by.bsuir.shop.model.Product;

/**
 * –еализаци€ интерфейса хранилища продуктов. –аботает с объектами продуктов,
 * которые мы создали в стартовом методе.
 */
public class InMemoryProductRepository implements ProductRepository {

	// список продуктов в хранилище
	private List<Product> productList = new ArrayList<Product>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * by.bsuir.shop.repository.ProductRepository#addProduct(by.bsuir.shop.model
	 * .Product) добавл€ет продукт к списку продуктов. ƒокументацию читать в
	 * интерфейсе
	 */
	@Override
	public void addProduct(Product product) {
		if (null != product) {
			productList.add(product);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.bsuir.shop.repository.ProductRepository#getAllProducts()
	 * возвращает копию списка всех продуктов, которую нельз€ будет мен€ть.
	 * ћожно будет только узнать всю информацию о продуктах
	 */
	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) Collections.unmodifiableCollection(productList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * by.bsuir.shop.repository.ProductRepository#getProduct(java.lang.String)
	 * документацию читать в интерфейсе. »щем в списке продуктов продукт с
	 * заданным именем и возвращаем его
	 */
	@Override
	public Product getProduct(String productName) {
		for (Product product : productList) {
			if (product.getName().equals(productName)) {
				return product;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.bsuir.shop.repository.ProductRepository#getProductNames()
	 * документацию читать в интерфейсе. —оздаем множество всех имен продуктов,
	 * добавл€ем в него все имена из списка продуктов, возвращаем множество имен
	 */
	@Override
	public Set<String> getProductNames() {
		Set<String> productNames = new LinkedHashSet<String>();
		for (Product product : productList) {
			productNames.add(product.getName());
		}
		return productNames;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * by.bsuir.shop.repository.ProductRepository#getProductPrice(java.lang.
	 * String) документацию читать в интерфейсе. ѕолучаем продукт из списка по
	 * заданному имени и возвращаем его стоимость
	 */
	@Override
	public double getProductPrice(String productName) {
		Product product = getProduct(productName);
		if (null != product) {
			return product.getPrice();
		}
		return 0.0;
	}

}
