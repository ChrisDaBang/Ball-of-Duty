package application.account;

import org.datacontract.schemas._2004._07.Ball_of_Duty_Server_DTO.PlayerDTO;

import application.engine.entities.BoDCharacter;
import application.engine.entities.specializations.Blaster;
import application.engine.entities.specializations.Heavy;
import application.engine.entities.specializations.Roller;
import application.engine.entities.specializations.Specializations;
import application.engine.rendering.TranslatedPoint;
import javafx.scene.image.Image;

/**
 * Keeps information about a player such as nickname, highscore, gold etc.
 * 
 * @author Gruppe6
 *
 */
public class Player
{

    private BoDCharacter _character;
    private String _nickname;
    private double _highscore;
    private int _id;

    /**
     * Creates a player based on a DTO from the serve (Players are always
     * created server side)
     * 
     * @param pdto
     *            The DTO received from the server.
     */
    public Player(PlayerDTO pdto)
    {
        this._id = pdto.getId();
        this._nickname = pdto.getNickname();
    }

    /**
     * Gets the current character the player is controlling.
     * 
     * @return The current character the player is controlling.
     */
    public BoDCharacter getCharacter()
    {
        return _character;
    }

    /**
     * Creates a new character for the player to control.
     */
    public void createNewCharacter(int id, Specializations spec)
    {
        int x = 100 + (int)(Math.random() * 900);
        int y = 100 + (int)(Math.random() * 400);
        Image myCharImage = new Image("images/ball_blue.png");
        switch (spec)
        {
            case BLASTER:
                this._character = new Blaster(id, new TranslatedPoint(x, y), myCharImage);
                break;
            case HEAVY:
                this._character = new Heavy(id, new TranslatedPoint(x, y), myCharImage);
                break;
            case ROLLER:
                this._character = new Roller(id, new TranslatedPoint(x, y), myCharImage);
                break;
            default:
                break;
        } // TODO image would be dynamic if player has different cosmetics
        this._character.setNickname(_nickname);
    }

    /**
     * Gets the identification for the player.
     * 
     * @return The identification for the player.
     */
    public int getId()
    {
        return _id;
    }

    public String getNickname()
    {
        return _nickname;
    }

    public double getHighscore()
    {
        return _highscore;
    }

    public void setHighscore(double highscore)
    {
        _highscore = highscore;
    }

    @Override
    public String toString()
    {
        return "Player [name=" + this._nickname + ", id=" + this._id + ", character=" + this._character + "]";
    }
}
