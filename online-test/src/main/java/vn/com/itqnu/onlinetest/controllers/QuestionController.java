package vn.com.itqnu.onlinetest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.itqnu.onlinetest.model.QuestionModel;
import vn.com.itqnu.onlinetest.service.QuestionService;
import vn.com.itqnu.onlinetest.utils.ResponseUtil;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

	@PostMapping()
	public ResponseEntity<?> createQuestion(@RequestBody QuestionModel questionModel, HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(questionService.createQuestion(questionModel));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Create error", e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<?> getAllQuestion(HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(questionService.getAllQuestion());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Get error", e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getQuestionById(@PathVariable(name = "id") Long idQuestion, HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(questionService.getQuestionByID(idQuestion));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Get error", e.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity<?> updateQuestion(@RequestBody QuestionModel questionModel, HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(questionService.updateQuestion(questionModel));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Update error", e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteQuestionById(@PathVariable(name = "id") Long idQuestion, HttpStatus status) {
		try {
			questionService.deleteQuestion(idQuestion);
			return ResponseUtil.getNormal(true, status.OK, "Delete", "Delete success!", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Delete error", e.getMessage());
		}
	}

	@GetMapping("/competition/{id}")
	public ResponseEntity<?> getAllQuestionByCompetition(@PathVariable(name = "id") Long idCompetition,
			HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(questionService.getQuestionByCompetition(idCompetition));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Update error", e.getMessage());
		}
	}
}
