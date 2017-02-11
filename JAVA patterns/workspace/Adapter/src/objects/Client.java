package objects;

import java.util.ArrayList;
import java.util.List;

import adapter.PageListPrinter;
import adapter.PrinterAdapter;


public class Client {
    
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("text1");
        list.add("text2");
        list.add("text3");
                
        
        PageListPrinter printerAdapter = new PrinterAdapter();
        printerAdapter.print(list);
    }

}
