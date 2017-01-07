// пример работы с JTree.
import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.tree.*;
/*
  <applet code="TreeDemo" width=400 height=200>
  </applet>
*/
 
public class TreeDemo extends JApplet {
	  // объект дерева
	  JTree tree;
	  JLabel jlab;

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

		    // создаем узел верхнего уровня
		    DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options");

		    // создаем поддерево "A".
		    DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
		    top.add(a);
		    DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("A1");
		    a.add(a1);
		    DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("A2");
		    a.add(a2);

		    // создаем поддерево "B".
		    DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");
		    top.add(b);
		    DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("B1");
		    b.add(b1);
		    DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("B2");
		    b.add(b2);
		    DefaultMutableTreeNode b3 = new DefaultMutableTreeNode("B3");
		    b.add(b3);

		    // создаем объект дерева, передавая указатель на объект "корня"
		    tree = new JTree(top);

		    // добавляем дерево в прокручиваемую панель
		    JScrollPane jsp = new JScrollPane(tree);

		    // а саму панель - на апплет
		    add(jsp);
		    
		    // обработчик для событий выбора элемента
		    tree.addTreeSelectionListener(new TreeSelectionListener() {
		      public void valueChanged(TreeSelectionEvent tse) {
		        jlab.setText("Выбрано: " + tse.getPath());
		      }
		    });


		    // метка для результата
		    jlab = new JLabel();
		    add(jlab, BorderLayout.SOUTH);
		    
		  }
		}