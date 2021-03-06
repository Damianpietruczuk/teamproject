package controller;

import hibernate.Employees;
import hibernate.HibernateDao;
import hibernate.MainHibernate;
import mail.SendEmail;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller
public class EmpController {
    private List<Employees> list;
    HibernateDao hibernateDao = new HibernateDao();


    public EmpController() {
        list = hibernateDao.getEmployees();
        try {
            list = hibernateDao.getEmployees();
        } catch (NullPointerException ex) {
            ex.getMessage();
            list=new ArrayList<>();
            list.add(new Employees());
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class,
                new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
    }

    @RequestMapping("/empform")
    public ModelAndView showform(){
        return new ModelAndView("empform","command", new Employees());
    }

    @RequestMapping(value="/db",  method = RequestMethod.GET)
    public ModelAndView initiateDB(){
        MainHibernate.main();
        list = hibernateDao.getEmployees();
        return new ModelAndView("redirect:/viewemp");
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("employees") Employees employees){
        employees.setStartJobDate(new Date());
        if(employees.getId() < 1) {
            System.out.println("New emp");
            System.out.println(employees.getId());
            employees.setId(list.size()+1);
            list.add(employees);
            hibernateDao.saveHibernateEntity(employees);
            SendEmail.sendMessage("Saved", "", employees.toString(), employees.getEmail());
        } else {
            Employees emp1 = getEmployeesById(employees.getId());
            hibernateDao.updateHibernateEntity(employees);
            SendEmail.sendMessage("Edited", emp1.toString(), employees.toString(), employees.getEmail());
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
        SendEmail.sendMessage("Deleted", employees.toString(), "", employees.getEmail());
        list.remove(employees);
        hibernateDao.deleteHibernateEntity(employees);
        return new ModelAndView("redirect:/viewemp");
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public ModelAndView edit(@RequestParam String id){
        Employees employees = getEmployeesById(Integer.parseInt(id));
        return new ModelAndView("empform","command", employees);
    }

    @RequestMapping(value = "/fulldata", method = RequestMethod.POST)
    public ModelAndView fulldata(@RequestParam String id){
        Employees employees = getEmployeesById(Integer.parseInt(id));
        return new ModelAndView("fulldata","command",employees);
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