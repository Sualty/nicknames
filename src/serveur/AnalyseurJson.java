package serveur;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by user on 09/11/15.
 */
public class AnalyseurJson extends Analyseur {
    private JSONObject requete ;

    public void analyser(String requete ){
        try {
            // ici il faut faire en sorte qu'on escape le string
            this.requete = new JSONObject(requete);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getRequete(){
        return requete;
    }
}
