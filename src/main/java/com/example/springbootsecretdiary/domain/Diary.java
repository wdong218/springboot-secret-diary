package com.example.springbootsecretdiary.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity //이 클래스가 테이블임을 명시
@EntityListeners(AuditingEntityListener.class)
public class Diary {
    @Id //기본키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 초기화 값 설정
    private Long id;
    @Column(nullable = false, length = 100) //제약조건 NUll금지,길이 제한
    private String title;
    private String content;
    private String author;
    @Column(nullable = false, length = 100)
    private String password;

    // 생성자 추가
    public Diary(String title, String content, String author, String password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }
    protected  Diary() {
        // JPA 기본 생성자
        // 밑에 생성자가 있었음에도 기본 생성자를 생성해야됨
    }
}