package views.components;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import model.Song;
import service.SongService;
import views.MainSceneController;

public class SongViewController {
	
	@FXML
	private TableView<Song> songTable;
	@FXML
	private TableColumn<Song, String> songTitle;
	@FXML
	private TableColumn<Song, String> songAuthor;
	@FXML
	private TableColumn<Song, String> songDuration;
	
	@FXML
	private HBox songView;
	
	private SongService songService;
	private MainSceneController mainController;
	private String origin;
	
	public void setMainController(MainSceneController mainController) {
		this.mainController = mainController;
		songService = mainController.getSongService();
		if(origin == "navbar") {
			songService.showAllSongs(null);
			songTable.setItems(songService.getAllSongs());
		}else if(origin == "playlist"){
			songService.showAllSongs(mainController.getPlaylistFromViewData());
			songTable.setItems(songService.getAllSongs());	
		}
	}
	
	@FXML
	public void initialize() {
		songTitle.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitle()));
		songAuthor.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAuthor().getName()));
		songDuration.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getDuration())));
		
		songTable.setRowFactory(tv ->{
			TableRow<Song> row = new TableRow<Song>();
			row.setOnMouseClicked(event -> {
				if(!row.isEmpty() && event.getClickCount() == 2) {
					Song selectedSong = row.getItem();
					mainController.setFooterTitle(selectedSong.getTitle());
					mainController.setFooterDuration(selectedSong.getDuration());
					mainController.setFooterAuthor(selectedSong.getAuthor().getName());
					mainController.setStartDurationAndProgressBar();
				}
			});
			return row;
		});
	}

	public void setOrigin(String origin) {
		this.origin = origin;
		
	}
	
	
	
}
