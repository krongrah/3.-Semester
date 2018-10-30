/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobSystems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import JobSystems.JobPost;

/**
 *Contains a List of Jobs, to make the JobPost class more accessible for Applicant
 * @author Naik
 */
public class JobList {
    private ArrayList<JobPost> jobs;
    private String category;
    
    public Array sortByCategory(){
        return null;
        
    }
     
    public JobPost getJobPost(int id){
        return new JobPost();
    }
}
