package com.example.springbootsecretdiary.controller;

import com.example.springbootsecretdiary.dto.DiaryRequestDto;
import com.example.springbootsecretdiary.dto.DiaryResponseDto;
import com.example.springbootsecretdiary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 이 클래스가 REST API의 컨트롤러임을 명시
@RequestMapping("/diary") // 모든 요청 경로는 /diary로 시작
@RequiredArgsConstructor // final 필드인 diaryService를 생성자 주입
public class DiaryController {
    private  final DiaryService diaryService;

    //게시글 작성
    @PostMapping
    public ResponseEntity<Void> createDiary(@RequestBody DiaryRequestDto diaryRequestDto) {
        diaryService.saveDiary(diaryRequestDto); // 서비스에 저장 요청
        return  ResponseEntity.ok().build(); // 200 OK 응답
    }
    // 게시글 단건 조회
    @GetMapping("/{id}") // /diary/{id} 형식의 GET
    public ResponseEntity<DiaryResponseDto> getDiary(@PathVariable Long id, @RequestParam String password) {
        return ResponseEntity.ok(diaryService.getDiary(id, password)); // 해당 id의 게시글 조회 후 응답
    }
    // 게시글 수정
    @PutMapping("/{id}") // PUT 요청 처리 (수정)
    public ResponseEntity<Void> updateDiary(
            @PathVariable Long id,
            @RequestBody DiaryRequestDto diaryRequestDto,
            @RequestParam String password
    ) {
        diaryService.updateDiary(id, diaryRequestDto, password); // 수정 요청
        return ResponseEntity.ok().build(); // 200 OK 응답
    }
    // 게시글 삭제
    @DeleteMapping("/{id}") // DELETE 요청 처리
    public ResponseEntity<Void> deleteDiary(
            @PathVariable Long id,
            @RequestParam String password
    ) {
        diaryService.deleteDiary(id, password); // 삭제 요청
        return ResponseEntity.ok().build(); // 200 OK 응답
    }
}
