
public class my_test_sigleton {
	
	private static my_test_sigleton instance;
	
	
	 public static my_test_sigleton getInstance() {
	        if (instance==null) {
	            instance = new my_test_sigleton();
	        }
	        return instance;
	 }		
	 
	 private my_test_sigleton() {
	    }

	    public void print(){
	    	//�������� toString � ������� ����� �������(������) �� ����������� ������( ��� ���������)
	        System.out.println(this);
	    }
	    
	    public void stop(){
	        System.out.println("stop");
	    }


}
