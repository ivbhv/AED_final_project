package controller.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Helper {
    public ArrayList<String> getCities() {
        ArrayList<String> cities = new ArrayList<>();
        try {
            // create URL for Open Cage Geocode API
            String url = "https://countriesnow.space/api/v0.1/countries/capital";

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            // read response from API
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // parse JSON response
            JSONObject json = new JSONObject(response.toString());
            JSONArray results = json.getJSONArray("data");

            // print list of all country capitals
            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);
                cities.add(result.getString("capital"));
            }
        } catch (IOException | JSONException e) {
        }

        return cities;
    }
    
    public boolean ValidatePhoneNumber(String value) {
        String PATTERN = "^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{4}$";
        return MatchPattern(PATTERN, value);
    }
    
    public boolean ValidatePassword(String value) {
        String PATTERN = "^[a-zA-Z0-9]{5,12}$";
        return MatchPattern(PATTERN, value);
    }
    
    public boolean ValidateUsername(String value) {
        String PATTERN = "^(?=.{3,20}$)(?![.])[a-zA-Z0-9._]+(?<![.])$";
        return MatchPattern(PATTERN, value);
    }
    
    public boolean ValidateEmail(String value) {
        String PATTERN = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)+$";
        return MatchPattern(PATTERN, value);
    }
    
    public boolean ValidateAge(String value) {
        String PATTERN = "^(0?[1-9]|[1-9][0-9]|[1][1-9][1-9]|200)$";
        return MatchPattern(PATTERN, value);
    }
    
    public boolean ValidateName(String value) {
        String PATTERN = "^[A-Za-z]+([\\ A-Za-z]+)*";
        return MatchPattern(PATTERN, value);
    }
    
    public boolean ValidateZip(String value) {
        String PATTERN = "^[0-9]{5,7}$";
        return MatchPattern(PATTERN, value);
    }
    
    public boolean ValidateLevel(String value) {
        String PATTERN = "^[0-9]{1,2}$";
        return MatchPattern(PATTERN, value);
    }
    
    public boolean ValidateInt(String value) {
        String PATTERN = "^[0-9]{1,3}$";
        return MatchPattern(PATTERN, value);
    }
    
    public boolean ValidateFloat(String value) {
        String PATTERN = "[+-]?([0-9]*[.])?[0-9]+";
        return MatchPattern(PATTERN, value);
    }
    
    public boolean ValidateEmpty(String value) {
        return !value.isEmpty();
    }
    
    public boolean ValidateBloodPressure(String value) {
        String PATTERN = "[+-]?((\\d+\\.?\\d*)|(\\.\\d+))";
        return MatchPattern(PATTERN, value);
    }
    
    private boolean MatchPattern(String pattern, String value) {
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(value);
        return match.matches();
    }
    
    public Date getFormattedDate(com.github.lgooddatepicker.components.DatePicker txtDate) {
        Date date;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd");

        try {
            date = formatter.parse(txtDate.getDateStringOrEmptyString());

        } catch (ParseException ex) {
            date = new Date(1970, 01, 01);
        }
        
        return date;
    }
}

