/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobCalculation;

import ProjectInterfaces.*;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author ahmadhamid
 */
public class JobCalFacade {
    
    JobCalculator calculator;

    public JobCalFacade() {
        calculator = new JobCalculator();
    }
    
    public double calculateScore(IUser user, IJobPost jobPost) {
        return calculator.calculateScore(user, jobPost);
    }
    
    public List<String> compare() {
        // TODO: implement compare.
        return null;
    }

    
    
    
    
}
