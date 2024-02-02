
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

	}
	
	// if otherWord is same to visibleWord, return true.
	// otherwise, return false. 
	public boolean isSameVisibleWord(String otherWord) {
		return true;
	}
	
	// copy originalWord and visibleWord from otherWord object
	public void copyFrom(VisibleWord otherWord) {

	}
	
	// initialize originalWord and visibleWord 
	public void initialize() {

	}

	// to return string for this object. The format is as follows.
	// originalWord = originalWord value, visibleWord = visibleWord value
	public String toString() {
		String a = "";
		return a;
	}
}