package tech.wetech.example.hibernate;

/**
 * @author cjbi
 */
public enum TypeEnum {

    string("java.lang.String"),
    datetime("java.util.Date"),
    userinfo("java.lang.String"),
    system("java.lang.String"),
    attach("java.lang.String"),
    number("java.lang.String"),
    org("java.lang.String"),
    radio("java.lang.String"),
    text("java.lang.String"),
    identifier("java.lang.String"),
    loc("java.lang.String"),
    zone("java.lang.String"),
    multiple("java.lang.String");

    private final String javaType;

    private static final String DEFAULT_JAVA_TYPE = "java.lang.String";

    TypeEnum(String javaType) {
        this.javaType = javaType;
    }

    public static String getJavaType(String type) {
        for (TypeEnum value : TypeEnum.values()) {
            if (value.name().equals(type)) {
                return value.getJavaType();
            }
        }
        return DEFAULT_JAVA_TYPE;
    }

    public String getJavaType() {
        return javaType;
    }


}
