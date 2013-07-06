package co.devrandom.audio;

import org.newdawn.slick.openal.Audio;

public enum AudioList {
	PING("sonar-pings.ogg"),
	SWISH("swish.ogg"),
	SMALL_EXPLOSION("small-explosion.ogg");
	
	private Audio audio;
	
	private AudioList(String fileName) {
		this.audio = AudioLoader.loadOGG(fileName);
	}
	
	public Audio getAudio() {
		return audio;
	}
}
