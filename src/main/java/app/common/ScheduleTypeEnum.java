package app.common;

/**
 * @author pickjob@126.com
 * @time 2019-08-01
 */
public enum ScheduleTypeEnum {
    SPRING(1),
    QUARTZ(2);

    ScheduleTypeEnum(int value) {
        this.value = value;
    }

    public byte value() {
        return (byte)value;
    }

    public static ScheduleTypeEnum valueOf(int value) {
        switch (value) {
            case 1: return ScheduleTypeEnum.SPRING;
            case 2: return ScheduleTypeEnum.QUARTZ;
            default: throw new RuntimeException("Unmatch schedule type");
        }
    }

    private int value;
}
