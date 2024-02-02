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

		createMenuBar();

		add(createCommandPanel(), BorderLayout.NORTH);

		textWindow = new JTextArea();
		add(textWindow, BorderLayout.CENTER);

		add(createTypeWordPanel(), BorderLayout.SOUTH);

		setSize(450, 400);
		setVisible(true);
	}
	
	public JPanel createCommandPanel() {
		JPanel commandPanel = new JPanel();
		commandPanel.setLayout(new GridLayout(2, 1));

		commandPanel.add(createDeletePanel());
		commandPanel.add(createExercisePanel());

		return commandPanel;
	}

	public JPanel createDeletePanel() {
		JPanel deletePanel = new JPanel();
		deletePanel.setLayout(new FlowLayout());

		deletePanel.add(new JLabel("Delete what: "));

		deleteWhatTextField = new JTextField(14);
		deletePanel.add(deleteWhatTextField);

		deletePanel.add(new JButton("Delete"));

		return deletePanel;
	}

	public JPanel createExercisePanel() {
		JPanel exercisePanel = new JPanel();
		exercisePanel.setLayout(new FlowLayout());

		exercisePanel.add(new JLabel("Words: "));

		typeWordTextField = new JTextField(5);
		exercisePanel.add(typeWordTextField);

		exercisePanel.add(new JLabel("Width: "));
		
		widthOfLineTextField = new JTextField(5);
		exercisePanel.add(widthOfLineTextField);

		exercisePanel.add(new JButton("Make"));
		exercisePanel.add(new JButton("Reset"));

		return exercisePanel;
	}

	public JPanel createTypeWordPanel() {
		JPanel typeWordPanel = new JPanel();
		typeWordPanel.setLayout(new FlowLayout());

		typeWordPanel.add(new JLabel("Enter a Word: "));

		numOfWordTextField = new JTextField(14);
		typeWordPanel.add(numOfWordTextField);

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
		JMenuBar menuBar = new JMenuBar();
		JMenu filMenu = new JMenu("File");
		
		filMenu.add(new JMenuItem("Load"));
		filMenu.add(new JMenuItem("Exit"));

		menuBar.add(filMenu);

		setJMenuBar(menuBar);
	}
	
	class FileMenuActionListener implements ActionListener {

	}
	
	public static void main(String[] args) {
		new TypingPracticeProgramGUI();
	}
}
