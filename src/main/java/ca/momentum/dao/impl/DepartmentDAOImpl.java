package ca.momentum.dao.impl;

import ca.momentum.dao.DepartmentDAO;
import ca.momentum.model.entity.Department;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Thiago Lima on 2016-05-10.
 */
@Transactional
@Repository
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

    public void persitDepartment(Department department) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(department);
    }

    public Department getDepartmentById(int id){
        Session session = this.sessionFactory.getCurrentSession();
        return (Department) session.get(Department.class, id);
    }
}
