package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import co.edu.uptc.exception.NotValidException;
import co.edu.uptc.view.Frame;


public class Presenter implements ActionListener{

	private Frame frame;

	public Presenter() {
		frame = new Frame(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		switch (source) {
		case "Start":
			this.startGame();;
			break;
		}
	}

	private void verifyValues() throws NotValidException, IOException {
		if(frame.getIntValue()>=0) {
			frame.initFractalPanel();
		}else {
			throw new NotValidException("Por favor introduzca un valor de 1 en adelante");
		}
	}

	private void startGame(){
		try {
			this.verifyValues();
		} catch (NotValidException e) {
			 JOptionPane.showMessageDialog(null, "Ingrese un numero mayor o igual a 0", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			 JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
		}catch (NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, "Ingrese el numero de iteraciones", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		new Presenter();
	}
}
