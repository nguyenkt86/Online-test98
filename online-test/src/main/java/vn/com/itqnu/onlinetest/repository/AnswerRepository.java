package vn.com.itqnu.onlinetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.itqnu.onlinetest.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
	Answer findByAnswerName(String answerName);
}
