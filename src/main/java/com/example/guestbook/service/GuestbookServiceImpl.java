package com.example.guestbook.service;

import com.example.guestbook.dto.GuestbookDTO;
import com.example.guestbook.dto.PageRequestDTO;
import com.example.guestbook.dto.PageResultDTO;
import com.example.guestbook.entity.Guestbook;
import com.example.guestbook.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {

    private final GuestbookRepository repository;
    @Override
    public Long create(GuestbookDTO dto) {
        log.info("DTO-----------------");
        log.info(dto);

        Guestbook entity = dtoToEntity(dto);

        log.info(entity);

        repository.save(entity);

        return entity.getId();
    }

    @Override
    public GuestbookDTO read(Long id) {
        Optional<Guestbook> result = repository.findById(id);
        return result.isPresent() ? entityToDto(result.get()) : null;
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void modify(GuestbookDTO dto) {
        Optional<Guestbook> result = repository.findById(dto.getId());

        if (result.isPresent()) {
            Guestbook entity = result.get();

            entity.changeContent(dto.getContent());
            entity.changeTitle(dto.getTitle());

            repository.save(entity);
        }



    }

    @Override             //DTO       , EN
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
        // SELECT * FROM ? ORDER BY ? DESC
        Pageable pageable = requestDTO.getPageable(Sort.by("id")
                .descending());

        Page<Guestbook> result = repository.findAll(pageable);

        Function<Guestbook, GuestbookDTO> fn = this::entityToDto;

        return new PageResultDTO<>(result, fn);
    }

}
