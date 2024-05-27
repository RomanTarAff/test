package util;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class DateHelper {

    private final DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private final Faker faker = new Faker();

    public String getRandomDateFromInterval(String dateAft, String dateBef) {
        try {
            Date dateAfter = formatter.parse(dateAft);
            Date dateBefore = formatter.parse(dateBef);
            return formatter.format(faker.date().between(dateAfter, dateBefore));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
