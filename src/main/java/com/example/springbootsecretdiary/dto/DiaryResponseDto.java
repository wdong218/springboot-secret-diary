package com.example.springbootsecretdiary.dto;
import com.example.springbootsecretdiary.domain.Diary;
import lombok.Getter;

@Getter
public class DiaryResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;

    public DiaryResponseDto(Diary diary) {
        this.id = diary.getId();
        this.title = diary.getTitle();
        this.content = diary.getContent();
        this.author = diary.getAuthor();
    }
}