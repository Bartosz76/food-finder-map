package bm.app.foodfindermap.controller;

import bm.app.foodfindermap.RestGoogleClient;
import bm.app.foodfindermap.model.Geometry;
import bm.app.foodfindermap.model.Location;
import bm.app.foodfindermap.model.Point;
import bm.app.foodfindermap.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MapController {

    private RestGoogleClient restGoogleClient;

    public MapController(RestGoogleClient restGoogleClient) {
        this.restGoogleClient = restGoogleClient;
    }

    @GetMapping
    public String getMap(Model model) throws IOException {
        List<Result> results = restGoogleClient.getVeganPlaces();
        List<Location> locationResults = new ArrayList<>();

        for (int i = 0; i < results.size() ; i++) {
            locationResults.add(results.get(i).getGeometry().getLocation());
        }

        model.addAttribute("points", locationResults);
        return "map";
    }
}
