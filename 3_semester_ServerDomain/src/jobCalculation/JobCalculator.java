/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobCalculation;

import ProjectInterfaces.*;
import static commondata.Constants.*;
import java.util.ArrayList;
import java.util.List;
import pkg3_semester_serverdomain.ServerDomainFacade;

/**
 *
 * @author ahmadhamid
 */
public class JobCalculator {

    public JobCalculator() {

    }
    
    public double calculateScore(IUser user, IJobPost jobPost, List<Integer> userScore, List<Integer> prefJobScore, IServerDomain domain) {
        double result = 0.0;
        
        // calculation algorithm
        for (int i = 0; i < 10; i++) {
            double d = (prefJobScore.get(i) - userScore.get(i));
            double dd = Math.abs(d);
            double ddd = dd / 100;
            result += ddd;
        }
        
        result += addExperience(user, jobPost, domain.getPrefExp(jobPost.getId()), user.getExperience(), domain.getExpWeight(jobPost.getId()));
        return result;
    }
    /**
     * Calculates how much the expereince weight, 
     * when the user applies for a Job.
     * @param user
     * @param jobPost
     * @param prefExp
     * @param userExp
     * @param expWeight
     * @return double
     */
    public double addExperience(IUser user, IJobPost jobPost, int prefExp, int userExp, int expWeight) {
        double desiredWeight;
        double result;
        
        switch (expWeight) {
            case 1:
                desiredWeight = DESIRED_WEIGHT_1;
                result = Math.abs(prefExp - userExp) * desiredWeight;
                return result;
                
            case 2:
                desiredWeight = DESIRED_WEIGHT_2;
                result = Math.abs(prefExp - userExp) * desiredWeight;
                return result;
                
            case 3:
                desiredWeight = DESIRED_WEIGHT_3;
                result = Math.abs(prefExp - userExp) * desiredWeight;
                return result;
                
            case 4:
                desiredWeight = DESIRED_WEIGHT_4;
                result = Math.abs(prefExp - userExp) * desiredWeight;
                return result;
                
            case 5:
                desiredWeight = DESIRED_WEIGHT_5;
                result = Math.abs(prefExp - userExp) * desiredWeight;
                return result;
                
            default:
                return 404.0;
            
        }
            
            
    }
    
}
