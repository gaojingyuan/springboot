package com.gao.practice.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;

import java.util.ArrayList;

/*
 *  参考资料
 *  http://blog.csdn.net/ugnei66/article/details/43743127
 */
public class GuavaTest {
    public static void main(String[] args) {
//        Person person1 = new Person(1, "Wilma", 16);
//        Person person2 = new Person(2, "Fred", 18);
//        Person person3 = new Person(3, "Betty", 20);
//        Person person4 = new Person(4, "Barney", 24);
//        Person person5 = new Person(5, "Sunny", 26);
//        Person person6 = new Person(6, "winter", 28);
//
//        List<Person> personList = Lists.newArrayList(person1, person2, person3, person4, person5, person6);
//
//        // 将年龄大于18岁的选出
//        Predicate<Person> predicate = new Predicate<Person>() {
//            @Override
//            public boolean apply(Person person) {
//                return person.getAge() > 18;
//            }
//        };
//        Iterable<Person> personsFilteredByAge = FluentIterable.from(personList).filter(predicate);
//        for (Person p : personsFilteredByAge) {
//            System.out.println(p.getName());
//        }
//
//        // 将list中的名字修改
//        List<Person> transformPersonList = FluentIterable
//                .from(personList)
//                .transform(new Function<Person, Person>() {
//                    @Override
//                    public Person apply(Person input) {
//                        input.setName("A-" + input.getName());
//                        return input;
//                    }
//                }).toList();
//        for (Person p : transformPersonList) {
//            System.out.println(p.getName());
//        }
//
//        Range<Integer> ageRange = Range.closed(22, 30);
//        Function<Person, Integer> ageFunction = new Function<Person, Integer>() {
//            @Override
//            public Integer apply(Person input) {
//                return input.getAge();
//            }
//        };
//        Predicate<Person> predicate1 = Predicates.compose(ageRange, ageFunction);
//        Iterable<Person> personsFilteredByAgeRange = FluentIterable.from(personList).filter(predicate1);
//        for (Person p : personsFilteredByAgeRange) {
//            System.out.println(p.getName());
//        }
//
//        // 将list每2个一组 生成新list
//        List<List<Person>> subList = Lists.partition(personList, 2);
//        for (List<Person> pList : subList) {
//            System.out.println(pList.size());
//        }
//
//        // 将list转换为map 例如以person Id为Key person为value
//        Map<Integer, Person> personMap = Maps.uniqueIndex(personList.iterator(), new Function<Person, Integer>() {
//            @Override
//            public Integer apply(Person input) {
//                return input.getId();
//            }
//        });
//        for (Map.Entry<Integer, Person> entry : personMap.entrySet()) {
//            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue().getName());
//        }
//
//        ArrayListMultimap<String, String> multiMap = ArrayListMultimap.create();
//        multiMap.put("Foo", "1");
//        multiMap.put("Foo", "2");
//        multiMap.put("Foo", "3");
//        multiMap.put("Foo", "3");
//        List<String> list = multiMap.get("Foo");
//        System.out.println(list);
//
//        HashMultimap<String, String> hashMultiMap = HashMultimap.create();
//        hashMultiMap.put("Foo", "1");
//        hashMultiMap.put("Foo", "2");
//        hashMultiMap.put("Foo", "3");
//        Set<String> set = hashMultiMap.get("Foo");
//        System.out.println(set);

//        BiMap<String, String> biMap = HashBiMap.create();
//        biMap.put("1", "Tom");
//        biMap.put("2", "Tom");
//        System.out.println(biMap);

        ArrayList<BoxInfo> boxList = Lists.newArrayList();
        boxList.add(new BoxInfo(0,"aa"));
        boxList.add(new BoxInfo(0,"aa"));
        boxList.add(new BoxInfo(1,"aa"));
        boxList.add(new BoxInfo(1,"aa"));
        boxList.add(new BoxInfo(1,"aa"));

        ArrayListMultimap<Integer, BoxInfo> boxMap = ArrayListMultimap.create();
        for(BoxInfo box :boxList){
            boxMap.put(box.getBoxType(),box);
        }

        System.out.println(boxMap.get(0).size());
        System.out.println(boxMap.get(1).size());
    }

}
