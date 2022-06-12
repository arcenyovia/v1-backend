package com.example.guestbook.controller;

import com.example.guestbook.dto.GuestbookDTO;
import com.example.guestbook.dto.PageRequestDTO;
import com.example.guestbook.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guestbook")
@Log4j2
@RequiredArgsConstructor
public class GuestbookController {

    private final GuestbookService service;

    @GetMapping("/")
    public String index() {
        return "hello";
    }

    @PostMapping("/")
    public void create(GuestbookDTO dto) {
        service.create(dto);
    }

    @GetMapping("/list")
    public List<GuestbookDTO> list(PageRequestDTO pageRequestDTO) {


        return service.getList(pageRequestDTO).getDtoList();
    }

    @GetMapping("/{id}")
    public GuestbookDTO retrieve(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping("/{id}")
    public void update(GuestbookDTO dto) {
        service.modify(dto);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        service.remove(id);
        log.info("{} been removed", id);
    }


}
