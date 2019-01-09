package com.injucksung.injucksung.controller.user;

import com.injucksung.injucksung.domain.QuizRecord;
import com.injucksung.injucksung.dto.SelectedBookContentForQuizForm;
import com.injucksung.injucksung.service.QuizRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users/{userId}/quiz-records")
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
