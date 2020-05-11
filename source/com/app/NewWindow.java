package com.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewWindow{


	public static void main(String[] args) {

		MyFrame frame = new MyFrame();	
	}

	static class MyFrame extends JFrame{

		MyPanel panel = new MyPanel();

		public MyFrame(){

			setTitle("Main Window");
			setBounds(1000,40,400,200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			add(panel);
		}
	}

	static class NewFrame extends JFrame{

		private static int counter = 0;

		public NewFrame(JButton main_button){

			counter++;
			setTitle("Window " + counter);
			setBounds(40*counter,40*counter,400,200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);

			main_button.addActionListener(new CloseBtnListener());
		}

		private class CloseBtnListener implements ActionListener{

			public void actionPerformed(ActionEvent e){

				dispose();
				counter=0;
			}
		}
	}

	static class MyPanel extends JPanel{

		private JButton newWindow = new JButton("New Window");
		private JButton closeWindows = new JButton("Close all Windows");

		public MyPanel(){

			newWindow.addActionListener(new NewBtnListener());

			add(newWindow);
			add(closeWindows);

		}

		private class NewBtnListener implements ActionListener{

			public void actionPerformed(ActionEvent e){

				 new NewFrame(closeWindows);
			}
		}
		
	}
}