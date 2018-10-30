/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import java.util.List;

/**
 *
 * @author mikkellarsen
 */
public interface IQuestionSet {
    
    public List<IQuestion> getQuestionSet();
    
    public void addToList(IQuestion q);

    public List<Integer> getAnswers();
}
