package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.BookContent;
import com.injucksung.injucksung.domain.QuizRecord;
import com.injucksung.injucksung.repository.BookContentRepository;
import com.injucksung.injucksung.repository.QuizRecordRepository;
import com.injucksung.injucksung.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class QuizRecordServiceImpl implements QuizRecordService {
    private final QuizRecordRepository quizRecordRepository;
    private final QuestionService questionService;
    private final BookContentRepository bookContentRepository;
    private final UserService userService;

    public Page<QuizRecord> getQuizRecordList(int start) {
        return null;
    }

    @Transactional
    public QuizRecord addQuizRecordService(Map<Long, Integer> selectedChoices, CustomUserDetails userDetails) {
        // TODO : for문안에 Repository는 구려보여 고민해봐야함
        //책 목차로 책 제목 만들기
        StringBuilder titleString = new StringBuilder();

        for (Long questionId : selectedChoices.keySet()) {
            String bookContentName = questionService.getQuestionById(questionId).getBookContent().getName();
            if (bookContentName != null) {
                titleString.append(bookContentName).append(", ");
            }
        }
        QuizRecord quizRecord = QuizRecord.builder()
                .title(titleString.toString())
                .user(userService.getUser(userDetails.getEmail()))
//                .time() // TODO : 풀이 시간
                .build();

        return quizRecordRepository.save(quizRecord);
    }

    // TODO: 2018-12-18 이게 과연 필요할까?
    public int modifyQuizRecordService(QuizRecord quizRecord) {
        return 0;
    }

    // TODO: 2018-12-18 이게 과연 필요할까? 
    public void deleteQuizRecordService(Long id) {

    }
}
