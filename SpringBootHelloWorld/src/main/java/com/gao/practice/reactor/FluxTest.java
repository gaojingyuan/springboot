package com.gao.practice.reactor;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class FluxTest {
    public static void main(String[] args) {
//        参考：https://www.ibm.com/developerworks/cn/java/j-cn-with-reactor-response-encode/index.html
        System.out.println(StringUtils.isBlank(StringUtils.EMPTY));
        System.out.println("Buffer");
        System.out.println("5 个包含 20 个元素的数组");
        Flux.range(1, 100).buffer(20).subscribe(System.out::println);
//        2 个包含了 10 个元素的数组 api不兼容
//        Flux.intervalMillis(100).bufferMillis(1001).take(2).toStream().forEach(System.out::println);
        System.out.println("5 个包含 2 个元素的数组");
        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
        System.out.println("5 个包含 1 个元素的数组");
        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);

        System.out.println("filter");
        System.out.println("对流中包含的元素进行过滤，中的语句输出的是 1 到 10 中的所有偶数。");
        Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);

        System.out.println("window");
        System.out.println("window 操作符的作用类似于 buffer，所不同的是 window 操作符是把当前流中的元素收集到另外的 Flux 序列中，因此返回值类型是 Flux<Flux<T>>");
        Flux.range(1, 100).window(20).subscribe(System.out::println);
//        Flux.intervalMillis(100).windowMillis(1001).take(2).toStream().forEach(System.out::println);

        System.out.println("zipWith");
        System.out.println("操作符没有使用合并函数，因此结果流中的元素类型为Tuple2");
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"))
                .subscribe(System.out::println);
        System.out.println("zipWith操作通过合并函数把元素类型变为String");
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
                .subscribe(System.out::println);

//        take(long n)，take(Duration timespan)和 takeMillis(long timespan)：按照指定的数量或时间间隔来提取。
//        takeLast(long n)：提取流中的最后 N 个元素。
//        takeUntil(Predicate<? super T> predicate)：提取元素直到 Predicate 返回 true。
//        takeWhile(Predicate<? super T> continuePredicate)： 当 Predicate 返回 true 时才进行提取。
//        takeUntilOther(Publisher<?> other)：提取元素直到另外一个流开始产生元素。
        System.out.println("take");
        System.out.println("数字 1 到 10");
        Flux.range(1, 1000).take(10).subscribe(System.out::println);
        System.out.println("数字 991 到 1000");
        Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
        System.out.println("数字 1 到 9");
        Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(System.out::println);
        System.out.println("数字 1 到 10");
        Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);

        System.out.println("reduce&reduceWith");
        System.out.println("对流中的元素进行相加操作，结果为 5050");
        Flux.range(1, 100).reduce((x, y) -> x + y).subscribe(System.out::println);
        System.out.println("Supplier 给出了初始值为 100，所以结果为 5150");
        Flux.range(1, 100).reduceWith(() -> 100, (x, y) -> x + y).subscribe(System.out::println);

        System.out.println("merge&mergeSequential");
//        merge 和 mergeSequential 操作符用来把多个流合并成一个 Flux 序列。不同之处在于 merge 按照所有流中元素的实际产生顺序来合并，而 mergeSequential 则按照所有流被订阅的顺序，以流为单位进行合并。
//        Flux.merge(Flux.intervalMillis(0, 100).take(5), Flux.intervalMillis(50, 100).take(5))
//                .toStream()
//                .forEach(System.out::println);
//        Flux.mergeSequential(Flux.intervalMillis(0, 100).take(5), Flux.intervalMillis(50, 100).take(5))
//                .toStream()
//                .forEach(System.out::println);

        System.out.println("concatMap");
//      oncatMap 操作符的作用也是把流中的每个元素转换成一个流，再把所有流进行合并。与 flatMap 不同的是，concatMap 会根据原始流中的元素顺序依次把转换之后的流进行合并；与 flatMapSequential 不同的是，concatMap 对转换之后的流的订阅是动态进行的，而 flatMapSequential 在合并之前就已经订阅了所有的流。
//        Flux.just(5, 10)
//                .concatMap(x -> Flux.intervalMillis(x * 10, 100).take(x))
//                .toStream()
//                .forEach(System.out::println);

        System.out.println("combineLatest");
//      combineLatest 操作符把所有流中的最新产生的元素合并成一个新的元素，作为返回结果流中的元素。只要其中任何一个流中产生了新的元素，合并操作就会被执行一次，结果流中就会产生新的元素。在 代码清单 14 中，流中最新产生的元素会被收集到一个数组中，通过 Arrays.toString 方法来把数组转换成 String。
//        Flux.combineLatest(
//                Arrays::toString,
//                Flux.intervalMillis(100).take(5),
//                Flux.intervalMillis(50, 100).take(5)
//        ).toStream().forEach(System.out::println);



    }
}
