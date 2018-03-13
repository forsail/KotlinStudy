import rx.Emitter;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/12/6.
 */
public class Test4 {
    public static void main(String[] args) {
        InterfaceTest test = new IntenfaceTestIml();
        test.test();
        System.out.println(test.getClass().getSimpleName());
        List<String> testList = Arrays.asList();
        System.out.println(testList.getClass().getSimpleName());

        Long testLong = new Long(1);
        System.out.println(testLong.toString());

        Observable.from(testList)
                .defaultIfEmpty("empty")
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("success");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("error");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }
                });

        Observable<String> test1 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("test1");
                subscriber.onCompleted();
            }
        });

        Observable<String> test2 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("test2");
            }
        });
        Observable.concat(test1, test2)
                .toList()
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> strings) {
                        System.out.println(strings);
                    }
                });

        Observable.just(1, 2, 3, 4)
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer < 3;
                    }
                })
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return "test" + integer;
                    }
                })
                .first()
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });

        test();

        String test4 = "\n";
        System.out.println("length" + test4.length());

        Observable.range(1, 20)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println(integer);
                    }
                });
    }

    private static void test() {
        final TestBean bean = new TestBean();
        bean.test1 = "21212";
        Observable.just(1, 2)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        bean.test2 = "2143e" + integer;
                        System.out.println(bean.test2);
                    }
                });
    }
}
