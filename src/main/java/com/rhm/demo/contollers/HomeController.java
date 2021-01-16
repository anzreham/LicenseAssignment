package com.rhm.demo.contollers;

import com.rhm.demo.models.License;
import com.rhm.demo.models.Person;
import com.rhm.demo.services.LicenseService;
import com.rhm.demo.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class HomeController {

    private final PersonService personService;
    private final LicenseService licenseService;

    public HomeController(PersonService personService, LicenseService licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }


    @GetMapping("/")
    public String home() {

        return "home";
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "/persons/new";
        } else {

            personService.createPerson(person);
            return "redirect:/";
        }
    }
//

    @RequestMapping("/licenses/new")
    public String NewLicense(@ModelAttribute("license") License lic, Model model) {
        List<Person> unlicensed = personService.getUnlicensedPeople();
        model.addAttribute("persons", unlicensed);
        return "newLic";
    }

    @RequestMapping(value = "/licenses", method = RequestMethod.POST)
    public String CreateLicense(@Valid @ModelAttribute("license") License lic, BindingResult result) {
        if (result.hasErrors())
            return "newLic";
        licenseService.createLicense(lic);
        return "redirect:/";
    }


    @GetMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {

        return "new";
    }

    @RequestMapping("/person/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Person p = personService.findById(id);
        model.addAttribute("p", p);
        return "show";
    }
}





























