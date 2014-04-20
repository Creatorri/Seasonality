package seasonality;

import java.time.Month;

/**
 *
 * @author Torri
 */
public enum Crops {

    Asparagus(3.5, 5.5, null),
    Beans(6, 10, null),
    Beets(5, 11, null),
    Spring_Broccoli(5.5, 6.5, null),
    Fall_Broccoli(8, 11, null),
    Carrots(6, 11, null),
    Corn(6, 9.5, null),
    Cucumber(6, 8.5, null),
    Lettuce(4, 11, null),
    Mushrooms(0, 0, null),
    Peas(5, 6, null),
    Sweet_Peppers(7, 11, null),
    Potatoes(6, 12, null),
    Pumpkins(8, 12, null),
    Radishes(5, 11, null),
    Rhubarb(3.5, 6, null),
    Sweet_Poatoes(8.5, 12, null),
    Tomatoes(5.5, 10, null),
    Apples(7, 11, null),
    Blackberries(5, 7, null),
    Blueberries(5, 7.5, null),
    Peaches(6, 9, null),
    Pears(7, 9, null),
    Raspberries(5, 10, null),
    Strawberries(3.5, 6, null);
    //month 0 is jan
    private final double START;
    private final double END;
    private final String[] DESCRIPTION;
    public int forceSeason = 0;//0 is use actual data, 1 is force false, 2 is force true

    private Crops(final double startMonth, final double endMonth, final String[] data) {
        START = startMonth;
        END = endMonth;
        DESCRIPTION = data;
        if (START == END) {
            forceSeason = 2;
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

    public boolean inSeason(Month m) {
        int mon = m.getValue() - 1;
        return forceSeason == 0 ? (mon >= START && mon < END) : (forceSeason != 1);
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
     * Gets String format of value
     *
     * @return
     */
    public String toString() {
        String[] s = super.toString().split("_");
        if (s.length == 1) {
            return super.toString();
        }
        String out = "";
        for (String item : s) {
            out += item + " ";
        }
        return out;
    }
}
