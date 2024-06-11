package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JProgressBar;

public class Controller implements ActionListener, PropertyChangeListener{
	private static Panel p;
	private static Worker w1;
	private static Worker w2;
	private static Worker w3;
	private JProgressBar pB1;
	private JProgressBar pB2;
	private JProgressBar pB3;

	public Controller(Panel p, JProgressBar pB1, JProgressBar pB2, JProgressBar pB3) {
		Controller.p = p;
		this.pB1 = pB1;
		this.pB2 = pB2;
		this.pB3 = pB3;
	}

	public static void allFinished() {
		try {
			if (w1.isDone()) {
				p.getNumber1().setEnabled(true);
				p.getListPrimes1().setEnabled(true);
			}

			if (w2.isDone()) {
				p.getNumber2().setEnabled(true);
				p.getListPrimes2().setEnabled(true);
			}

			if (w3.isDone()) {
				p.getNumber3().setEnabled(true);
				p.getListPrimes3().setEnabled(true);
			}
			
			//The way this is implemented this can throw NullPointerException
			if (w1.isDone() && w2.isDone() && w3.isDone()) {
				p.getEnd().setEnabled(false);
			}
		} catch (NullPointerException e) {
			//some of the 3 workers is null at this moment
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("CANCEL")) {
			if (w1 != null) {
				w1.cancel(true);
				p.getListPrimes1().setEnabled(true);
				p.getNumber1().setEnabled(true);

				w1 = null;
			}

			if (w2 != null) {
				w2.cancel(true);
				p.getListPrimes2().setEnabled(true);
				p.getNumber2().setEnabled(true);

				w2 = null;
			}

			if (w3 != null) {
				w3.cancel(true);
				p.getListPrimes3().setEnabled(true);
				p.getNumber3().setEnabled(true);

				w3 = null;
			}

			p.getEnd().setEnabled(false);

		} else if (e.getActionCommand().equalsIgnoreCase("PRIM_TWINS")) {
			p.getNumber1().setEnabled(false);
			w1 = new Worker(p.getListPrimes1(), Worker.primT.twins, Integer.parseInt(p.getNumber1().getText()),
					this.pB1);
			w1.execute();
			p.getEnd().setEnabled(true);
			p.getListPrimes1().setEnabled(false);

		} else if (e.getActionCommand().equalsIgnoreCase("PRIM_COUSINS")) {
			p.getNumber2().setEnabled(false);
			w2 = new Worker(p.getListPrimes2(), Worker.primT.cousins, Integer.parseInt(p.getNumber2().getText()),
					this.pB2);
			w2.execute();
			p.getEnd().setEnabled(true);
			p.getListPrimes2().setEnabled(false);

		} else if (e.getActionCommand().equalsIgnoreCase("PRIM_SEXY")) {
			p.getNumber3().setEnabled(false);
			w3 = new Worker(p.getListPrimes3(), Worker.primT.sexy, Integer.parseInt(p.getNumber3().getText()),
					this.pB3);
			w3.execute();
			p.getEnd().setEnabled(true);
			p.getListPrimes3().setEnabled(false);
		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

}
