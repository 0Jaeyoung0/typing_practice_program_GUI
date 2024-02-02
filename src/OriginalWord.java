
public class OriginalWord {
	private String originalWord;

	// constructor
	public OriginalWord() {

	}

	// constructor
	public OriginalWord(String originalWord) {
		this.originalWord = originalWord;
	}

	// to return originalWord
	public String getOriginalWord() {
		return this.originalWord;
	}

	// to set originalWord
	public void setOriginalWord(String originalWord) {
		this.originalWord = originalWord;
	} 
	
	// if otherWord is same to originalWord, return true.
	// otherwise, return false. 
	public boolean isSameOriginalWord(String otherWord) {
		return true;
	}

	// to return string for this object. The format is as follows.
	// originalWord = originalWord value
	public String toString() {
		return this.originalWord;
	}
}