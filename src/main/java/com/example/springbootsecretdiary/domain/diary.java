package com.example.springbootsecretdiary.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity //이 클래스가 테이블임을 명시
@EntityListeners(AuditingEntityListener.class)
public class diary {
    @Id //기본키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 초기화 값 설정
    private Long id;
    
}