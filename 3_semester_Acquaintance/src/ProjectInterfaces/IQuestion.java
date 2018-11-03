/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import java.io.Serializable;

/**
 *
 * @author mikkellarsen
 */
public interface IQuestion extends Serializable{
    
    public String getQuestion();

    public int getQuestionsfactor();

    public boolean getQuestionDirection();

    public int getQuestionAnswer();
    
    public void setQuestionAnswer(int ans);
    
}
