package ca.momentum.dao.impl;

import ca.momentum.dao.DepartmentDAO;
import ca.momentum.entity.Department;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Thiago Lima on 2016-05-10.
 */
@Transactional
public class DepartmentDAOImpl implements DepartmentDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<Department> listDepartment() {
        Session session = this.sessionFactory.getCurrentSession();

        List<Department> list = session.createQuery("from Department").list();

        return list;
    }

    public Integer getMaxDeptId() {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "Select max(d.deptId) from Department d ";
        Query query = session.createQuery(sql);
        Integer maxDeptId = (Integer) query.uniqueResult();
        if (maxDeptId == null) {
            return 0;
        }
        return maxDeptId;
    }

    public void createDepartment(String name, String location) {
        Integer deptId = getMaxDeptId() + 1;
        Department dept = new Department();
        dept.setDeptId(deptId);
        dept.setDeptNo("D" + deptId);
        dept.setDeptName(name);
        dept.setLocation(location);
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(dept);
    }
}
