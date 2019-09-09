/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.rogue.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ajplarson
 */
public class Map {
    private List<List<Square>> mapvalues = new ArrayList<>();

    public void setMapvalues(List<List<Square>> mapvalues) {
        this.mapvalues = mapvalues;
    }

    public List<List<Square>> getMapvalues() {
        return mapvalues;
    }
    
    
}
