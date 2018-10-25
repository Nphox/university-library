import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ExcelParser {
    public static Set<BookEntity> parse(String fileName) throws IllegalArgumentException{
        Set<BookEntity> set = new HashSet<BookEntity>();
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

            if(row.getLastCellNum() != 3){
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
                        break;
                }
            }

            String publisher = stack.pop();
            String year = stack.pop();
            String bookName = stack.pop();

            set.add(new BookEntity(bookName, year, publisher));
        }

        return set;
    }
}
