package surnom;

import exceptions.AddNameExistingNameException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 09/11/15.
 */
public class Surnoms {
    private HashMap<String,ArrayList<String>> surnoms = new HashMap<>();

    public void addNameAndNicknames(String name , ArrayList<String> nicknames) throws AddNameExistingNameException {
        if(surnoms.containsKey(name)) throw new AddNameExistingNameException();
        surnoms.put(name,nicknames);
    }

    public void displayAll(){
        // boucle for;
    }
}
