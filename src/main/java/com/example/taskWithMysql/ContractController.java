package com.example.taskWithMysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ContractController {
    
    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/submit")
    public String handleFormSubmit(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String message){


    System.out.println("Name: " + name);
    System.out.println("Email: " + email);
    System.out.println("Message: " + message);
    
        // save the contact to the database
        Contact contact = new Contact(name, email, message);
        contactRepository.save(contact);

        return "Form submission successful!!";
    }
    

    @GetMapping("/contacts")
public List<Contact> getAllContacts() {
    return contactRepository.findAll();
    }

}