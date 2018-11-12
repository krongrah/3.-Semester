/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebas
 */
public class QuestionSetTask extends Task{

    public QuestionSetTask(){
        
    }
    
    @Override
    public void run() {
        try {
            super.getOutputStream().writeObject(super.getDomain().getQuestionSet());
        } catch (IOException ex) {
            Logger.getLogger(QuestionSetTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
