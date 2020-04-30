package tech.wetech.example.hibernate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cjbi
 */
public class MetaDataContext {

    private String table;
    private String entityName;
    private List<ColumnProperty> columnProperties = new ArrayList<>();

    public MetaDataContext() {
    }

    public MetaDataContext(String table, String entityName) {
        this.table = table;
        this.entityName = entityName;
    }

    public static class ColumnProperty {
        private String name;
        private String type;
        private String column;

        public ColumnProperty() {
        }

        public ColumnProperty(String name, String type, String column) {
            this.name = name;
            this.type = type;
            this.column = column;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }
    }

    public String getTable() {
        return table;
    }

    public String getEntityName() {
        return entityName;
    }

    public List<ColumnProperty> getColumnProperties() {
        return columnProperties;
    }

    public void addColumnProperty(ColumnProperty columnProperty) {
        this.columnProperties.add(columnProperty);
    }
}
