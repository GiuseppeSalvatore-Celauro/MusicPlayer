package views.components;

import java.util.List;

import Interface.PopupController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import model.Playlist;
import model.Song;
import service.SongService;
import views.MainSceneController;

public class AddSongToPlaylistViewController{
	private List<Playlist> playlists;
	private List<Song> songs;
	private MainSceneController mainController;
	private Stage dialog;
	
	@FXML
	private ChoiceBox<Playlist> playlistBox;
	
	@FXML
	private ChoiceBox<Song> songBox;
	public void setMainController(MainSceneController mainController) {
		this.mainController = mainController;
		
	}

	public void setDialog(Stage dialog) {
		this.dialog = dialog;
		
	}

	public void setPlaylist(List<Playlist> playlist) {
		this.playlists = playlist;
		
		if(!playlists.isEmpty()) {
			playlistBox.setItems(FXCollections.observableArrayList(playlists));
		}
	}

	public void setSong(SongService songService) {
		this.songs = songService.getAllSongs();
		songService.showAllSongs(null);
		songBox.setItems(FXCollections.observableArrayList(songs));
	}
	
	public void addSong() {
		Playlist p = playlistBox.getValue();
		Song s = songBox.getValue();
		if(p !=null && s != null) {
			p.addSong(s);;
			System.out.println(p.getPlaylistSongs());
			dialog.close();
		}
	}
	
	
	
	

}
