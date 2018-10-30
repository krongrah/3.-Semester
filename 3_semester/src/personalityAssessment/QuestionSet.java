/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalityAssessment;

import ProjectInterfaces.IQuestionSet;
import java.io.Serializable;

/**
 *
 * @author ahmadhamid
 */
public class QuestionSet implements IQuestionSet, Serializable {

    private PersonalityFacade pf;
    private Question q1;

    public QuestionSet(PersonalityFacade pf) {
        this.pf = pf;

        
    }

    

}
