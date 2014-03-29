package seasonality;

import java.time.Month;

/**
 *
 * @author Torri
 */
public class CropsProps {
    public static Month getStartMonth(Crops c){
        switch(c){
            case Asparagus:
                return Month.APRIL;
            case Beans:
                return Month.JULY;
            default:
                return Month.JANUARY;
        }
    }
    public static Month getEndMonth(Crops c){
        switch(c){
            case Asparagus:
                return Month.JUNE;
            case Beans:
                return Month.OCTOBER;
            default:
                return Month.JANUARY;
        }
    }
}
