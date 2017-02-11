package patternsdemo.singleton;

public class TestSingleton {
	//ќбъ€вл€ем переменную тип которой совпадает с типом класса

    private static TestSingleton instance;

    public static TestSingleton getInstance() {
        if (instance==null) {
            instance = new TestSingleton();
        }
        return instance;
    }
    
    private TestSingleton() {
    }

    public void print(){
    	//вызывает toString и выводит адрес обьекта(класса) на виртуальной машине( где находитс€)
        System.out.println(this);
    }
    
    public void stop(){
        System.out.println("stop");
    }

}
