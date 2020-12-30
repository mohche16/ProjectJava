package soundgui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	
	//Arraylist med våra knappar, knappar läggs till med createNewSoundBtn
	ArrayList<JButton> soundBtns = new ArrayList<JButton>();
	
	
	
	//Vår SoundPlayer class objekt
	SoundPlayer player = new SoundPlayer();
	
	public void createNewSoundBtn(String soundpath) {
		JButton Button = new JButton(soundpath);
		Button.addActionListener(this);
		soundBtns.add(Button);
	}
	
	//Constructor för vår GUI
	public MainGui() {
		//Objekt av jframe
		frame = new JFrame("LjudSpelare GritAcademy");
		
		//Objekt till våra komponenter
		createNewSoundBtn("/resources/1.wav");
		createNewSoundBtn("/resources/2.wav");
		createNewSoundBtn("/resources/3.wav");
		createNewSoundBtn("/resources/4.wav");
		JLabel headerLabel = new JLabel("Tryck för att spela ljud");
		
		//Panel komponent
		panel = new JPanel();
		
		//Mellanrum mellan panelen och framen
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		//Sorterar komponenterna i panelen så de ligger i en "grid"
		panel.setLayout(new GridLayout(0, 1));
		//Lägg till komponenterna till parenten (panelen)
		panel.add(headerLabel);
		
		//Loopa och lägg till knapp objekten som vi skapa med createNewSoundBtn till panelen
		for (JButton btn: soundBtns)
		{
			panel.add(btn);
		}
		
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
		//Lägg till objektet vi tryckt på och casta den till en JButton sedan spela upp ljudet som är namnet på knappen
		JButton button = (JButton) e.getSource();
		player.playSound(button.getText());
			
		
	}

}
