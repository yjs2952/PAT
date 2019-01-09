package com.injucksung.injucksung.controller.user;

import com.injucksung.injucksung.service.QuizRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users/{userId}/results")
public class QuizRecordController {
    private final QuizRecordService quizRecordService;

    //시험 목록 가져오기
    @GetMapping
    public String getQuizRecords(@PathVariable Long userId,
                                 @RequestParam(value = "start", defaultValue = "0") int start,
                                 Model model) {
        model.addAttribute("quizRecordPage", quizRecordService.getQuizRecordList(userId, start));
        return "/users/quiz/quizRecord";
    }

}
