package vn.com.itqnu.onlinetest.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import vn.com.itqnu.onlinetest.entity.Account;
import vn.com.itqnu.onlinetest.model.CompetitionModel;
import vn.com.itqnu.onlinetest.model.QuestionModel;
import vn.com.itqnu.onlinetest.service.CompetitionService;
import vn.com.itqnu.onlinetest.service.QuestionService;
import vn.com.itqnu.onlinetest.utils.AppUtils;
import vn.com.itqnu.onlinetest.utils.ResponseUtil;

@RestController
@RequestMapping("/competitions")
public class CompetitionController {

	private CompetitionService competitionService;
	private QuestionService questionService;

	public CompetitionController(CompetitionService competitionService, QuestionService questionService) {
		this.competitionService = competitionService;
		this.questionService = questionService;
	}

	@GetMapping
	public ResponseEntity<?> getAllCompetition(HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(competitionService.getAllCompetition());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Get error", e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCompetitionById(@PathVariable(name = "id") Long idCompetition, HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(competitionService.getCompetitionById(idCompetition));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Create error", e.getMessage());
		}
	}

	@PostMapping()
	public ResponseEntity<?> createCompetition(@RequestBody CompetitionModel competitionModel, HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(competitionService.createCompetition(competitionModel));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Create error", e.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity<?> updateCompetition(@RequestBody CompetitionModel competitionModel, HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(competitionService.updateCompetition(competitionModel));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Update error", e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCompetitionById(@PathVariable(name = "id") Long idCompetition, HttpStatus status) {
		try {
			competitionService.deleteCompetition(idCompetition);
			return ResponseUtil.getNormal(true, status, "Delete", "Delete success!", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Delete error", e.getMessage());
		}
	}

	@GetMapping("/build-test/{id}")
	public ResponseEntity<?> buildTest(@PathVariable Long id, HttpStatus status, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			Account account = AppUtils.getAccountFromSession(session);
			List<QuestionModel> listQuestionModels = questionService.getQuestionByCompetition(id);
			List<QuestionModel> listQuestionTest = questionService.buildTest(listQuestionModels);
			
			return ResponseUtil.getSuccess(listQuestionTest);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Get error", e.getMessage());
		}
	}
}
