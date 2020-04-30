package tech.wetech.example.hibernate;

import javax.xml.parsers.ParserConfigurationException;

/**
 * @author cjbi
 */
public class MetadataSourcesGenerator {

    /**
     * @return
     * @throws ParserConfigurationException
     */
    public static String toXMLString(MetaDataContext metaDataContext) {
        StringBuffer sb = new StringBuffer();
        sb.append("<hibernate-mapping>");
        sb.append(String.format("<class entity-name=\"%s\" table=\"%s\" dynamic-update=\"true\">", metaDataContext.getEntityName(), metaDataContext.getTable()));
        sb.append("<id name=\"id\" type=\"java.lang.Long\" length=\"64\" unsaved-value=\"null\">");
        sb.append("<generator class=\"native\" />");
        sb.append("</id>");
        for (MetaDataContext.ColumnProperty columnProperty : metaDataContext.getColumnProperties()) {
            sb.append(String.format("<property name=\"%s\" type=\"%s\" column=\"%s\"/>", columnProperty.getName(), columnProperty.getType(), columnProperty.getColumn()));
        }
        sb.append("</class>");
        sb.append("</hibernate-mapping>");

        return sb.toString();
    }

}
