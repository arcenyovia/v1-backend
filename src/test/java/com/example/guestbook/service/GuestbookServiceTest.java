package com.example.guestbook.service;

import com.example.guestbook.dto.GuestbookDTO;
import com.example.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GuestbookServiceTest {

    @Autowired
    private GuestbookService service;

    @Test
    void testRegister() {

        GuestbookDTO dto = GuestbookDTO.builder()
                .title("Test")
                .content("Sample")
                .writer("user0")
                .build();

        System.out.println(service.register(dto));
    }
}