package vn.com.itqnu.onlinetest.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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

import vn.com.itqnu.onlinetest.entity.Account;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Id", "Title", "Description", "Published" };
	static String SHEET = "Accounts";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static ByteArrayInputStream tutorialsToExcel(List<Account> accountsList) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(SHEET);

			// Header
			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERs[col]);
			}

			int rowIdx = 1;
			for (Account account : accountsList) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(account.getId());
				row.createCell(1).setCellValue(account.getUsername());
				row.createCell(2).setCellValue(account.getPassword());
				row.createCell(3).setCellValue(account.getFullName());
				row.createCell(4).setCellValue(account.getBirthday());
				row.createCell(5).setCellValue(account.isGender());
				row.createCell(6).setCellValue(account.getEmail());
				row.createCell(7).setCellValue(account.getPhone());
				row.createCell(8).setCellValue(account.getAddress());
				row.createCell(9).setCellValue(account.getRoleId());
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}

	public static List<Account> excelToTutorials(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<Account> accountsList = new ArrayList<Account>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				Account account = new Account();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					case 0:
						account.setId(1l);
						break;

					case 1:
						account.setUsername(currentCell.getStringCellValue());
						break;

					case 2:
						account.setPassword(currentCell.getStringCellValue());
						break;

					case 3:
						account.setFullName(currentCell.getStringCellValue());
						break;

					case 4:
						account.setBirthday(currentCell.getDateCellValue());
						break;
					case 5:
						account.setGender(currentCell.getBooleanCellValue());
						break;
					case 6:
						account.setEmail(currentCell.getStringCellValue());
						break;
					case 7:
						account.setPhone(currentCell.getStringCellValue());
						break;
					case 8:
						account.setAddress(currentCell.getStringCellValue());
						break;
					case 9:
						account.setRoleId((int) currentCell.getNumericCellValue());
						break;
					default:
						break;
					}

					cellIdx++;
				}

				accountsList.add(account);
			}

			workbook.close();

			return accountsList;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}
