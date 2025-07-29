package com.example.springbootsecretdiary.service;

import com.example.springbootsecretdiary.domain.Diary;
import com.example.springbootsecretdiary.dto.DiaryRequestDto;
import com.example.springbootsecretdiary.dto.DiaryResponseDto;
import com.example.springbootsecretdiary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;

    //저장 기능 구현
    public void saveDiary(DiaryRequestDto diaryRequestDto) {
        Diary diary = new Diary(
                diaryRequestDto.getTitle(),
                diaryRequestDto.getContent(),
                diaryRequestDto.getAuthor(),
                diaryRequestDto.getPassword()
        );
        diaryRepository.save(diary); // 레포지토리에 저장
    }

    // 조회 기능 구현
    public DiaryResponseDto getDiary(Long id,String password) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Diary not found with id: " + id));
        if (!password.equals(diary.getPassword())) {
            throw new IllegalArgumentException("Wrong password");
        }
        return new DiaryResponseDto(diary); // 조회된 다이어리 반환
    }


    // 수정 기능 구현
    public void updateDiary(Long id, DiaryRequestDto diaryRequestDto, String password) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Diary not found with id: " + id));
        if (!password.equals(diary.getPassword())) {
            throw new IllegalArgumentException("Wrong password");
        }
        diary.update(
                diaryRequestDto.getTitle(),
                diaryRequestDto.getContent(),
                diaryRequestDto.getAuthor()
        );
    }

    // 삭제 기능 구현
    public void deleteDiary(Long id, String password) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Diary not found with id: " + id));
        if (!password.equals(diary.getPassword())) {
            throw new IllegalArgumentException("Wrong password");
        }
        diaryRepository.delete(diary); // 레포지토리에서 삭제


    }
}
