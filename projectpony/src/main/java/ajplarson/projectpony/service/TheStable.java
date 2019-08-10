/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.projectpony.service;

import ajplarson.projectpony.dao.ColorDao;
import ajplarson.projectpony.dao.PonyDao;
import ajplarson.projectpony.models.Color;
import ajplarson.projectpony.models.Pony;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.stereotype.Service;

/**
 *
 * @author ajplarson
 */
@Service
public class TheStable {

    private ColorDao cDao;
    private PonyDao pDao;
    
    public TheStable(ColorDao cDao, PonyDao pDao) {
        this.cDao = cDao;
        this.pDao = pDao;
    }
    
    public List<Pony> allPonies() {
        return pDao.getAllPonies();
    }
    
    public List<Color> allColors() {
        return cDao.getAllColors();
    }

    public Color findColorById(int id) {
        return cDao.getColorById(id);
    }

    public Pony findPonyById(int id) {
        return pDao.getPonyById(id);
    }
    
    public Pony findPonyByName(String name) {
        return pDao.getPonyByName(name);
    }
    
    public void updatePony(Pony pony) {
        pDao.updatePony(pony);
    }
    
    public void destroyPony(int id) {
        pDao.deletePonyById(id);
    }
    
    public Pony addPony(Pony p) {

        Validator validator = Validation.buildDefaultValidatorFactory()
                .getValidator();

        Set<ConstraintViolation<Pony>> violations = validator.validate(p);
        if (violations.size() > 0) {
            throw new RuntimeException("INVALID DATA.");
        }

        return pDao.addPony(p);
    }

   
    
    
    
    
    
}
