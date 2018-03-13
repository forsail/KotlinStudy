import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import rx.Observable;
import rx.functions.Action1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/1.
 */
public class TestEnum {
    public static void main(String[] args) {
        Color color = Color.RED;
        Color color1 = Color.valueOf("YELLOW");
        System.out.println(color1);

        List<String> list = new ArrayList();
        Observable.from(list)
                .toList()
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> strings) {
                        System.out.println(strings.size());
                    }
                });
    }

    enum Color {
        RED, YELLOW
    }
}
