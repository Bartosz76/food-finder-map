package bm.app.foodfindermap;

import bm.app.foodfindermap.model.Result;
import bm.app.foodfindermap.model.VeganPlaces;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestGoogleClient {

    public List<Result> getVeganPlaces() throws IOException {
        List<Result> myList = new ArrayList<>();
        URL url = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=52.2297,21.0122&radius=500&types=food&name=vegan&key=AIzaSyCKfe-nuhQl-PiA1lMK2SIce8CbllPoaEE");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        VeganPlaces veganPlaces = new Gson().fromJson(reader, VeganPlaces.class);
        for (Result result : veganPlaces.getResults()) {
            myList.add(result);
        }
        return myList;
    }
}
