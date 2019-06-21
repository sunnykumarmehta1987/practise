package net.guide.springboot2.validator;


import net.guide.springboot2.model.User;
import net.guide.springboot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user =(User)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username" ,"NonEmpty");

        if(user.getUsername().length()<6 ||  user.getUsername().length()>32){
            errors.rejectValue("username","Size.userForm.username");
        }

        if(userService.findByUserName(user.getUsername())!=null){
            errors.rejectValue("username","Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","NonEmpty");
        if(user.getPassword().length()<8 || user.getPassword().length()>32){
            errors.rejectValue("password","Size.userForm.password");
        }

        if(!user.getPassword().equals(user.getPasswordConfirm())){
            errors.rejectValue("password","Diff.userForm.passwordConfirm");
        }

    }
}
