package app.common;

/**
 * @author pickjob@126.com
 * @time 2019-08-27
 */
public enum RequestAttributeEnum {
    IP("IP");

    RequestAttributeEnum(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    private String attributeName;
}
