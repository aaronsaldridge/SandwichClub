package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            // parse JSON
            JSONObject sandwichInfo = new JSONObject(json);
            JSONObject name = sandwichInfo.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAsArray = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            String placeOfOrigin = sandwichInfo.getString("placeOfOrigin");
            String description = sandwichInfo.getString("description");
            String image = sandwichInfo.getString("image");
            JSONArray ingredientsArray = sandwichInfo.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();

            //read in arrays
            for (int aka = 0; aka < alsoKnownAsArray.length(); aka++) {
                alsoKnownAs.add(alsoKnownAsArray.getString(aka));
            }

            for (int ing = 0; ing < ingredientsArray.length(); ing++) {
                ingredients.add(ingredientsArray.getString(ing));
            }

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        }

        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
