package com.SpringBoot.ResponsEntity.service;

import com.SpringBoot.ResponsEntity.Model.Book;
import com.SpringBoot.ResponsEntity.Model_Repository.BookRepository;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@Service
public class BookService {

    private  BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public byte[] getBooksAsCsv()   {
        List<Book> books =bookRepository.findAll();
        try(StringWriter writer = new StringWriter();
            CSVWriter csvWriter = new CSVWriter(writer))
        {
            // Writer CSV header
            String[] header ={"bookName","bookAuthor"};
            csvWriter.writeNext(header);

            // Writer CSV data
            for(Book book: books){
                String[] rowData = {
                        book.getBookName(),
                        book.getBookAuthor(),

                };
                csvWriter.writeNext(rowData);
            }
            csvWriter.flush();
            return writer.toString().getBytes();
        }
        catch(Exception e){
            // Handle any exceptions
            e.printStackTrace();
            return new byte[0];
        }

    }

    public  String saveAll(List<Book> bookList){
         bookRepository.saveAll(bookList);
         return " out of mind kindly save all books  PLEASE";
    }

    public List<Book> GetAllBooks() {
      return   bookRepository.findAll();
    }

}
