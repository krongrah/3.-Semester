/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import java.io.Serializable;

/**
 * This class is extended by the various tasks that can be sent to the server.
 * The run methods call the methods they're responsible for calling on the
 * domain in this class, and then sends the return object, when applicable, to
 * the output stream in this class.
 *
 * @author Sebas
 */
public abstract class Task implements Serializable {
    private TaskTypes type;
    public TaskTypes getType(){
    return type;
    }
    Task(TaskTypes type){
    this.type=type;
    }

}
