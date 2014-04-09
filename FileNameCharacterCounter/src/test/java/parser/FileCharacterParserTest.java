package test.java.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import main.java.parser.FileCharacterParser;

import org.junit.Test;

public class FileCharacterParserTest {

	@Test
	public void test() {
		try {
			FileCharacterParser parser = new FileCharacterParser();
			TreeMap<Character, Integer> characterCountMap= parser.mapAndParseFile("/tmp/1000-males-names.txt");
			Iterator entries = characterCountMap.entrySet().iterator();
			while (entries.hasNext()) {
			  Entry thisEntry = (Entry) entries.next();
			  Character key = (Character) thisEntry.getKey();
			  Integer value = (Integer) thisEntry.getValue();
			  if(value > 0){
				  System.out.println(key + " = " + value);
			  }
			}
		} catch (Exception e) {
			fail("No exception should have been thrown");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateFileFromPathWithNullFilePath(){
		FileCharacterParser parser = new FileCharacterParser();
		try{
			parser.mapAndParseFile(null);
			fail("Exception should have been thrown at this point");
		}catch (Exception e){
			final String errorMessage = "Path to file is missing";
		    assertEquals(errorMessage, e.getMessage());
		}
	}
	
	@Test
	public void testCreateFileFromPathWithEmptyFilePath(){
		FileCharacterParser parser = new FileCharacterParser();
		try{
			parser.mapAndParseFile("");
			fail("Exception should have been thrown at this point");
		}catch (Exception e){
			final String errorMessage = "Path to file is missing";
		    assertEquals(errorMessage, e.getMessage());
		}
	}
	
	@Test
	public void testCreateFileFromPathWithIncorrectFilePath(){
		FileCharacterParser parser = new FileCharacterParser();
		try{
			parser.mapAndParseFile("fake-file.txt");
			fail("Exception should have been thrown at this point");
		}catch (Exception e){
			final String errorMessage = "fake-file.txt (No such file or directory)";
			System.out.println("e.getMessage(): " + e.getMessage());
		    assertEquals(errorMessage, e.getMessage());
		}
	}
}
