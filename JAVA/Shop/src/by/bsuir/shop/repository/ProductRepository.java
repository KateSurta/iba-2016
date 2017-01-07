package by.bsuir.shop.repository;

import java.util.List;
import java.util.Set;

import by.bsuir.shop.model.Product;

/**
 * Интерфейс, позволяющий определить основные методы для хранилища продуктов
 */
public interface ProductRepository {

	/**
	 * абстрактный метод добавления продукта в хранилище
	 * 
	 * @param product
	 *            - продукт для добавления
	 */
	public void addProduct(Product product);

	/**
	 * абстрактный метод для получения продукта из хранилища по его имени
	 * 
	 * @param productName
	 *            - имя продукта
	 * @return - объект продукта с заданным именем или null, если нет такого в
	 *         хранилище
	 */
	public Product getProduct(String productName);

	/**
	 * абстрактный метод для получения всех продуктов из хранилища
	 * 
	 * @return список всех продуктов
	 */
	public List<Product> getAllProducts();

	/**
	 * абстрактный метод для получения множества всех имен продуктов
	 * 
	 * @return множество имен продуктов в хранилище
	 */
	public Set<String> getProductNames();

	/**
	 * абстрактный метод для получения цены продукта по его имени
	 * 
	 * @param productName
	 *            - имя продукта
	 * @return цена продукта с таким именем
	 */
	public double getProductPrice(String productName);
}
