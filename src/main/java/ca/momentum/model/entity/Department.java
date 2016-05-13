package ca.momentum.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Thiago Lima on 2016-05-10.
 */
@Entity
@Table(name = "DEPARTMENT", uniqueConstraints = { @UniqueConstraint(columnNames = { "DEPT_NO" }) })
public class Department implements Serializable {

    private int deptId;
    private String deptNo;

    private String deptName;
    private String location;

    public Department() {
    }

    public Department(int deptId, String deptName, String location) {
        this.deptId = deptId;
        this.deptNo = "D" + this.deptId;
        this.deptName = deptName;
        this.location = location;
    }

    @Id
    @Column(name = "DEPT_ID")
    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Column(name = "DEPT_NO", length = 20, nullable = false)
    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    @Column(name = "DEPT_NAME", nullable = false)
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Column(name = "LOCATION")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (deptId != that.deptId) return false;
        if (deptNo != null ? !deptNo.equals(that.deptNo) : that.deptNo != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;
        return location != null ? location.equals(that.location) : that.location == null;

    }

    @Override
    public int hashCode() {
        int result = deptId;
        result = 31 * result + (deptNo != null ? deptNo.hashCode() : 0);
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
