package com.practice.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.practice.model.City;
import com.practice.model.People;

/**
*
* @author Satyabrata Kundu
*/
public class CollectionListMap {

    public static void main(String[] args) {

        People p1 = new People("Alice", 23);
        People p2 = new People("Brian", 56);
        People p3 = new People("Chelsea", 46);
        People p4 = new People("David", 28);
        People p5 = new People("Erica", 37);
        People p6 = new People("Francisco", 18);
        List<People> persons = new ArrayList <People>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);
        persons.add(p6);
        System.out.println("---------------------------------");
        persons.forEach(System.out::println);
        System.out.println("---------------------------------");
        
        City newYork = new City("New York");
        City shanghai = new City("Shanghai");
        City india = new City("India");
        
        Map<City, List<People>> map = new HashMap<>();
        
        map.put(newYork, persons);
        map.forEach((c, p) -> System.out.println(c + " : " + p));
        System.out.println("---------------------------------");
        
        map.putIfAbsent(newYork, new ArrayList<>());
        map.get(newYork).add(new People("Satya", 32));
        map.forEach((c, p) -> System.out.println(c + " : " + p));
        System.out.println("---------------------------------");
        map.computeIfAbsent(india, city-> new ArrayList<>()).add( new People("Nutu", 32));
        map.forEach((c, p) -> System.out.println(c + " : " + p));
        System.out.println("---------------------------------");
        
        

        System.out.println("People from Shanghai : " + map.getOrDefault(shanghai, Collections.EMPTY_LIST));
        System.out.println("People from New York : " + map.getOrDefault(newYork, Collections.EMPTY_LIST));
        
        Map<City, List<People>> source = new HashMap<>();
        source.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p1);
        source.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p2);
        source.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p3);
        
        System.out.println("Map 1");
        source.forEach((city, people) -> System.out.println(city + " : " + people));

        
        Map<City, List<People>> destination = new HashMap<>();
        destination.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p4);
        destination.computeIfAbsent(india, city -> new ArrayList<>()).add(p5);
        destination.computeIfAbsent(india, city -> new ArrayList<>()).add(p6);
        
        System.out.println("Map 2");
        destination.forEach((city, people) -> System.out.println(city + " : " + people));
        
		source.forEach((key, value) -> {
			destination.merge(key, value, (peoplefromSource, peoplefromDestination) -> {
				peoplefromDestination.addAll(peoplefromSource);
				return peoplefromDestination;
			});
		});
		System.out.println("------------------------Merged Map");
		destination.forEach((city, people) -> System.out.println(city + " : " + people));
//
//        map2.forEach(
//                (city, people) -> {
//                    map1.merge(
//                            city, people, 
//                            (peopleFromMap1, peopleFromMap2) -> {
//                                peopleFromMap1.addAll(peopleFromMap2);
//                                return peopleFromMap1;
//                            });
//                }
//        );
//        
//        System.out.println("Merged map1 ");
//        map1.forEach(
//                (city, people) -> System.out.println(city + " : " + people)
//        );
    }
}
