package model.dao;

import db.DB;
import model.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDAO createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }
}
