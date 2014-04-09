package main.java.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

public class FileCharacterParser {

	public TreeMap<Character, Integer> mapAndParseFile(
			String pathToFile) throws Exception {

		// Create new TreeMap with all letters and default count set to 0
		TreeMap<Character, Integer> characterCountMap = createNewCharacterCountMap();

		// Create a file object from path to file
		BufferedReader fileReader = createFileReaderFromPath(pathToFile);

		// Parse file and increment letter counts
		characterCountMap = parseLetterCountsFromFile(characterCountMap,
				fileReader);

		return characterCountMap;
	}

	public BufferedReader createFileReaderFromPath(String pathToFile)
			throws Exception {
		// If invalid path given, throw exception
		if (pathToFile == null || pathToFile.isEmpty()) {
			throw new Exception("Path to file is missing");
		}

		// Create Buffered reader from file object
		return new BufferedReader(new FileReader(new File(pathToFile)));
	}

	public TreeMap<Character, Integer> createNewCharacterCountMap() {
		TreeMap<Character, Integer> defaultCharacterCountMap = new TreeMap<Character, Integer>();
		defaultCharacterCountMap.put('a', 0);
		defaultCharacterCountMap.put('b', 0);
		defaultCharacterCountMap.put('c', 0);
		defaultCharacterCountMap.put('d', 0);
		defaultCharacterCountMap.put('e', 0);
		defaultCharacterCountMap.put('f', 0);
		defaultCharacterCountMap.put('g', 0);
		defaultCharacterCountMap.put('h', 0);
		defaultCharacterCountMap.put('i', 0);
		defaultCharacterCountMap.put('j', 0);
		defaultCharacterCountMap.put('k', 0);
		defaultCharacterCountMap.put('l', 0);
		defaultCharacterCountMap.put('m', 0);
		defaultCharacterCountMap.put('n', 0);
		defaultCharacterCountMap.put('o', 0);
		defaultCharacterCountMap.put('p', 0);
		defaultCharacterCountMap.put('q', 0);
		defaultCharacterCountMap.put('r', 0);
		defaultCharacterCountMap.put('s', 0);
		defaultCharacterCountMap.put('t', 0);
		defaultCharacterCountMap.put('u', 0);
		defaultCharacterCountMap.put('v', 0);
		defaultCharacterCountMap.put('w', 0);
		defaultCharacterCountMap.put('x', 0);
		defaultCharacterCountMap.put('y', 0);
		defaultCharacterCountMap.put('z', 0);

		return defaultCharacterCountMap;
	}

	public TreeMap<Character, Integer> parseLetterCountsFromFile(
			TreeMap<Character, Integer> characterCountMap,
			BufferedReader fileReader) throws FileNotFoundException {
		try {
			int readValue;
			while ((readValue = fileReader.read()) != -1) {
				// Make characters lower case
				char charValue = Character.toLowerCase((char) readValue);
				if (characterCountMap.containsKey(charValue)) {
					characterCountMap.put(charValue,
							characterCountMap.get(charValue) + 1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return characterCountMap;
	}

	public void printCharacterCountsOfFile(
			TreeMap<Character, Integer> characterCountMap) {
		Iterator<Entry<Character, Integer>> entries = characterCountMap
				.entrySet().iterator();
		int totalLetterCount = 0;
		while (entries.hasNext()) {
			Entry<Character, Integer> thisEntry = (Entry<Character, Integer>) entries
					.next();
			Character key = (Character) thisEntry.getKey();
			Integer value = (Integer) thisEntry.getValue();
			if (value > 0) {
				totalLetterCount++;
				System.out.println(key + " = " + value);
			}
		}
		if (totalLetterCount == 0) {
			System.out.println("No letters were detected in file");
		}
	}

}
