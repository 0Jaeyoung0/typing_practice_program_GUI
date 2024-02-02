import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TypingPracticeProgramGUI extends JFrame {
	private WordManager wordManager = new WordManager();
	private JTextArea textWindow;
	private JTextField numOfWordTextField;
	private JTextField widthOfLineTextField;
	private JTextField typeWordTextField;
	private JTextField deleteWhatTextField;
	private int countOfWord = -1;
	private int numOfCorrectWord = 0;
	
	public TypingPracticeProgramGUI() {
		setTitle("Typing Practice Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		add(createCommandPanel(), BorderLayout.NORTH);

		setSize(450, 400);
		setVisible(true);
	}
	
	public JPanel createCommandPanel() {
		JPanel commandPanel = new JPanel();
		commandPanel.setLayout(new GridLayout(3, 1));

		JMenuBar menuBar = new JMenuBar();
		JMenu filMenu = new JMenu("file");
		
		filMenu.add(new JMenuItem("Load"));
		filMenu.add(new JMenuItem("Exit"));

		menuBar.add(filMenu);

		commandPanel.add(menuBar);
		commandPanel.add(createDeletePanel());

		return commandPanel;
	}

	public JPanel createDeletePanel() {
		JPanel deletePanel = new JPanel();
		deletePanel.setLayout(new FlowLayout());
		return deletePanel;
	}

	public JPanel createExercisePanel() {
		JPanel exercisePanel = new JPanel();
		exercisePanel.setLayout(new FlowLayout());
		return exercisePanel;
	}

	public JPanel createTypeWordPanel() {
		JPanel typeWordPanel = new JPanel();
		typeWordPanel.setLayout(new FlowLayout());
		return typeWordPanel;
	}

	public JPanel createLabelPanel(String labelTitle) {

	}

	public JPanel createButtonPanel(JButton button) {

	}

	class ButtonActionListener implements ActionListener {

	}

	// remove all data in exercise pool and restore all data in word pool
	// clear all textField and textArea
	// initialize countOfWord and numOfCorrectWord
	public void reset() {

	}

	// if all words are typed correctly, reset should be conducted.
	class TypeKeyAdapter extends KeyAdapter {

	}
	
	public void createMenuBar() {

	}
	
	class FileMenuActionListener implements ActionListener {

	}
	
	public static void main(String[] args) {
		TypingPracticeProgramGUI typingPracticeProgramGUI = new TypingPracticeProgramGUI();
	}
}
