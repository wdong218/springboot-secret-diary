package com.example.springbootsecretdiary.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class post {
    @Id //기본키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 초기화 값 설정
    private Long id;
    
}