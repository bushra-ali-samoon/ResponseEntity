package com.SpringBoot.ResponsEntity.Model_Repository;

import com.SpringBoot.ResponsEntity.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
