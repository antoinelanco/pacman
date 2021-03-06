import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class View {

	private JFrame frame;
	private static final int SCALE = 50;
	private plateau plateau;
	private Model model;
			
	public View(Model model, int size) {
		this.model = model;
		JFrame frame = new JFrame();
		Container cp = frame.getContentPane();
		frame.setTitle("PacMan");
		frame.setSize((size * SCALE) + 25 +300, (size * SCALE) + 50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.plateau = new plateau(model);
		cp.add(this.plateau);
		
		
		JPanel LP = new JPanel();
		JLabel label = new JLabel();
		label.setForeground(Color.WHITE);
		label.setText("Score : "+this.model.getHero().getScore());
		System.out.println(this.model.getHero().getScore());
		LP.setPreferredSize(new Dimension(300,(size*SCALE)+50));
		LP.setBackground(Color.BLACK);
		LP.add(label);
		cp.add(LP, BorderLayout.EAST);
		
		frame.setVisible(true);
		this.frame = frame;
	}

	public JFrame getFrame() {
		return this.frame;
	}

}

class plateau extends JPanel {

	private Model model;
	private static final int SCALE = 50;

	public plateau(Model model) {
		this.model = model;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < this.model.getSize(); i++) {
			for (int j = 0; j < this.model.getSize(); j++) {
				this.model.getMap()[i][j].paintCell(g2, i * this.SCALE, j * this.SCALE, this.SCALE);
			}
		}
		try {
			this.model.getHero().paintHero(g2, this.SCALE);
			for(Monstre m : this.model.getMonstre()){
				m.paintMonstre(g2, this.SCALE);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//class LeftPanel extends JPanel{
//	
//	private Model model;
//	private int size;
//	private static final int SCALE = 50;
//	
//	public LeftPanel(Model model, int size){
//		this.model = model;
//		this.size = size;
//
//
//		
//	}
//	
//	public void paintComponent(Graphics g) {
//		
//
//		
//		
//	}
//}
//






