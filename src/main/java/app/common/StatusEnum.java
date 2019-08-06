package app.common;

/**
 * @author pickjob@126.com
 * @time 2019-07-30
 */
public enum StatusEnum {
    NORMAL(0),
    PAUSE(1),
    DELETED(2);

    StatusEnum(int value) {
        this.value = value;
    }

    public byte value() {
        return (byte)value;
    }

    public static StatusEnum valueOf(int value) {
        switch (value) {
            case 0: return NORMAL;
            case 1: return PAUSE;
            case 2: return DELETED;
            default: throw new RuntimeException("Unmatch Status");
        }
    }
    private int value;
}
