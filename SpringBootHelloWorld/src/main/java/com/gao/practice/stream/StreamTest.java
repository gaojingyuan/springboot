package com.gao.practice.stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Stream提供的API 待补充
// 1. Stream<T> stream = Stream.of(T... values);
// 2. Stream<Object> build = Stream.builder().add(1).add(2).build();
// 3. Stream<Integer> iterate= Stream.iterate(0, x -> x + 1).limit(3);
// 4. Stream<String> generate = Stream.generate(() -> "hello world").limit(3);

// map flatmap分别什么作用？ map进行一对一的对象转换 flatmap可把多个集合内容合并为一个(Stream<List<Integer>> 转Stream<Integer>) 待补充
// Stream<Integer> IntStream Optional<Integer> OptionalInt 为什么支持了泛型还对特定类型进行封装？ 目的是免除额外的装箱拆箱消耗 ok

// java.util.function主要接口(以下接口是对lambda表达式的形容) 以Bi开头的2个参数
// 除一下方法外 还对int long double2个类型进行了接口封装
// Predicate<T>——接收T对象并返回boolean ReferencePipeline类里filter、anyMatch、allMatch、allMatch参数都是 Predicate
// Supplier<T>——提供T对象（例如工厂），不接收值
// Consumer<T>——接收T对象，不返回值 Consumer<String> getName2 = (a) -> System.out.println("aaa");
// Function<T, R>——接收T对象，返回R对象
// UnaryOperator<T>——接收T对象，返回T对象 也属于接收一个对象 返回一个对象 只是2个对象相同而已

// Collectors类 Collector接口
// reduce用法
// collect用法 averagingInt groupingBy等
// boxed用法
// Objects.requireNonNull(other);
// coverage Stream Test工具什么鬼
// peek(System.out::println) 为什么能省略参数 peek(e -> System.out.print("a" + e))
public class StreamTest {
    public static void main(String[] args) {

        // （一）数据列表
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5, 5);
        // 创建流
        Stream<List<Integer>> listStream = Stream.of(list);

        // 返回stream
        // 过滤filter
        Stream<Integer> filterStream = list.stream().filter(i -> i > 3);// Predicate
        IntStream filterIntStream = list.stream().mapToInt(o -> o).filter(i -> i > 3);// IntPredicate

        // 去重distinct
        Stream<Integer> distinctStream = list.stream().distinct();
        IntStream distinctIntstream = list.stream().mapToInt(o -> o).distinct();
        // 排序sorted
        Stream<Integer> sortedStream = list.stream().sorted((a, b) -> (a - b));// Comparator
        IntStream sortedIntStream = list.stream().mapToInt(o -> o).sorted();// 没有比较器。。
        // 监听peek 消费时会调用peek的函数
        Stream<Integer> peekStream = list.stream().peek(e -> System.out.println("some one will use" + e));// Consumer
        peekStream.forEach(e -> System.out.println("some one use" + e));
        // 前4个limit
        Stream<Integer> limitStream = list.stream().limit(4);
        // 跳过前4个skip
        Stream<Integer> skipStream = list.stream().skip(4);
        // 连接 只能连接2个 联合机多个
        Stream<Integer> concatStream = Stream.concat(Stream.of(1, 2), Stream.of(3));
        // 连接多个可用flatmap 下例中List::stream把3个list 转化成了一个Stream<Integer>
        Stream<List<Integer>> inputStream1 = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        inputStream1.flatMap(List::stream).forEach(System.out::println);
        // 以下写法forEach得到的是List<Integer>
        Stream<List<Integer>> inputStream2 = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        inputStream2.map((ls) -> ls.size()).forEach(System.out::println);
        System.out.println("stream");

        // 返回统计数据 聚合
        // 最大值
        Integer max = list.stream().max((a, b) -> (a - b)).get();
        Integer maxIntStream = list.stream().mapToInt(o -> o).max().getAsInt();
        Integer maxReduce = list.stream().reduce(Math::max).get();
        Integer maxCollect = list.stream().collect(Collectors.maxBy((a, b) -> (a - b))).get();
        // 最小值 同上
        Integer min = list.stream().min((a, b) -> (a - b)).get();
        // 加和
        Integer sum = list.stream().mapToInt(o -> o).sum();
        // 平均值
        Double avg = list.stream().mapToInt(o -> o).average().getAsDouble();
        Double avarage = list.stream().collect(Collectors.averagingInt(item -> item));
        // 统计 IntSummaryStatistics{count=7, sum=25, min=1, average=3.571429, max=5}
        IntSummaryStatistics streamStatistics = list.stream().collect(Collectors.summarizingInt(value -> value));
        System.out.println(streamStatistics.toString());
        IntSummaryStatistics IntStreamStatistics = list.stream().mapToInt(o -> o).summaryStatistics();
        System.out.println(IntStreamStatistics.toString());

        // IntStream的静态方法用于生产IntStream对象 区间
        IntStream rangeIntStream = IntStream.range(1, 5);// 左闭右开
        IntStream rangeClosedIntStream = IntStream.rangeClosed(6, 10);// 闭区间
        IntStream concatIntStream = IntStream.concat(IntStream.range(1, 5), IntStream.rangeClosed(6, 10));// 连接
        // rangeStream.forEach(System.out::println);

        // 转换为list
        // http://javarevisited.blogspot.jp/2015/03/5-ways-to-convert-java-8-stream-to-list.html
        List<Integer> res = list.stream().collect(Collectors.toList());
        List<Integer> res1 = list.stream().collect(Collectors.toCollection(ArrayList::new));

        // （二）对象列表
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(18, "张三", "男"));
        persons.add(new Person(28, "李四", "男"));
        persons.add(new Person(38, "王五", "女"));
        persons.add(new Person(38, "赵六", "女"));

        Stream<Person> stream = persons.stream();

        // 过滤
        Stream<Person> boyStream = stream.filter((Person s) -> s.getSexy().equals("男"));
        System.out.println("男的人数:" + boyStream.count());
        // 年龄列表
        List<Integer> newList = new ArrayList<>();
        persons.stream().mapToInt((Person s) -> s.getAge()).forEach(newList::add);

        Function<Person, Integer> getAge = Person::getAge;
        persons.stream().map(getAge).forEach(newList::add);
        // 平均年龄
        Double avgAge = persons.stream().collect(Collectors.averagingInt(Person::getAge));
        // 年龄分组 类似于guava的ArrayListMultimap
        Map<Integer, List<Person>> ageMap = persons.stream().collect(Collectors.groupingBy(Person::getAge));

        // （三）方法面向对象 java.util.function包
        // 接收T对象并返回boolean
        Predicate<String> predicate = (str) -> "aaa".equals(str);
        // 提供T对象（例如工厂），不接收值
        Supplier<String> supplier = () -> "aaa";
        // Consumer<T>——接收T对象，不返回值
        Consumer<String> consumer = (str) -> System.out.println(str + "aaa");
        // Function<T, R>——接收T对象，返回R对象
        Function<String, Integer> function = (str) -> Integer.valueOf(str);
        // UnaryOperator<T>——接收T对象，返回T对象 extends Function<T, T>
        UnaryOperator<String> unaryOperator = (str) -> str + "ss";
        // BiFunction接收2个不同对象 返回1个相同对象
        BiFunction<String, Integer, String> biFunction = (i, str) -> i + str;
        // BinaryOperator<T>——接收两个T对象，返回T对象 extends BiFunction<T,T,T>
        BinaryOperator<String> binaryOperator = (s1, s2) -> s1 + s2;
        System.out.println("over");

    }

}
