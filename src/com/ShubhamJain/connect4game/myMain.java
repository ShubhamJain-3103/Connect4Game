package com.ShubhamJain.connect4game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class myMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception { super.init(); }

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("game has started...");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();
        controller = loader.getController();
        controller.createPlayground(); //create the playground in the game

        MenuBar menuBar = createMenu();

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);

        menuPane.getChildren().add(menuBar);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty()); //to make its width equal to the width of our scene

        Scene scene = new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect4");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private MenuBar createMenu() {
        //file menu
        Menu fileMenu = new Menu("File");

        MenuItem newGame = new MenuItem("New Game");
        MenuItem resetGame = new MenuItem("Reset Game");
        SeparatorMenuItem fileMenuSeparator = new SeparatorMenuItem();
        MenuItem exitGame = new MenuItem("Exit Game");

        fileMenu.getItems().addAll(newGame,resetGame,fileMenuSeparator,exitGame);

        //about Menu
        Menu helpMenu = new Menu("Help");

        MenuItem aboutConnect4Game = new MenuItem("About Connect4");
        MenuItem aboutMe = new MenuItem("About Me");
        SeparatorMenuItem helpMenuSeparator = new SeparatorMenuItem();

        helpMenu.getItems().addAll(aboutConnect4Game,helpMenuSeparator,aboutMe);

        //MenuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        newGame.setOnAction(event -> controller.resetGame() );
        resetGame.setOnAction(event -> controller.resetGame() );
        exitGame.setOnAction(event -> exitTheGame() );

        aboutConnect4Game.setOnAction(event -> aboutGame() );
        aboutMe.setOnAction(event -> aboutDev() );

        return menuBar;
    }

    private void exitTheGame() {
        System.out.println("Closing the game...");
        Platform.exit();
        System.exit(0);
    }

    private void aboutGame(){
        Alert aboutGameAlert = new Alert(Alert.AlertType.INFORMATION);
        aboutGameAlert.setTitle("About Connect 4 Game");
        aboutGameAlert.setHeaderText("How To Play?");
        aboutGameAlert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");
        aboutGameAlert.show();
    }

    private  void aboutDev() {
        Alert aboutDevAlert = new Alert(Alert.AlertType.INFORMATION);
        aboutDevAlert.setTitle("About Developer");
        aboutDevAlert.setHeaderText("Shubham Jain");
        aboutDevAlert.setContentText("Hi, I am a Java Game Developer and I built this game on JavaFx.");
        aboutDevAlert.show();
    }

    @Override
    public void stop() throws Exception { super.stop(); }

    //here ends the myMain class
}