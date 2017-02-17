import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

/**
 * Tester class that contains all GUI components 
 * @author Richard Papalia, Shakti Singh Rathore, Aman Vaid
 *
 */
public class MancalaTest 
{
	private static ColorStrategy strategy;
	/**
	 * Main method makes the board according to the specification provided to it.
	 * @param args argument passed if run from the command line
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout()); 
		frame.setSize(300, 200);
		JPanel panel1 = new JPanel(new GridLayout(0, 1));
		JPanel panel2 = new JPanel(new GridLayout(0, 1));
		//panel2.setLayout(new FlowLayout());
		//panel1.setLayout(new FlowLayout());
		//panel1.setSize(10, 10);
		//panel2.setSize(10, 10);
		panel1.add(new JLabel("Red or Blue?"));
		panel2.add(new JLabel("3 or 4 Stones?"));
		//panel1.add(new JLabel("Red Or Blue Board Color?              3 or 4 Stones?"));
		//JTextArea area = new JTextArea(10, 10);
		//area.setColumns (10);
		//area.setLineWrap (true);
		//area.setWrapStyleWord (true);
		//JTextArea area2 = new JTextArea(10, 10);
		//area2.setColumns (10);
		//area2.setLineWrap (true);
		//area2.setWrapStyleWord (true);
		JButton button = new JButton();
		button.setText("Start Game!");

		ButtonGroup RedvBlue = new ButtonGroup();
		JRadioButton RedButton = new JRadioButton("Red");
		JRadioButton BlueButton = new JRadioButton("Blue");

		panel1.add(RedButton);
		RedvBlue.add(RedButton);
		panel1.add(BlueButton);
		RedvBlue.add(BlueButton);

		ButtonGroup ThreevFour = new ButtonGroup();
		JRadioButton ThreeButton = new JRadioButton("3");
		JRadioButton FourButton = new JRadioButton("4");

		panel2.add(ThreeButton);
		ThreevFour.add(ThreeButton);
		panel2.add(FourButton);
		ThreevFour.add(FourButton);

		frame.add(panel1, BorderLayout.WEST);
		frame.add(panel2, BorderLayout.EAST);
		//frame.add(area, BorderLayout.WEST);
		//frame.add(area2, BorderLayout.EAST);
		frame.add(button, BorderLayout.SOUTH);

		ActionListener al = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!RedButton.isSelected() && !BlueButton.isSelected())
				{
					JOptionPane.showMessageDialog(null, "Please Select A Color!", "Color Error", JOptionPane.ERROR_MESSAGE);
					//area.setText("Error: Please type a valid choice");
				}
				if(!ThreeButton.isSelected() && !FourButton.isSelected())
				{
					JOptionPane.showMessageDialog(null, "Please Select A Pebble Qty!", "Pebble Qty Error", JOptionPane.ERROR_MESSAGE);
					//area2.setText("Error: Please choose a valid number of stones");
				}
				if((RedButton.isSelected() || BlueButton.isSelected())
						&& (ThreeButton.isSelected() || FourButton.isSelected()))
				{


					frame.setVisible(false);
					JFrame frame2 = new JFrame();
					frame2.setSize(1000, 600);
					
					int[] a = new int[14];

					if(ThreeButton.isSelected()){
						for(int i = 0; i < a.length; i++)
						{
							if(i < 12)
							{
								a[i] =3;
							}
							else{
								a[i] = 0;
							} 
						}
					}

					if(FourButton.isSelected()){
						for(int i = 0; i < a.length; i++)
						{
							if(i < 12)
							{
								a[i] =4;
							}
							else
							{
								a[i] = 0;
							}
						}
					}


					DataModel m = new DataModel(a);

					Board b = new Board(m);
					if(RedButton.isSelected())
					{
						b.newColor(new RedColorStrategy());
					}
					if(BlueButton.isSelected())
					{
						b.newColor(new BlueColorStrategy());
					}

					m.attach(b);
					frame2.add(b);
					frame2.validate();

					frame2.setVisible(true);
					frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				}
			}

		};

		button.addActionListener(al);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		RedButton.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent evt){
				if(evt.getKeyCode() == evt.VK_TAB){
					if(evt.getModifiers() > 0){
						RedButton.transferFocusBackward();
					}
					else{
						RedButton.transferFocus();
					}
					evt.consume();
				}
			}
		});

	}
}