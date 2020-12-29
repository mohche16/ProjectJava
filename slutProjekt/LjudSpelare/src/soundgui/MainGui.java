package soundgui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import soundplayer.SoundPlayer;

public class MainGui implements ActionListener {
	//Skapar en ruta
	JFrame frame;
	//Behållare i rutan som lagrar komponenter
	JPanel panel;
	//Komponenter (knappar)
	JButton soundOneBtn;
	JButton soundTwoBtn;
	JButton soundThreeBtn;
	
	//Vår SoundPlayer class objekt
	static SoundPlayer player = new SoundPlayer();
	
	
	//Constructor för vår GUI
	public MainGui() {
		//Objekt av jframe
		frame = new JFrame("LjudSpelare GritAcademy");
		
		//Objekt till våra komponenter
		soundOneBtn = new JButton("Spela ljud 1");
		soundTwoBtn = new JButton("Spela ljud 2");
		soundThreeBtn = new JButton("Spela ljud 3");
		
		soundOneBtn.addActionListener(this);
		soundTwoBtn.addActionListener(this);
		soundThreeBtn.addActionListener(this);
		JLabel headerLabel = new JLabel("Tryck för att spela ljud");
		
		//Panel komponent
		panel = new JPanel();
		
		//Mellanrum mellan panelen och framen
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		//Sorterar komponenterna i panelen så de ligger i en "grid"
		panel.setLayout(new GridLayout(0, 1));
		//Lägg till komponenterna till parenten (panelen)
		panel.add(headerLabel);
		panel.add(soundOneBtn);
		panel.add(soundTwoBtn);
		panel.add(soundThreeBtn);
		
		//Lägg panelen till framen
		frame.add(panel, BorderLayout.CENTER);
		//Storleken på rutan
		frame.setPreferredSize(new Dimension(400, 200));
		//Vad som händer när man trycker close, stäng programmet
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Automatisk resizing
		frame.pack();
		//Framen är invisible i början
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		//Nytt objekt av vår MainGui klass
		new MainGui();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Kör 1.wav om objektet man tryckt på är första knappen
		if (e.getSource() == soundOneBtn)
			player.playSound("/resources/1.wav");
		else if (e.getSource() == soundTwoBtn)
			player.playSound("/resources/2.wav");
		else if (e.getSource() == soundThreeBtn)
			player.playSound("/resources/3.wav");
			
		
	}

}
