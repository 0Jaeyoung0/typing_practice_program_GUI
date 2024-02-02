import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class WordManager {
    private Vector<VisibleWord> wordPool;           // a total of words
    private Vector<String> exercisePool;       // words for exercise

    // constructor
    public WordManager() {
        wordPool = new Vector<>();
    }

    // constructor, size indicates the initial size of vector
    public WordManager(int size) {
        wordPool = new Vector<>(size);
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
        String[] words = sentence.split("\\s+");
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

    // make a problem from wordPool vector for typing practice
    // the length of white space is randomly determined, and the length is rounded.
    // return the String includes words and white space
    public void makeExercise(int countOfWord, int widthOfLine) {
        Random random = new Random();
        exercisePool = new Vector<>();

        for (int i = 0; i < countOfWord; i++) {
            int randomIndex = random.nextInt(wordPool.size());
            String word = wordPool.get(randomIndex).getVisibleWord();
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
        int matchedWords = 0;

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
            displaySentence.append(randomString);
        }

        return displaySentence.toString();
    }

    // run exercise using makeExercise, checkAnswer, and displayExercise method until user enter all correct words
    public void runExercise(Scanner scanner, int countOfWord, int widthOfLine) {
        makeExercise(countOfWord, widthOfLine);
        Scanner temp = new Scanner(System.in);

        while (true) {
            System.out.println(displayExercise());
            System.out.print("Enter a word: ");
            String answer = temp.nextLine();

            int matchedWords = checkAnswer(answer);

            if (matchedWords == countOfWord) {
                System.out.println("Congratulations! You entered all correct words.");
                break;
            } else {
                System.out.println("Matched words: " + matchedWords);
            }
        }
    }

    // return VisibleWord object which is stored at 'index' in Vector
    public VisibleWord getData(int index) {
        VisibleWord a = new VisibleWord();
        return a;
    }

    // return VisibleWord object which is recently stored in Vector
    public VisibleWord getLastData() {
        VisibleWord a = new VisibleWord();
        return a;
    }
}