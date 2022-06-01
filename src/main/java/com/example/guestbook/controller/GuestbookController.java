package com.example.guestbook.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guestbook")
@Slf4j
public class GuestbookController {

    @GetMapping({"/", "/list"})
    public String list() {

        log.info("list");

        return "Ok";
    }
}
