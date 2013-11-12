package chaosPoems;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Window implements ActionListener
{
	JFrame frame;
	JTextArea input;
	JTextArea output;
	JPanel buttons;
	JButton generate;
	JButton clear;
	JPanel languages;
	JRadioButton danish;
	JRadioButton english;
	JRadioButton german;
	JPanel inputArea;
	JPanel modes;
	JRadioButton default_mode;
	JRadioButton continue_mode;
	Main main;
	
	public Window()
	{
		main = new Main();
	}
	
	public void drawWindow()
	{
		frame = new JFrame("Chaos Poem");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 1));
		input = new JTextArea(25, 50);
		input.setLineWrap(true);
		frame.getContentPane().add(input);
		inputArea = new JPanel();
		inputArea.setLayout(new GridLayout(2, 1));
		addButtons();
		addLanguages();
		addModes();
		inputArea.add(languages);
		inputArea.add(buttons);
		inputArea.add(modes);
		frame.getContentPane().add(inputArea);
		output = new JTextArea();
		output.setLineWrap(true);
		output.setEditable(false);
		frame.getContentPane().add(output);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void addButtons()
	{
		buttons = new JPanel();
		buttons.setLayout(new GridLayout(1, 2));
		generate = new JButton("Generate");
		generate.addActionListener(new
			ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					output.setText(main.generate(input.getText()));
				}
			});
		clear = new JButton("Clear");
		clear.addActionListener(new
			ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					output.setText("");
				}
			});
		buttons.add(generate);
		buttons.add(clear);
	}
	
	private void addLanguages()
	{
		languages = new JPanel();
		
		danish = new JRadioButton("Dansk");
		danish.setActionCommand("da");
		danish.setSelected(true);
		danish.addActionListener(this);
		languages.add(danish);
		
		english = new JRadioButton("English");
		english.setActionCommand("en");
		english.addActionListener(this);
		languages.add(english);
		
		german = new JRadioButton("Deutsch");
		german.setActionCommand("en");
		german.addActionListener(this);
		languages.add(german);
		
		ButtonGroup group = new ButtonGroup();
		group.add(danish);
		group.add(english);
		group.add(german);
	}
	
	private void addModes()
	{
		modes = new JPanel();
		
		default_mode = new JRadioButton("Default");
		default_mode.setActionCommand("default_mode");
		default_mode.setSelected(true);
		default_mode.addActionListener(this);
		modes.add(default_mode);
		
		continue_mode = new JRadioButton("Continue");
		continue_mode.setActionCommand("continue_mode");
		continue_mode.addActionListener(this);
		modes.add(continue_mode);
		
		ButtonGroup mode_group = new ButtonGroup();
		mode_group.add(default_mode);
		mode_group.add(continue_mode);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().contains("mode"))
		{
			main.default_mode = (e.getActionCommand().equals("default_mode"));
		} else
		{
			main.getSearcher().getSe().setLanguage(e.getActionCommand());
		}
	}
}
