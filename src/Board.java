import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.geom.Ellipse2D.Double;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.event.*;
/**
 * Board that contains all components of the game
 * @author Richard Papalia, Shakti Singh Rathore, Aman Vaid
 *
 */
public class Board extends JComponent implements ChangeListener
{
	private int XCoord;
	private int YCoord;
	private DataModel model;
	final private int length = 100;
	final private int pebbleLength = 20;
	private Color color;
	JLabel turnLabel = new JLabel();
	JLabel winnerLabel = new JLabel();
	JButton undoButton = new JButton("UNDO");
	JButton restartButton = new JButton("RESTART");
	JLabel label1 = new JLabel("B6               B5              B4              B3              B2              B1");
	JLabel label2 = new JLabel("A1               A2              A3              A4              A5              A6");
	JLabel label3 = new JLabel("<----- Player B");
	JLabel label4 = new JLabel("-----> Player A");
	JLabel label5 = new JLabel("M");
	JLabel label6 = new JLabel("A");
	JLabel label7 = new JLabel("N");
	JLabel label8 = new JLabel("C");
	JLabel label9 = new JLabel("A");
	JLabel label10 = new JLabel("L");
	JLabel label11 = new JLabel("A");
	JLabel label12 = new JLabel("A");
	JLabel label13 = new JLabel("M");
	JLabel label14 = new JLabel("A");
	JLabel label15 = new JLabel("N");
	JLabel label16 = new JLabel("C");
	JLabel label17 = new JLabel("A");
	JLabel label18 = new JLabel("L");
	JLabel label19 = new JLabel("A");
	JLabel label20 = new JLabel("B");

			/**
			 * constructs board for the Mancala game
			 * @param m model object that contains data
			 */
	public Board(DataModel m)
	{ 
		this.setLayout(null);
		model = m;
		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				XCoord = e.getX();
				YCoord = e.getY();
				model.update(XCoord, YCoord);

			}});
		undoButton.setBounds(150,450,70, 40);

		undoButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {


				model.undo();
				
			}

		});
		add(undoButton);

		restartButton.setBounds(220,450,100, 40);

		restartButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {


				model.restart();

			}

		});
		add(restartButton);
		
		label1.setBounds(190, 50, 800, 100);
		label1.setFont(new Font("Serif", Font.PLAIN, 25));
		label1.setForeground(Color.BLACK);
		add(label1);
		label2.setBounds(190, 355, 800, 100);
		label2.setFont(new Font("Serif", Font.PLAIN, 25));
		label2.setForeground(Color.BLACK);
		add(label2);
		label3.setBounds(400, 16, 300, 100);
		label3.setFont(new Font("Serif", Font.PLAIN, 25));
		label3.setForeground(Color.BLACK);
		add(label3);
		label4.setBounds(400, 390, 300, 100);
		label4.setFont(new Font("Serif", Font.PLAIN, 25));
		label4.setForeground(Color.BLACK);
		add(label4);
		label5.setBounds(5, 100, 25, 25);
		label5.setFont(new Font("Serif", Font.PLAIN, 25));
		label5.setForeground(Color.BLACK);
		add(label5);
		label6.setBounds(5, 125, 25, 25);
		label6.setFont(new Font("Serif", Font.PLAIN, 25));
		label6.setForeground(Color.BLACK);
		add(label6);
		label7.setBounds(5, 150, 25, 25);
		label7.setFont(new Font("Serif", Font.PLAIN, 25));
		label7.setForeground(Color.BLACK);
		add(label7);
		label8.setBounds(5, 175, 25, 25);
		label8.setFont(new Font("Serif", Font.PLAIN, 25));
		label8.setForeground(Color.BLACK);
		add(label8);
		label9.setBounds(5, 200, 25, 25);
		label9.setFont(new Font("Serif", Font.PLAIN, 25));
		label9.setForeground(Color.BLACK);
		add(label9);
		label10.setBounds(5, 225, 25, 25);
		label10.setFont(new Font("Serif", Font.PLAIN, 25));
		label10.setForeground(Color.BLACK);
		add(label10);
		label11.setBounds(5, 250, 25, 25);
		label11.setFont(new Font("Serif", Font.PLAIN, 25));
		label11.setForeground(Color.BLACK);
		add(label11);
		label20.setBounds(5, 290, 25, 25);
		label20.setFont(new Font("Serif", Font.PLAIN, 25));
		label20.setForeground(Color.BLACK);
		add(label20);
		label13.setBounds(970, 100, 25, 25);
		label13.setFont(new Font("Serif", Font.PLAIN, 25));
		label13.setForeground(Color.BLACK);
		add(label13);
		label14.setBounds(970, 125, 25, 25);
		label14.setFont(new Font("Serif", Font.PLAIN, 25));
		label14.setForeground(Color.BLACK);
		add(label14);
		label15.setBounds(970, 150, 25, 25);
		label15.setFont(new Font("Serif", Font.PLAIN, 25));
		label15.setForeground(Color.BLACK);
		add(label15);
		label16.setBounds(970, 175, 25, 25);
		label16.setFont(new Font("Serif", Font.PLAIN, 25));
		label16.setForeground(Color.BLACK);
		add(label16);
		label17.setBounds(970, 200, 25, 25);
		label17.setFont(new Font("Serif", Font.PLAIN, 25));
		label17.setForeground(Color.BLACK);
		add(label17);
		label18.setBounds(970, 225, 25, 25);
		label18.setFont(new Font("Serif", Font.PLAIN, 25));
		label18.setForeground(Color.BLACK);
		add(label18);
		label19.setBounds(970, 250, 25, 25);
		label19.setFont(new Font("Serif", Font.PLAIN, 25));
		label19.setForeground(Color.BLACK);
		add(label19);
		label12.setBounds(970, 290, 25, 25);
		label12.setFont(new Font("Serif", Font.PLAIN, 25));
		label12.setForeground(Color.BLACK);
		add(label12);
	}

	/**
	 * draws and paints the different circles and rectangles on the board
	 * @param g graphics object that has the information to draw
	 */
	public void paintComponent(Graphics g)
	{	

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D rectangle = new Rectangle2D.Double(0,0,1000,600);

		g2.setPaint(Color.darkGray);
		g2.fill(rectangle);
		Rectangle2D rect = new Rectangle2D.Double(0, 50, 1000, 450);
		g2.setPaint(color);
		g2.fill(rect);
		g2.setColor(Color.BLACK);
		Rectangle2D  rect2 = new Rectangle2D.Double(41, 60, length, 380 );
		g2.fill(rect2);
		Rectangle2D  rect3 = new Rectangle2D.Double(854.75, 60, length, 380 );
		g2.fill(rect3);
		for(int i = 12; i < 14; i++)
		{
			for(int j = 0; j < model.getData()[i]; j++)
			{
				if(j<3)
				{
					Ellipse2D circle = new Ellipse2D.Double(41 + ((j*pebbleLength)) +((i-12)*813.75) , 60, pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.draw(circle);
					g2.fill(circle);
				}
				if (j >= 3 && j < 6)
				{
					Ellipse2D circle = new Ellipse2D.Double(41 + ((j%3)*pebbleLength) +((i-12)*813.75) , 60 + pebbleLength, pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.draw(circle);
					g2.fill(circle);
				}
				if (j >= 6 && j < 9)
				{
					Ellipse2D circle = new Ellipse2D.Double(41 + ((j%3)*pebbleLength) +((i-12)*813.75), 60 + (2*pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.draw(circle);
					g2.fill(circle);
				}
				if (j >= 9 && j < 12)
				{
					Ellipse2D circle = new Ellipse2D.Double(41 + ((j%3)*pebbleLength) +((i-12)*813.75), 60 + (3*pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.draw(circle);
					g2.fill(circle);
				}
				if (j >= 12 && j < 15)
				{
					Ellipse2D circle = new Ellipse2D.Double(41 + ((j%3)*pebbleLength)+((i-12)*813.75) , 60 + (4*pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.draw(circle);
					g2.fill(circle);
				}
				if (j >= 15 && j < 18)
				{
					Ellipse2D circle = new Ellipse2D.Double(41 + ((j%3)*pebbleLength)+((i-12)*813.75) , 60 + (5*pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.draw(circle);
					g2.fill(circle);
				}
				if (j >= 18 && j < 21)
				{
					Ellipse2D circle = new Ellipse2D.Double(41 + ((j%3)*pebbleLength)+((i-12)*813.75) , 60 + (6*pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.draw(circle);
					g2.fill(circle);
				}
				if (j >= 21 && j < 24)
				{
					Ellipse2D circle = new Ellipse2D.Double(41 + ((j%3)*pebbleLength) +((i-12)*813.75), 60 + (7*pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.draw(circle);
					g2.fill(circle);
				}
				if (j >= 24 && i < 27)
				{
					Ellipse2D circle = new Ellipse2D.Double(41 + ((j%3)*pebbleLength) +((i-12)*813.75), 60 + (8*pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.draw(circle);
					g2.fill(circle);
				}
				if (j >= 27 && j < 30)
				{
					Ellipse2D circle = new Ellipse2D.Double(41 + ((j%3)*pebbleLength)+((i-12)*813.75) , 60 + (9*pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.draw(circle);
					g2.fill(circle);
				}
				if (j >= 30 && j < 33)
				{
					Ellipse2D circle = new Ellipse2D.Double(41 + ((j%3)*pebbleLength)+((i-12)*813.75) , 60 + (10*pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.draw(circle);
					g2.fill(circle);
				}
				if (j >= 33 && j < 36)
				{
					Ellipse2D circle = new Ellipse2D.Double(41 + ((j%3)*pebbleLength) +((i-12)*813.75), 60 + (11*pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.draw(circle);
					g2.fill(circle);
				}
			}
		}

		g2.setColor(Color.BLACK);
		Ellipse2D circle = new Ellipse2D.Double(158.25, 116,length,length);
		g2.draw(circle);
		Ellipse2D circle2 = new Ellipse2D.Double(274.5, 116,length,length);
		g2.draw(circle2);
		Ellipse2D circle3 = new Ellipse2D.Double(390.75, 116,length,length);
		g2.draw(circle3);
		Ellipse2D circle4 = new Ellipse2D.Double(507, 116,length,length);
		g2.draw(circle4);
		Ellipse2D circle5 = new Ellipse2D.Double(623.25, 116,length,length);
		g2.draw(circle5);
		Ellipse2D circle6 = new Ellipse2D.Double(739.5, 116,length,length);
		g2.draw(circle6);

		Ellipse2D circle9 = new Ellipse2D.Double(158.25, 282,length,length);
		g2.draw(circle9);
		Ellipse2D circle10 = new Ellipse2D.Double(273.5, 282,length,length);
		g2.draw(circle10);
		Ellipse2D circle11 = new Ellipse2D.Double(390.75, 282,length,length);
		g2.draw(circle11);
		Ellipse2D circle12 = new Ellipse2D.Double(506, 282,length,length);
		g2.draw(circle12);
		Ellipse2D circle13 = new Ellipse2D.Double(622.25, 282,length,length);
		g2.draw(circle13);
		Ellipse2D circle14 = new Ellipse2D.Double(738.5, 282,length,length);
		g2.draw(circle14);



		g2.fill(circle);
		g2.fill(circle2);
		g2.fill(circle3);
		g2.fill(circle4);
		g2.fill(circle5);
		g2.fill(circle6);


		g2.fill(circle9);
		g2.fill(circle10);
		g2.fill(circle11);
		g2.fill(circle12);
		g2.fill(circle13);
		g2.fill(circle14);


		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < model.getData()[i]; j++)
			{
				if(j < 2)
				{
					Ellipse2D ell1 = new Ellipse2D.Double(175.25 + (j*pebbleLength) +(i*116.25), 283, pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.fill(ell1);

				}
				if(j >= 2 && j < 4)
				{
					Ellipse2D ell1 = new Ellipse2D.Double(175.25 + (pebbleLength *(j%2) +(i*116.25)), 283 + pebbleLength, pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.fill(ell1);

				}
				if(j >= 4 && j < 6)
				{
					Ellipse2D ell1 = new Ellipse2D.Double(175.25 + (pebbleLength *(j%2)+(i*116.25)), 283 +(2* pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.fill(ell1);

				}
				if(j >= 6 && j < 8)
				{
					Ellipse2D ell1 = new Ellipse2D.Double(175.25 + (pebbleLength *(j%2)+(i*116.25)), 283 + (3 *pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.fill(ell1);
				}
				if(j >= 8 && j < 10)
				{
					Ellipse2D ell1 = new Ellipse2D.Double(175.25 + (pebbleLength *(j%2)+(i*116.25)), 283 + (4 *pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.fill(ell1);
				}


			}
		}
		int counter = 11;

		for(int i = 11; i > 5; i--)
		{
			if(i!= 11)
			{
				counter = counter - 2;;
			}
			for(int j = 0; j < model.getData()[i]; j++)
			{

				if(j < 2)
				{
					Ellipse2D ell1 = new Ellipse2D.Double(175.25 + (j*pebbleLength) +((i-counter)*116.25), 117, pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.fill(ell1);


				}
				if(j >= 2 && j < 4)
				{
					Ellipse2D ell1 = new Ellipse2D.Double(175.25 + (pebbleLength *(j%2) +((i-counter)*116.25)), 117 + pebbleLength, pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.fill(ell1);

				}
				if(j >= 4 && j < 6)
				{
					Ellipse2D ell1 = new Ellipse2D.Double(175.25 + (pebbleLength *(j%2)+((i-counter)*116.25)), 117 + (2*pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.fill(ell1);

				}
				if(j >= 6 && j < 8)
				{
					Ellipse2D ell1 = new Ellipse2D.Double(175.25 + (pebbleLength *(j%2)+((i-counter)*116.25)), 117 + (3*pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.fill(ell1);
				}
				if(j >= 8 && j < 10)
				{
					Ellipse2D ell1 = new Ellipse2D.Double(175.25 + (pebbleLength *(j%2)+((i-counter)*116.25)), 117 + (4*pebbleLength), pebbleLength, pebbleLength);
					g2.setColor(Color.WHITE);
					g2.fill(ell1);
				}

			}
		}


		winnerLabel.setBounds(250, 200, 600, 100);
		winnerLabel.setText("");
		winnerLabel.setFont(new Font("Serif", Font.BOLD, 60));
		winnerLabel.setForeground(Color.ORANGE);
		add(winnerLabel);
		if(model.getData()[0] + model.getData()[1] + model.getData()[2] + model.getData()[3] + model.getData()[4] + model.getData()[5] 
				+ model.getData()[6] + model.getData()[7] +	model.getData()[8] + model.getData()[9] + model.getData()[10] + model.getData()[11] == 0)
		{
			if(model.getData()[12] > model.getData()[13])
			{
				winnerLabel.setText("Winner is Player B!");
				turnLabel.setText("  ");
			}
			else if(model.getData()[12] < model.getData()[13])
			{
				winnerLabel.setText("Winner is Player A!");
				turnLabel.setText("   ");
			}
			else{
				winnerLabel.setText("TIE GAME!");
				turnLabel.setText("  ");
			}
		}
		turnLabel.setBounds(450, 200, 400, 100);
		turnLabel.setText("");
		turnLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		turnLabel.setForeground(Color.BLACK);
		add(turnLabel);
		if(model.player1Turn == true && model.player2Turn == false){
			turnLabel.setText("Player A Turn");
		}
		else if(model.player2Turn == true && model.player1Turn == false){
			turnLabel.setText("Player B Turn");
		}
	}

	@Override
	/**
	 *  This is the state change method that repaints if state of the board has been changed.
	 *  @param e event that has the knowledge of current change on the board
	 */
	public void stateChanged(ChangeEvent e) {

		repaint();

	}

	/**
	 * Sets the color of the board according to given strategy
	 * @param cs color strategy object that has color 
	 */
	public void newColor(ColorStrategy cs)
	{
		color =  cs.setColor();
	}
}