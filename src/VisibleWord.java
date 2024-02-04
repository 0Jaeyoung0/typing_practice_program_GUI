
public class VisibleWord extends OriginalWord{
	private String visibleWord;

	// constructor
	public VisibleWord() {

	}

	// constructor
	public VisibleWord(String originalWord) {
		super(originalWord);
		this.visibleWord = originalWord;
	}

	// constructor
	public VisibleWord(String originalWord, String visibleWord) {
		super(originalWord);
		this.visibleWord = visibleWord;
	}

	// to return visibleWord
	public String getVisibleWord() {
		return this.visibleWord;
	}

	// to set visibleWord
	public void setVisibleWord(String visibleWord) {
		this.visibleWord = visibleWord;
	}
	
	// to set originalWord and visibleWord simultaneously
	public void insert(String word) {
		setOriginalWord(word);
        setVisibleWord(word);
	}
	
	// if otherWord is same to visibleWord, return true.
	// otherwise, return false. 
	public boolean isSameVisibleWord(String otherWord) {
		return this.visibleWord.equals(otherWord);
	}
	
	// copy originalWord and visibleWord from otherWord object
	public void copyFrom(VisibleWord otherWord) {
		setOriginalWord(otherWord.getOriginalWord());
        setVisibleWord(otherWord.getVisibleWord());
	}
	
	// initialize originalWord and visibleWord 
	public void initialize() {
		setOriginalWord("");
        setVisibleWord("");
	}

	// to return string for this object. The format is as follows.
	// originalWord = originalWord value, visibleWord = visibleWord value
	public String toString() {
		return "originalWord = " + getOriginalWord() + ", visibleWord = " + this.visibleWord;
	}
}