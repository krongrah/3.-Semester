/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobCalculation;

import ProjectInterfaces.*;
import pkg3_semester_serverdomain.ServerDomainFacade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmadhamid
 */
public class JobCalFacade {

    private JobCalculator calculator;

    public JobCalFacade() {
        calculator = new JobCalculator();
    }

    public double calculateScore(IUser user, IJobPost jobPost) {
        return calculator.calculateScore(user, jobPost);
    }

    public int getRankings(int jobPostId, IUser user, IServerPersistence isp) {
        ResultSet rs = isp.getApplicants(jobPostId);
        int i = 1;
        try {
            while (rs.next()) {
                if (user.getUserId() == rs.getInt(1)) {
                    return i;
                } else {
                    i++;
                }
            }

            }catch (SQLException ex) {
            Logger.getLogger(JobCalFacade.class.getName()).log(Level.SEVERE, null, ex);
        
        }
            return 0;
        }

    }
