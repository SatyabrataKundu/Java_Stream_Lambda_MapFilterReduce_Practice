package com.practice.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.practice.model.Person;

/**
 *
 * @author Satyabrata Kundu
 */
public class CollectorsExample {

	public static void main(String... args) {

		List<Person> persons = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(CollectorsExample.class.getResourceAsStream("people.txt")));

				Stream<String> stream = reader.lines();) {

			stream.map(line -> {
				String[] s = line.split(" ");
				Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
				persons.add(p);
				return p;
			}).forEach(System.out::println);

		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		System.out.println("----------------------------------------");
		persons.stream().filter(p -> p.getAge() > 30).forEach(System.out::println);

		System.out.println("----------------------------------------");
		Optional<Person> minAge = persons.stream().filter(p -> p.getAge() > 30)
				.min(Comparator.comparing(Person::getAge));
		System.out.println(minAge);

		System.out.println("----------------------------------------");

		Map<Integer, String> m = persons.stream().collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.joining(","))));
		System.out.print(m);

	}
}
