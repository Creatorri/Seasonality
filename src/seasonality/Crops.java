package seasonality;

import assets.LoadArt;
import java.awt.image.BufferedImage;

/**
 *
 * @author Torri
 */
public enum Crops {

    Asparagus(3.5, 5.5, "Stuff"),
    Green_Beans(6, 9, "Beans are beans because beans.", "In season from July to October"),
    Beets(5, 11, "Stuff"),
    Spring_Broccoli(5.5, 6.5, "Stuff"),
    Fall_Broccoli(8, 11, "Stuff"),
    Carrots(6, 11, "Stuff"),
    Corn(6, 9.5, "Stuff"),
    Cucumber(6, 8.5, "Stuff"),
    Lettuce(4, 11, "Stuff"),
    Mushrooms(0, 0, "Stuff"),
    Peas(5, 6, "Stuff"),
    Sweet_Peppers(7, 11, "Stuff"),
    Potatoes(6, 12, "Stuff"),
    Pumpkins(8, 12, "Stuff"),
    Radishes(5, 11, "Stuff"),
    Rhubarb(3.5, 6, "Stuff"),
    Sweet_Potatoes(8.5, 12, "Stuff"),
    Tomatoes(5.5, 10, "Stuff"),
    Apples(7, 11, "Draggy Drag the blue green dragon"),
    Blackberries(5, 7, "Stuff"),
    Blueberries(5, 7.5, "Stuff"),
    Peaches(6, 9, "Stuff"),
    Pears(7, 9, "Stuff"),
    Raspberries(5, 10, "Stuff"),
    Strawberries(3.5, 6, "Stuff");
    //month 0 is jan
    private final double START;
    private final double END;
    private final String[] DESCRIPTION;
    public int forceSeason = 0;//0 is use actual data, 1 is force false, 2 is force true
    public final BufferedImage image;
    private final LoadArt la = new LoadArt();

    private Crops(final double startMonth, final double endMonth, final String... data) {
        START = startMonth;
        END = endMonth;
        DESCRIPTION = data;
        if (START == END) {
            forceSeason = 2;
        }
        if (la.createBufferedImage(this.toString().toLowerCase() + ".png") == null) {
            image = la.createBufferedImage("default.png");
        } else {
            image = la.createBufferedImage(this.toString().toLowerCase() + ".png");
        }
    }

    public void forceSeason(boolean inseason) {
        forceSeason = inseason ? 2 : 1;
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

}
