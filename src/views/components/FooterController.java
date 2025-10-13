package views.components;



import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;
import views.MainSceneController;

public class FooterController {

	@FXML
	private Label songTitleFooterLable, durationEndLabel, songAuthorFooterLable, durationStartLabel;
	
	@FXML
	private Button footerPlayBtn;
	
	@FXML
	private ProgressBar footerProgressBar;
	
	private Timeline songDuration = new Timeline();
	private MainSceneController mainController;
	private int time = 0;
	private boolean isPlaying = false; 
	private double progressbar;
	public void setMainController(MainSceneController controller) {
		this.mainController = controller;
	}
	
	public void setTitle(String songTitle) {
		this.songTitleFooterLable.setText(songTitle);
	}
	
	public void setAuthor(String songAuthor) {
		this.songAuthorFooterLable.setText(songAuthor);
	}
	
	
	public void setEndDuration(int songDuration) {
		this.durationEndLabel.setText(String.valueOf(songDuration));
	}
	
	public void setIsPlaying(boolean check) {
		this.isPlaying = check;
	}
	
	public boolean getIsPlaying() {
		return this.isPlaying;
	}
	
	private void changeTime() {
		this.time++;
	}
	
	private void resetTime() {
		this.time = 0;
	}
		
	public void playSong() {
		if(!getIsPlaying()) {
			this.setIsPlaying(true);
			footerPlayBtn.setText("||");
			this.songDuration = new Timeline(
				    new KeyFrame(Duration.seconds(1), e -> {
				    	this.changeTime();
				        this.durationStartLabel.setText(String.valueOf(this.time));
				        progressbar = (double)this.time/Integer.parseInt(this.durationEndLabel.getText());
				        this.footerProgressBar.setProgress(progressbar);
				    })
				);
			songDuration.setCycleCount(Integer.parseInt(this.durationEndLabel.getText()));
			songDuration.play();
		}else {
			this.footerPlayBtn.setText(">");
			this.setIsPlaying(false);
			songDuration.pause();
		}
	}
	public void songPrev() {
		System.out.println("Canzone precedente");
	}
	public void songNext() {
		System.out.println("Canzone Successiva");
	}

	public void resetStartDurationAndProgressBar() {
		resetTime();
		this.setIsPlaying(false);
		songDuration.stop();
		footerProgressBar.setProgress(0);
		durationStartLabel.setText("0");
		footerPlayBtn.setText(">");
	}
}
