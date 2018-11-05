import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ExcelParser {

    public static List<TableEntity> parse(String fileName) throws IllegalArgumentException{
        List<TableEntity> list = new ArrayList<TableEntity>();
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;

        try {
            inputStream = new FileInputStream(fileName);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if(row.getLastCellNum() != 7){
                throw new IllegalArgumentException("Wrong file format: illegal number of cells.");
            }

            Iterator<Cell> cellIterator = row.iterator();

            Stack<String> stack = new Stack<String>();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                int cellType = cell.getCellType();

                switch(cellType){
                    case Cell.CELL_TYPE_STRING:
                        stack.push(cell.getStringCellValue());
                        break;

                    case Cell.CELL_TYPE_NUMERIC:
                        stack.push(Integer.toString((int)cell.getNumericCellValue()));
                        break;

                    default:
                        stack.push(null);
                        break;
                }
            }

            String booksOnTheHands = stack.pop();
            String realCountBooks = stack.pop();
            String publicationYear = stack.pop();
            String type = stack.pop();
            String bookName = stack.pop();
            String author = stack.pop();
            String rowNum = stack.pop();

            list.add(new TableEntity(rowNum, author, bookName, type, publicationYear, realCountBooks, booksOnTheHands));
        }

        return list;
    }
}
