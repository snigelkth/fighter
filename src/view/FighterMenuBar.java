package view;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import model.WorldModel;
import view.WorldView;
import controller.WorldController;
import model.Player;

public class FighterMenuBar extends MenuBar {
    public FighterMenuBar(Stage stage, boolean showPause) {

        Menu gameMenu = new Menu("Game");

        MenuItem MIPvP = new MenuItem("Start Player vs Player");
        MIPvP.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                WorldModel wModel = new WorldModel(new Player(0, 50, 32, 32), new Player(50, 50, 32, 32));
                WorldView wView = new WorldView(stage, wModel);
                Scene scene = new Scene(wView);
                stage.setScene(scene);
                WorldController worldController = new WorldController(stage, scene, wModel, wView);
            }
        });
        MenuItem MIPvAI = new MenuItem("Start Player vs AI");
        MenuItem MIPause = new MenuItem("Pause");
        MenuItem MIHighscore = new MenuItem("Show highscore");
        MenuItem MIExit = new MenuItem("Exit");
        MIExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.close();
            }
        });

        if (showPause)
            gameMenu.getItems().addAll(MIPvP, MIPvAI, MIPause, MIHighscore, MIExit);
        else
            gameMenu.getItems().addAll(MIPvP, MIPvAI, MIHighscore, MIExit);

        Menu helpMenu = new Menu("Help");
        MenuItem MIHow = new MenuItem("How to play");
        MIHow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage stage = new Stage();
                BorderPane root = new BorderPane();
                String htpText = "How to play:\n\n"
                        + "Player 1 controls: W A S D\n" +
                        "Player 2 controls: Arrow keys\n\n" +
                        "The purpose of the game is to jump onto the head of the opponent.\n" +
                        "The players can jump and attack where attack makes the player dive faster.";
                Label text = new Label(htpText);
                text.setPadding(new Insets(10));
                root.setCenter(text);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });
        helpMenu.getItems().addAll(MIHow);

        getMenus().addAll(gameMenu, helpMenu);
    }
}
