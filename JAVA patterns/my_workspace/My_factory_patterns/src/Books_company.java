
public class Books_company {
	public  Books getBooks(Types_Books booksType) {
        Books books = null;
        switch (booksType) {
            case HORROR_TYPE:
            	books = new Master_and_Margarita();
                break;
            case HISTORICAL:
            	books = new War_and_Piece();
                break;
            case FAIRY_TALE:
            	books = new Cristmas();
                break;          
                
        }

        return books;
    }
}
