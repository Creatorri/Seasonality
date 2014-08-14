package seasonality;

import assets.LoadArt;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Torri
 */
public enum Crops {

    Apples(7, 10, Season.DEFAULT, "Draggy Drag the blue green dragon"),
    Peaches(6, 8, Season.DEFAULT, "Stuff"),
    Grapes(7, 8, Season.DEFAULT, "Stuff"),
    Bananas(0, 0, Season.NEVER, "STUFF"),
    Lemons(0, 0, Season.NEVER, "STUFF"),
    Oranges(0, 0, Season.NEVER, "STUFF"),
    Cherries(5, 6, Season.DEFAULT, "STUFF"),
    Plums(6, 8, Season.DEFAULT, "STUFF"),
    Avocado(0, 0, Season.NEVER, "STUFF"),//Add this next
    Mushrooms(0, 0, Season.TRUE, "Stuff"),
    Cantelopes(7, 8, Season.DEFAULT, "STUFF"),
    Zucchinis(5, 9, Season.DEFAULT, "STUFF"),
    Sweet_Peppers(7, 9, Season.DEFAULT, "Stuff"),
    Peas(5, 6, Season.DEFAULT, "Stuff"),
    Radishes(5, 11, Season.DEFAULT, "Stuff"),
    Carrots(6, 11, Season.DEFAULT, "Stuff"),
    Pumpkins(8, 12, Season.DEFAULT, "Stuff"),
    Sweet_Potatoes(8.5, 11, Season.DEFAULT, "Stuff"),
    Tomatoes(5.5, 10, Season.DEFAULT, "Stuff"),
    Asparagus(3.5, 5.5, Season.DEFAULT, "Stuff"),
    Lettuce(4, 11, Season.DEFAULT, "Stuff"),
    Garlic(5, 7, Season.DEFAULT, "STUFF"),//Storage?
    Watermelons(7, 8, Season.DEFAULT, "STUFF"),
    Onions(4, 7, Season.DEFAULT, "STUFF"),//Storage?
    Strawberries(3.5, 6, Season.DEFAULT, "Stuff"),
    Eggplant(6, 9, Season.DEFAULT, "STUFF"),
    Corn(6, 9.5, Season.DEFAULT, "Stuff"),
    Swiss_Chard(4, 10, Season.DEFAULT, "STUFF"),
    Pineapples(0, 0, Season.NEVER, "STUFF"),
    Blueberries(5, 7.5, Season.DEFAULT, "Stuff"),
    Raspberries(5, 10, Season.DEFAULT, "Stuff");

    //month 0 is jan
    private final double START;
    private final double END;
    private final String[] DESCRIPTION;
    public int forceSeason;//0 is use actual data, 1 is force false, 2 is force true, 3 is not grown in PA
    public BufferedImage image;
    private final LoadArt la = new LoadArt();

    private Crops(final double startMonth, final double endMonth, int force, final String... data) {
        START = startMonth;
        END = endMonth;
        DESCRIPTION = data;
        forceSeason = force;
        if (START == END && force == Season.DEFAULT) {
            forceSeason = Season.TRUE;
        }
        if (la.createBufferedImage(this.toString().toLowerCase() + ".png") == null) {
            image = la.createBufferedImage("default.png");
        } else {
            image = la.createBufferedImage(this.toString().toLowerCase() + ".png");
        }
    }

    public void forceSeason(boolean inseason) {
        forceSeason = inseason ? Season.TRUE : Season.FALSE;
    }

    /**
     * gets starting month (in decimal format)
     *
     * @return
     */
    public double getStartMonth() {
        return START;
    }

    /**
     * gets end month (END OF MONTH GROWN NOT MONTH GROWN IN)
     *
     * @return
     */
    public double getEndMonth() {
        return END;
    }

    /**
     * Month 0 is Jan, Month 11 is Dec
     *
     * @param m
     * @return
     */
    public boolean inSeason(double m) {
        return forceSeason == 0 ? (m >= START && m <= END) : (forceSeason != 1);
    }

    /**
     * Data
     *
     * @return
     */
    public String[] getDescription() {
        return DESCRIPTION;
    }

    /**
     * Gets String format of type
     *
     * @return
     */
    public String toString() {
        String[] s = super.toString().split("_");
        if (s.length <= 1) {
            return super.toString();
        }
        String out = "";
        for (int i = 0; i < s.length; i++) {
            out += i == s.length - 1 ? s[i] : s[i] + " ";
        }
        return out;
    }

    public static String stringToInternalName(String value) {
        String[] s = value.split(" ");
        if (s.length <= 1) {
            return value;
        }
        String out = "";
        for (int i = 0; i < s.length; i++) {
            out += i == s.length - 1 ? s[i] : s[i] + "_";
        }
        return out;
    }

    private class Season {
        public final static int DEFAULT = 0, FALSE = 1, TRUE = 2, NEVER = 3;
    }

    public void resizeImage(int sx, int sy) {
        BufferedImage temp = image;
        BufferedImage out = new BufferedImage(sx, sy, BufferedImage.TYPE_INT_ARGB);
        out.createGraphics().drawImage(temp.getScaledInstance(sx, sy, Image.SCALE_SMOOTH), 0, 0, null);
        out.createGraphics().dispose();
        image = out;
    }

}
