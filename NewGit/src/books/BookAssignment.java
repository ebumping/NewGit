package books;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BookAssignment {
	DateFormat df = new SimpleDateFormat("MM/DD/YYYY");
	private List<Book> books = new ArrayList<Book>();
	
	private static Comparator<Book> SORT_BY_AUTHOR = new Comparator<Book>(){

		@Override
		public int compare(Book o1, Book o2) {
			return o1.getAuthor().compareTo(o2.getAuthor());
		}
		
	};
	
	public void list(){
		for(Book x : books){
			System.out.println(x);
		}
	}
	
	private void loadBooks(){
		try {
			//this one's for you Kyle
			books.add(new Book("50 Shades of Grey","E L James", 9780345803481L, "Knopf Doubleday Publishing Group", df.parse("04/03/2012")));
																// 'L' is required at the end of long integer to allow the compiler to recognize it as a long and not an int
			books.add(new Book("1984", "George Orwell", 9780451524935L , "Signet Classic", df.parse("01/01/1961")));
			books.add(new Book("Atlas Shrugged", "Ayn Rand", 9780451191144L, "Signet", df.parse("10/10/1957")));
			books.add(new Book("The Fountainhead", "Ayn Rand", 9780451191151L, "Signet", df.parse("06/07/1943")));
			books.add(new Book("Anthem", "Ayn Rand", 9781503250703L, "Cassell", df.parse("01/01/1938")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] argz){
		BookAssignment ba = new BookAssignment();
		ba.loadBooks();
		ba.list();
	}
	
}
