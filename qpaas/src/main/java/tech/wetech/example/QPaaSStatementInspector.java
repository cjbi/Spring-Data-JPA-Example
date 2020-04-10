package tech.wetech.example;

import org.hibernate.resource.jdbc.spi.StatementInspector;

/**
 * sql检查处理占位符
 * @author cjbi
 */
public class QPaaSStatementInspector implements StatementInspector {
    @Override
    public String inspect(String sql) {
        //替换${entId}、${appId}占位符
        return SystemContextHolder.replacePlaceholder(sql);
    }
}
