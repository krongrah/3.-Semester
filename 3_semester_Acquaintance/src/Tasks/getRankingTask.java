/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IUser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmadhamid
 */
public class getRankingTask extends Task {
    private IJobPost jobPost;
    private IUser user;

    public getRankingTask(IJobPost jobPost, IUser user) {
        this.jobPost = jobPost;
        this.user = user;
    }

    @Override
    public void run() {
        try {
            super.getOutputStream().writeObject(super.getDomain().getRankings(jobPost.getId(), user));
        } catch (IOException ex) {
            Logger.getLogger(getRankingTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
