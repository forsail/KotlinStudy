import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */
public class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("3")) {
                iterator.remove();
            }
        }

        System.out.println(list.size());

        System.out.println(String.format("%s", "null"));

        System.out.println(getSubtractDays("2017-07-24 10:00:00", "2018-08-25 10:00:00", "yyyy-MM-dd HH:mm:ss"));

        System.out.println(getIntervalMonths("2017-11", "2017-12"));

        List<String> dateYearMonthArrayList = new ArrayList<>();
        dateYearMonthArrayList.add("2017-01");
        dateYearMonthArrayList.add("2017-06");
        dateYearMonthArrayList.add("2018-09");
        List<String> allYearMonthList = new ArrayList<>();
        for (int i = 0, n = dateYearMonthArrayList.size(); i < n; i++) {
            allYearMonthList.add(dateYearMonthArrayList.get(i));
            if (i != (n - 1)) {
                int intervalMonths = getIntervalMonths(dateYearMonthArrayList.get(i), dateYearMonthArrayList.get(i + 1));
                if (intervalMonths > 1) {
                    String monthStr = dateYearMonthArrayList.get(i).substring(5, 7);
                    if (monthStr.startsWith("0")) {
                        monthStr = monthStr.replaceFirst("0", "");
                    }
                    int yearInt = Integer.valueOf(dateYearMonthArrayList.get(i).substring(0, 4));
                    int monthInt = Integer.valueOf(monthStr);
                    for (int j = 0; j < (intervalMonths - 1); j++) {
                        if (monthInt + 1 <= 12) {
                            monthInt += 1;
                            allYearMonthList.add(dateYearMonthArrayList.get(i).substring(0, 5) +
                                    (monthInt > 9 ? ("" + monthInt) : ("0" + monthInt)));
                        } else {
                            monthInt = 1;
                            allYearMonthList.add((yearInt + 1) + "-" + ("0" + monthInt));
                        }
                    }
                }
            }
        }

        for (String str : allYearMonthList) {
            System.out.println(str);
        }
    }

    public static int getIntervalMonths(String startTime, String endTime) {
        String format = "yyyy-MM";
        int month = 0;
        SimpleDateFormat sd = new SimpleDateFormat(format);
        try {
            Date date1 = sd.parse(startTime);
            Date date2 = sd.parse(endTime);
            month = (date2.getYear() - date1.getYear()) * 12 + date2.getMonth() - date1.getMonth();
        } catch (ParseException var8) {
            var8.printStackTrace();
        }

        return month;
    }

    public static int getAge(String birthday) {
        int age = 0;
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            age = (new Date().getYear() - date.getYear());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return age;
    }

    public static long getSubtractDays(String startTime, String endTime, String format) {
        format = "yyyy-MM-dd";
        long day = 0;
        SimpleDateFormat sd = new SimpleDateFormat(format);
        try {
            //获得两个时间的毫秒时间差异
            long diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
            day = diff / (1000 * 24 * 60 * 60);//计算差多少天
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }
}
