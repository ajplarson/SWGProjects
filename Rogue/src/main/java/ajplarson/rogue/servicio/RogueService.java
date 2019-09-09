/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.rogue.servicio;

import ajplarson.rogue.models.Entity;
import ajplarson.rogue.models.Square;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ajplarson
 */
@Service
public class RogueService {
    
    
    public Entity moveUp(Entity shrek) {
        Square square = shrek.getCurrentSquare();
        square.setYcoord(square.getYcoord() + 1);
        shrek.setCurrentSquare(square);
        return shrek;
    }

    public Entity moveDown(Entity shrek) {
        Square square = shrek.getCurrentSquare();
        square.setYcoord(square.getYcoord() - 1);
        shrek.setCurrentSquare(square);
        return shrek;
    }

    public Entity moveRight(Entity shrek) {
        Square square = shrek.getCurrentSquare();
        square.setXcoord(square.getXcoord() + 1);
        shrek.setCurrentSquare(square);
        return shrek;
    }

    public Entity moveLeft(Entity shrek) {
        Square square = shrek.getCurrentSquare();
        square.setXcoord(square.getXcoord() - 1);
        shrek.setCurrentSquare(square);
        return shrek;
    }

    //1 up, 2 down, 3 left, 4 right
    public boolean validMove(Entity shrek, List<Square> listOfSquares, int direction) {
        Square magicalSquareUp = listOfSquares.stream().filter
                                (q -> (q.getXcoord() == shrek.getCurrentSquare().getXcoord()) &&
                                      (q.getYcoord() == shrek.getCurrentSquare().getYcoord()+1)).findFirst().orElse(null);
        Square magicalSquareDown = listOfSquares.stream().filter
                                (q -> (q.getXcoord() == shrek.getCurrentSquare().getXcoord()) &&
                                      (q.getYcoord() == shrek.getCurrentSquare().getYcoord()-1)).findFirst().orElse(null);
        Square magicalSquareLeft = listOfSquares.stream().filter
                                (q -> (q.getXcoord() == shrek.getCurrentSquare().getXcoord()-1) &&
                                      (q.getYcoord() == shrek.getCurrentSquare().getYcoord())).findFirst().orElse(null);
        Square magicalSquareRight = listOfSquares.stream().filter
                                (q -> (q.getXcoord() == shrek.getCurrentSquare().getXcoord()+1) &&
                                      (q.getYcoord() == shrek.getCurrentSquare().getYcoord())).findFirst().orElse(null);
        
        int max = ((int)Math.sqrt(listOfSquares.size())) - 1;
        for (Square s : listOfSquares) {
            switch (direction) {
                case 1: //up
                    if (magicalSquareUp == null || magicalSquareUp.getSquareContent().isExists()){
                        return false;
                    } else {
                        break;
                    }
                case 2: //down
                    if (magicalSquareDown == null || magicalSquareDown.getSquareContent().isExists()){
                        return false;
                    } else {
                        break;
                    }
                case 3: //left
                    if (magicalSquareLeft == null || magicalSquareLeft.getSquareContent().isExists()){
                        return false;
                    } else {
                        break;
                    }
                case 4: //right
                    if (magicalSquareRight == null || magicalSquareRight.getSquareContent().isExists()){
                        return false;
                    } else {
                        break;
                    }
                default:
                    break;

            }
        }
        return true;
    }
    
    

}
