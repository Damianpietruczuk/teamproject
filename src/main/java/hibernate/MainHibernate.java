package hibernate;

import java.util.*;

public class MainHibernate {
    public static void main() {
        HibernateDao hibernateDao = new HibernateDao();
        Employees employee = new Employees("Test", "Test", "Test", "Test", 1000, 18 ,  1, "dampiet34@wp.pl");
        Employees employee1 = new Employees("Test1", "Test", "Test", "Test", 1000, 18 , 1, "dampiet34@wp.pl");
        hibernateDao.saveHibernateEntity(employee);
        hibernateDao.saveHibernateEntity(employee1);
        List<Employees> employeesList = hibernateDao.getEmployees();

        Set<Employees> employeesSet = new HashSet<>();
        employeesSet.add(employeesList.get(0));
        employeesSet.add(employeesList.get(1));

        employeesList.forEach(System.out::println);

        Phones phones = new Phones("Sony", "Xperia 10", employee);

        Printer printer = new Printer("Hp", employeesSet);

        hibernateDao.saveHibernateEntity(phones);
        hibernateDao.getPhones().forEach(System.out::println);
        hibernateDao.saveHibernateEntity(printer);
        hibernateDao.getPrinters().forEach(System.out::println);
    }
}
