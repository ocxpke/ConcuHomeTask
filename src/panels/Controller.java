package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
	private Panel p;

	public Controller(Panel p) {
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("CANCEL")) {
			System.out.println("Cancelar");
		} else if (e.getActionCommand().equalsIgnoreCase("PRIM_TWINS")) {
			System.out.println("PRIMO TWIN");
		} else if (e.getActionCommand().equalsIgnoreCase("PRIM_COUSINS")) {
			System.out.println("PRIMO COUSIN");
		} else if (e.getActionCommand().equalsIgnoreCase("PRIM_SEXY")) {
			System.out.println("PRIMO SEXY");
		}

	}

}
