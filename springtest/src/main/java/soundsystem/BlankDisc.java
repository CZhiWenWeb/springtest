package soundsystem;

import lombok.Data;

import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-06-17 11:52
 * @UpdeteTime: 2019-06-17 11:52
 * @Description:
 */
@Data
public class BlankDisc implements CompactDisc{
	private String title;
	private String artist;
	private List<String> tracks;
	public BlankDisc(){
		this.artist=artist;
		this.title=title;
		this.tracks=tracks;
	}
	@Override
	public void play() {
		System.out.println("Playing"+title+"by"+artist);
		for (String track:tracks
		     ) {
			System.out.println("-Track:"+track);
		}
	}

	@Override
	public void playTrack(int i) {

	}
}
