package by.bsuir.shop.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import by.bsuir.shop.repository.ProductRepository;
import by.bsuir.shop.view.ShopFrame;

public class CalculateButtonListener implements ActionListener {

	private int productsCount;
	private double productPrice;
	private ShopFrame shopFrame;
	private ProductRepository repository;

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String productName = shopFrame.getSelectedProduct();
			checkFormCorrectness(shopFrame.getSelectedProduct(), shopFrame.getProductsCount());
			double totalPrice = productPrice * productsCount;
			StringBuilder message = new StringBuilder("�� ������� ");
			message.append(productsCount);
			message.append(" �����(-��) � ������������� ");
			message.append(productName);
			message.append(". �������� ��������� = ");
			message.append(totalPrice);
			shopFrame.showMessage(message.toString());
			saveToFile(message);
		} catch (FileNotFoundException | NullPointerException | IllegalArgumentException exception) {
			shopFrame.showMessage(exception.getMessage());
		}
	}

	private void checkFormCorrectness(String productName, String productsCountString) {
		StringBuilder builder = new StringBuilder();
		if (!shopFrame.isCheckboxSelected()) {
			builder.append("����������, �������� ������ ��������.\n");
		}
		if (null != productsCountString && !"".equals(productsCountString)) {
			productsCount = Integer.valueOf(productsCountString);
		}
		if (productsCount <= 0) {
			builder.append("���������� ��������� ������ ���� > 0.\n");
		}
		if (null == productName) {
			builder.append("����������, �������� ������� ��� �������");
		} else {
			this.productPrice = repository.getProductPrice(productName);
		}
		if (builder.length() > 0) {
			throw new IllegalArgumentException(builder.toString());
		}
	}

	public void setShopFrame(ShopFrame shopFrame) {
		this.shopFrame = shopFrame;
	}

	public void setProductRepository(ProductRepository repository) {
		this.repository = repository;
	}

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
