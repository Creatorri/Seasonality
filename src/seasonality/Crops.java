
package seasonality;

import java.time.Month;

/**
 *
 * @author Torri
 */
public enum Crops {
    Asparagus(3.5,5.5),
    Beans(6,10),
    Beets(5,11),
    Broccoli(0,10),
    Carrots(0,10),
    Corn(0,10),
    Cucumber(0,10),
    Lettuce(0,10),
    Mushrooms(0,10),
    Peas(0,10),
    SweetPeppers(0,10),
    Potatoes(0,10),
    Pumpkins(0,10),
    Radishes(0,10),
    Rhubarb(0,10),
    Tomatoes(0,10),
    Apples(0,10),
    Blackberries(0,10),
    Blueberries(0,10),
    Peaches(0,10),
    Pears(0,10),
    Raspberries(0,10),
    Strawberries(0,10);
    //month 0 is jan
    private final double start;
    private final double end;
    public int forceSeason = 0;//0 is use whatever is true, 1 is force false, 2 is force true
    private Crops(final double startMonth,final double endMonth){
        start = startMonth;
        end = endMonth;
    }
    /**
     * gets starting month (in dec format)
     * @return 
     */
    public double getStartMonth(){
        return start;
    }
    /**
     * gets end month (END OF MONTH GROWN NOT MONTH GROWN IN)
     * @return 
     */
    public double getEndMonth(){
        return end;
    }
    public boolean inSeason(Month m){
        int mon = m.getValue()-1;
        return forceSeason==0 ? (mon>=start && mon<end) : (forceSeason != 1);
    }
    /**
     * Month 0 is Jan, Month 11 is Dec
     * @param m
     * @return 
     */
    public boolean inSeason(double m){
        return forceSeason==0 ? (m>=start && m<end) : (forceSeason != 1);
    }
}
