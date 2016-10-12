package controller;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.MenuModel;
import model.Player;
import model.WorldModel;
import view.MenuView;
import view.WorldView;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by timothy on 2016-10-11.
 */
public class MenuController {

    private final MenuModel model;
    private final MenuView view;
    private final Stage stage;
    private Scene scene;

    public MenuController(Stage stage, Scene scene,
                          MenuModel model, MenuView view) {

        this.model = model;
        this.view = view;
        this.stage = stage;
        this.scene = scene;
    }

    public void handlePvPEvent() {
        System.out.println("pvp");
        WorldModel wModel = new WorldModel(new Player(0,50), new Player(50,50));
        WorldView wView = new WorldView(stage, wModel);
        scene = new Scene(wView);
        stage.setScene(scene);
        WorldController worldController = new WorldController(stage, scene, wModel, wView);
    }

    public void handleExitEvent() {
        stage.close();
    }
}