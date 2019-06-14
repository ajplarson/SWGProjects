/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.classroster;

import ajplarson.classroster.controller.ClassRosterController;
import ajplarson.classroster.dao.ClassRosterDao;
import ajplarson.classroster.dao.ClassRosterDaoFileImpl;
import ajplarson.classroster.ui.ClassRosterView;
import ajplarson.classroster.ui.UserIO;
import ajplarson.classroster.ui.UserIOConsoleImpl;

/**
 *
 * @author ajplarson
 */
public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(myDao, myView);
        controller.run();
    }

}
