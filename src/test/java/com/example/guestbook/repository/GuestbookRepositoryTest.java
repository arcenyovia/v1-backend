package com.example.guestbook.repository;

import com.example.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class GuestbookRepositoryTest {

    @Autowired
    private GuestbookRepository repository;

    @Test
    void insertDummies() {
        IntStream.rangeClosed(1, 300).forEach(i -> {

            Guestbook guestbook = Guestbook.builder()
                    .title("Title..." + i)
                    .content("Content..." + i)
                    .writer("user" + (i % 10))
                    .build();
            System.out.println(repository.save(guestbook));
        });
    }

    @Test
    void updateTest() {
        Optional<Guestbook> result = repository.findById(300L);

        Guestbook guestBook = result.get();

        guestBook.changeContent("change Content for AuditingEntityListener");

        repository.save(guestBook);
    }



}