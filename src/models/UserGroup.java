/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.google.gson.annotations.Expose;

/**
 *
 * @author ADMIN
 */
public class UserGroup {
    
    @Expose(serialize = true, deserialize = true)
    private String userGroupName;
    
    @Expose(serialize = true, deserialize = true)
    private int price;

    public UserGroup(String userGroupName, int price) {
        this.userGroupName = userGroupName;
        this.price = price;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
