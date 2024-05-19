package com.uisrael.DigitalRecipe.controller;

import com.uisrael.DigitalRecipe.model.Recipe;
import com.uisrael.DigitalRecipe.model.RecipeCommand;
import com.uisrael.DigitalRecipe.services.IRecipeService;
import com.uisrael.DigitalRecipe.services.IRegionService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    IRecipeService serv;
    @Autowired
    IRegionService regionServ;

    @GetMapping("/")
    public String region(Model model) {
        model.addAttribute("objectsList", serv.getAll());
        return "recipe/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("objectsList", serv.getAll());
        model.addAttribute("object", new Recipe());
        model.addAttribute("regions", regionServ.getAll());
        return "recipe/form";
    }
    @GetMapping("/update/{id}")
    public String create(Model model, @PathVariable("id") int objectId) {
        model.addAttribute("objectsList", serv.getAll());
        model.addAttribute("object", serv.getById(objectId));
        model.addAttribute("regions", regionServ.getAll());
        return "recipe/form";
    }

    @PostMapping("/save")
    public String save(RecipeCommand command) {
        Recipe object = new Recipe();
        // copia los otros campos de command a object
        object.setId(command.getId());
        object.setNombreReceta(command.getNombreReceta());
        object.setDescripcionReceta(command.getDescripcionReceta());
        object.setTiempoPreparacion(command.getTiempoPreparacion());
        object.setRegion(regionServ.getById(command.getRegion().getId()));
        object.setIngredients(command.getIngredients());
        object.setRecipeSteps(command.getRecipeSteps());

        if (command.getPhotoFile() != null && !command.getPhotoFile().isEmpty()) {
            try {
                byte[] bytes = command.getPhotoFile().getBytes();
                String encodedString = Base64.encodeBase64String(bytes);
                object.setPhoto(encodedString);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error al guardar la imagen");
            }
        }
        serv.save(object);
        return "redirect:/recipe/";
    }

    @GetMapping("/delete/{id}")
    public String save(@PathVariable("id") int objectId){
        serv.deleteById(objectId);
        return "redirect:/recipe/";
    }
}
