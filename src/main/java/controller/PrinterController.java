package controller;

import hibernate.HibernateDao;
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
public class PrinterController{

        private List<Printer> list;

        private HibernateDao hibernateDao;



        public PrinterController() {
            hibernateDao = new HibernateDao();
            try {
                list = hibernateDao.getPrinters();
            } catch (NullPointerException ex) {
                ex.getMessage();
                list=new ArrayList<>();
                list.add(new Printer());
            }
        }

    @RequestMapping("/printerform")
    public ModelAndView showform(){
        return new ModelAndView("printerform","command", new Printer());
    }

        @RequestMapping(value="/savePrinter", method = RequestMethod.POST)
        public ModelAndView save(@ModelAttribute("printer") Printer printer){
            if(printer.getId() < 1) {
                System.out.println("New printer");
                System.out.println(printer.getId());
                printer.setId(list.size()+1);
                list.add(printer);
                hibernateDao.saveHibernateEntity(printer);
            } else {
                Printer printer1 = getPrinterById(printer.getId());
                hibernateDao.updateHibernateEntity(printer1);
                list.remove(printer1);
                list.add(printer);
                list.sort(Comparator.comparing(Printer::getId));
            }
            System.out.println(printer.getName()+" "+ printer.getId());
            return new ModelAndView("redirect:/viewprinters");
        }

        @RequestMapping(value="/deletePrinter", method=RequestMethod.POST)
        public ModelAndView delete(@RequestParam String id){
            Printer printer=getPrinterById(Integer.parseInt(id));
            list.remove(printer);
            hibernateDao.deleteHibernateEntity(printer);
            return new ModelAndView("redirect:/viewprinters");
        }
    @RequestMapping("/show")
    public ModelAndView show(@RequestParam String id){
            Printer printer = getPrinterById(Integer.parseInt(id));
        return new ModelAndView("fulldataPrinter","command", printer);
    }

        @RequestMapping(value="/editPrinter", method=RequestMethod.POST)
        public ModelAndView edit(@RequestParam String id){
            Printer printer = getPrinterById(Integer.parseInt(id));
            return new ModelAndView("printerform","command", printer);
        }

        @RequestMapping("/viewprinters")
        public ModelAndView viewprinter(){
            list = hibernateDao.getPrinters();
            return new ModelAndView("viewprinters","list", list);
        }

        private Printer getPrinterById(@RequestParam int id) {
            return list.stream().filter(f -> f.getId() == id).findFirst().get();
        }
}
