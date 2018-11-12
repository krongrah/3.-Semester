/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OutgoingCommunication;

import ServerInterfaces.IOutComm;
import ServerInterfaces.IUser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kasper
 */
public class OutCommFacade implements IOutComm{
    
    private List<Sender> list=new ArrayList(); 

    @Override
    public void addUser(IUser user) {
      list.add(new Sender(user));
      
    }

}
