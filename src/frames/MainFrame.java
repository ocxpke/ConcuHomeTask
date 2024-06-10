package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import panels.Controller;
import panels.Panel;
import panels.Worker;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Worker w1;
	private Worker w2;
	private Worker w3;
	private JProgressBar progressBar1, progressBar2, progressBar3;
	private Controller ctr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() throws Exception {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 375);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		Panel p = new Panel();
		ctr =new Controller(p);
		p.setController(ctr);
		p.setBounds(203, 10, 978, 277);
		contentPane.add(p);
		setContentPane(contentPane);

		progressBar1 = new JProgressBar();
		progressBar1.setBounds(203, 298, 305, 20);
		contentPane.add(progressBar1);

		progressBar2 = new JProgressBar();
		progressBar2.setBounds(531, 298, 305, 20);
		contentPane.add(progressBar2);

		progressBar3 = new JProgressBar();
		progressBar3.setBounds(855, 298, 305, 20);
		contentPane.add(progressBar3);

		//Cancelamos
		p.getEnd().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				w1.cancel(true);
				w2.cancel(true);
				w3.cancel(true);
			}
		});

		//Utilizamos ActionListener o DocumentListener??
		p.getNumber1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				w1 = new Worker(p.getListPrimes1(), Worker.primT.twins, Integer.parseInt(p.getNumber1().getText()), progressBar1);
				w1.execute();
			}
		});

		p.getNumber2().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				w2 = new Worker(p.getListPrimes2(), Worker.primT.cousins, Integer.parseInt(p.getNumber2().getText()), progressBar2);
				w2.execute();
			}
		});

		p.getNumber3().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				w3 = new Worker(p.getListPrimes3(), Worker.primT.sexy, Integer.parseInt(p.getNumber3().getText()), progressBar3);
				w3.execute();
			}
		});

	}
}
