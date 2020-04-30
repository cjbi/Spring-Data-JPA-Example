package tech.wetech.example.hibernate;

import tech.wetech.example.entity.DatacenterField;

import java.util.List;

/**
 * @author cjbi
 */
public class MetaDataContextBuilder {

    /**
     * 创建动态模型映射
     *
     * @param list
     * @return
     */
    public static MetaDataContext buildMetaDataContexts(String entId, String tableId, List<DatacenterField> list) {
        String table = String.format("ent_%s_datapool_%s", entId, tableId);
        MetaDataContext context = new MetaDataContext(table, entId + tableId);
        for (DatacenterField datacenterField : list) {
            if ("id".equals(datacenterField.getId())) {
                continue;
            }
            MetaDataContext.ColumnProperty columnProperty = new MetaDataContext.ColumnProperty();
            columnProperty.setName(datacenterField.getId());
            columnProperty.setColumn(datacenterField.getId());
            columnProperty.setType(JavaTypeEnum.getJavaType(datacenterField.getType()));
            context.addColumnProperty(columnProperty);
        }
        return context;
    }

}
