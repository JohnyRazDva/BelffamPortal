package com.bellfam.website.controller.mvc.content.profile;

import com.bellfam.website.model.Role;
import com.bellfam.website.model.User;
import com.bellfam.website.service.interf.role.RoleService;
import com.bellfam.website.service.interf.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author Eugene Petrov
 */
@Controller
@RequestMapping("/options")
public class ContentProfileController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    //TODO make something with null user statement
    @RequestMapping()
    public String optionsContent(Model model) {
        User user;
        model.addAttribute("presentation", "options");
        model.addAttribute("presentationOptions", "user-data");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            user = userService.findUserByUsername(((UserDetails) principal).getUsername());
        } else {
            return "redirect:/error";
        }
        model.addAttribute("user", user);
        return "/home";
    }

    @RequestMapping("/user-list")
    public String optionsContentUserList(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("presentation", "options");
        model.addAttribute("presentationOptions", "user-list");
        model.addAttribute("users", users);
        return "/home";
    }

    //TODO move some actions to services
    @RequestMapping("/ui/user/read/{id}")
    public String optionsContentUserRead(@PathVariable String id, Model model) {
        List<Role> roles = roleService.findAll();
        int userId = Integer.parseInt(id);
        User user = userService.findById(userId);
        int roleId = userService.getUserRoleId(userId);
        String role = roleService.findById(roleId).getTitle();
        model.addAttribute("presentation", "options");
        model.addAttribute("presentationOptions", "user-read");
        model.addAttribute("user", user);
        model.addAttribute("role", role);
        model.addAttribute("roles", roles);
        return "/home";
    }

    @RequestMapping("/ui/user/update-role")
    public String optionsContentUpdateUserRole(@RequestParam("roleId") int roleId, @RequestParam("userId") int userId) {
        userService.updateUserRole(userId, roleId);
        return "redirect:/options/ui/user/read/" + userId;
    }

    @RequestMapping("/profile/password")
    public String optionsContentChangeProfilePasswordForm(Model model) {
        model.addAttribute("changePassword", "true");
        return "redirect:/options";
    }

    @PostMapping("/profile/change-password")
    public String optionContentChangeProfilePassword(@RequestParam("password") String password,
                                                     @RequestParam("newPassword") String newPassword,
                                                     @RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("result", "incorrect password");
        if (userService.checkUserPassword(id, password)) {
            userService.changePassword(id, newPassword);
            redirectAttributes.addFlashAttribute("result", "password has been changed");
        }
        return "redirect:/options";
    }

    @PostMapping("/profile/change-user-password")
    public String optionContentChangePasswordFromAdmin(@RequestParam("newPassword") String newPassword,
                                                       @RequestParam("id") int userId) {
        userService.changePassword(userId, newPassword);
        return "redirect:/options/ui/user/read/" + userId;

    }
}
