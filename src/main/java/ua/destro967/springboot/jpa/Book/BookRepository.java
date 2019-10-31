package ua.destro967.springboot.jpa.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.destro967.springboot.jpa.Book.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{

}

