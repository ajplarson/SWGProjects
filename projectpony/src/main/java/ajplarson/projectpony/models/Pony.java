/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.projectpony.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author ajplarson
 */
public class Pony {
    
    private int ponyId;
    
    @NotBlank(message = "Name must not be blank")
    @Size(max = 50, message = "Name must be fewer than 50 characters")
    private String ponyName;
    
    private int foreignColorId;

    public Pony() {
    }

    public int getPonyId() {
        return ponyId;
    }

    public void setPonyId(int ponyId) {
        this.ponyId = ponyId;
    }

    public String getPonyName() {
        return ponyName;
    }

    public void setPonyName(String ponyName) {
        this.ponyName = ponyName;
    }

    public int getForeignColorId() {
        return foreignColorId;
    }

    public void setForeignColorId(int foreignColorId) {
        this.foreignColorId = foreignColorId;
    }
    
}
