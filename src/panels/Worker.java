package panels;

import java.util.List;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

//SwingWorker<[lo que devuleve doInBackgorund() al acabar],[parametro del publish, lo que se devuelve en valores intermedios(publish() y process())]>
public class Worker extends SwingWorker<String, Integer[]> {

	// Que tipo de Worker es
	public enum primT {
		twins, cousins, sexy
	}

	private JTextArea textArea;
	public primT type;
	private int total;

	// Cosntructor
	public Worker(JTextArea textArea, primT a, int total) {
		this.textArea = textArea;
		this.type = a;
		this.total = total;
	}

	@Override
	protected String doInBackground() throws Exception {
		int numI = 2;
		int cont = 0;
		while (cont < total) {
			if (Primes.isPrime(numI)) {
				// Escogemos por cada caso
				switch (this.type) {
				case twins:
					if (nextPrim(cont, numI, 2)) {
						cont++;
					}
					break;
				case cousins:
					if (nextPrim(cont, numI, 4)) {
						cont++;
					}
					break;
				case sexy:
					if (nextPrim(cont, numI, 6)) {
						cont++;
					}
					break;
				}
			}
			Thread.sleep(50);
			numI++;
		}
		return "Hecho";
	}

	// Function to test if next num, depending on worker type, is prim
	private boolean nextPrim(int cont, int numI, int sum) {
		boolean ret = false;
		// sum indica el tipo de Worker (2,4,6)
		int numToC = numI + sum;
		if (Primes.isPrime(numToC)) {
			Integer arr[] = { cont, numI, numToC };
			publish(arr);
			ret = true;
		}
		return ret;
	}

	@Override
	protected void process(List<Integer[]> chunks) {
		// Procesamos los publish hecho en doInBackground()
		if ((chunks.get(0)[0] % 5) == 0 && chunks.get(0)[0] != 0) {
			this.textArea.setText(this.textArea.getText() + "\n");
		}
		this.textArea.setText(
				this.textArea.getText() + chunks.get(0)[0] + ":[" + chunks.get(0)[1] + " " + chunks.get(0)[2] + "], ");

		// this.total-->100%;
		int value = ((chunks.get(0)[0] * 100) / this.total - 1);
		if(value<=0) {
			value=1;
		}
		this.setProgress(value);
	}

	@Override
	protected void done() {
		try {
			this.textArea.setText(this.textArea.getText() + "\n" + get().toString());
			this.setProgress(100);
			Controller.finishedThread(this.type);
			Controller.allFinished();
		} catch (Exception e) {
			this.setProgress(0);
			this.textArea.setText("Cancelled\n");
			
		}
	}

}
