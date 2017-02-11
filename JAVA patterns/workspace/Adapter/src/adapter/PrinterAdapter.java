package adapter;

import java.util.List;
import objects.Printer;


public class PrinterAdapter implements PageListPrinter{

    private Printer printer = new Printer();
    
    
    public void print(List<String> list) {
        for (String text : list) {
            printer.print(text);            
        }
    }
 
}
