// ������ � ����������� �������
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
  <applet code="ToggleDemo" width=200 height=80>
  </applet>
*/

public class ToggleDemo extends JApplet {

  // ������� ��� ����� � ������
  JLabel jlab;
  JToggleButton jtbn;

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
        System.out.println("������ ������� ������� " + exc);
      }
    }

    private void makeGUI() {

      // ���������� ������� ������������ �����������
      setLayout(new FlowLayout());

      // ������� �����
      jlab = new JLabel("������ ����.");

      // ������� ������
      jtbn =  new JToggleButton("���/����");

      // ��������� ����������
      jtbn.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent ie) {
          if(jtbn.isSelected())
            jlab.setText("������ ���.");
          else
            jlab.setText("������ ����.");
        }

      });

      // Add the toggle button and label to the content pane.
      add(jtbn);
      add(jlab);
    }
  }