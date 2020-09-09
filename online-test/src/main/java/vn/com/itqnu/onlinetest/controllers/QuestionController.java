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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vn.com.itqnu.onlinetest.helper.ExcelHelper;
import vn.com.itqnu.onlinetest.helper.QuestionBankHelper;
import vn.com.itqnu.onlinetest.model.QuestionModel;
import vn.com.itqnu.onlinetest.service.QuestionService;
import vn.com.itqnu.onlinetest.utils.ResponseMessage;
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

	@PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";

	    if (QuestionBankHelper.hasExcelFormat(file)) {
	      try {
	        questionService.save(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	    }

	    message = "Please upload an excel file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
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
