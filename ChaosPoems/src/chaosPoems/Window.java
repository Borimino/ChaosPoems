
package chaosPoems;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	JPanel radios;
	JRadioButton danish;
	JRadioButton english;
	JPanel inputArea;
	
	public Window()
	{
		
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
		addRadios();
		inputArea.add(radios);
		inputArea.add(buttons);
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
					output.setText(Main.generate(input.getText()));
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
	
	private void addRadios()
	{
		radios = new JPanel();
		
		danish = new JRadioButton("Dansk");
		danish.setActionCommand("da");
		danish.setSelected(true);
		danish.addActionListener(this);
		radios.add(danish);
		
		english = new JRadioButton("English");
		english.setActionCommand("en");
		english.addActionListener(this);
		radios.add(english);
		
		ButtonGroup group = new ButtonGroup();
		group.add(danish);
		group.add(english);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Searcher.language = e.getActionCommand();
	}
}
