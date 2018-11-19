/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobCalculation;

import ProjectInterfaces.*;
import static commondata.Constants.*;
import java.util.List;

/**
 *
 * @author ahmadhamid
 */
public class JobCalculator {

    public JobCalculator() {

    }
    
    /**
     * Returns a double, representing the users compatibility with the {@link IJobPost}.
     * An calculator that calculates the relative distance to the chosen {@link IJobPost} and afterwards combine the calculated score with the {@link IUser} experience.
     * 
     * @param user a concrete implementation of the interface {@link IUser}.
     * @param jobPost a concrete implementation of the interface {@link IJobPost}.
     * @param userScore a List contaning the results of the personality assessment, derivated from {@link ScoreCalculator}.
     * @param prefJobScore a List contaning the personality assessment of a fictive, but optimal applicant.
     * @param domain a concrete implementation of the interface {@link IServerDomain}.
     * @return a double, representing the "distance" between the {@link IUser} and the optimal applicant.
     */
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
     * Returns a double, representing the experience in a format that is applicable to the calculator.
     * @param user a concrete implementation of the interface {@link IUser}.
     * @param jobPost a concrete implementation of the interface {@link IJobPost}.
     * @param prefExp a double containing the amount of years the company prefer the applicant to have.
     * @param userExp a double containing the amount of experience the {@link IUser} has in the given field. The amount is in years.
     * @param expWeight a int representing the companys weighting of the importance of their preference being upheld.
     * @return a dobule contaning a weighted form of the {@link IUser} experience.
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
