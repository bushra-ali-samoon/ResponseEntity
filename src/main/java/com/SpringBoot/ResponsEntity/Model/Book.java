package com.SpringBoot.ResponsEntity.Model;

import jakarta.persistence.*;

@Entity
@Table(name  ="tbl_Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String bookName;
    private String bookAuthor;

    public Book() {
    }

    public Book(String jane, String s) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }


//    public Book(int id, String book_Name, String book_Author) {
//        this.id = id;
//        Book_Name = book_Name;
//        Book_Author = book_Author;
//    }
//


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }
}
