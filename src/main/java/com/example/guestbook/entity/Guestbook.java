package com.example.guestbook.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "guest_book")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Guestbook extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1500, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    public void changeContent(String content) {
        this.content = content;
    }

    public void changeTitle(String title) {
        this.title = title;
    }
}
