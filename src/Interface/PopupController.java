package Interface;

import javafx.stage.Stage;
import views.MainSceneController;

public interface PopupController {
	void setMainController(MainSceneController mainController);
	void setDialog(Stage dialog);
}
