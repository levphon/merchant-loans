package cn.com.payu.common.constant;

public final class ConstantCacheKeys {

    public static final int MILLISECOND_1000 = 1000;
    public static final int SECOND_30 = 30;
    public static final int SECOND_60 = 60;
    public static final int MINUTES_1 = 1;
    public static final int MINUTES_60 = 60;
    public static final int HOURS_1 = 1;
    public static final int HOURS_24 = 24;
    public static final int DAYS_7 = 7;
    public static final int DAYS_30 = 30;
    public static final int DAYS_365 = 365;

    public static final String ONE_MINUTE_EXPIRE = "OneMinuteCache";
    public static final String ONE_HOUR_EXPIRE = "OneHourCache";
    public static final String ONE_DAY_EXPIRE = "OneDayCache";
    public static final String ONE_MONTH_EXPIRE = "OneMonthCache";
    public static final String ONE_YEAR_EXPIRE = "OneYearCache";

    // 省份
    public static final String REDIS_PROVINCES_KEY = "list:provinces";
    public static final String REDIS_PROVINCE_KEY = "provinces:province_";
    // 市区
    public static final String REDIS_CITIES_KEY = "list:cities";
    public static final String REDIS_CITY_KEY = "cities:city_";
    // 区县
    public static final String REDIS_AREAS_KEY = "list:areas";
    public static final String REDIS_AREA_KEY = "areas:area_";

}
