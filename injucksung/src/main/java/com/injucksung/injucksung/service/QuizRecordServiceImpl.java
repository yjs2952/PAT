package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Question;
import com.injucksung.injucksung.domain.QuizRecord;
import com.injucksung.injucksung.domain.enums.PageSize;
import com.injucksung.injucksung.repository.QuizRecordRepository;
import com.injucksung.injucksung.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class QuizRecordServiceImpl implements QuizRecordService {
    private final QuizRecordRepository quizRecordRepository;
    private final QuestionService questionService;
    private final UserService userService;

    @Transactional(readOnly = true)
    public Page<QuizRecord> getQuizRecordList(Long userId, int start) {
        PageRequest pageRequest = PageRequest.of(start, PageSize.QUIZ_RECORD.getLimit());
        return quizRecordRepository.findQuizRecordByUserId(userId, pageRequest);
    }

    @Transactional
    public QuizRecord addQuizRecordService(Map<Long, Integer> selectedChoices, CustomUserDetails userDetails, int bookContentCount) {
        QuizRecord quizRecord = QuizRecord.builder()
                .title(createQuizRecordTitle(selectedChoices.keySet(), bookContentCount))
                .user(userService.getUser(userDetails.getEmail()))
//                .time() // TODO : 풀이 시간
                .build();

        return quizRecordRepository.save(quizRecord);
    }

    //QuizRecord(시험 목록)의 제목 만들기
    private String createQuizRecordTitle(Set<Long> questionIds, int bookContentCount) {
        StringBuilder title = new StringBuilder();
        Iterator<Long> iterator = questionIds.iterator();
        if (iterator.hasNext()) {
            //책 이름과 책목차 한가지를 생성한다.
            Question questionById = questionService.getQuestionById(iterator.next());

            //제일 앞에 책 이름
            title.append(questionById.getBookContent().getBook().getName())
                    .append(" : ")
                    //책 이름 뒤에 대표로 들어갈 책 목차 이름
                    .append(questionById.getBookContent().getName())
                    .append(" 영역");
        }

        //위에 적힌 제목이외에 여러 영역을 응시한 경우
        if (bookContentCount > 1) {
            title.append(" 외 ").append(bookContentCount-1).append("건");
        }

        return title.toString();
    }

    // TODO: 2018-12-18 이게 과연 필요할까?
    public int modifyQuizRecordService(QuizRecord quizRecord) {
        return 0;
    }

    // TODO: 2018-12-18 이게 과연 필요할까? 
    public void deleteQuizRecordService(Long id) {

    }
}
