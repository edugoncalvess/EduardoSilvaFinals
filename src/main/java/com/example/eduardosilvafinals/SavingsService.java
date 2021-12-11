package com.example.eduardosilvafinals;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SavingsService {


    private static List<Savings> todos = new ArrayList<Savings>();
    private static int todoCount = 2;



    public List<Savings> retrieveTodos() {
        List<Savings> filteredTodos = new ArrayList<Savings>();
        for (Savings todo : todos) {
            filteredTodos.add(todo);
        }
        return filteredTodos;    }


    public void addTodo(String custno, String custname, Double cdep, Integer nyears, String savtype) {
        todos.add(new Savings(custno, custname, cdep, nyears, savtype));
    }


    public void deleteTodo(String id) {

        for (int i = 0; i < todos.size(); i++) {

            if(id.equals(todos.get(i).getCustno())) {

                todos.remove(i);
                break;
            }


        }

    }

    public Savings retrieve(String id){

        for(Savings todo: todos){
            if(todo.getCustno().equals(id)){
                return todo;
            }
        }
        return null;

    }

    public void update(Savings todo){
        todos.remove(todo);
        todos.add(todo);
    }
}
