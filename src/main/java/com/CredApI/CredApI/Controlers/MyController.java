package com.CredApI.CredApI.Controlers;

import com.CredApI.CredApI.DAOs.User;
import com.CredApI.CredApI.DBmanager.DBoperation;
import com.CredApI.CredApI.requeste.CreateRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class MyController {
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public void insertUser(@RequestBody CreateRequest requeste) throws SQLException {
        DBoperation.insertUser(requeste);
    }
    @RequestMapping(value = "/createTable",method = RequestMethod.POST)
    public void createTable(@RequestParam(value = "name") String name) throws SQLException {
        DBoperation.createTable(name);
    }
    @GetMapping("/getUsers")
    public List<User> getUsers() throws SQLException {
        return DBoperation.getUser();
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam(name = "id") int id) throws SQLException {
        DBoperation.deleteUser(id);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/getstudents/{id}")
    public User getStudent(@PathVariable int id) throws SQLException {

        return DBoperation.getstudents(id);

    }

}
