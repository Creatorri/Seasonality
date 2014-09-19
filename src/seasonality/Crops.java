package seasonality;

import assets.LoadArt;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Calendar;

/**
 *
 * @author Torri
 */
public enum Crops {

    Apples(7, 10, Season.DEFAULT,           "harvested in the Lehigh Valley", "from August to November.", "Stored apples are available through March."),
    Peaches(6, 8, Season.DEFAULT,           "harvested in the Lehigh Valley", "from July to September."),
    Grapes(7, 8, Season.DEFAULT,            "harvested in the Lehigh Valley", "in September."),
    Bananas(0, 0, Season.NEVER,             "grown in tropical climates", "and are not grown in the Lehigh Valley."),
    Lemons(0, 0, Season.NEVER,              "grown in subtropical climates", "and are not grown in the Lehigh Valley."),
    Oranges(0, 0, Season.NEVER,             "grown in subtropical climates", "and are not grown in the Lehigh Vally."),
    Cherries(5, 6, Season.DEFAULT,          "harvested in the Lehigh Valley", "from June through July."),
    Plums(6, 8, Season.DEFAULT,             "harvested in the Lehigh Valley", "from July through September."),
    Avocado(0, 0, Season.NEVER,             "grown in subtropical climates", "and are not grown in the Lehigh Valley."),
    Mushrooms(0, 0, Season.TRUE,            "harvested in the Lehigh Valley", "throughout the year."),
    Cantelopes(7, 8, Season.DEFAULT,        "harvested in the Lehigh Valley", "from August through September."),
    Zucchinis(5, 9, Season.DEFAULT,         "harvested in the Lehigh Valley", "from June through October."),
    Sweet_Peppers(7, 9, Season.DEFAULT,     "harvested in the Lehigh Valley", "from August through November."),
    Peas(5, 6, Season.DEFAULT,              "harvested in the Lehigh Valley", "in June."),
    Radishes(5, 11, Season.DEFAULT,         "harvested in the Lehigh Valley", "from May through November.", "Stored radishes are available through April."),
    Carrots(6, 11, Season.DEFAULT,          "harvested in the Lehigh Valley", "from July through November.", "Stored carrots are available through March."),
    Pumpkins(8, 12, Season.DEFAULT,         "harvested in the Lehigh Valley", "from September through November.", "Stored pumpkins are available through mid-February."),
    Sweet_Potatoes(8.5, 11, Season.DEFAULT, "harvested in the Lehigh Valley", "from September through November.", "Stored sweet potatoes are available through March."),
    Tomatoes(5.5, 10, Season.DEFAULT,       "harvested in the Lehigh Valley", "from July through November."),
    Asparagus(3.5, 5.5, Season.DEFAULT,     "harvested in the Lehigh Valley", "from mid-April through mid-June."),
    Lettuce(4, 11, Season.DEFAULT,          "harvested in the Lehigh Valley", "from May through November."),
    Garlic(5, 7, Season.DEFAULT,            "harvested in the Lehigh Valley", "from July through August.", "Stored garlic is available through April."),
    Watermelons(7, 8, Season.DEFAULT,       "harvested in the Lehigh Valley", "from August through September."),
    Onions(4, 7, Season.DEFAULT,            "harvested in the Lehigh Valley", "from May through August.", "Stored onions are available through March."),
    Strawberries(3.5, 6, Season.DEFAULT,    "harvested in the Lehigh Valley", "in June."),
    Eggplant(6, 9, Season.DEFAULT,          "harvested in the Lehigh Valley", "from July through mid-October."),
    Corn(6, 9.5, Season.DEFAULT,            "harvested in the Lehigh Valley", "from July through mid-October."),
    Swiss_Chard(4, 10, Season.DEFAULT,      "harvested in the Lehigh Valley", "from May through November."),
    Pineapples(0, 0, Season.NEVER,          "grown in tropical climates", "and are not grown in the Lehigh Valley."),
    Blueberries(5, 7.5, Season.DEFAULT,     "harvested in the Lehigh Valley", "from June through mid-August."),
    Raspberries(5, 10, Season.DEFAULT,      "harvested in the Lehigh Valley", "from June through October.");

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
    
    public static Crops[] editableCrops(){
        int j = 0;
        for (Crops value : Crops.values()) {
            if (value.forceSeason != Season.NEVER) {
                j++;
            }
        }
        Crops[] edit = new Crops[j];
        j = 0;
        for (Crops value : Crops.values()) {
            if (value.forceSeason != Season.NEVER) {
                edit[j] = value;
                j++;
            }
        }
        System.out.println("DONE");
        return edit;
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

    public static int maxScore(){
        int score = 0;
        for (Crops value : values()) {
            if (value.forceSeason == 2) {
                score++;
            } else if (value.forceSeason == 3) {
//                score = score - 2;
            } else if (value.inSeason((double) Calendar.getInstance().get(Calendar.MONTH)) && value.forceSeason != 1) {
                score++;
            } else {
//                score--;
            }
        }
        return score;
    }
}
