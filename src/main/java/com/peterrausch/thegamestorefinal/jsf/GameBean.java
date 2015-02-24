package com.peterrausch.thegamestorefinal.jsf;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import com.peterrausch.thegamestorefinal.model.Game;
import com.peterrausch.thegamestorefinal.service.GameFacade;
import javax.enterprise.context.SessionScoped;

@Named("gameb")
@SessionScoped
public class GameBean implements Serializable{
    private List<Game> allGames;
    private List<Game> customGames;
    
    private Game selectedGame;
    private boolean gameFound = false;
    private String possibleError = "";
    
    private int gameID;
    private String gameImg;
    private String gameName;
    private String gameDesc;
    private Double gamePrice;
    
    private String ERR_NULL_GAME = "A game you tried to pass was null";
    
    @Inject
    private GameFacade gameDAO;

    @PostConstruct
    public void preloadList() {
        allGames = gameDAO.findAll();
    }
    
    public String reloadList() {
        preloadList();
        
        return null;
    }
    
    public List<Game> getGamesInCat(String category) {
        
        return customGames;
    }
    
    public List<Game> getAllGames() {
        return allGames;
    }
    
    public Game getGameFromID(int id) {
        Game game = null;
        for(Game g : allGames) {
            if(g.getGameid() == id) {
                game = g;
            }
        }
        
        return game;
    }

    public void setAllGames(List<Game> games) {
        this.allGames = games;
    }
    
    public String goNew() {
        
        return "newgame";
    }
    
    public String createGame() {
        Game newGame = new Game();
        newGame.setName(gameName);
        newGame.setDescription(gameDesc);
        newGame.setImgpath(gameImg);
        newGame.setPrice(gamePrice);
        newGame.setCategory("0");
        
        gameDAO.create(newGame);
        
        reloadList();
        
        return "editgames";
    }
    
    public String modifyGame(int g) {
        for(Game game : allGames) {
            if(game.getGameid() == g) {
                selectedGame = game;
            }
        }
        
        gameID = selectedGame.getGameid();
        gameImg = selectedGame.getImgpath();
        gameName = selectedGame.getName();
        gameDesc = selectedGame.getDescription();
        gamePrice = selectedGame.getPrice();
        
        return "modifygame";
    }
    
    public String preformUpdate() {
        selectedGame.setName(gameName);
        selectedGame.setImgpath(gameImg);
        selectedGame.setDescription(gameDesc);
        selectedGame.setPrice(gamePrice);
        
        gameDAO.edit(selectedGame);
        
        return "editgames";
    }
    
    public String preformDeletionOfGame(int g) {
        for(Game game : allGames) {
            if(game.getGameid() == g) {
                selectedGame = game;
            }
        }
        
        gameID = selectedGame.getGameid();
        gameImg = selectedGame.getImgpath();
        gameName = selectedGame.getName();
        gameDesc = selectedGame.getDescription();
        gamePrice = selectedGame.getPrice();
        
        gameDAO.remove(selectedGame);
        
        reloadList();
        
        return "editgames";
    }
    
    public String viewDetail(int g) {
        if(g > 0) {
            // LOOP THROUGH ALL GAMES SEE IF THE ID EXISTS
            for(Game game : allGames) {
                if(game.getGameid() == g) {
                    selectedGame = game;
                    gameFound = true;
                }
            }
            
            // IF ITS NOT FOUND, REDIRECTS BACK TO INDEX.HTML
            if(!gameFound) {
               return "index.xhtml"; 
            }
        } else {
            throw new IllegalArgumentException(ERR_NULL_GAME);
        }
        
        return "viewgame.xhtml";
    }
    
    public int getSelectedGameID() {
        return selectedGame.getGameid();
    }

    public List<Game> getCustomGames() {
        return customGames;
    }

    public void setCustomGames(List<Game> customGames) {
        this.customGames = customGames;
    }

    public Game getSelectedGame() {
        return selectedGame;
    }

    public void setSelectedGame(Game selectedGame) {
        this.selectedGame = selectedGame;
    }

    public GameFacade getGameDAO() {
        return gameDAO;
    }

    public void setGameDAO(GameFacade gameDAO) {
        this.gameDAO = gameDAO;
    }

    public String getPossibleError() {
        return possibleError;
    }

    public boolean isGameFound() {
        return gameFound;
    }

    public void setGameFound(boolean gameFound) {
        this.gameFound = gameFound;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getGameImg() {
        return gameImg;
    }

    public void setGameImg(String gameImg) {
        this.gameImg = gameImg;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameDesc() {
        return gameDesc;
    }

    public void setGameDesc(String gameDesc) {
        this.gameDesc = gameDesc;
    }

    public Double getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(Double gamePrice) {
        this.gamePrice = gamePrice;
    }
    
    

    public void setPossibleError(String possibleError) {
        this.possibleError = possibleError;
    }
    
    
    
}
