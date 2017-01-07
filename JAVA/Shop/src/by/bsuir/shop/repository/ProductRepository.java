package by.bsuir.shop.repository;

import java.util.List;
import java.util.Set;

import by.bsuir.shop.model.Product;

/**
 * ���������, ����������� ���������� �������� ������ ��� ��������� ���������
 */
public interface ProductRepository {

	/**
	 * ����������� ����� ���������� �������� � ���������
	 * 
	 * @param product
	 *            - ������� ��� ����������
	 */
	public void addProduct(Product product);

	/**
	 * ����������� ����� ��� ��������� �������� �� ��������� �� ��� �����
	 * 
	 * @param productName
	 *            - ��� ��������
	 * @return - ������ �������� � �������� ������ ��� null, ���� ��� ������ �
	 *         ���������
	 */
	public Product getProduct(String productName);

	/**
	 * ����������� ����� ��� ��������� ���� ��������� �� ���������
	 * 
	 * @return ������ ���� ���������
	 */
	public List<Product> getAllProducts();

	/**
	 * ����������� ����� ��� ��������� ��������� ���� ���� ���������
	 * 
	 * @return ��������� ���� ��������� � ���������
	 */
	public Set<String> getProductNames();

	/**
	 * ����������� ����� ��� ��������� ���� �������� �� ��� �����
	 * 
	 * @param productName
	 *            - ��� ��������
	 * @return ���� �������� � ����� ������
	 */
	public double getProductPrice(String productName);
}
