package by.bsuir.shop.main;

import by.bsuir.shop.listener.CalculateButtonListener;
import by.bsuir.shop.model.Product;
import by.bsuir.shop.repository.InMemoryProductRepository;
import by.bsuir.shop.repository.ProductRepository;
import by.bsuir.shop.view.ShopFrame;

public class Executor {

	public static void main(String[] args) {
		CalculateButtonListener listener = new CalculateButtonListener();
		ProductRepository repository = new InMemoryProductRepository();
		fillProductsData(repository);
		ShopFrame shopFrame = new ShopFrame(repository.getProductNames());
		shopFrame.setCalculateButtonListener(listener);
		listener.setShopFrame(shopFrame);
		listener.setProductRepository(repository);
	}

	private static void fillProductsData(ProductRepository repository) {
		repository.addProduct(new Product("������� A", 10.0));
		repository.addProduct(new Product("������� B", 20.0));
		repository.addProduct(new Product("������� C", 30.0));
		repository.addProduct(new Product("������� D", 40.0));
		repository.addProduct(new Product("������� E", 50.0));
		repository.addProduct(new Product("������� F", 60.0));
		repository.addProduct(new Product("������� G", 70.0));
		repository.addProduct(new Product("������� H", 80.0));
		repository.addProduct(new Product("������� I", 90.0));
		repository.addProduct(new Product("������� J", 100.0));
		repository.addProduct(new Product("������� K", 110.0));
		repository.addProduct(new Product("������� L", 120.0));
		repository.addProduct(new Product("������� M", 130.0));
		repository.addProduct(new Product("������� N", 140.0));
		repository.addProduct(new Product("������� O", 150.0));
		repository.addProduct(new Product("������� P", 160.0));
		repository.addProduct(new Product("������� Q", 170.0));
		repository.addProduct(new Product("������� R", 180.0));
		repository.addProduct(new Product("������� S", 190.0));
		repository.addProduct(new Product("������� T", 200.0));
		repository.addProduct(new Product("������� U", 210.0));
		repository.addProduct(new Product("������� V", 220.0));
		repository.addProduct(new Product("������� W", 230.0));
		repository.addProduct(new Product("������� X", 240.0));
		repository.addProduct(new Product("������� Y", 250.0));
		repository.addProduct(new Product("������� Z", 260.0));
	}
}
