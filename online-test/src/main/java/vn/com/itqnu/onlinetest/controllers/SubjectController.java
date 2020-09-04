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

import vn.com.itqnu.onlinetest.model.SubjectModel;
import vn.com.itqnu.onlinetest.service.SubjectService;
import vn.com.itqnu.onlinetest.utils.ResponseUtil;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

	private SubjectService subjectService;

	public SubjectController(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	@PostMapping()
	public ResponseEntity<?> createSubject(@RequestBody SubjectModel subjectModel, HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(subjectService.createSubject(subjectModel));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Create error", e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<?> getAllSubject(HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(subjectService.getAllSubject());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Get error", e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getSubjectById(@PathVariable(name = "id") Long idSubject, HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(subjectService.getSubjectById(idSubject));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Get error", e.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity<?> updateSubject(@RequestBody SubjectModel subjectModel, HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(subjectService.updateSubject(subjectModel));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Update error", e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSubjectById(@PathVariable(name = "id") Long idSubject, HttpStatus status) {
		try {
			subjectService.deleteSubject(idSubject);
			return ResponseUtil.getNormal(true, status.OK, "Delete", "Delete success!", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Delete error", e.getMessage());
		}
	}

}
