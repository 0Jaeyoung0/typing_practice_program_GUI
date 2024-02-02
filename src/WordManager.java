import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class WordManager {
    private Vector<VisibleWord> wordPool;           // a total of words
    private Vector<VisibleWord> exercisePool;       // words for exercise

    // constructor
    public WordManager() {

    }

    // constructor, size indicates the initial size of vector
    public WordManager(int size) {

    }

    // to insert new VisibleWord object to wordPool vector.
    // if the insertion is successfully completed, return true. otherwise return false.
    public boolean insert(String sentence) {

    }

    // to divide sentence to words, and words are stored in String array.
    // returns String array
    public String[] divideWords(String sentence) {

    }

    // to load words from the file and insert new VisibleWord object to wordPool vector.
    // if the insertion is successfully completed, return true. otherwise return false.
    public boolean load(String fileName) {

    }

    // if the value of originalWord is findWord, replace the value of visibleWord to replaceWord
    // return the number of replaced words.
    // you have to use Iterator for searching the vector
    public int replace(String findWord, String replaceWord) {

    }

    // to delete Visible object whose originalWord is word
    // return the number of deleted words.
    public int delete(String word) {

    }

    // to set visibleWord value to originalWord value for all words
    public void restore() {

    }

    // to print all data
    // you have to use size and get method of Vector class
    public void print() {

    }

    // print all visible word in wordPool to JtextArea
    // you have to use size and get method of Vector class
    public void print(JTextArea textArea) {

    }
    
    // print the String content to JtextArea
    // you have to use size and get method of Vector class
    public void print(JTextArea textArea, String content) {

    }

    // make a problem from wordPool vector for typing practice
    // the length of white space is randomly determined, and the length is rounded.
    // return the number of words for typing practice
    public int makeExercise(int countOfWord, int widthOfLine) {

    }
    
    
    // make and return the white space string with length
    public String makeWhiteSpace(int length) {

    }

    // check whether the answer is contained in exercisePool vector
    // if the answer is included, replace the word of exercisePool to white space with equal size
    // return the number of matched words
    public int checkAnswer(String answer) {

    }

    // make a sentence from exercisePool vector for displaying the exercise
    // return the display sentence
    public String displayExercise() {

    }

    // remove all data from exercise pool
    public void cleanExercisePool() {

    }

    // return VisibleWord object which is stored at 'index' in Vector
    public VisibleWord getData(int index) {

    }

    // return VisibleWord object which is recently stored in Vector
    public VisibleWord getLastData() {

    }
}