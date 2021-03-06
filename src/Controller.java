import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Controller implements KeyListener {

	private Model model;
	private JFrame frame;

	public Controller(Model model, JFrame frame) {
		this.model = model;
		this.frame = frame;
		this.frame.addKeyListener(this);
		this.frame.setFocusable(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyChar() == 'z') {
			this.model.heroMove(Direction.NORTH);
		}

		if (e.getKeyChar() == 's') {
			this.model.heroMove(Direction.SOUTH);
		}

		if (e.getKeyChar() == 'd') {
			this.model.heroMove(Direction.EAST);
		}

		if (e.getKeyChar() == 'q') {
			this.model.heroMove(Direction.WEST);
		}
		this.frame.repaint();
		
	}
}
