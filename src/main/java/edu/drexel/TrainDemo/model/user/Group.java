package edu.drexel.TrainDemo.model.user;

import java.util.HashSet;
import java.util.Set;

public class Group {

    private String groupName;
    private Set<Permission> permission = new HashSet<>();

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<Permission> getPermission() {
        return permission;
    }

    public void setPermission(Set<Permission> permission) {
        this.permission = permission;
    }


}
