package employees;

import hibernate.Employees;
import hibernate.HibernateDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;

@Controller
public class EmpController {
    private List<Employees> list;

    public EmpController() {
        HibernateDao hibernateDao = new HibernateDao();
        list = hibernateDao.getEmployees();
    }

    @RequestMapping("/empform")
    public ModelAndView showform(){
        return new ModelAndView("empform","command", new Employees());
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("employees") Employees employees){
        HibernateDao hibernateDao = new HibernateDao();
        if(employees.getId() < 1) {
            System.out.println("New emp");
            System.out.println(employees.getId());
            employees.setId(list.size()+1);
            list.add(employees);
            hibernateDao.saveHibernateEntity(employees);
        } else {
            Employees emp1 = getEmployeesById(employees.getId());
            hibernateDao.updateHibernateEntity(employees);
            System.out.println("*****"+employees.getFirstName()+" "+employees.getSalary()+" "+employees.getLastName());
            list.remove(emp1);
            list.add(employees);
            list.sort(Comparator.comparing(Employees::getId));
        }
        System.out.println(employees.getFirstName()+" "+employees.getSalary()+" "+employees.getLastName());
        return new ModelAndView("redirect:/viewemp");
    }

    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public ModelAndView delete(@RequestParam String id){
        Employees employees=getEmployeesById(Integer.parseInt(id));
        list.remove(employees);
        HibernateDao hibernateDao = new HibernateDao();
        hibernateDao.deleteHibernateEntity(employees);
        return new ModelAndView("redirect:/viewemp");
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public ModelAndView edit(@RequestParam String id){
        Employees employees = getEmployeesById(Integer.parseInt(id));
        return new ModelAndView("empform","command", employees);
    }

    @RequestMapping(value="/test", method=RequestMethod.POST)
    public ModelAndView test(){
        System.out.println("Test");
        return new ModelAndView("redirect:/viewemp");
    }

    @RequestMapping("/viewemp")
    public ModelAndView viewemp(){
        return new ModelAndView("viewemp","list", list);
    }

    private Employees getEmployeesById(@RequestParam int id) {
        return list.stream().filter(f -> f.getId() == id).findFirst().get();
    }
}