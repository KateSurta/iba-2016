import java.io.File; 
 
class DirList { 
  public static void main(String args[]) {
	// имя каталога 
    String dirname = "d:\\";
    // создаем объект
    File f1 = new File(dirname);
    // точно каталог?
    if (f1.isDirectory()) { 
        System.out.println("Каталог " + dirname);
        // список содержимого
        String s[] = f1.list(); 
   
        // выводим файлы и подкаталоги
        for (int i=0; i < s.length; i++) {
          // конструируем объект содержимого
          File f = new File(dirname + "/" + s[i]);
          // выводим его тип и название
          if (f.isDirectory()) { 
            System.out.println(s[i] + " - каталог"); 
          } else { 
            System.out.println(s[i] + " - файл"); 
          } 
        } 
      } else { 
        System.out.println(dirname + " не каталог"); 
      } 
    } 
  }
