
import java.io.File; 

// Задание:
// - сделать приложение интерактивным (ввод имени файла пользователем)
// - выводить только объекты, соответствующие опр.условиям (файлы, каталоги и т.д.)
 
class FileDemo { 
  static void p(String s) { 
    System.out.println(s); 
  } 
 
  public static void main(String args[]) {
	// создаем объект файла
    File f1 = new File("d:\\test.txt"); 
 
    // получаем имя
    p("File Name: " + f1.getName());
    // путь
    p("Path: " + f1.getPath());
    // абсолютный путь
    p("Abs Path: " + f1.getAbsolutePath());
    // родительский объект
    p("Parent: " + f1.getParent());
    // факт существования
    p(f1.exists() ? "exists" : "does not exist");
    // параметры чтения и записи
    p(f1.canWrite() ? "is writeable" : "is not writeable"); 
    p(f1.canRead() ? "is readable" : "is not readable");
    // каталог?
    p("is " + (f1.isDirectory() ? "" : "not" + " a directory"));
    // реальный файл?
    p(f1.isFile() ? "is normal file" : "might be a named pipe"); 
    p(f1.isAbsolute() ? "is absolute" : "is not absolute");
    // дата последней модификации
    p("File last modified: " + f1.lastModified());
    // размер в байтах
    p("File size: " + f1.length() + " Bytes"); 
  } 
}
