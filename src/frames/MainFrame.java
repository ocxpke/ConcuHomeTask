package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import panels.Controller;
import panels.Panel;
import javax.swing.JProgressBar;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
		
		ctr = new Controller(p, progressBar1, progressBar2, progressBar3);
		p.setController(ctr);

	}
}
