package model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

	private static int counter = 0;
	private Integer id;
	private String playlistName;
	private User playlistAuthor;
	private String pfp;
	private List<Song> playlistSongs;
	
	public Playlist(String playlistName, User playlistAuthor) {
		incrementCounter();
		this.id = counter;
		this.playlistName = playlistName;
		this.playlistAuthor = playlistAuthor;
		this.playlistSongs = new ArrayList<Song>();
	}
	
	
	public String getPlaylistName() {
		return playlistName;
	}
	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}
	public User getPlaylistAuthor() {
		return playlistAuthor;
	}
	public void setPlaylistAuthor(User playlistAuthor) {
		this.playlistAuthor = playlistAuthor;
	}
	public String getPfp() {
		return pfp;
	}
	public void setPfp(String pfp) {
		this.pfp = pfp;
	}
	public List<Song> getPlaylistSongs() {
		return playlistSongs;
	}
	public void setPlaylistSongs(List<Song> playlistSongs) {
		this.playlistSongs = playlistSongs;
	}
	public Integer getId() {
		return id;
	}
	
	static public void incrementCounter() {
		counter++;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Playlist "+ id +": Nome della playlist='" + playlistName + "', Autore della playlist=" + playlistAuthor.getName() + ".\n";
	}
	
	public void addSong(Song song) {
		this.getPlaylistSongs().add(song);
	}
	
	public boolean removeSong(Song song) {
		if(this.getPlaylistSongs().remove(song)) {
			return true;
		}
		return false;
	}
	
}
