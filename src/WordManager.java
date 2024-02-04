import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Vector;

public class WordManager {
    private Vector<VisibleWord> wordPool;           // a total of words
    private Vector<String> exercisePool;       // words for exercise
    private int matchedWords = 0;

    // constructor
    public WordManager() {
        wordPool = new Vector<>();
        exercisePool = new Vector<>();
    }

    // constructor, size indicates the initial size of vector
    public WordManager(int size) {
        wordPool = new Vector<>(size);
        exercisePool = new Vector<>();
    }

    // to insert new VisibleWord object to wordPool vector.
    // if the insertion is successfully completed, return true. otherwise return false.
    public boolean insert(String sentence) {
        if(sentence.trim().isEmpty())
            return false;
        else {
            String[] words = divideWords(sentence);

            for(String originalWord : words) {
                VisibleWord visibleWord = new VisibleWord(originalWord);
                wordPool.add(visibleWord);
            }

            return true;
        }
    }

    // to divide sentence to words, and words are stored in String array.
    // returns String array
    public String[] divideWords(String sentence) {
        StringTokenizer tokenizer = new StringTokenizer(sentence);
        int numberOfTokens = tokenizer.countTokens();
        String[] words = new String[numberOfTokens];

        for(int i = 0; i < numberOfTokens; i++) {
            words[i] = tokenizer.nextToken();
        }

        return words;
    }

    // to load words from the file and insert new VisibleWord object to wordPool vector.
    // if the insertion is successfully completed, return true. otherwise return false.
    public boolean load(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String sentence;
            while((sentence = bufferedReader.readLine()) != null) {
                String[] words = divideWords(sentence);

                for(String originalWord : words) {
                    VisibleWord visibleWord = new VisibleWord(originalWord);
                    wordPool.add(visibleWord);
                }
            }
            
            bufferedReader.close();

            return true;
        }
        catch(FileNotFoundException e) {
            return false;
        }
        catch(IOException e) {
            return false;
        }
    }

    // if the value of originalWord is findWord, replace the value of visibleWord to replaceWord
    // return the number of replaced words.
    // you have to use Iterator for searching the vector
    public int replace(String findWord, String replaceWord) {
        int replacedCount = 0;

        Iterator<VisibleWord> iterator = wordPool.iterator();
        while (iterator.hasNext()) {
            VisibleWord visibleWord = iterator.next();
            if (visibleWord.getOriginalWord().equals(findWord)) {
                visibleWord.setVisibleWord(replaceWord);
                replacedCount++;
            }
        }

        return replacedCount;
    }

    // to delete Visible object whose originalWord is word
    // return the number of deleted words.
    public int delete(String word) {
        int deletedCount = 0;

        Iterator<VisibleWord> iterator = wordPool.iterator();
        while (iterator.hasNext()) {
            VisibleWord visibleWord = iterator.next();
            if (visibleWord.getOriginalWord().equals(word)) {
                iterator.remove();
                deletedCount++;
            }
        }

        return deletedCount;
    }

    // to set visibleWord value to originalWord value for all words
    public void restore() {
        Iterator<VisibleWord> iterator = wordPool.iterator();
        while (iterator.hasNext()) {
            VisibleWord visibleWord = iterator.next();
            visibleWord.setVisibleWord(visibleWord.getOriginalWord());
        }
    }

    // to print all data
    // you have to use size and get method of Vector class
    public void print() {
        if(wordPool.size() == 0)
            System.out.println("no words stored");
        else {
            System.out.println(wordPool.size() + " word(s) are stored as follows:");

            for(VisibleWord visibleWord : wordPool) {
                System.out.print(visibleWord.getVisibleWord() + " ");
            }
            System.out.print("\n");
        }
    }

    // print all visible word in wordPool to JtextArea
    // you have to use size and get method of Vector class
    public void print(JTextArea textArea) {
        if(wordPool.size() == 0)
        {
            JOptionPane.showMessageDialog(null, "No words stored", "information", JOptionPane.ERROR_MESSAGE);
        }
        else {
            StringBuilder stringBuilder = new StringBuilder();

            for(VisibleWord visibleWord : wordPool) {
                stringBuilder.append(visibleWord.getVisibleWord()).append("\n");
            }

            textArea.setText(stringBuilder.toString());
        }
    }
    
    // print the String content to JtextArea
    // you have to use size and get method of Vector class
    public void print(JTextArea textArea, String content) {
        textArea.setText(content);
    }

    // make a problem from wordPool vector for typing practice
    // the length of white space is randomly determined, and the length is rounded.
    // return the number of words for typing practice
    public void makeExercise(int countOfWord, int widthOfLine) {
        Random random = new Random();

        if(wordPool.size() == 0) {
            JOptionPane.showMessageDialog(null, "No words loaded", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (int i = 0; i < countOfWord; i++) {
            int randomIndex = random.nextInt(wordPool.size());
            String word = wordPool.get(randomIndex).getVisibleWord();

            if(widthOfLine < word.length())
                widthOfLine = word.length() + 1;
            
            int randomPadding = random.nextInt(widthOfLine - word.length());

            String leftSpaceString = " ".repeat(randomPadding);
            String rightSpaceString = " ".repeat(widthOfLine - word.length() - randomPadding);

            String randomString = leftSpaceString + word + rightSpaceString;

            exercisePool.add(randomString);
        }
    }

    // check whether the answer is contained in exercisePool vector
    // if the answer is included, replace the word of exercisePool to white space with equal size
    // return the number of matched words
    public int checkAnswer(String answer) {
        if(answer.trim().isEmpty())
            return matchedWords;
        
        Iterator<String> iterator = exercisePool.iterator();
        while (iterator.hasNext()) {
            String randomString = iterator.next();
            if (randomString.contains(answer)) {
                matchedWords++;
                exercisePool.set(exercisePool.indexOf(randomString), " ".repeat(randomString.length()));
            }
        }

        return matchedWords;
    }

    // make a sentence from exercisePool vector for displaying the exercise
    // return the display sentence
    public String displayExercise() {
        StringBuilder displaySentence = new StringBuilder();

        for (String randomString : exercisePool) {
            displaySentence.append(randomString).append("\n");
        }

        return displaySentence.toString();
    }

    // remove all data from exercise pool
    public void cleanExercisePool() {
        exercisePool.clear();
    }

    public void cleanWordPool() {
        wordPool.clear();
    }

    // return VisibleWord object which is stored at 'index' in Vector
    public VisibleWord getData(int index) {
        return wordPool.get(index);
    }

    // return VisibleWord object which is recently stored in Vector
    public VisibleWord getLastData() {
        return wordPool.lastElement();
    }
}