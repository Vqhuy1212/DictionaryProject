package test;

import service.DictionaryService;
import entity.Word;
import entity.NounDefinition;
import entity.AdjectiveDefinition;
import entity.Pronunciation;

/**
 * Simple test class - không cần JUnit
 * Chạy bằng main method
 */
public class DictionaryServiceTest {

    private static DictionaryService service;
    private static int testsPassed = 0;
    private static int testsFailed = 0;

    public static void main(String[] args) {
        service = DictionaryService.getInstance();

        System.out.println("========== DICTIONARY SERVICE TESTS ==========\n");

        // Test 1: Define mới
        testDefineNewWord();

        // Test 2: Lookup từ vừa define
        testLookupWord();

        // Test 3: Define thêm definition
        testAddMoreDefinitions();

        // Test 4: Drop từ
        testDropWord();

        // Test 5: Case insensitive
        testCaseInsensitive();

        // In kết quả
        System.out.println("\n========== TEST RESULTS ==========");
        System.out.println("Passed: " + testsPassed);
        System.out.println("Failed: " + testsFailed);
        System.out.println("Total: " + (testsPassed + testsFailed));
    }

    /**
     * Test 1: Define một từ mới
     */
    private static void testDefineNewWord() {
        try {
            String testName = "Test 1: Define new word";
            Word word = new Word("apple");
            word.addDefinition(new NounDefinition("a red fruit", "I like apple", "Tôi thích táo"));

            service.define(word);

            Word result = service.lookup("apple");
            if (result != null && result.getDefinitions().size() == 1) {
                print(testName, "✓ PASSED", true);
            } else {
                print(testName, "✗ FAILED - Word not found", false);
            }
        } catch (Exception e) {
            print("Test 1", "✗ EXCEPTION: " + e.getMessage(), false);
        }
    }

    /**
     * Test 2: Lookup từ
     */
    private static void testLookupWord() {
        try {
            String testName = "Test 2: Lookup word";
            Word result = service.lookup("apple");

            if (result != null && result.getKeyword().equalsIgnoreCase("apple")) {
                print(testName, "✓ PASSED", true);
            } else {
                print(testName, "✗ FAILED - Lookup failed", false);
            }
        } catch (Exception e) {
            print("Test 2", "✗ EXCEPTION: " + e.getMessage(), false);
        }
    }

    /**
     * Test 3: Thêm nhiều definitions
     */
    private static void testAddMoreDefinitions() {
        try {
            String testName = "Test 3: Add multiple definitions";
            Word word = new Word("apple");
            word.addDefinition(new AdjectiveDefinition("red", "", ""));

            service.define(word);

            Word result = service.lookup("apple");
            if (result != null && result.getDefinitions().size() >= 2) {
                print(testName, "✓ PASSED - Has " + result.getDefinitions().size() + " definitions", true);
            } else {
                print(testName, "✗ FAILED", false);
            }
        } catch (Exception e) {
            print("Test 3", "✗ EXCEPTION: " + e.getMessage(), false);
        }
    }

    /**
     * Test 4: Drop từ
     */
    private static void testDropWord() {
        try {
            String testName = "Test 4: Drop word";
            Word word = new Word("banana");
            word.addDefinition(new NounDefinition("yellow fruit", "", ""));
            service.define(word);

            service.drop("banana");

            Word result = service.lookup("banana");
            if (result == null) {
                print(testName, "✓ PASSED", true);
            } else {
                print(testName, "✗ FAILED - Word still exists", false);
            }
        } catch (Exception e) {
            print("Test 4", "✗ EXCEPTION: " + e.getMessage(), false);
        }
    }

    /**
     * Test 5: Case insensitive
     */
    private static void testCaseInsensitive() {
        try {
            String testName = "Test 5: Case insensitive lookup";
            Word word = new Word("Orange");
            word.addDefinition(new NounDefinition("fruit", "", ""));
            service.define(word);

            Word result1 = service.lookup("orange");
            Word result2 = service.lookup("ORANGE");

            if (result1 != null && result2 != null) {
                print(testName, "✓ PASSED", true);
            } else {
                print(testName, "✗ FAILED", false);
            }
        } catch (Exception e) {
            print("Test 5", "✗ EXCEPTION: " + e.getMessage(), false);
        }
    }

    /**
     * Helper method để in test result
     */
    private static void print(String testName, String result, boolean passed) {
        System.out.println(testName);
        System.out.println("  " + result);

        if (passed) {
            testsPassed++;
        } else {
            testsFailed++;
        }
        System.out.println();
    }
}