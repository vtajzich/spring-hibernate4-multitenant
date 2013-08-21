package net.tajzich.mt.rest;

import net.tajzich.mt.domain.TodoItem;
import net.tajzich.mt.domain.User;
import net.tajzich.mt.service.MultitenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vtajzich
 * Date: 8/21/13
 */
@Controller
@RequestMapping("rest")
public class MultitenantController {

    @Autowired
    private MultitenantService service;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserInfo(@PathVariable Long id) {
        return service.getUser(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getCustomers() {
        return service.getUsers();
    }

    @RequestMapping(value = "/user/{id}/todo", method = RequestMethod.GET)
    @ResponseBody
    public List<TodoItem> getTransactions(@PathVariable Long id) {
        return getUserInfo(id).getTodoItems();
    }

    @RequestMapping(value = "/user/{id}/todo", method = RequestMethod.POST)
    @ResponseBody
    public List<TodoItem> addTransaction(@PathVariable Long id, @RequestBody TodoItem todoItem) {

        User user = getUserInfo(id);
        user.getTodoItems().add(todoItem);

        service.save(user);

        return user.getTodoItems();
    }

    @RequestMapping(value = "/user/{id}/todo/{todoId}", method = RequestMethod.DELETE)
    @ResponseBody
    public User addTransaction(@PathVariable Long id, @PathVariable Long todoId) {

        User user = getUserInfo(id);

        user.deleteTodo(todoId);

        service.save(user);

        return getUserInfo(id);
    }
}
