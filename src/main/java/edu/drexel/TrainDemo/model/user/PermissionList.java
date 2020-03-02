package edu.drexel.TrainDemo.model.user;

import java.util.ArrayList;
import java.util.List;

public class PermissionList {

    private int totalCount;
    private List<Permission> permissions = new ArrayList<Permission>();
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public List<Permission> getPermissions() {
        return permissions;
    }
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

}
