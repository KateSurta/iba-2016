// пример JTable.
import java.awt.*;
import javax.swing.*;

/*
  <applet code="JTableDemo" width=400 height=200>
  </applet>
*/

public class TableDemo extends JApplet {

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

    // массив заголовков
    String[] colHeads = { "Имя", "ВнНомер", "ТабНомер" };

    // сами данные - двумерный массив (на три столбца)
    Object[][] data = {
      { "Иван", "4567", "865" },
      { "Михаил", "7566", "555" },
      { "Никифор", "5634", "587" },
      { "Маланья", "7345", "922" },
      { "Анастасия", "1237", "333" },
      { "Константин", "5656", "314" },
      { "Василий", "5672", "217" },
      { "Иван", "6741", "444" },
      { "Ольга", "9023", "519" },
      { "Анастасия", "1134", "532" },
      { "Гражина", "5689", "112" },
      { "Кирилл", "9030", "133" },
      { "Елена", "6751", "145" }
    };

    // создаем таблицу, передавая массив колонок и массив данных
    JTable table = new JTable(data, colHeads);

    // добавляем таблицу в панель прокрутки и выкладываем ее (панель) на апплет
    JScrollPane jsp = new JScrollPane(table);
    add(jsp);
  }
}