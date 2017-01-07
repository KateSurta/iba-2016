package by.bsuir.shop.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import by.bsuir.shop.repository.ProductRepository;
import by.bsuir.shop.view.ShopFrame;

/**
 * Класс-слушатель. Задача объектов этого класса - проверить правильность
 * введенной формы, рассчитать стоимость продуктов и сохранить результаты в файл
 *
 */
public class CalculateButtonListener implements ActionListener {

	// количество продуктов
	private int productsCount;
	// цена выбранного продукта
	private double productPrice;
	// окно, откуда получаем данные
	private ShopFrame shopFrame;
	// хранилище продуктов, откуда получаем данные о продуктах
	private ProductRepository repository;

	/*
	 * Этот метод будет вызван при нажатии на кнопку "Рассчитать". В нем
	 * происходит вся логика
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// получаем имя выбранного продукта из главного окна
			String productName = shopFrame.getSelectedProduct();
			// проверяем форму на корректность введенных данных
			checkFormCorrectness(shopFrame.getSelectedProduct(), shopFrame.getProductsCount());
			// считаем итоговую стоимость как цену продукта умноженную на
			// количество продуктов
			double totalPrice = productPrice * productsCount;
			// формируем итоговое сообшение
			StringBuilder message = new StringBuilder("Вы выбрали ");
			message.append(productsCount);
			message.append(" товар(-ов) с наименованием ");
			message.append(productName);
			message.append(". Итоговая стоимость = ");
			message.append(totalPrice);
			// показываем сообщение в главном окне
			shopFrame.showMessage(message.toString());
			// сохраняем результаты в файл
			saveToFile(message);
		} catch (FileNotFoundException | NullPointerException | IllegalArgumentException exception) {
			// в случае возникновения ошибки выводим пользователю сообщение об
			// ошибке
			shopFrame.showMessage(exception.getMessage());
		}
	}

	/**
	 * Метод проверяет правильность введенных данных.
	 * 
	 * @param productName
	 *            - имя продукта
	 * @param productsCountString
	 *            - строка с количеством продуктов
	 */
	private void checkFormCorrectness(String productName, String productsCountString) {
		StringBuilder builder = new StringBuilder();
		// если не выбран ни один из способов - добавляем в сообщение
		// соответствующий текст
		if (!shopFrame.isCheckboxSelected()) {
			builder.append("Пожалуйста, выберите способ доставки.\n");
		}
		// если строка с количеством продуктов не пустая - преобразуем ее в int
		// значение
		if (null != productsCountString && !"".equals(productsCountString)) {
			productsCount = Integer.valueOf(productsCountString);
		}
		// если количество продуктов отрицательное - добавляем в сообщение
		// соответствующий текст
		if (productsCount <= 0) {
			builder.append("Количество продуктов должно быть > 0.\n");
		}
		// если ни один из продуктов не был выбран - добавляем в сообщение
		// соответствующий текст. Иначе получаем от хранилища продуктов цену
		// продукта, соответствующее его имени
		if (null == productName) {
			builder.append("Пожалуйста, выберите продукт для покупки");
		} else {
			this.productPrice = repository.getProductPrice(productName);
		}
		// если итоговое сообщение получилось не пустым - выкидываем исключение
		// с этим сообщением
		if (builder.length() > 0) {
			throw new IllegalArgumentException(builder.toString());
		}
	}

	/**
	 * задаем окно, из которого будем получать данные
	 * 
	 * @param shopFrame
	 *            - объект окна
	 */
	public void setShopFrame(ShopFrame shopFrame) {
		this.shopFrame = shopFrame;
	}

	/**
	 * задаем хранилище продуктов, из которого узнаем цену продукта
	 * 
	 * @param repository
	 *            - объект хранилища продуктов
	 */
	public void setProductRepository(ProductRepository repository) {
		this.repository = repository;
	}

	/**
	 * Метод сохранение итогового сообщения в файл. Имя файла - results.txt.
	 * Файл находится в папке проекта
	 * 
	 * @param message
	 *            - сообщение, которое нужно сохранить
	 */
	private void saveToFile(StringBuilder message) throws FileNotFoundException {
		PrintWriter out = null;
		try {
			out = new PrintWriter("results.txt");
			out.print(message);
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}
}
