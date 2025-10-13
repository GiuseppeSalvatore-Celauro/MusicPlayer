package views.components;


import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import model.Playlist;
import model.Song;
import model.User;
import service.PlaylistService;
import service.SongService;
import views.MainSceneController;

public class PlaylistViewController {
	
	private User authUser;
	
	@FXML
	private TableView<Playlist> playlistTable;
	@FXML
	private TableColumn<Playlist, String> playlistTitle;
	@FXML
	private TableColumn<Playlist, String> playlistAuthor;
	
	@FXML
	private HBox playlistView;
	
	private MainSceneController mainController;
	private AnchorPane anchorPane;
	@FXML
	public void initialize() {
		playlistTitle.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPlaylistName()));
		playlistAuthor.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPlaylistAuthor().getName()));
		
		playlistTable.setRowFactory(tv ->{
			TableRow<Playlist> row = new TableRow<Playlist>();
			row.setOnMouseClicked(event -> {
			    if (!row.isEmpty() && event.getClickCount() == 2) {
			        Playlist selectedPlaylist = row.getItem();
			        mainController.sendPlaylistToSongView(selectedPlaylist);
			        mainController.setContent("components/SongView.fxml", "playlist");
			    }
			});
			return row;
		});
	}
	
	public void setAuthUser(User auth) {
		this.authUser = auth;
	}
	
	public void setMainController(MainSceneController mainController) {
		this.mainController = mainController;
	}
	
	public void setPlaylistList(List<Playlist> playlistList) {
		if(playlistList !=null) {
			for(Playlist playlist: playlistList) {
				playlistTable.getItems().setAll(playlist);
			}
		}else {
			System.out.println("Non hai ancora creato nessuna playlist");
		}
	}

	public void setAnchorPane(AnchorPane contentArea) {
		this.anchorPane = contentArea;
		
	}
}