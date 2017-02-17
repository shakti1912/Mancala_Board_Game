import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.event.*;
/**
 * This is the model class that contains data for the game
 * @author Richard Papalia, Shakti Singh Rathore, Aman Vaid
 */
public class DataModel
{
	int player1Undos = 0;
	int player2Undos = 0;
	int lastPitClicked  = 0;
	int[] data;
	int[] dataCopy = new int[14];
	int[] restart = new int[14];
	ArrayList<ChangeListener> listeners;
	int mancala1;
	int mancala2;
	boolean player1Turn = true;
	boolean player2Turn = false;
	public int[] corresponding = {11,10,9,8,7,6,5,4,3,2,1,0};
	boolean player1Done = false;
	boolean player2Done = false;

	boolean dontSwitch = false;
	/**
	 * contructs model object with given array.
	 * @param arr array that has details about the number of stones in the pits
	 */
	public DataModel(int[] arr)
	{
		mancala1 = 0;
		mancala2 = 0;
		data = arr;

		int x = arr[1];
		for(int i = 0; i < data.length; i++)
		{
			dataCopy[i] = x;
		}
		listeners = new ArrayList<ChangeListener>();

		for(int i = 0; i < data.length; i++)
		{
			restart[i] = x;
		}
	}

	/**
	 * returns array that contains number of stones in each pit
	 * @return array with details of number of stones in the pits
	 */
	public int[] getData()
	{
		return data;
	}

	/**
	 * This methods restarts the game if restart button is pressed. Changes players turn to original.
	 */
	public void restart(){
		for(int i = 0; i < 12; i++)
		{
			data[i] = restart[i];
			player1Turn = true;
			player2Turn = false;
		}
		data[13] = 0;
		data[12] = 0;
		player2Done = false;
		player1Done = false;
		player1Undos = 0;
		player2Undos = 0;
		for (ChangeListener l : listeners)
		{
			l.stateChanged(new ChangeEvent(this));
		}
	}

	/**
	 * This method attaches listener to the model object
	 * @param c changelistener to be attached to model
	 */
	public void attach(ChangeListener c)
	{
		listeners.add(c);
	}

	/**
	 * This method updates the board data if undo button is pressed
	 */
	public void undo()
	{	
		if(player1Turn == true && lastPitClicked < 6)
		{
			player1Undos++;
		}
		if(player2Turn == true && lastPitClicked < 6)
		{
			player1Undos++;
		}
		if(player1Turn == true && lastPitClicked > 6)
		{
			player2Undos++;
		}
		if(player2Turn == true && lastPitClicked > 6)
		{
			player2Undos++;
		}
		if(player1Turn == true && lastPitClicked < 6)
		{
			if(player1Undos < 4)
			{
				boolean changeIt = false;
				for(int i = 0; i < data.length; i++){
					if(data[i] != dataCopy[i])
					{
						changeIt = true;
					}
				}
				if(changeIt == true)
				{
					for(int i = 0; i < data.length; i ++)
					{
						int x = dataCopy[i];
						data[i] = x;
					}
					if(dontSwitch == false)
					{
						if(player1Turn == true)
						{
							player1Turn =false;
							player2Turn = true;
						}
						else if(player2Turn == true)
						{
							player2Turn =false;
							player1Turn = true;
						}
						else
						{}
					}

					for (ChangeListener l : listeners)
					{
						l.stateChanged(new ChangeEvent(this));
					}
				}
			}
		}
		else if(player2Turn == true && lastPitClicked > 6)
		{
			if(player2Undos < 4)
			{
				boolean changeIt = false;
				for(int i = 0; i < data.length; i++){
					if(data[i] != dataCopy[i])
					{
						changeIt = true;
					}
				}
				if(changeIt == true)
				{
					for(int i = 0; i < data.length; i ++)
					{
						int x = dataCopy[i];
						data[i] = x;
					}
					if(dontSwitch == false)
					{
						if(player1Turn == true)
						{
							player1Turn =false;
							player2Turn = true;
						}
						else if(player2Turn == true)
						{
							player2Turn =false;
							player1Turn = true;
						}
						else
						{}
					}

					for (ChangeListener l : listeners)
					{
						l.stateChanged(new ChangeEvent(this));
					}
				}
			}
		}
		else if(player2Turn == true)
		{
			if(player1Undos < 4)
			{
				boolean changeIt = false;
				for(int i = 0; i < data.length; i++){
					if(data[i] != dataCopy[i])
					{
						changeIt = true;
					}
				}
				if(changeIt == true)
				{
					for(int i = 0; i < data.length; i ++)
					{
						int x = dataCopy[i];
						data[i] = x;
					}
					if(dontSwitch == false)
					{
						if(player1Turn == true)
						{
							player1Turn =false;
							player2Turn = true;
						}
						else if(player2Turn == true)
						{
							player2Turn =false;
							player1Turn = true;
						}
						else
						{}
					}

					for (ChangeListener l : listeners)
					{
						l.stateChanged(new ChangeEvent(this));
					}
				}
			}
		}
		else
		{
			if(player2Undos < 4)
			{
				boolean changeIt = false;
				for(int i = 0; i < data.length; i++){
					if(data[i] != dataCopy[i])
					{
						changeIt = true;
					}
				}
				if(changeIt == true)
				{
					for(int i = 0; i < data.length; i ++)
					{
						int x = dataCopy[i];
						data[i] = x;
					}
					if(dontSwitch == false)
					{
						if(player1Turn == true)
						{
							player1Turn =false;
							player2Turn = true;
						}
						else if(player2Turn == true)
						{
							player2Turn =false;
							player1Turn = true;
						}
						else
						{}
					}

					for (ChangeListener l : listeners)
					{
						l.stateChanged(new ChangeEvent(this));
					}
				}
			}
		}
	}

	/**
	 * This method handles the movement of stones in the pits.
	 * @param XCoord x-coordinate where mouse has been pressed
	 * @param YCoord y-coordinate where mouse has been pressed
	 */
	public void update(int XCoord, int YCoord)
	{
		for(int i = 0; i < data.length; i ++)
		{
			int x = data[i];
			dataCopy[i] = x;
		}
		if(XCoord > 173 && XCoord < 246)
		{
			lastPitClicked  =11;
			if(data[11] != 0){
				if(YCoord > 131 && YCoord < 209 )
				{
					if(player2Turn == true)
					{
						dontSwitch = false;
						int x = data[11];
						int y = 11;
						data[11] = 0;
						for(int i = 0; i < x; i++)
						{
							if(y == 5)
							{
								y++;
								y = y%13;
								data[y]++;
								if(i == (x-1)){
									if(data[y] == 1){
										if(y == 6 || y == 7 || y == 8 || y == 9 || y == 10 || y == 11){
											int a = corresponding[y];
											int b = data[a];
											data[a] =0;
											data[y] = 0;
											data[12] = data[12]+ 1 + b;
										}
									}
								}
							}

							else
							{
								y++;
								y = y%13;
								data[y]++;
								if(i == (x-1)){
									if(data[y] == 1){
										if(y == 6 || y == 7 || y == 8 || y == 9 || y == 10 || y == 11){
											int a = corresponding[y];
											int b = data[a];
											data[a] =0;
											data[y] = 0;
											data[12] = data[12]+ 1 + b;
										}
									}
								}
							}
						}
						if(y != 12)
						{
							player2Turn = false;
							player1Turn = true;
						}
						else
						{
							dontSwitch = true;
						}
					}
				}
			}

			if(YCoord > 297 && YCoord < 380)
			{
				for(int i = 0; i < data.length; i ++)
				{
					int x = data[i];
					dataCopy[i] = x;
				}
				if(data[0] != 0){
					if(player1Turn == true)
					{
						lastPitClicked  =0;
						dontSwitch = false;
						int x = data[0];
						int y = 0;
						data[0] = 0;
						for(int i = 0; i < x; i++)
						{
							if(y == 5)
							{
								y = y +8;
								data[y]++;
							}
							else if(y == 13)
							{
								y = y - 8;
								y++;
								data[y]++;
							}
							else
							{
								if(y== 11)
								{
									y = y + 2;
									y = y%13;
									data[y]++;
									if(i == (x-1)){
										if(data[y] == 1){
											if(y == 0 || y == 1 || y == 2 || y == 3 || y == 4 || y == 5){
												int a = corresponding[y];
												int b = data[a];
												data[a] =0;
												data[y] = 0;
												data[13] = data[13]+ 1 + b;
											}
										}
									}
								}
								else
								{
									y++;
									y = y%13;
									data[y]++;
									if(i == (x-1)){
										if(data[y] == 1){
											if(y == 0 || y == 1 || y == 2 || y == 3 || y == 4 || y == 5){
												int a = corresponding[y];
												int b = data[a];
												data[a] =0;
												data[y] = 0;
												data[13] = data[13]+ 1 + b;
											}
										}
									}
								}
							}
						}
						if(y != 13)
						{
							player1Turn = false;
							player2Turn = true;
						}
						else
						{
							dontSwitch = true;
						}
					}
				}
			}
			if(data[0]+ data[1] + data[2] +data[3]+ data[4] + data[5] == 0)
			{
				player1Done = true;
			}
			if(data[6]+ data[7] + data[8] +data[9]+ data[10] + data[11] == 0)
			{
				player2Done = true;
			}

		}
		if(XCoord > 290 && XCoord < 359)
		{
			for(int i = 0; i < data.length; i ++)
			{
				int x = data[i];
				dataCopy[i] = x;
			}
			if(data[10] != 0){
				if(YCoord > 131 && YCoord < 209)
				{
					if(player2Turn == true)
					{
						lastPitClicked  =10;
						dontSwitch = false;
						int x = data[10];
						int y = 10;
						data[10] = 0;
						for(int i = 0; i < x; i++)
						{
							if(y == 5)
							{
								y++;
								y = y%13;
								data[y]++;
								if(i == (x-1)){
									if(data[y] == 1){
										if(y == 6 || y == 7 || y == 8 || y == 9 || y == 10 || y == 11){
											int a = corresponding[y];
											int b = data[a];
											data[a] =0;
											data[y] = 0;
											data[12] = data[12]+ 1 + b;
										}
									}
								}
							}

							else
							{
								y++;
								y = y%13;
								data[y]++;
								if(i == (x-1)){
									if(data[y] == 1){
										if(y == 6 || y == 7 || y == 8 || y == 9 || y == 10 || y == 11){
											int a = corresponding[y];
											int b = data[a];
											data[a] =0;
											data[y] = 0;
											data[12] = data[12]+ 1 + b;
										}
									}
								}
							}
						}
						if(y != 12)
						{
							player2Turn = false;
							player1Turn = true;
						}
						else
						{
							dontSwitch = true;
						}
					}

				}
			}
			if(YCoord > 297 && YCoord < 380)
			{

				for(int i = 0; i < data.length; i ++)
				{
					int x = data[i];
					dataCopy[i] = x;
				}
				if(data[1] != 0){
					if(player1Turn == true)
					{
						lastPitClicked  =1;
						dontSwitch = false;
						int x = data[1];
						int y = 1;
						data[1] = 0;
						for(int i = 0; i < x; i++)
						{

							if(y == 5)
							{
								y = y +8;
								data[y]++;
							}
							else if(y == 13)
							{
								y = y - 8;
								y++;
								data[y]++;
							}
							else
							{
								if(y== 11)
								{
									y = y + 2;
									y = y%13;
									data[y]++;
									if(i == (x-1)){
										if(data[y] == 1){
											if(y == 0 || y == 1 || y == 2 || y == 3 || y == 4 || y == 5){
												int a = corresponding[y];
												int b = data[a];
												data[a] =0;
												data[y] = 0;
												data[13] = data[13]+ 1 + b;
											}
										}
									}


								}
								else
								{
									y++;
									y = y%13;
									data[y]++;
									if(i == (x-1)){
										if(data[y] == 1){
											if(y == 0 || y == 1 || y == 2 || y == 3 || y == 4 || y == 5){
												int a = corresponding[y];
												int b = data[a];
												data[a] =0;
												data[y] = 0;
												data[13] = data[13]+ 1 + b;
											}
										}
									}

								}
							}
						}
						if(y != 13)
						{
							player1Turn = false;
							player2Turn = true;
						}
						else
						{
							dontSwitch = true;
						}
					}
				}
			}
			if(data[0]+ data[1] + data[2] +data[3]+ data[4] + data[5] == 0)
			{
				player1Done = true;
			}
			if(data[6]+ data[7] + data[8] +data[9]+ data[10] + data[11] == 0)
			{
				player2Done = true;
			}
		}
		if(XCoord > 409 && XCoord < 474)
		{
			for(int i = 0; i < data.length; i ++)
			{
				int x = data[i];
				dataCopy[i] = x;
			}
			if(YCoord > 131 && YCoord < 209)
			{

				if(data[9] != 0){
					if(player2Turn == true)
					{
						lastPitClicked  =9;
						dontSwitch = false;
						int x = data[9];
						int y = 9;
						data[9] = 0;
						for(int i = 0; i < x; i++)
						{

							if(y == 5)
							{
								y++;
								y = y%13;
								data[y]++;
								if(i == (x-1)){
									if(data[y] == 1){
										if(y == 6 || y == 7 || y == 8 || y == 9 || y == 10 || y == 11){
											int a = corresponding[y];
											int b = data[a];
											data[a] =0;
											data[y] = 0;
											data[12] = data[12]+ 1 + b;
										}
									}
								}
							}

							else
							{
								y++;
								y = y%13;
								data[y]++;
								if(i == (x-1)){
									if(data[y] == 1){
										if(y == 6 || y == 7 || y == 8 || y == 9 || y == 10 || y == 11){
											int a = corresponding[y];
											int b = data[a];
											data[a] =0;
											data[y] = 0;
											data[12] = data[12]+ 1 + b;
										}
									}
								}
							}

						}
						if(y != 12)
						{
							player2Turn = false;
							player1Turn = true;
						}
						else
						{
							dontSwitch = true;
						}
					}
				}

			}
			if(YCoord > 297 && YCoord < 380)
			{
				for(int i = 0; i < data.length; i ++)
				{
					int x = data[i];
					dataCopy[i] = x;
				}
				if(data[2] != 0){
					if(player1Turn == true)
					{
						lastPitClicked  =2;
						dontSwitch = false;
						int x = data[2];
						int y = 2;
						data[2] = 0;
						for(int i = 0; i < x; i++)
						{

							if(y == 5)
							{
								y = y +8;
								data[y]++;
							}
							else if(y == 13)
							{
								y = y - 8;
								y++;
								data[y]++;
							}
							else
							{
								if(y== 11)
								{
									y = y + 2;
									y = y%13;
									data[y]++;
									if(i == (x-1)){
										if(data[y] == 1){
											if(y == 0 || y == 1 || y == 2 || y == 3 || y == 4 || y == 5){
												int a = corresponding[y];
												int b = data[a];
												data[a] =0;
												data[y] = 0;
												data[13] = data[13]+ 1 + b;
											}
										}
									}
								}
								else
								{
									y++;
									y = y%13;
									data[y]++;
									if(i == (x-1)){
										if(data[y] == 1){
											if(y == 0 || y == 1 || y == 2 || y == 3 || y == 4 || y == 5){
												int a = corresponding[y];
												int b = data[a];
												data[a] =0;
												data[y] = 0;
												data[13] = data[13]+ 1 + b;
											}
										}
									}
								}
							}
						}
						if(y != 13)
						{
							player1Turn = false;
							player2Turn = true;
						}
						else
						{
							dontSwitch = true;
						}
					}
				}

			}
			if(data[0]+ data[1] + data[2] +data[3]+ data[4] + data[5] == 0)
			{
				player1Done = true;
			}
			if(data[6]+ data[7] + data[8] +data[9]+ data[10] + data[11] == 0)
			{
				player2Done = true;
			}
		}
		if(XCoord > 525 && XCoord < 581)
		{
			for(int i = 0; i < data.length; i ++)
			{
				int x = data[i];
				dataCopy[i] = x;
			}
			if(data[8] != 0){
				if(YCoord > 131 && YCoord < 209)
				{
					if(player2Turn == true)
					{
						lastPitClicked  =8;
						dontSwitch = false;
						int x = data[8];
						int y = 8;
						data[8] = 0;
						for(int i = 0; i < x; i++)
						{

							if(y == 5)
							{
								y++;
								y = y%13;
								data[y]++;
								if(i == (x-1)){
									if(data[y] == 1){
										if(y == 6 || y == 7 || y == 8 || y == 9 || y == 10 || y == 11){
											int a = corresponding[y];
											int b = data[a];
											data[a] =0;
											data[y] = 0;
											data[12] = data[12]+ 1 + b;
										}
									}
								}
							}

							else
							{
								y++;
								y = y%13;
								data[y]++;
								if(i == (x-1)){
									if(data[y] == 1){
										if(y == 6 || y == 7 || y == 8 || y == 9 || y == 10 || y == 11){
											int a = corresponding[y];
											int b = data[a];
											data[a] =0;
											data[y] = 0;
											data[12] = data[12]+ 1 + b;
										}
									}
								}
							}
						}
						if(y != 12)
						{
							player2Turn = false;
							player1Turn = true;
						}
						else
						{
							dontSwitch = true;
						}
					}
				}
			}
			if(YCoord > 297 && YCoord < 380)
			{
				for(int i = 0; i < data.length; i ++)
				{
					int x = data[i];
					dataCopy[i] = x;
				}
				if(data[3] != 0){
					if(player1Turn == true)
					{
						lastPitClicked  =3;
						dontSwitch = false;
						int x = data[3];
						int y = 3;
						data[3] = 0;
						for(int i = 0; i < x; i++)
						{	
							if(y == 5)
							{
								y = y +8;
								data[y]++;
							}
							else if(y == 13)
							{
								y = y - 8;
								y++;
								data[y]++;
							}
							else
							{
								if(y== 11)
								{
									y = y + 2;
									y = y%13;
									data[y]++;
									if(i == (x-1)){
										if(data[y] == 1){
											if(y == 0 || y == 1 || y == 2 || y == 3 || y == 4 || y == 5){
												int a = corresponding[y];
												int b = data[a];
												data[a] =0;
												data[y] = 0;
												data[13] = data[13] + 1 + b;
											}
										}
									}
								}
								else
								{
									y++;
									y = y%13;
									data[y]++;
									if(i == (x-1)){
										if(data[y] == 1){
											if(y == 0 || y == 1 || y == 2 || y == 3 || y == 4 || y == 5){
												int a = corresponding[y];
												int b = data[a];
												data[a] =0;
												data[y] = 0;
												data[13] = data[13]+ 1 + b;
											}
										}
									}
								}
							}

						}
						if(y != 13)
						{
							player1Turn = false;
							player2Turn = true;
						}
						else
						{
							dontSwitch = true;
						}
					}
				}
			}
			if(data[0]+ data[1] + data[2] +data[3]+ data[4] + data[5] == 0)
			{
				player1Done = true;
			}
			if(data[6]+ data[7] + data[8] +data[9]+ data[10] + data[11] == 0)
			{
				player2Done = true;
			}
		}
		if(XCoord > 641 && XCoord < 710)
		{
			for(int i = 0; i < data.length; i ++)
			{
				int x = data[i];
				dataCopy[i] = x;
			}
			if(data[7] != 0){
				if(YCoord > 131 && YCoord < 209)
				{
					if(player2Turn == true)
					{
						lastPitClicked  =7;
						dontSwitch = false;
						int x = data[7];
						int y = 7;
						data[7] = 0;
						for(int i = 0; i < x; i++)
						{
							if(y == 5)
							{
								y++;
								y = y%13;
								data[y]++;
								if(i == (x-1)){
									if(data[y] == 1){
										if(y == 6 || y == 7 || y == 8 || y == 9 || y == 10 || y == 11){
											int a = corresponding[y];
											int b = data[a];
											data[a] =0;
											data[y] = 0;
											data[12] = data[12]+ 1 + b;
										}
									}
								}
							}
							else
							{
								y++;
								y = y%13;
								data[y]++;
								if(i == (x-1)){
									if(data[y] == 1){
										if(y == 6 || y == 7 || y == 8 || y == 9 || y == 10 || y == 11){
											int a = corresponding[y];
											int b = data[a];
											data[a] =0;
											data[y] = 0;
											data[12] = data[12]+ 1 + b;
										}
									}
								}
							}
						}
						if(y != 12)
						{
							player2Turn = false;
							player1Turn = true;
						}
						else
						{
							dontSwitch = true;
						}
					}
				}
			}
			if(YCoord > 297 && YCoord < 380)
			{
				for(int i = 0; i < data.length; i ++)
				{
					int x = data[i];
					dataCopy[i] = x;
				}
				if(data[4] != 0){
					if(player1Turn == true)
					{
						lastPitClicked  =4;
						dontSwitch = false;
						int x = data[4];
						int y = 4;
						data[4] = 0;
						for(int i = 0; i < x; i++)
						{

							if(y == 5)
							{
								y = y +8;
								data[y]++;
							}
							else if(y == 13)
							{
								y = y - 8;
								y++;
								data[y]++;

							}
							else
							{
								if(y== 11)
								{
									y = y + 2;
									y = y%13;
									data[y]++;
									if(i == (x-1)){
										if(data[y] == 1){
											if(y == 0 || y == 1 || y == 2 || y == 3 || y == 4 || y == 5){
												int a = corresponding[y];
												int b = data[a];
												data[a] =0;
												data[y] = 0;
												data[13] = data[13]+ 1 + b;
											}
										}
									}
								}
								else
								{
									y++;
									y = y%13;
									data[y]++;
									if(i == (x-1)){
										if(data[y] == 1){
											if(y == 0 || y == 1 || y == 2 || y == 3 || y == 4 || y == 5){
												int a = corresponding[y];
												int b = data[a];
												data[a] =0;
												data[y] = 0;
												data[13] = data[13] + 1 + b;
											}
										}
									}


								}
							}
						}
						if(y != 13)
						{
							player1Turn = false;
							player2Turn = true;
						}
						else
						{
							dontSwitch = true;
						}
					}
				}
			}
			if(data[0]+ data[1] + data[2] +data[3]+ data[4] + data[5] == 0)
			{
				player1Done = true;
			}
			if(data[6]+ data[7] + data[8] +data[9]+ data[10] + data[11] == 0)
			{
				player2Done = true;
			}
		}
		if(XCoord > 753 && XCoord < 826)
		{
			for(int i = 0; i < data.length; i ++)
			{
				int x = data[i];
				dataCopy[i] = x;
			}
			if(YCoord > 131 && YCoord < 209)
			{
				if(data[6] != 0){
					if(player2Turn == true)
					{
						lastPitClicked  = 6;
						dontSwitch = false;
						int x = data[6];
						int y = 6;
						data[6] = 0;
						for(int i = 0; i < x; i++)
						{
							if(y == 5)
							{
								y++;
								y = y%13;
								data[y]++;
								if(i == (x-1)){
									if(data[y] == 1){
										if(y == 6 || y == 7 || y == 8 || y == 9 || y == 10 || y == 11){
											int a = corresponding[y];
											int b = data[a];
											data[a] =0;
											data[y] = 0;
											data[12] = data[12]+ 1 + b;
										}
									}
								}

							}

							else
							{
								y++;
								y = y%13;
								data[y]++;
								if(i == (x-1)){
									if(data[y] == 1){
										if(y == 6 || y == 7 || y == 8 || y == 9 || y == 10 || y == 11){
											int a = corresponding[y];
											int b = data[a];
											data[a] =0;
											data[y] = 0;
											data[12] = data[12]+ 1 + b;
										}
									}
								}

							}
						}
						if(y != 12)
						{
							player2Turn = false;
							player1Turn = true;
						}
						else
						{
							dontSwitch = true;
						}
					}
				}
			}
			if(YCoord > 297 && YCoord < 380)
			{

				for(int i = 0; i < data.length; i ++)
				{
					int x = data[i];
					dataCopy[i] = x;
				}
				if(data[5] != 0){
					if(player1Turn == true)
					{
						lastPitClicked  =5;
						dontSwitch = false;
						int x = data[5];
						int y = 5;
						data[5] = 0;
						for(int i = 0; i < x; i++)
						{

							if(y == 5)
							{
								y = y +8;
								data[y]++;
							}
							else if(y == 13)
							{
								y = y - 8;
								y++;
								data[y]++;

							}
							else
							{
								if(y== 11)
								{
									y = y + 2;
									y = y%13;
									data[y]++;
									if(i == (x-1)){
										if(data[y] == 1){
											if(y == 0 || y == 1 || y == 2 || y == 3 || y == 4 || y == 5){
												int a = corresponding[y];
												int b = data[a];
												data[a] =0;
												data[y] = 0;
												data[13] = data[13] + 1 + b;
											}
										}
									}
								}
								else
								{
									y++;
									y = y%13;
									data[y]++;
									if(i == (x-1)){
										if(data[y] == 1){
											if(y == 0 || y == 1 || y == 2 || y == 3 || y == 4 || y == 5){
												int a = corresponding[y];
												int b = data[a];
												data[a] =0;
												data[y] = 0;
												data[13] = data[13] + 1 + b;
											}
										}
									}
								}
							}
						}
						if(y != 13)
						{
							player1Turn = false;
							player2Turn = true;
						}
						else
						{
							dontSwitch = true;
						}
					}
				}
			}
			if(data[0]+ data[1] + data[2] +data[3]+ data[4] + data[5] == 0)
			{
				player1Done = true;
			}
			if(data[6]+ data[7] + data[8] +data[9]+ data[10] + data[11] == 0)
			{
				player2Done = true;
			}
		}
		if(player1Done == true)
		{
			int int1 = data[6];
			int int2 = data[7];
			int int3 = data[8];
			int int4 = data[9];
			int int5 = data[10];
			int int6 = data[11];

			data[6] = 0;
			data[7] = 0;
			data[8] = 0;
			data[9] = 0;
			data[10] = 0;
			data[11] = 0;
			data[12] = data[12] + int1 + int2 + int3 + int4 + int5 + int6;
		}
		if(player2Done == true)
		{
			int int1 = data[0];
			int int2 = data[1];
			int int3 = data[2];
			int int4 = data[3];
			int int5 = data[4];
			int int6 = data[5];

			data[0] = 0;
			data[1] = 0;
			data[2] = 0;
			data[3] = 0;
			data[4] = 0;
			data[5] = 0;
			data[13] = data[13] + int1 + int2 + int3 + int4 + int5 + int6;
		}
		for (ChangeListener l : listeners)
		{
			l.stateChanged(new ChangeEvent(this));
		}
	}
}