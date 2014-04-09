package main.java.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class FileCharacterParserPrompt {

	public static void main(String[] args) throws Exception {

		System.out
				.println("Enter the file location to parse (ex: /tmp/test.txt): ");
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(
				System.in));
		String inputFileName;
		try {
			inputFileName = inputReader.readLine();
			while (inputFileName == null || "".equals(inputFileName)) {
				System.out.println("Invalid file name, please enter again:");
				inputFileName = inputReader.readLine();
			}

			System.out.println("Now parsing file '" + inputFileName + "'...");
			FileCharacterParser FileParser = new FileCharacterParser();
			TreeMap<Character, Integer> characterCountMap = FileParser
					.mapAndParseFile(inputFileName);
			FileParser.printCharacterCountsOfFile(characterCountMap);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}