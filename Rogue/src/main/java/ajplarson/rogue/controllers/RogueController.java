package ajplarson.rogue.controllers;

import ajplarson.rogue.data.RogueDao;
import ajplarson.rogue.models.Entity;
import ajplarson.rogue.models.Square;
import ajplarson.rogue.servicio.RogueService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rogue")
public class RogueController {

    private final RogueDao dao;
    private final RogueService service;

    public RogueController(RogueDao dao, RogueService service) {
        this.dao = dao;
        this.service = service;
    }

    @GetMapping
    public List<Square> displayDungeon() {
        return dao.getAllMapRow();
    }

    @GetMapping("/entity")
    public List<Entity> displayEntities() {
        return dao.getAllEntities();
    }

    @PatchMapping("/entity/up")
    public ResponseEntity<Entity> moveUp() {
        ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
        Entity shrek = dao.getAllEntities().get(0);
        List<Square> listOfSquares = dao.getAllMapRow();
        if (!service.validMove(shrek, listOfSquares, 1)) {
            response = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        } else {
            shrek = service.moveUp(shrek);
            dao.updateEntity(shrek);
            return response.ok(shrek);
        }
        return null;
    }

    @PatchMapping("/entity/down")
    public ResponseEntity<Entity> moveDown() {
        ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
        Entity shrek = dao.getAllEntities().get(0);
        List<Square> listOfSquares = dao.getAllMapRow();
        if (!service.validMove(shrek, listOfSquares, 1)) {
            response = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        } else {
            shrek = service.moveDown(shrek);
            dao.updateEntity(shrek);
            return response.ok(shrek);
        }
        return null;
    }

    @PatchMapping("/entity/left")
    public ResponseEntity<Entity> moveLeft() {
        ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
        Entity shrek = dao.getAllEntities().get(0);
        List<Square> listOfSquares = dao.getAllMapRow();
        if (!service.validMove(shrek, listOfSquares, 3)) {
            response = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        } else {
            shrek = service.moveLeft(shrek);
            dao.updateEntity(shrek);
            return response.ok(shrek);
        }
        return null;
    }

    @PatchMapping("/entity/right")
    public ResponseEntity<Entity> moveRight() {
        ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
        Entity shrek = dao.getAllEntities().get(0);
        List<Square> listOfSquares = dao.getAllMapRow();
        if (!service.validMove(shrek, listOfSquares, 4)) {
            response = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        } else {
            shrek = service.moveRight(shrek);
            dao.updateEntity(shrek);
            return response.ok(shrek);
        }
        return null;
    }
//
//    @GetMapping
//    public List<ToDo> all() {
//        return dao.getAll();
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ToDo create(@RequestBody ToDo todo) {
//        return dao.add(todo);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ToDo> findById(@PathVariable int id) {
//        ToDo result = dao.findById(id);
//        if (result == null) {
//            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
//        }
//        return ResponseEntity.ok(result);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity update(@PathVariable int id, @RequestBody ToDo todo) {
//        ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
//        if (id != todo.getId()) {
//            response = new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
//        } else if (dao.update(todo)) {
//            response = new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return response;
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity delete(@PathVariable int id) {
//        if (dao.deleteById(id)) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
//    }
}
