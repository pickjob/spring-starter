package app;

/**
 * @author pickjob@126.com
 * @time 2019-07-30
 */
public enum StatusEnum {
    NORMAL(0),
    PAUSE(1),
    DELETED(2);

    StatusEnum(int value) {
        this.v = value;
    }

    public byte getValue() {
        return (byte)v;
    }
    private int v = 0;
}
