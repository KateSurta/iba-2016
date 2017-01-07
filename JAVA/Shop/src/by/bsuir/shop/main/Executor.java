package by.bsuir.shop.main;

import by.bsuir.shop.listener.CalculateButtonListener;
import by.bsuir.shop.model.Product;
import by.bsuir.shop.repository.InMemoryProductRepository;
import by.bsuir.shop.repository.ProductRepository;
import by.bsuir.shop.view.ShopFrame;

/**
 * Главный класс, с которого начинается выполнение программы
 *
 */
public class Executor {

	/**
	 * Стартовый метод
	 */
	public static void main(String[] args) {
		// создаем объект слушателя, который будет обрабатывать нажатие кнопки
		CalculateButtonListener listener = new CalculateButtonListener();
		// создаем объект хранилища, которое будет содержать все продукты
		ProductRepository repository = new InMemoryProductRepository();
		// заполняем хранилище продуктами
		fillProductsData(repository);
		// создаем объект главного окна приложения, на котором будут отображены
		// все элементы
		ShopFrame shopFrame = new ShopFrame(repository.getProductNames());
		// добавляем слушателя к кнопке в главном окне
		shopFrame.setCalculateButtonListener(listener);
		// задаем слушателю окно, из которого он будет брать необходимые данные
		listener.setShopFrame(shopFrame);
		// задаем слушателю хранилище продуктов, откуда он будет получать
		// продукты для рассчета
		listener.setProductRepository(repository);
	}

	/**
	 * Метод заполнения хранилища продуктов. Создаем объекты продуктов, которым
	 * задаем название и стоимость. Все продукты добавляем в хранилище
	 * 
	 * @param repository
	 *            - объект хранилища, который будем заполнять
	 */
	private static void fillProductsData(ProductRepository repository) {
		repository.addProduct(new Product("Продукт A", 10.0));
		repository.addProduct(new Product("Продукт B", 20.0));
		repository.addProduct(new Product("Продукт C", 30.0));
		repository.addProduct(new Product("Продукт D", 40.0));
		repository.addProduct(new Product("Продукт E", 50.0));
		repository.addProduct(new Product("Продукт F", 60.0));
		repository.addProduct(new Product("Продукт G", 70.0));
		repository.addProduct(new Product("Продукт H", 80.0));
		repository.addProduct(new Product("Продукт I", 90.0));
		repository.addProduct(new Product("Продукт J", 100.0));
		repository.addProduct(new Product("Продукт K", 110.0));
		repository.addProduct(new Product("Продукт L", 120.0));
		repository.addProduct(new Product("Продукт M", 130.0));
		repository.addProduct(new Product("Продукт N", 140.0));
		repository.addProduct(new Product("Продукт O", 150.0));
		repository.addProduct(new Product("Продукт P", 160.0));
		repository.addProduct(new Product("Продукт Q", 170.0));
		repository.addProduct(new Product("Продукт R", 180.0));
		repository.addProduct(new Product("Продукт S", 190.0));
		repository.addProduct(new Product("Продукт T", 200.0));
		repository.addProduct(new Product("Продукт U", 210.0));
		repository.addProduct(new Product("Продукт V", 220.0));
		repository.addProduct(new Product("Продукт W", 230.0));
		repository.addProduct(new Product("Продукт X", 240.0));
		repository.addProduct(new Product("Продукт Y", 250.0));
		repository.addProduct(new Product("Продукт Z", 260.0));
	}
}
