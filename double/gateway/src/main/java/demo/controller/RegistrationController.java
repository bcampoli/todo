package demo.controller;


import demo.domain.User;
import demo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by William Campoli on 2017-08-24.
 */
@RestController
public class RegistrationController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public List<String> register(@RequestBody @Valid User user, BindingResult result) {
        if(result.hasErrors()){
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return errors;
        }
        userDetailsService.save(user);
        return null;
    }
}
