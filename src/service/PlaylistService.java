package service;

import java.util.ArrayList;
import java.util.List;

import model.Playlist;
import model.User;

public class PlaylistService {

	private List<Playlist> playlistList = new ArrayList<Playlist>();
	
	public Playlist playlistCreate(String playlistName, User user) {
		Playlist playlist = new Playlist(playlistName, user);
		playlistList.add(playlist);
		user.getUserPlaylists().add(playlist);
		return playlist;
	}
	
	public List<Playlist> getAllPlaylist(){
		return playlistList;
	}
	
	public Playlist getPlaylistById(Integer id) {
		for(Playlist playlist: playlistList) {
			if(playlist.getId() == id) {
				return playlist;
			}
		}
		
		return null;
	}
	
	public boolean editPlaylistName(Integer id, String playlistName) {
		Playlist playlist = getPlaylistById(id);
		if(playlist != null) {
			playlist.setPlaylistName(playlistName);
			return true;
		}
		return false;
	}
	
	public String getPlaylistInfos(Integer id) {
		Playlist playlist = getPlaylistById(id);
		
		if(playlist == null) {return "Nessuna canzone trovata";}
		
		return playlist.toString();
	}
}
