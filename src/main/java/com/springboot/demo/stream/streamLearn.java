package com.springboot.demo.stream;



import com.springboot.demo.Dao.Person;
import com.springboot.demo.Dao.PersonVo;

import java.util.*;
import java.util.stream.Collectors;


public class streamLearn {
    public static void main(String[] args) {
        test1();

    }

    public static void test1() {
        List<PersonVo> list = new ArrayList<PersonVo>();
        list.add(new PersonVo("aa", 11, "EN"));
        list.add(new PersonVo("bb", 22,"EN"));
        list.add(new PersonVo("cc", 33, "JP"));
        list.add(new PersonVo("dd", 44,"CH"));
        list.add(new PersonVo("ee", 55,"CH"));

        List<Person> personList = list.stream()
                .filter(i->!Objects.equals(i.getName(),"bilyWong"))
                .map(i->{
                    Person perPerson = new Person();
                    perPerson.setSkin("black");
                    perPerson.setName(i.getName());
                    perPerson.setAge(i.getAge());
                    return perPerson;
                })
                .collect(Collectors.toList());

        Map<Integer, Person> map = new HashMap<>();
        int count = 1;
//        list.stream().collect(Collectors.toMap(count++, new PersonVo()));


//        for(Person p: personList){
//            System.out.println(p);
//        }

        /**
         * 去空
         */
//        if(list.size()>0){
//            list.removeIf(elem -> StrUtil.isEmpty(elem.getUid()));
//        }

        /**
         * 排序1
         */

//        Collections.sort(list, new Comparator<CommunityNews>() {
//            @Override
//            public int compare(CommunityNews o1, CommunityNews o2) {
//                return o1.getTopSort().compareTo(o2.getTopSort());
//            }
//        });

        /**
         * 排序2
         */
//
//        Collections.sort(list, ((o1, o2) -> o2.getTopSort().compareTo(o1.getTopSort())));

        /**
         * 排序3
         */
//         list.sort(Comparator.comparing(CommunityNews::getTopSort));

        /**
         * filter
         */
//        list = list.stream()
//                .filter(s-> s.getTopSort() > 1)
//                .filter(s-> s.getUid().startsWith("a"))
//                .filter(s-> "aa".equals(s.getUid()))
//                .collect(Collectors.toList());
//
//        list.forEach(System.out::println);



        /**
         * count
         */
//        Long count = list.stream().distinct().count();
//        System.out.println(count);

        /**
         * 去重1
         */
//        list = list.stream()
//                .filter(distinctByKey(b->b.getage()))
//                .collect(Collectors.toList());
//


        /**
         * map:保留一项
         */
//        Set<Integer> collectset = list.stream().map(CommunityNews::getTopSort).collect(Collectors.toSet());
//        collectset.forEach(System.out::println);

        /**
         * map:類型轉換pair -> map
         */
//        List<Pair<String, Integer>>  pairList = new ArrayList<>(3);
//        pairList.add(new Pair<>("version", 20));
//        pairList.add(new Pair<>("version1", 21));
//        pairList.add(new Pair<>("version2", 22));
//        Map<String, Integer> map = pairList.stream().collect(
//                Collectors.toMap(Pair::getKey,Pair::getValue)
//        );
//        System.out.println(map);



        /**
         * map
         */
//        List<Integer> number = Arrays.asList(11,11,11,44,55,66,77);
//        List<Integer> squareNumber = number.stream().map(i -> i*i).distinct().collect(Collectors.toList());
//        System.out.println(squareNumber);


        /**
         * List ->map
         */
//        Map<String, String> map = list.stream()
//                .collect(Collectors.toMap(Person::getname, Person::toString));
//        map.entrySet().forEach(System.out::println);




//        public static <T > Predicate < T > distinctByKey(Function < ? super T, ?>keyExtractor){
//            Map<Object, Boolean> seen = new ConcurrentHashMap<>();
//            // 当putIfAbsent返回值为空时，过滤
//            return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
        }




}
