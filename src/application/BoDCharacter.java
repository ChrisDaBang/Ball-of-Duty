package application;

public class BoDCharacter extends GameObject
{
    int speed = 200;
    public MousePosition mousePosition;

    public BoDCharacter(int id)
    {
        super(id);
        this.physics = new Physics(this, speed);
        this.body = new Body(this);
        this.view = new View(this);
        this.mousePosition = new MousePosition();
    }

}
