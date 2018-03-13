import rx.Observable;
import rx.functions.*;
import rx.observables.GroupedObservable;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Administrator on 2017/11/23.
 */
public class Test3 {
    static int pos = 0;

    public static void main(String[] args) {
        String[] array = {"a", "b", "1", "3", "2", "3", "b", "1", "2"};
        Double childSellPriceDouble = 0d;
        Double sellPriceDouble = 0d;
        try {
            childSellPriceDouble = Double.valueOf(200000) * 100;
        } catch (Exception e) {
        }

        System.out.println(childSellPriceDouble.longValue());
        final List<String> keys = new ArrayList<>();
        Observable.from(array)
                .distinct()
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        keys.add(s);
                    }
                });

        Observable.from(array)
                .groupBy(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s;
                    }
                }).toSortedList(new Func2<GroupedObservable<String, String>, GroupedObservable<String, String>, Integer>() {
            @Override
            public Integer call(GroupedObservable<String, String> stringStringGroupedObservable, GroupedObservable<String, String> stringStringGroupedObservable2) {
                String key1 = stringStringGroupedObservable.getKey();
                String key2 = stringStringGroupedObservable2.getKey();
                int pos1 = keys.indexOf(key1);
                int pos2 = keys.indexOf(key2);
                return pos1 - pos2;
            }
        }).subscribe(new Action1<List<GroupedObservable<String, String>>>() {
            @Override
            public void call(List<GroupedObservable<String, String>> groupedObservables) {
                for (GroupedObservable<String, String> groupedObservable : groupedObservables
                        ) {
                    groupedObservable.collect(new Func0<List<String>>() {
                        @Override
                        public List<String> call() {
                            return new ArrayList<>();
                        }
                    }, new Action2<List<String>, String>() {
                        @Override
                        public void call(List<String> strings, String s) {
                            strings.add(s);
                        }
                    }).subscribe(new Action1<List<String>>() {
                        @Override
                        public void call(List<String> strings) {
                            for (String s : strings) {
                                System.out.println(s);
                            }
                        }
                    });
                }
            }
        });

        List<TestBean> list = new ArrayList<>();
        list.add(new TestBean());
        list.add(new TestBean());
        list.add(new TestBean());

        Observable.from(list)
                .flatMap(new Func1<TestBean, Observable<String>>() {
                    @Override
                    public Observable<String> call(TestBean testBean) {
                        return Observable.from(testBean.strings);
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });

        Observable.just("b", "a")
                .toSortedList(new Func2<String, String, Integer>() {
                    @Override
                    public Integer call(String s, String s2) {
                        return 1;
                    }
                })
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> strings) {
                        for (String s : strings) {
                            System.out.println(s);
                        }
                    }
                });

        Observable.just(1, 2)
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer > 3;
                    }
                })
                .first()
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println(integer);
                    }
                });
    }
}
