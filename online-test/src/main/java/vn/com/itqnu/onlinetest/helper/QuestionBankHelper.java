package vn.com.itqnu.onlinetest.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import vn.com.itqnu.onlinetest.entity.Question;

public class QuestionBankHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Id", "Title", "Description", "Published" };
	static String SHEET = "Question";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Question> excelToTutorials(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<Question> questionList = new ArrayList<Question>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				Question question = new Question();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					case 0:
						question.setId(1l);
						break;

					case 1:
						question.setQuestionName(currentCell.getStringCellValue());
						break;

					case 2:
						question.setResult(currentCell.getStringCellValue());
						break;

					case 3:
						question.setSubjectId((long) currentCell.getNumericCellValue());
						break;

					case 4:
						question.setCompetitionId((long) currentCell.getNumericCellValue());
						break;
					case 5:
						question.setLevel((int) currentCell.getNumericCellValue());
						break;
					default:
						break;
					}

					cellIdx++;
				}

				questionList.add(question);
			}

			workbook.close();

			return questionList;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}
