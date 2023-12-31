package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.models.User;

import javax.validation.Valid;

@Controller
//@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //показать всех _______________________________________________________________________________
    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/allUsers";
    }

    //    //создать нового _______________________________________________________________________________
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("users", new User());
        return "newUser";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("users") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newUser";
        userService.createUser(user);
        return "redirect:/";
    }

    //
//    //прочитать по id _______________________________________________________________________________
    @GetMapping("/{id}")
    public String read(@PathVariable("id") Long id, Model model) {
        model.addAttribute("users", userService.readUser(id));
        return "show";
    }

    // UPdate -------------
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("users", userService.readUser(id));
        return "updateUser";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("users") @Valid User user, BindingResult result, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "updateUser";
        }
        userService.updateUser(user, id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
