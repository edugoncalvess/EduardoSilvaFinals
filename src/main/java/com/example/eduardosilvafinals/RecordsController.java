package com.example.eduardosilvafinals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes({"id","desc","errMsg","ans"})
@Controller
public class RecordsController {

    DatabaseService service1;

    @Autowired
    SavingsService service;

    @Autowired
    Connection123 connect;


    @RequestMapping(value = "/savings", method = RequestMethod.GET)
    public String showSavingspage(ModelMap model, @RequestParam(defaultValue = "") String id) throws ClassNotFoundException, SQLException {


        service1 = new DatabaseService(connect.connect());

        model.addAttribute("todos", service1.display());


        List<Savings> filteredTodos = new ArrayList<Savings>();

        filteredTodos = (List) model.get("todos");

        model.put("id",filteredTodos.get(0).getCustno());
        model.put("custname",filteredTodos.get(0).getCustname());
        model.put("cdep",filteredTodos.get(0).getCdep());
        model.put("nyears",filteredTodos.get(0).getNyears());
        model.put("savtype",filteredTodos.get(0).getSavtype());


        return "savings";


    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showSavingsPage2(ModelMap model) throws ClassNotFoundException, SQLException {

        service1 = new DatabaseService(connect.connect());



        model.addAttribute("todos", service1.display());


        List<Savings> filteredTodos = new ArrayList<Savings>();

        filteredTodos = (List) model.get("todos");

        model.put("id",filteredTodos.get(0).getCustno());
        model.put("custname",filteredTodos.get(0).getCustname());
        model.put("cdep",filteredTodos.get(0).getCdep());
        model.put("nyears",filteredTodos.get(0).getNyears());
        model.put("savtype",filteredTodos.get(0).getSavtype());


        return "savings";


    }

    @RequestMapping(value ="/add-todo", method = RequestMethod.GET)
    public String showtodopage(){
        return "savingsser";
    }


    @RequestMapping(value ="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String custno, @RequestParam String custname,
                          @RequestParam Double cdep, @RequestParam Integer nyears, @RequestParam String savtype)
                            throws SQLException, ClassNotFoundException {




        if (!((service1.search(custno)) ==null)){

            model.put("errorMessage","Record Existing");
            return "redirect:/category";

        }


        Savings svs = new Savings(custno,custname, cdep, nyears, savtype);

        service1.add(svs);

        model.clear();
        return "redirect:/savings";
    }


    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model,  @RequestParam(defaultValue = "") String id) throws SQLException, ClassNotFoundException {

        model.put("id", id);


        Savings svs =  service1.search(id);


        model.put("id",svs.getCustno());
        model.put("custname",svs.getCustname());
        model.put("cdep",svs.getCdep());
        model.put("nyears",svs.getNyears());
        model.put("savtype",svs.getSavtype());

        return "savingsedit";
    }




    @RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam String id) throws SQLException, ClassNotFoundException {


        service1.delete(id);


        model.clear();
        return "redirect:/";
    }


}
