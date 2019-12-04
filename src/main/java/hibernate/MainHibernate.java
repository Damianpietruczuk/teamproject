package hibernate;

import java.util.Date;
import java.util.List;

public class MainHibernate {
    public static void main(String[] args) {
        HibernateDao hibernateDao = new HibernateDao();
        Employees employee = new Employees("Test", "Test", "Test", "Test", 1000, 18 , new Date(), 1);
        hibernateDao.saveHibernateEntity(employee);
        List<Employees> employeesList = hibernateDao.getEmployees();

        Employees employeeToUpdate = employeesList.get(0);
        employeeToUpdate.setSalary(9999);

        hibernateDao.updateHibernateEntity(employeeToUpdate);
        employeesList.forEach(System.out::println);

        Phones phones = new Phones("Sony", "Xperia 10");

        hibernateDao.saveHibernateEntity(phones);
        hibernateDao.getPhones().forEach(System.out::println);
    }
}
