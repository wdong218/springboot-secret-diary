package com.example.springbootsecretdiary.service;

import com.example.springbootsecretdiary.domain.Diary;
import com.example.springbootsecretdiary.dto.DiaryRequestDto;
import com.example.springbootsecretdiary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;
    public void saveDiary(DiaryRequestDto diaryRequestDto) {
        Diary diary = new Diary(
                diaryRequestDto.getTitle(),
                diaryRequestDto.getContent(),
                diaryRequestDto.getAuthor(),
                diaryRequestDto.getPassword()
        );
    }
}
