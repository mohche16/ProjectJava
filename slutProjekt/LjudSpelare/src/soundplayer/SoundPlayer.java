//Vårt package
package soundplayer;

//Package som Används för att spela upp ljud
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//SoundPlayer class med playSound method som tar en sträng som är soundfilen
public class SoundPlayer {
	public void playSound(String soundpath) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getResource(soundpath)));
			clip.start();

		} catch (Exception exc) {
			System.out.println(exc);

		}
	}
}
