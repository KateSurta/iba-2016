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

/**
 * Класс главного окна интерфейса
 */
public class ShopFrame extends JFrame {

	private static final long serialVersionUID = 4799077637267392027L;

	// задаем имя нашего окна (вверху оно будет отображено)
	public static final String FRAME_TITLE = "Магазин";
	// задаем имена чекбоксов вариантов доставки, которые будут отображены
	public static final String[] CHECKBOX_TITLES = { "Самовывоз", "Курьер", "Почта" };
	// задаем имя кнопки для рассчета
	public static final String CALCULATE_BUTTON_TITLE = "Рассчитать";
	// задаем текст для поля количества продуктов
	public static final String PRODUCTS_COUNT_LABEL_TEXT = "Количество товаров для покупки:";

	// задаем ширину и высоту окна
	public static final int WIDTH = 600;
	public static final int HEIGHT = 700;

	// задаем ширину и высоту JList списка всех продуктов
	public static final int PRODUCT_LIST_SCROLLER_WIDTH = 100;
	public static final int PRODUCT_LIST_SCROLLER_HEIGHT = 100;

	// множество имен продуктов
	private Set<String> productNames;

	// главная панель внутри окна. Далее кнопки, JList товаров, поле количества,
	// чекбоксы
	private Container mainPanel;
	private JButton calculateButton;
	private JList<String> productList;
	private JTextField productsCountField;
	private List<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();

	/**
	 * Конструктор главного окна. В него передаем множество всех имен продуктов,
	 * полученных из хранилища
	 * 
	 * @param productNames
	 *            - множество имен продуктов
	 */
	public ShopFrame(Set<String> productNames) {
		// присваиваем имя нашего окна (вверху оно будет отображено)
		super(FRAME_TITLE);
		// создаем менеджер представлния. Например для Windows кнопки будут
		// выглядеть по-своему, для Linux - по своему
		initializeUIManager();
		// задаем имена продуктов
		setProductNames(productNames);
		// задаем размер и делаем окно по центру в строках 75-77
		setLocationRelativeTo(null);
		setSize(new Dimension(WIDTH, HEIGHT));
		centreWindow(this);
		mainPanel = getContentPane();
		JPanel checkBoxPanel = new JPanel();
		calculateButton = new JButton(CALCULATE_BUTTON_TITLE);
		// создаем JList продуктов и добавляем его в центр главной панели
		mainPanel.add(createProductList(), BorderLayout.CENTER);
		// задаем чекбоксы и добавляем их в список чекбоксов и в панель
		// чекбоксов
		for (String checkBoxTitle : CHECKBOX_TITLES) {
			JCheckBox deliveryCheckbox = new JCheckBox(checkBoxTitle);
			checkBoxList.add(deliveryCheckbox);
			checkBoxPanel.add(deliveryCheckbox);
		}
		// добавляем панель чекбоксов в "северную" верхнюю часть главной панели
		mainPanel.add(checkBoxPanel, BorderLayout.NORTH);
		JPanel productsCountPanel = new JPanel();
		JLabel productsCountLabel = new JLabel(PRODUCTS_COUNT_LABEL_TEXT);
		productsCountField = new JTextField(5);
		// добавляем в панель количства продуктов JLabel с текстом, JTextField -
		// поле для ввода и кнопку рассчета
		productsCountPanel.add(productsCountLabel);
		productsCountPanel.add(productsCountField);
		productsCountPanel.add(calculateButton);
		// добавляем панель количества продуктов в "юг" низ окна
		mainPanel.add(productsCountPanel, BorderLayout.SOUTH);
		// задаем, чтобы при нажатии "крестика" в правом верху окно закрывалось
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// делаем окно видимым
		setVisible(true);
	}

	/**
	 * Метод для отображения диалогового окна с заданным сообщением пользователю
	 * 
	 * @param message
	 *            - сообщение для показа
	 */
	public void showMessage(String message) {
		// показываем сообщение в главной панели
		JOptionPane.showMessageDialog(mainPanel, message);
	}

	/**
	 * Добавляем слушатель на кнопку рассчета
	 * 
	 * @param listener
	 *            - объект слушателя
	 */
	public void setCalculateButtonListener(ActionListener listener) {
		calculateButton.addActionListener(listener);
	}

	/**
	 * Метод возвращает выбранное в JList списке продуктов имя продукта
	 * 
	 * @return имя выбранного продукта
	 */
	public String getSelectedProduct() {
		return productList.getSelectedValue();
	}

	/**
	 * Метод возвращает количество продуктов, введенное в JTextField
	 * 
	 * @return текст, введенный в JTextField
	 */
	public String getProductsCount() {
		return productsCountField.getText();
	}

	/**
	 * Задаем множество имен продуктов
	 * 
	 * @param productNames
	 *            - множество имен продуктов
	 */
	public void setProductNames(Set<String> productNames) {
		this.productNames = productNames;
	}

	/**
	 * Метод возвращает boolean значение был ли выбран хоть один чекбокс.
	 * 
	 * @return true - если хоть один чекбокс выбран, false иначе
	 */
	public boolean isCheckboxSelected() {
		for (JCheckBox checkBox : checkBoxList) {
			if (checkBox.isSelected() == true) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Делаем отображение окна по центру экрана монитора. Для этого получает
	 * значение координат экрана, смещаем на половину и отображаем там окно
	 * 
	 * @param frame
	 *            - окно, которое необходимо отобразить по центру экрана
	 */
	private void centreWindow(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

	/**
	 * Создаем список продуктов JList. В него передаем все массив всех имен
	 * продуктов для отображения. Создаем скроллер в случае, если продуктов
	 * много. Устанавливаем значение размеров скроллера и возращаем всю панель
	 * со списком продуктов и скроллером
	 * 
	 * @return
	 */
	private JScrollPane createProductList() {
		// создаем JList. В конструктор передаем массив всех имен продуктов для
		// отображения
		productList = new JList<String>(getProducts());
		JScrollPane productListScroller = new JScrollPane(productList);
		productListScroller.setPreferredSize(new Dimension(PRODUCT_LIST_SCROLLER_WIDTH, PRODUCT_LIST_SCROLLER_HEIGHT));
		return productListScroller;
	}

	/**
	 * Множество всех имен продуктов преобразуем в массив. Возвращаем массив
	 * всех имен продуктов
	 * 
	 * @return массив всех имен продуктов
	 */
	private String[] getProducts() {
		return productNames.toArray(new String[productNames.size()]);
	}

	/**
	 * Инициализируем внешний вид интерфейса. Так, он будет отличаться для
	 * Windows, Linux, других систем.
	 */
	private void initializeUIManager() {
		try {
			// получаем и задаем стандартный вид элементов (кнопок, полей ввода
			// и т.д.) нашей операционной системы. Выводим сообщение в случае
			// ошибки инициализации
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			showMessage("Не удалось инициализировать UI менеджер");
		}
	}
}
