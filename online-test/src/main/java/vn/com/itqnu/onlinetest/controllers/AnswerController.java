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

import vn.com.itqnu.onlinetest.model.AnswerModel;
import vn.com.itqnu.onlinetest.service.AnswerService;
import vn.com.itqnu.onlinetest.utils.ResponseUtil;

@RestController
@RequestMapping("/answers")
public class AnswerController {

	private AnswerService answerService;

	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}

	@PostMapping()
	public ResponseEntity<?> createAnswer(@RequestBody AnswerModel answerModel, HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(answerService.createAnswer(answerModel));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Create error", e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<?> getAllAnswer(HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(answerService.getAllAnswer());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Get error", e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAnswerById(@PathVariable(name = "id") Long idAnswer, HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(answerService.getAnswerByID(idAnswer));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Create error", e.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity<?> updateAnswer(@RequestBody AnswerModel answerModel, HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(answerService.updateAnswer(answerModel));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Update error", e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAnswerById(@PathVariable(name = "id") Long idAnswer, HttpStatus status) {
		try {
			answerService.deleteAnswer(idAnswer);
			return ResponseUtil.getNormal(true, status, "Delete", "Delete success!", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Delete error", e.getMessage());
		}
	}
}
