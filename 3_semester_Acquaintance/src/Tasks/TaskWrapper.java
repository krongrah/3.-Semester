/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import javax.crypto.SealedObject;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Sebas
 */
public class TaskWrapper {

    private SealedObject task;
    private SecretKeySpec key;

    public TaskWrapper(SealedObject task, SecretKeySpec key) {
        this.task = task;
        this.key = key;
    }

    public SealedObject getTask() {
        return task;
    }

    public SecretKeySpec getKey() {
        return key;
    }

}
