import annotations.ExportField;
import annotations.Exportable;
import exceptions.ClassNotExportable;
import exceptions.NoExportableFieldsFound;
import org.apache.commons.lang3.reflect.FieldUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExportExcelUtil {
    private List<ExcelColumn> columns;
    private String name;

    ExportExcelUtil(Class<?> cls) throws Exception {
        this.columns = getCellName(cls);
        this.name = getExcelName(cls);
    }

    static Object getFieldValue(Object object, String fieldName) {
        Class<?> cls = object.getClass();
        try {
            Field name = FieldUtils.getField(cls, fieldName, true);
            return FieldUtils.readField(name, object, true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<ExcelColumn> getCellName(Class<?> cls) throws Exception {
        List<ExcelColumn> cellNames = new ArrayList<>();
        List<Field> fields = FieldUtils.getFieldsListWithAnnotation(cls, ExportField.class);
        if (fields.size() == 0){
            throw new NoExportableFieldsFound("There is no exportable fields ");
        }
        for (Field field : fields) {
            ExportField annotation = field.getAnnotation(ExportField.class);
                cellNames.add(new ExcelColumn(annotation.value(), field.getName(), annotation.sort()));
        }
        cellNames.sort(Comparator.comparingInt(ExcelColumn::getSort));
        return cellNames;
    }

    private String getExcelName(Class cls) throws Exception {
        Exportable annotation = (Exportable) cls.getAnnotation(Exportable.class);
        if (annotation != null) {
            return annotation.value();
        }
        throw new ClassNotExportable("Class is not exportable");
    }

    // getters and setters
    public List<ExcelColumn> getColumns() {
        return columns;
    }

    public String getName() {
        return name;
    }
}
