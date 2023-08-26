package genericLibraries;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
/**
 * This class contains reusable methods related to java operations
 * @author DELL
 */
public class JavaUtility
{
	/**
	 * This method is used to 
	 * @param limit
	 * @return
	 */
    public int generateRandomNum(int limit)
    {
    	Random random=new Random();
    	return random.nextInt(limit);
    	
    }
    /**
     * This method returns current time
     * @return
     */
    public String getCurrentTime()
    {
    	Date date=new Date();
    	SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
    	return sdf.format(date);
    }
    /**
     * This method is used to convert string type month to integer
     * @param month
     * @return
     */
    public int convertMonthToInt(String month)
    {
    	return DateTimeFormatter
    			.ofPattern("MMMM")
    			.withLocale(Locale.ENGLISH)
    			.parse(month)
    			.get(ChronoField.MONTH_OF_YEAR);
    }
    
}
