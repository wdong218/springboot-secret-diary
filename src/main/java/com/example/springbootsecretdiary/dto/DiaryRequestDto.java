package com.example.springbootsecretdiary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;
}
