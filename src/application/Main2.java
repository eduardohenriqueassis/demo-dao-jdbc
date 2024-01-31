package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        DepartmentDAO departmentDAO = DaoFactory.createDepartmentDao();
        Department department = departmentDAO.findById(10);

        System.out.println("\n=== Test 1: Department insert ===");
        Department newDepartment = new Department(null, "Camping");
        departmentDAO.insert(newDepartment);
        System.out.println("New id = " + newDepartment.getId());

        System.out.println("\n=== Test 2: Department update ===");
        department = departmentDAO.findById(13);
        department.setName("Car Accessories");
        departmentDAO.update(department);

        System.out.println("\n=== Test 3: Seller delete ===");
        departmentDAO.deleteById(8);
        System.out.println("Deleted");

        List<Department>list = departmentDAO.findAll();
        for(Department obj : list){
            System.out.println(obj);
        }

    }
}
