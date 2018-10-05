/*
 * Copyright 2018 Orest Vasylyshyn.
 */
package com.orest.hilleltestapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Orest Vasylyshyn
 */
public class HillelTestApp {

	/**
	 * Method remove from string next characters: ".,/-;: and divide into words
	 *
	 * @param text Text that will be divided into separate words
	 * @return list of words
	 */
	private static List<String> textToWordList(String text) {
		List<String> result = new ArrayList<>();
		String[] words = text.replaceAll("[\".,/;:-]", "").split(" ");
		result = Arrays.asList(words);
		return result;
	}

	/**
	 * Method checks for the word in the list
	 *
	 * @param word Word that will be checked
	 * @param list List of words
	 * @return boolean
	 */
	public static boolean wordContainsInList(String word, List<String> list) {
		for (String str : list) {
			if (str.equalsIgnoreCase(word)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 2. Generic method that takes an array of objects and a collection, and puts all objects in the
	 * array into the collection.
	 *
	 * @param array Word that will be checked
	 * @param collection List of words
	 */
	public static void arrayToCollection(Object array[], Collection<Object> collection) {
		collection.addAll(Arrays.asList(array));
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		String fileName = "text.txt";

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			List<String> distinctWords = new ArrayList<>();
			stream.forEach(item -> {
				textToWordList(item).forEach(word -> {
					if (!word.isEmpty() && !wordContainsInList(word, distinctWords)) {
						distinctWords.add(word);
					}
				});
			});

			distinctWords.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
