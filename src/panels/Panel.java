package panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import java.util.List;

public class Panel extends JPanel {

	private JLabel label1 = new JLabel("How many twin primes do you want?");
	private JTextField number1 = new JTextField(3);
	private JLabel label2 = new JLabel("How many cousin primes do you want?");
	private JTextField number2 = new JTextField(3);
	private JLabel label3 = new JLabel("How many sexy primes do you want?");
	private JTextField number3 = new JTextField(3);
	private JLabel message = new JLabel("GUI created");
	private JTextArea listPrimes1 = new JTextArea(10, 40);
	private JTextArea listPrimes2 = new JTextArea(10, 40);
	private JTextArea listPrimes3 = new JTextArea(10, 40);
	private JScrollPane scroll1 = new JScrollPane(listPrimes1);
	private JScrollPane scroll2 = new JScrollPane(listPrimes2);
	private JScrollPane scroll3 = new JScrollPane(listPrimes3);
	private JLabel message1 = new JLabel("Calculating  primes 'twin'");
	private JLabel message2 = new JLabel("Calculating  primes 'cousin'");
	private JLabel message3 = new JLabel("Calculating  primes 'sexy'");
	private JButton end = new JButton("Cancel");

	
	//Solo he añadido los getters
	
	public JButton getEnd() {
		return end;
	}

	public JTextArea getListPrimes1() {
		return listPrimes1;
	}

	public JTextArea getListPrimes2() {
		return listPrimes2;
	}

	public JTextArea getListPrimes3() {
		return listPrimes3;
	}

	public JTextField getNumber1() {
		return number1;
	}

	public JTextField getNumber2() {
		return number2;
	}

	public JTextField getNumber3() {
		return number3;
	}

	public Panel() {
		this.setLayout(new BorderLayout());
		JPanel north = new JPanel();
		north.add(end);
		
		end.setActionCommand("CANCEL");
		end.setEnabled(false);
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1, 3));
		JPanel leftTop = new JPanel();
		leftTop.add(label1);
		leftTop.add(number1);
		
		number1.setActionCommand("PRIM_TWINS");
		
		JPanel centerTop = new JPanel();
		centerTop.add(label2);
		centerTop.add(number2);
		
		number2.setActionCommand("PRIM_COUSINS");
		
		JPanel rightTop = new JPanel();
		rightTop.add(label3);
		rightTop.add(number3);
		
		number3.setActionCommand("PRIM_SEXY");
		
		JPanel left = new JPanel();
		left.setLayout(new BorderLayout());

		left.add(BorderLayout.NORTH, leftTop);
		left.add(BorderLayout.CENTER, scroll1);
		left.add(BorderLayout.SOUTH, message1);
		JPanel center1 = new JPanel();
		center1.setLayout(new BorderLayout());
		center1.add(BorderLayout.NORTH, centerTop);
		center1.add(BorderLayout.CENTER, scroll2);
		center1.add(BorderLayout.SOUTH, message2);
		JPanel right = new JPanel();
		right.setLayout(new BorderLayout());
		right.add(BorderLayout.NORTH, rightTop);
		right.add(BorderLayout.CENTER, scroll3);
		right.add(BorderLayout.SOUTH, message3);
		center.add(left);
		center.add(center1);
		center.add(right);
		this.add(BorderLayout.NORTH, north);
		this.add(BorderLayout.CENTER, center);
		this.add(BorderLayout.SOUTH, message);

	}

	public void setController(ActionListener ctr) {
		end.addActionListener(ctr);
		number1.addActionListener(ctr);
		number2.addActionListener(ctr);
		number3.addActionListener(ctr);
	}

}
