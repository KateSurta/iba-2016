// Пример использования JList.
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/*
  <applet code="ListDemo" width=200 height=120>
  </applet>
*/

public class ListDemo extends JApplet {
  JList<String> jlst;
  JLabel jlab;
  JScrollPane jscrlp;

  // создаем массив элементов
  String Cities[] = { "Брест", "Витебск", "Гомель",
                      "Гродно", "Минск", "Могилев"};

  public void init() {
    try {
      SwingUtilities.invokeAndWait(
        new Runnable() {
          public void run() {
            makeGUI();
          }
        }
      );
    } catch (Exception exc) {
      System.out.println("Ошибка создания апплета " + exc); 
    }
  }

  private void makeGUI() {

    setLayout(new FlowLayout());

    // создаем JList (на основе заготовленного списка)
    jlst = new JList<String>(Cities);

    // переключаем список в режим единственного выбора
    jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    // укладываем его в панель прокрутки
    jscrlp = new JScrollPane(jlst);

    // и устанавливаем ее размер
    jscrlp.setPreferredSize(new Dimension(120, 90));

    // метка для отображения результатов выбора
    jlab = new JLabel("Выберите город");

    // добавляем обработчик событий для списка
    jlst.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent le) {
        // получаем номер "сработавшего" элемента
        int idx = jlst.getSelectedIndex();
        // отображаем результат выбора 
        if(idx != -1)
          jlab.setText("Выбран город: " + Cities[idx]);
        else // ничего не выбрано - спросим еще раз
          jlab.setText("Выберите город");

      }
    });

    // добавляем панель со списком и метку на апплет
    add(jscrlp);
    add(jlab);
  }
}