public class ExcelColumn {
    private String name;
    private String fieldName;
    private Integer sort;

    ExcelColumn(String name, String fieldName, Integer sort) {
        this.name = name;
        this.fieldName = fieldName;
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Integer getSort() {
        return sort;
    }
}
