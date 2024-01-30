package application;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDAO sellerDAO = DaoFactory.createSellerDao();
        System.out.println("=== Test 1: Seller by Id ===");
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Test 2: Seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDAO.findByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== Test 3: Seller findByDepartment ===");

        list = sellerDAO.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }
        System.out.println("\n=== Test 4: Seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDAO.insert(newSeller);
        System.out.println("New id = " + newSeller.getId());

        System.out.println("\n=== Test 5: Seller update ===");
        seller = sellerDAO.findById(1);
        seller.setName("Martha Waine");
        seller.setEmail("marthawaine@gmail.com");
        sellerDAO.update(seller);
        System.out.println("Update completed.");

        System.out.println("\n=== Test 6: Seller delete ===");
        sellerDAO.deleteById(14);
        sellerDAO.deleteById(15);
        System.out.println("Deleted");
    }
}