/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalityAssessment;

/**
 *
 * @author ahmadhamid
 */
public class PersonalityFacade {
    private QuestionSet qs;

    public PersonalityFacade() {
        this.qs = new QuestionSet(this);
    }
    
    public QuestionSet getQuestionSet(/*IUser - står i UML class diagram*/) {
        return qs;
    }
}
