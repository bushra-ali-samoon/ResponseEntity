package com.SpringBoot.ResponsEntity.Controller;


import com.SpringBoot.ResponsEntity.Model.Book;
import com.SpringBoot.ResponsEntity.Model_Repository.BookRepository;
import com.SpringBoot.ResponsEntity.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
   BookRepository bookRepository;
//    @PostMapping("/MultipleBooks")
//    public String saveAll( @RequestBody List<Book> bookList){
//        bookService.saveAll(bookList);
//        return "THANK U FOR MAKING MY DAY WORST ";
//    }
//    @GetMapping ("/Books")
//    public ResponseEntity<List<Book>> GetBooks( ){
//        List<Book> list=bookService.GetAllBooks();
//        if (list.size() <= 0)// have books in db that is why it shows "ok " ststus
//        {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//
//        }
//        return ResponseEntity.of(Optional.of(list));
//        //return (List<Book>)   bookRepository.findAll();
//
//
//    }
//


//        @PostMapping("/convert")
//        public ResponseEntity<byte[]> convertJsonToCsv(@RequestBody List<Book> people) throws IOException {
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(outputStream));
//
//            // Write header
//            csvWriter.writeNext(new String[]{"bookName", " bookAuthor"});
//
//            // Write data
//            for ( Book book : people) {
//                csvWriter.writeNext(new String[]{ book.getBookName(), String.valueOf( book.getBookAuthor())});
//            }
//
//            csvWriter.close();
//
//            byte[] csvBytes = outputStream.toByteArray();
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.parseMediaType("text/csv"));
//            headers.setContentDispositionFormData("attachment", "people.csv");
//
//            return new ResponseEntity<>(csvBytes, headers, HttpStatus.OK);
//
//    }




    @PostMapping("/convert")
    public ResponseEntity<String> insertData(@RequestBody List< Book>  book) {
        try (FileWriter fileWriter = new FileWriter("data.csv")) {
            for ( Book model :  book) {
                String csvRow = String.format("%s,%s\n", model.getBookName(), model.getBookAuthor());
                fileWriter.write(csvRow);
            }
            return ResponseEntity.ok("Data inserted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert data.");
        }
    }
//@GetMapping("/AllBooks")
//public List<Book> getAllBooks(){
//    return this.bookService.GetAllBooks();
//}
//
//
//    }

    @GetMapping(value="/download")
    public ResponseEntity<byte[]> downloadBooksAsCsv()
    {
            byte[] csvData = bookService.getBooksAsCsv();
             HttpHeaders headers = new HttpHeaders();
             headers.setContentType(MediaType.parseMediaType("text/csv"));
             headers.setContentDispositionFormData("attacment","books.csv");
             return ResponseEntity.ok()
                     .headers(headers)
                     .body(csvData);
        }
}





//    @PostMapping("/saveBook")
//    public String AddBooks(@RequestBody Book book){
//        bookRepository.save(book);
//  return "your record has been succesfully saved !! ";
//    }

//    public String Books(@RequestBody List<Book> book){
//        bookRepository.saveAll(book);
//        return "your record has been succesfully saved !! ";
//    }


