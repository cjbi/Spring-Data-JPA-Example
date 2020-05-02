package tech.wetech.example.hibernate;

import tech.wetech.example.entity.DatacenterField;

import java.util.List;

/**
 * @author cjbi
 */
public class MetadataContextBuilder {

    public static String getEntityName(String entId, String tableId) {
        return String.format("ent_%s_datapool_%s", entId, tableId);
    }

    /**
     * 创建动态模型映射
     *
     * @param list
     * @return
     */
    public static MetadataContext buildMetaDataContexts(String entId, String tableId, List<DatacenterField> list) {
        String table = String.format("ent_%s_datapool_%s", entId, tableId);
        MetadataContext context = new MetadataContext(table, getEntityName(entId, tableId));
        for (DatacenterField datacenterField : list) {
            MetadataContext.ColumnProperty columnProperty = new MetadataContext.ColumnProperty();
            columnProperty.setName(datacenterField.getId());
            columnProperty.setColumn(datacenterField.getId());
            columnProperty.setType(TypeEnum.getJavaType(datacenterField.getType()));
            context.addColumnProperty(columnProperty);
        }
        return context;
    }

}
