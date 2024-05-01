package Models;

public class Book {
private String name;
private byte[] cover;
private String author;
private String publisher;
private String date;
private String subject;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public byte[] getCover() {
	return cover;
}
public void setCover(byte[] cover) {
	this.cover = cover;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublisher() {
	return publisher;				
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public Book(String name, byte[] cover, String author, String publisher, String date, String subject) {
	super();

	this.name = name;
	this.cover = cover;
	this.author = author;
	this.publisher = publisher;
	this.date = date;
	this.subject = subject;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}

}
