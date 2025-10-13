package views;


import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import model.Playlist;
import model.Song;
import model.User;
import service.PlaylistService;
import service.SongService;
import service.UserService;
import utils.FileReader;
import views.components.FooterController;
import views.components.NavbarController;
import views.components.PlaylistViewController;
import views.components.SongViewController;
import views.components.UserHomepageViewController;

public class MainSceneController {

	
	private UserService userList;
	private SongService songList;
	private PlaylistService playlistList;
	private User authUser;
	@FXML
	private AnchorPane contentArea;
	
	@FXML
	private NavbarController navbarController;
	
	@FXML
	private FooterController footerController;
	
	
	public PlaylistService getPlaylistService() {
		return this.playlistList;
	}
	
	public User getAuthUser() {
		return this.authUser;
	}
	
	@FXML
	private void initialize() {
		navbarController.setMainController(this);
		footerController.setMainController(this);
	}
	
	public void setAuthUser(User auth) {
		this.authUser  = auth;
	}
	public void authUserName(User auth) {
		navbarController.setLabelName(authUser);
	}
	public SongService getSongService() {
		return this.songList;
	}
	public void setSongList(SongService songList) {
		this.songList = songList;
	}
	public void setPlaylistList(PlaylistService playlistList) {
		this.playlistList = playlistList;
	}
	
	public void setContent(String path, String origin) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/" + path));
			Node node = loader.load();
			
			this.setControllerAndId(loader, node, path, origin);
			if(contentArea.getChildren().size() > 0) {
				contentArea.getChildren().clear();				
			}
			
			contentArea.getChildren().add(node);		
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	private void setControllerAndId(FXMLLoader loader,Node node, String path, String origin) {
		System.out.println(origin);
		switch(path) {
		case "components/UserHomepageView.fxml":
			UserHomepageViewController userHomepageViewController = loader.getController();
			userHomepageViewController.setMainController(this);
			node.setId("songView");
			break;
		case "components/SongView.fxml":
			SongViewController songController = loader.getController();
			songController.setOrigin(origin);
			songController.setMainController(this);
			node.setId("songView");
			break;
		case "components/PlaylistView.fxml":
			PlaylistViewController playlistController = loader.getController();
			playlistController.setMainController(this);
			playlistController.setAuthUser(authUser);
			playlistController.setPlaylistList(authUser.getUserPlaylists());
			playlistController.setAnchorPane(contentArea);
			node.setId("playlistView");
			
			break;
		}
	}

	//footer settings
	public void setFooterDuration(Integer duration) {
		footerController.setEndDuration(duration);
	}
	public void setFooterTitle(String text) {
		footerController.setTitle(text);
	}
	
	public void setFooterAuthor(String text) {
		footerController.setAuthor(text);
	}

	public void setStartDurationAndProgressBar() {
		footerController.resetStartDurationAndProgressBar();
	}

	private Playlist playlistFromView;
	public void sendPlaylistToSongView(Playlist selectedPlaylist) {
		this.playlistFromView = selectedPlaylist;
	}
	
	public List<Song> getPlaylistFromViewData(){
		return playlistFromView.getPlaylistSongs();
	}

	
	
}
