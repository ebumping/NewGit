package books;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//Allows you to call book class and input data into your list that corresponds to the title of choice

public class Book {
	private String title;
	private String author;
	private String fAuthor;
	//Chose to use first name as a separate variable to ensure functional sorting by last name
	private long isbn;
	private String publisher;
	private Date pubDate;

	
	DateFormat df = new SimpleDateFormat("MM/DD/YYYY");
	//allows formatting the pubDate in toString
	public Book(String title,String fAuthor, String author, long isbn, String publisher, Date pubDate){
		this.title = title;
		this.author = author;
		this.fAuthor = fAuthor;
		this.isbn = isbn;
		this.publisher = publisher;
		this.pubDate = pubDate;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public long getIsbn() {
		return isbn;
	}
	
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public Date getPubDate() {
		return pubDate;
	}
	
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	
	public String toString(){
		return "Title: " + title + "\nAuthor: " + fAuthor + " " + author + "\nISBN: " + isbn + "\nPublisher: " + 
			publisher + "\nPublishing Date: " + DateFormat.getDateInstance(DateFormat.MEDIUM).format(pubDate) + "\n";
												//This formats pubDate to remove instance of time
	}

	public String getfAuthor() {
		return fAuthor;
	}

	public void setfAuthor(String fAuthor) {
		this.fAuthor = fAuthor;
	}
	
}
