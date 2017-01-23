
public class Start {
	 public static void main(String[] args) {
	        
	        Books_company booksCompany = new Books_company ();
	        
	        Books books = booksCompany.getBooks(Types_Books.HORROR_TYPE);
	        books.kol_list();
	        books.book_cover();
	               
	        books = booksCompany.getBooks(Types_Books.HISTORICAL);
	        books.kol_list();
	        books.book_cover();
	        books.binding();
	        
	        
	        books = booksCompany.getBooks(Types_Books.FAIRY_TALE);
	        books.binding();
	        
	        
	        
	        
	    }
}
