import java.awt.*;
import java.util.*;

enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem
{
    private final int [] POINT_VAL = {0,5,10,15,20,25,30,35,40,45,50};
    private int points;
    private String fileName;
    private GemType type;
    public Gem()
    {
        int index =  (int) (3*Math.random()+1);
        if (index == 1)
        {
            type = GemType.GREEN;
            fileName = "gem_green.png";
        }
        else if (index ==2)
        {
            type = GemType.BLUE;
            fileName = "gem_blue.png";
        }
        else
        {
            type = GemType.ORANGE;
            fileName = "gem_orange.png";
        }

        points = POINT_VAL [(int) (10*(Math.random()) + 1)];
    }
    public Gem (GemType type, int points)
    {
        this.type = type;
        this.points = points;
        if (type == GemType.GREEN)
        {
            fileName = "gem_green.png";
        }
        else if (type == GemType.BLUE)
        {
            fileName = "gem_blue.png";
        }
        else
        {
            fileName = "gem_orange.png";
        }
    }
    public String toString ()
    {
        return type + " " + points;
    }
    public GemType getType()
    {
        return type;
    }
    public int getPoints()
    {
        return points;
    }
    public void draw (double x, double y)
    {
        StdDraw.picture(x,y,this.fileName);
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.setFont (new Font ("SansSerif", Font.BOLD, 14));
        StdDraw.text (x,y,points+"") ;
    }
    /** Tester main method */
    public static void main(String [] args)
    {
        final int maxGems = 16;

        //Create a gem of each type
        Gem green  = new Gem(GemType.GREEN, 10);
        Gem blue   = new Gem(GemType.BLUE, 20);
        Gem orange = new Gem(GemType.ORANGE, 30);
        System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());
        System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
        System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
        green.draw(0.3, 0.7);
        blue.draw(0.5, 0.7);
        orange.draw(0.7, 0.7);

        // A row of random gems
        for (int i = 0; i < maxGems; i++)
        {
            Gem g = new Gem();
            g.draw(1.0 / maxGems * (i + 0.5), 0.5);
        }
    }
}