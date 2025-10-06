package service;

import java.util.ArrayList;
import java.util.List;

import model.Playlist;
import model.Song;
import model.User;

public class UserService {

	private List<User> userList = new ArrayList<User>();
	
	public User userCreate(String name, String email) {
		User user = new User(name, email);
		userList.add(user);
		return user;
	}
	
	public List<User> getAllUser() {
		return userList;
	}
	
	public User getUserById(Integer id) {
		for(User user: userList) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public boolean editUserEmail(Integer id, String Email) {
		User user = getUserById(id);
		if(user != null) {
			user.setEmail(Email);
			return true;
		}
		return false;
	}
	
	public List<Song> getUserSongs(Integer id) {
		User user = getUserById(id);
		if(user.getUserSongs().isEmpty()) { return null; }
		return user.getUserSongs();
	}
	
	public List<Playlist> getUserPlaylists(Integer id){
		User user = getUserById(id);
		if(user.getUserPlaylists().isEmpty()) { return null; }
		return user.getUserPlaylists();
	}
	
	public String getUserInfos(Integer id) {
		User user = getUserById(id);
		
		if(user == null) {return "Nessun utente trovato";}
		
		StringBuilder sb = new StringBuilder();
		sb.append("L'utente ").append(user.getName()).append("\n");
		if(user.getUserSongs().isEmpty()) {
			sb.append(" non ha pubblicato alcuna canzone \n") ;
		}else {
			sb.append(" ha pubblicato queste canzoni: \n");
			for(Song song: user.getUserSongs()) {
				sb.append("   - ").append(song.getTitle()).append("\n");
			}
		}
		
		if(user.getUserPlaylists().isEmpty()) {
			sb.append(" non ha creato alcuna playlist \n") ;
		}else {
			sb.append(" ha creato queste playlist: \n");
			for(Playlist playlist: user.getUserPlaylists()) {
				sb.append("   - ").append(playlist.getPlaylistName()).append("\n");
			}
		}
		
		return sb.toString();
		
	}
}
