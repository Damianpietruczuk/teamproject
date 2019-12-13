package controller;

import hibernate.HibernateDao;
import hibernate.Phones;
import hibernate.Printer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class PhoneController{

    private List<Phones> list;
    private HibernateDao hibernateDao = new HibernateDao();


    public PhoneController() {
        list = hibernateDao.getPhones();
        try {
            list = hibernateDao.getPhones();
        } catch (NullPointerException ex) {
            ex.getMessage();
            list=new ArrayList<>();
            list.add(new Phones());
        }
    }

    @RequestMapping("/phoneform")
    public ModelAndView showform(){
        return new ModelAndView("phoneform","command", new Phones());
    }

    @RequestMapping(value="/savePhone", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("phone") Phones phone){
        if(phone.getId() < 1) {
            System.out.println("New phone");
            System.out.println(phone.getId());
            phone.setId(list.size()+1);
            list.add(phone);
            hibernateDao.saveHibernateEntity(phone);
        } else {
            Phones phone1 = getPhonesbyID(phone.getId());
            hibernateDao.updateHibernateEntity(phone1);
            list.remove(phone1);
            list.add(phone);
            list.sort(Comparator.comparing(Phones::getId));
        }
        System.out.println(phone.getName()+" "+ phone.getId());
        return new ModelAndView("redirect:/viewphones");
    }

    @RequestMapping(value="/deletePrinter", method=RequestMethod.POST)
    public ModelAndView delete(@RequestParam String id){
        Phones phone=getPhonesbyID(Integer.parseInt(id));
        list.remove(phone);
        hibernateDao.deleteHibernateEntity(phone);
        return new ModelAndView("redirect:/viewprinters");
    }
    @RequestMapping("/show")
    public ModelAndView show(@RequestParam String id){
        Phones phone = getPhonesbyID(Integer.parseInt(id));
        return new ModelAndView("fulldataPrinter","command", phone);
    }

    @RequestMapping(value="/editPrinter", method=RequestMethod.POST)
    public ModelAndView edit(@RequestParam String id){
        Phones phone = getPhonesbyID(Integer.parseInt(id));
        return new ModelAndView("phonesform","command", phone);
    }

    @RequestMapping("/viewphones")
    public ModelAndView viewphones(){
        list = hibernateDao.getPhones();
        return new ModelAndView("viewphones","list", list);
    }

    private Phones getPhonesbyID(@RequestParam int id) {
        return list.stream().filter(f -> f.getId() == id).findFirst().get();
    }
}
