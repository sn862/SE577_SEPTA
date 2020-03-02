package edu.drexel.TrainDemo.model.user;

import java.util.ArrayList;
import java.util.List;

public class Permission {
    private String permissionName;
    private List<Group> groups = new ArrayList<Group>();

    public Permission() {

    }

    public Permission(String permissionName) {
        this.permissionName = permissionName;
    }


    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
    }


}
