package tech.wetech.example.hibernate;

import tech.wetech.example.entity.DatacenterField;

import java.util.List;

/**
 * @author cjbi
 */
public class MetaDataContextBuilder {

    public static String getEntityName(String entId, String tableId) {
        return String.format("ent_%s_datapool_%s", entId, tableId);
    }

    /**
     * 创建动态模型映射
     *
     * @param list
     * @return
     */
    public static MetaDataContext buildMetaDataContexts(String entId, String tableId, List<DatacenterField> list) {
        String table = String.format("ent_%s_datapool_%s", entId, tableId);
        MetaDataContext context = new MetaDataContext(table, getEntityName(entId, tableId));
        for (DatacenterField datacenterField : list) {
            if ("id".equals(datacenterField.getId())) {
                continue;
            }
            MetaDataContext.ColumnProperty columnProperty = new MetaDataContext.ColumnProperty();
            columnProperty.setName(datacenterField.getId());
            columnProperty.setColumn(datacenterField.getId());
            columnProperty.setType(TypeEnum.getJavaType(datacenterField.getType()));
            context.addColumnProperty(columnProperty);
        }
        return context;
    }

}
