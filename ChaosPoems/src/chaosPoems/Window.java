package chaosPoems;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Window
{
	JFrame frame;
	JTextArea input;
	JLabel output;
	JPanel buttons;
	JButton generate;
	JButton clear;
	
	public Window()
	{
		
	}
	
	public void drawWindow()
	{
		frame = new JFrame("Chaos Poem");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 1));
		input = new JTextArea(25, 50);
		frame.getContentPane().add(input);
		addButtons();
		output = new JLabel();
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
					output.setText(input.getText());
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
		frame.getContentPane().add(buttons);
	}
}
