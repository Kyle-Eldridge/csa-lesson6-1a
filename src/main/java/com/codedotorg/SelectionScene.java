package com.codedotorg;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SelectionScene {

    /** The primary stage of the game */
    private Stage window;

    /** The width of the stage */
    private int width;

    /** The height of the stage */
    private int height;

    TextField minTextField;
    TextField maxTextField;
    Button startButton;

    /**
     * Constructor for the GuessingGame class.
     * 
     * @param primaryStage the primary stage of the game
     * @param width the width of the game window
     * @param height the height of the game window
     */
    public SelectionScene(Stage primaryStage, int width, int height) {
        window = primaryStage;
        window.setTitle("Guessing Game");

        this.width = width;
        this.height = height;
    }
    
    /**
     * Starts the guessing game selection scene by creating the main layout, creating
     * the main scene with the layout, setting the scene to the window
     * and showing the window.
     */
    public void start() {
        VBox mainLayout = createLayout();

        Scene mainScene = createMainScene(mainLayout);

        setSceneAndShow(mainScene);
    }

    /**
     * Sets the current scene and shows the window.
     * 
     * @param currentScene the scene to be set and shown
     */
    public void setSceneAndShow(Scene currentScene) {
        window.setScene(currentScene);
        window.show();
    }

    /**
     * Creates the main scene for the guessing game.
     * 
     * @param layout the layout of the scene
     * @return the main scene for the guessing game
     */
    public Scene createMainScene(VBox layout) {
        Scene tempScene = new Scene(layout, width, height);
        return tempScene;
    }

    /**
     * Creates a VBox layout for the guessing game scene.
     * 
     * @return the VBox layout containing the scene labels and buttons
     */
    public VBox createLayout() {
        VBox tempLayout = new VBox();

        tempLayout.getChildren().add(new Label("Enter minimum vallue"));
        tempLayout.getChildren().add(minTextField = new TextField());
        tempLayout.getChildren().add(new Label("Enter maximum vallue"));
        tempLayout.getChildren().add(maxTextField = new TextField());
        tempLayout.getChildren().add(startButton = new Button("Start Game"));
        startButton.onMouseClickedProperty().set(event -> {
            int min = Integer.parseInt(minTextField.getText());
            int max = Integer.parseInt(maxTextField.getText());
            GuessingGame game = new GuessingGame(window, width, height, Math.min(min, max), Math.max(min, max));
            game.startGame();
        });

        return tempLayout;
    }

}
