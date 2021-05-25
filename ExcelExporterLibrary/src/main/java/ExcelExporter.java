import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import exceptions.NoExportableDataFound;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExporter {
    public static <T> void toExcel(List<T> list, String path) throws Exception {
        if (list.size() == 0){
            throw new NoExportableDataFound("No data found to export");
        }
        ExportExcelUtil excel = new ExportExcelUtil(list.get(0).getClass());
        List<ExcelColumn> models = excel.getColumns();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(excel.getName());

        Row row = sheet.createRow(0);
        for (int i = 0; i < models.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(models.get(i).getName());
        }

        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < models.size(); j++) {
                Cell cell = row.createCell(j);
                Object value = null;
                if (list.get(i) != null) {
                    value = ExportExcelUtil.getFieldValue(list.get(i), models.get(j).getFieldName());
                }
                cell.setCellValue(value.toString());
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream(new File(path+excel.getName() + ".xlsx"))) {
            workbook.write(outputStream);
            workbook.close();
        }
    }
}