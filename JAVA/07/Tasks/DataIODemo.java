 
import java.io.*; 
 
class DataIODemo { 
  public static void main(String args[]) throws IOException { 
 
	// создаем поток для вывода примитивных данных
    try ( DataOutputStream dout = new DataOutputStream(new FileOutputStream("d:\\test.dat")) ) 
    { 
      // записываем данные
      dout.writeDouble(98.6); 
      dout.writeInt(1000); 
      dout.writeBoolean(true); 
    } catch(FileNotFoundException e) { 
        System.out.println("Нет файла для записи"); 
        return; 
      } catch(IOException e) { 
        System.out.println("Ошибка ввода-вывода: " + e); 
      } 
   
      // создаем поток для ввода примитивных данных
      try ( DataInputStream din = new DataInputStream(new FileInputStream("d:\\test.dat")) ) 
      { 
    	// читаем данные
        double d = din.readDouble(); 
        int i = din.readInt(); 
        boolean b = din.readBoolean(); 
        // выводим значения
        System.out.println("Значения: " + d + " " + i + " " + b); 
      } catch(FileNotFoundException e) { 
        System.out.println("Нет файла для чтения"); 
        return; 
      } catch(IOException e) { 
        System.out.println("Ошибка ввода-вывода: " + e); 
      } 
    } 
  }
