package Library;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

enum Status{
    AVAILABLE, UNAVAILABLE, OVERDUE;
}

abstract class Book{
    protected String title;
    protected String author;

    Book(String title, String author){
        this.author = author;
        this.title = title;
    }

    protected String getTitle(){
        return title;
    }

    protected String getAuthor(){
        return author;
    }
}

class BookCopy extends Book{
    private String ISBN;
    private Status status;
    private LocalDate lastCheckOutDate;
    private LocalDate dueDate;

    public BookCopy(String ISBN, String title, String author){
        super(title,author);
        this.ISBN = ISBN;
        status = Status.AVAILABLE;
    }

    public LocalDate getLastCheckOutDate(){
        return lastCheckOutDate;
    }

    public void setLastCheckoutDate(LocalDate date){
        this.lastCheckOutDate = date;
    }
    public void checkOut() {
        this.lastCheckOutDate = LocalDate.now();
        this.dueDate = lastCheckOutDate.plusDays(14);
        this.status = Status.UNAVAILABLE;
    }

    public void returnBook(){
        lastCheckOutDate = null;
        dueDate = null;
        this.status = Status.AVAILABLE;
    }

    public boolean isOverDue() {
        if (status == Status.UNAVAILABLE && LocalDate.now().isAfter(dueDate)) {
            status = Status.OVERDUE;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "BookCopy{" +
            "ISBN='" + ISBN + '\'' +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", status=" + status.name() +
            '}';
    }

    public String getISBN(){ return ISBN; }

    public void setISBN(String ISBN){ this.ISBN = ISBN; }

    public Status getStatus(){ return status; }

    public void setStatus(Status status){ this.status = status;}

}

public class Library {
    private Map<String,BookCopy> collection;
    
    Library(){
        collection = new HashMap<>();
    }

    public void addBook(String ISBN, String title, String author){
        BookCopy newBookCopy = new BookCopy(ISBN, title, author);
        collection.put(ISBN,newBookCopy);
    }

    public BookCopy getBookByISBN(String ISBN){
        return collection.get(ISBN);
    }

    public boolean checkOutBook(String ISBN){
        BookCopy bookCopy = getBookByISBN(ISBN);
        if(bookCopy!=null && bookCopy.getStatus()==Status.AVAILABLE){
            bookCopy.checkOut();
            return true;
        }
        return false;
    }

    public boolean returnBook(String ISBN){
        BookCopy bookCopy = getBookByISBN(ISBN);
        if(bookCopy!=null && bookCopy.getStatus()==Status.UNAVAILABLE){
            bookCopy.returnBook();
            return true;
        }
        return false;
    }

    public List<BookCopy> getOverDueBooks(){
        return collection.values().stream().filter(a->a.isOverDue()).collect(Collectors.toList());
    }
}
