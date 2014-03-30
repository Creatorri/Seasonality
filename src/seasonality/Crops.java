
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
    Spring_Broccoli(5.5,6.5),
    Fall_Broccoli(8,11),
    Carrots(6,11),
    Corn(6,9.5),
    Cucumber(6,8.5),
    Lettuce(4,11),
    Mushrooms(0,0),
    Peas(5,6),
    Sweet_Peppers(7,11),
    Potatoes(6,12),
    Pumpkins(8,12),
    Radishes(5,11),
    Rhubarb(3.5,6),
    Sweet_Poatoes(8.5,12),
    Tomatoes(5.5,10),
    Apples(7,11),
    Blackberries(5,7),
    Blueberries(5,7.5),
    Peaches(6,9),
    Pears(7,9),
    Raspberries(5,10),
    Strawberries(3.5,6);
    //month 0 is jan
    private final double start;
    private final double end;
    public int forceSeason = 0;//0 is use whatever is true, 1 is force false, 2 is force true
    private Crops(final double startMonth,final double endMonth){
        start = startMonth;
        end = endMonth;
        if(start==end) forceSeason = 2;
    }
    public void forceSeason(boolean inseason){
        forceSeason = inseason ? 2 : 1;
    }
    /**
     * gets starting month (in decimal format)
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
        return forceSeason==0 ? (m>=start && m<=end) : (forceSeason != 1);
    }
    public String toString(){
        String[] s = super.toString().split("_");
        if(s.length==1) return super.toString();
        String out = "";
        for (String item : s) {
            out += item + " ";
        }
        return out;
    }
}
