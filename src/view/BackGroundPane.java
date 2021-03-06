package view;

import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import util.FileIO;

import java.io.IOException;

public class BackGroundPane extends StackPane {
    Menu menu;
    GamePane gamePane;

    public BackGroundPane(){
        super();
        super.setPrefSize(1010,800);
        super.setAlignment(Pos.TOP_LEFT);
        initBackGroundPane();
        super.getChildren().addAll(gamePane.getGamePane(), menu.getMenuArea());
    }

    public Menu getMenu(){
        return this.menu;
    }
    public GamePane getGamePane(){
        return this.gamePane;
    }

    private void initBackGroundPane(){
        gamePane = new GamePane();
        menu = new Menu();
        initWindow();
    }

    private void initWindow(){
        initMenu();
        initGameArea();
    }

    private void initMenu(){
        FXMLLoader menuLoader = new FXMLLoader();
        menuLoader.setLocation(FileIO.getFXML_URL("Menu"));
        menuLoader.setController(menu);
        loadFXML(menuLoader);
        menu.translate(810,0);
    }

    private void initGameArea(){
        FXMLLoader gameAreaLoader = new FXMLLoader();
        gameAreaLoader.setLocation(FileIO.getFXML_URL("GamePane"));
        gameAreaLoader.setController(gamePane);
        loadFXML(gameAreaLoader);
        gamePane.init();
    }

    private void loadFXML(FXMLLoader loader){
        try {
            loader.load();
        }catch (IOException e){
            System.out.println(e);
            e.printStackTrace();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
