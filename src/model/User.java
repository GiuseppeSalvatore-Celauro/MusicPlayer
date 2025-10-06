package model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private static Integer counter = 0;
	private Integer id;
	private String name;
	private String email;
	private String profilePicture = null;
	private Integer totalFollowers = 0;
	private Integer totalFollowing = 0;
	private List<Playlist> userPlaylists;
	private List<Song> userSongs;
	
	//	Costructor di user
	public User(String name, String email) {
		incrementCounter();
		this.id = counter;
		this.name = name;
		this.email = email;
		this.userPlaylists = new ArrayList<Playlist>();
		this.userSongs = new ArrayList<Song>();
	}
	
	
	// Sezione getter and setter
	public Integer getId() {
		return id;
	}
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getProfilePicture() {
		return profilePicture;
	}
	
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	public int getTotalFollowers() {
		return totalFollowers;
	}
	
	public void setTotalFollowers(int totalFollowers) {
		this.totalFollowers = totalFollowers;
	}
	
	public int getTotalFollowing() {
		return totalFollowing;
	}
	public void setTotalFollowing(int totalFollowing) {
		this.totalFollowing = totalFollowing;
	}
	public List<Playlist> getUserPlaylists() {
		return userPlaylists;
	}
	public void setUserPlaylists(List<Playlist> userPlaylists) {
		this.userPlaylists = userPlaylists;
	}
	public List<Song> getUserSongs() {
		return userSongs;
	}
	public void setUserSongs(List<Song> songs) {
		this.userSongs = songs;
	}	
	
	// funzione che permette all'id degli utenti di aumentarsi automaticamente
	static public void incrementCounter() {
		counter++;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User"+ id +": name='" + name + "', email=" + email;
	}
	
	
	//funzioni relative alla gestione delle song per il singolo user
	
	public void addSong(Song song) {
		this.userSongs.add(song);
		if(song.getAuthor() != this) {
			song.setAuthor(this);
		}
	}
}
