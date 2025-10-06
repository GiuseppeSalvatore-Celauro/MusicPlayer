package service;

import java.util.ArrayList;
import java.util.List;

import model.Song;
import model.User;

public class SongService {

	private List<Song> songList = new ArrayList<Song>();
	
	public Song songCreate(String title, Integer duration,User user) {
		Song song = new Song(title, duration ,user);
		songList.add(song);
		user.getUserSongs().add(song);
		return song;
	}
	
	public List<Song> getAllSongs(){
		return songList;
	}
	
	public Song getSongById(Integer id) {
		for(Song song: songList) {
			if(song.getId() == id) {
				return song;
			}
		}
		
		return null;
	}
	
	public String playSong(Song song) {
		return "In riproduzione... " + song.getTitle();
	}
	
	public boolean editSongTitle(Integer id, String title) {
		Song song = getSongById(id);
		if(song != null) {
			song.setTitle(title);
			return true;
		}
		return false;
	}
	
	public String getSongInfos(Integer id) {
		Song song = getSongById(id);
		
		if(song == null) {return "Nessuna canzone trovata";}
		
		return song.toString();
	}

	
}
