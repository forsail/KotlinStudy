import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */
public class Test {
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
