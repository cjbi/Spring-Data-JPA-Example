package tech.wetech.example;

/**
 * 上下文持有者
 *
 * @author cjbi
 */
public class SystemContextHolder {
    /**
     * 企业id
     */
    private static final ThreadLocal<String> entId = new ThreadLocal<>();
    /**
     * 应用id
     */
    private static final ThreadLocal<String> appId = new ThreadLocal<>();

    private static final ThreadLocal<String> tableId = new ThreadLocal<>();

    private static final ThreadLocal<Boolean> dynamicModel = ThreadLocal.withInitial(() -> Boolean.FALSE);

    public static String getEntId() {
        return entId.get();
    }

    public static String getAppId() {
        return appId.get();
    }

    public static void setEntId(String entId) {
        SystemContextHolder.entId.set(entId);
    }

    public static void setAppId(String appId) {
        SystemContextHolder.appId.set(appId);
    }

    public static void setTableId(String tableId) {
        SystemContextHolder.tableId.set(tableId);
    }

    public static String getTableId() {
        return SystemContextHolder.tableId.get();
    }

    public static void setDynamicModel(boolean dynamicModel) {
        SystemContextHolder.dynamicModel.set(dynamicModel);
    }

    public static boolean isDynamicModel() {
        return SystemContextHolder.dynamicModel.get();
    }

    public static void setEntIdAndAppId(String entId, String appId) {
        SystemContextHolder.appId.set(appId);
        SystemContextHolder.entId.set(entId);
    }


    public static String replacePlaceholder(String text) {
        String entId = getEntId();
        String appId = getAppId();
        if (entId != null) {
            text = text.replaceAll("(\\$\\{ent_id\\}|\\$\\{entId\\})", entId);

        }
        if (appId != null) {
            text = text.replaceAll("(\\$\\{app_id\\}|\\$\\{appId\\})", appId);
        }
        return text;
    }

}
