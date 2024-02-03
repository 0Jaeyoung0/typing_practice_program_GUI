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
		textWindow.setEditable(false);
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

		deletePanel.add(createLabelPanel("Delete what:"));

		deleteWhatTextField = new JTextField(14);
		deletePanel.add(deleteWhatTextField);

		JButton deleteButton = new JButton("Delete");
		deletePanel.add(createButtonPanel(deleteButton));

		return deletePanel;
	}

	public JPanel createExercisePanel() {
		JPanel exercisePanel = new JPanel();
		exercisePanel.setLayout(new FlowLayout());

		exercisePanel.add(createLabelPanel("Words:"));

		typeWordTextField = new JTextField(5);
		exercisePanel.add(typeWordTextField);

		exercisePanel.add(createLabelPanel("Width:"));
		
		widthOfLineTextField = new JTextField(5);
		exercisePanel.add(widthOfLineTextField);

		JButton makeButton = new JButton("Make");
		JButton resetButton = new JButton("Reset");
		exercisePanel.add(createButtonPanel(makeButton));
		exercisePanel.add(createButtonPanel(resetButton));

		return exercisePanel;
	}

	public JPanel createTypeWordPanel() {
		JPanel typeWordPanel = new JPanel();
		typeWordPanel.setLayout(new FlowLayout());

		typeWordPanel.add(createLabelPanel("Enter a Word:"));

		numOfWordTextField = new JTextField(14);
		typeWordPanel.add(numOfWordTextField);

		return typeWordPanel;
	}

	public JPanel createLabelPanel(String labelTitle) {
		JPanel labelPanel = new JPanel();

		labelPanel.add(new JLabel(labelTitle));

		return labelPanel;
	}

	public JPanel createButtonPanel(JButton button) {
		ButtonActionListener listener = new ButtonActionListener();
		button.addActionListener(listener);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(button);

		return buttonPanel;
	}

	class ButtonActionListener implements ActionListener {
		public void  actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();

			switch(button.getText()) {
				case "Delete":
					String deletedWord = deleteWhatTextField.getText();

					if(deletedWord.trim().isEmpty())
						JOptionPane.showMessageDialog(null, "You should enter words you want to delete", "Warning", JOptionPane.WARNING_MESSAGE);

					break;
				case "Make":
					String wordsText = typeWordTextField.getText();
					String widthText = widthOfLineTextField.getText();
	
					if (wordsText.isEmpty() || widthText.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter values for both 'Words' and 'Width'", "Warning", JOptionPane.WARNING_MESSAGE);
					} 
					else {
						try {
							double words = Double.parseDouble(wordsText);
							double width = Double.parseDouble(widthText);
						} 
						catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Please enter valid numeric values for 'Words' and 'Width'", "Error", JOptionPane.WARNING_MESSAGE);
						}
					}

					break;
				case "Reset":
					break;
			}
		}
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
		JMenuItem loadMenuItem = new JMenuItem("Load");
		JMenuItem exitMenuItem = new JMenuItem("Exit");

		FileMenuActionListener listener = new FileMenuActionListener();

		loadMenuItem.addActionListener(listener);
		exitMenuItem.addActionListener(listener);
		
		filMenu.add(loadMenuItem);
		filMenu.add(exitMenuItem);

		menuBar.add(filMenu);

		setJMenuBar(menuBar);
	}
	
	class FileMenuActionListener implements ActionListener {
		public void  actionPerformed(ActionEvent e) {
			String menuItem = e.getActionCommand();

			switch(menuItem) {
				case "Load":
					JFileChooser fileChooser  = new JFileChooser();

					if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						String fileName = fileChooser.getSelectedFile().toString();

						if(wordManager.load(fileName)) {
							JOptionPane.showMessageDialog(null, "File load is completed!!", "information", JOptionPane.INFORMATION_MESSAGE);
							wordManager.print(textWindow);
						}
						else
							JOptionPane.showMessageDialog(null, "File load is failed!!", "information", JOptionPane.INFORMATION_MESSAGE);
					}
					
					break;
				case "Exit":
					System.exit(0);
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		new TypingPracticeProgramGUI();
	}
}
