package by.bsuir.shop.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ShopFrame extends JFrame {

	private static final long serialVersionUID = 4799077637267392027L;

	public static final String FRAME_TITLE = "Магазин";
	public static final String[] CHECKBOX_TITLES = { "Самовывоз", "Курьер", "Почта" };
	public static final String CALCULATE_BUTTON_TITLE = "Рассчитать";
	public static final String PRODUCTS_COUNT_LABEL_TEXT = "Количество товаров для покупки:";

	public static final int WIDTH = 600;
	public static final int HEIGHT = 700;

	public static final int PRODUCT_LIST_SCROLLER_WIDTH = 100;
	public static final int PRODUCT_LIST_SCROLLER_HEIGHT = 100;

	private Set<String> productNames;

	private Container mainPanel;
	private JButton calculateButton;
	private JList<String> productList;
	private JTextField productsCountField;
	private List<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();

	public ShopFrame(Set<String> productNames) {
		super(FRAME_TITLE);
		initializeUIManager();
		setProductNames(productNames);
		setLocationRelativeTo(null);
		setSize(new Dimension(WIDTH, HEIGHT));
		centreWindow(this);
		mainPanel = getContentPane();
		JPanel checkBoxPanel = new JPanel();
		calculateButton = new JButton(CALCULATE_BUTTON_TITLE);
		mainPanel.add(createProductList(), BorderLayout.CENTER);
		for (String checkBoxTitle : CHECKBOX_TITLES) {
			JCheckBox deliveryCheckbox = new JCheckBox(checkBoxTitle);
			checkBoxList.add(deliveryCheckbox);
			checkBoxPanel.add(deliveryCheckbox);
		}
		mainPanel.add(checkBoxPanel, BorderLayout.NORTH);
		JPanel productsCountPanel = new JPanel();
		JLabel productsCountLabel = new JLabel(PRODUCTS_COUNT_LABEL_TEXT);
		productsCountField = new JTextField(5);
		productsCountPanel.add(productsCountLabel);
		productsCountPanel.add(productsCountField);
		productsCountPanel.add(calculateButton);
		mainPanel.add(productsCountPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(mainPanel, message);
	}

	public void setCalculateButtonListener(ActionListener listener) {
		calculateButton.addActionListener(listener);
	}

	public String getSelectedProduct() {
		return productList.getSelectedValue();
	}

	public String getProductsCount() {
		return productsCountField.getText();
	}

	public void setProductNames(Set<String> productNames) {
		this.productNames = productNames;
	}

	public boolean isCheckboxSelected() {
		for (JCheckBox checkBox : checkBoxList) {
			if (checkBox.isSelected() == true) {
				return true;
			}
		}
		return false;
	}

	private void centreWindow(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

	private JScrollPane createProductList() {
		productList = new JList<String>(getProducts());
		JScrollPane productListScroller = new JScrollPane(productList);
		productListScroller.setPreferredSize(new Dimension(PRODUCT_LIST_SCROLLER_WIDTH, PRODUCT_LIST_SCROLLER_HEIGHT));
		return productListScroller;
	}

	private String[] getProducts() {
		return productNames.toArray(new String[productNames.size()]);
	}

	private void initializeUIManager() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			showMessage("Не удалось инициализировать UI менеджер");
		}
	}
}
