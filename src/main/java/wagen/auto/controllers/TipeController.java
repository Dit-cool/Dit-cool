package wagen.auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wagen.auto.model.Merk;
import wagen.auto.model.Tipe;
import wagen.auto.service.MerkService;
import wagen.auto.service.TipeService;
import java.util.List;

@Controller
public class TipeController {
    @Autowired
    TipeService tipeService;

    @Autowired
    MerkService merkService;

    @RequestMapping("/listTipe")
    public String getTipe (Model model){

        List<Tipe> tipeList = tipeService.getAllTipe();
        model.addAttribute("listTipe", tipeList);
        return "/tipe/listTipe";
    }

    @PostMapping("/addTipe")
    public String addTipe(Tipe tipe){

        tipeService.saveTipe(tipe);

        return "redirect:/listTipe";
    }

    @RequestMapping ("viewaddTipe")
    public String viewAddTipe(Model model){
        model.addAttribute("tipeObject", new Tipe());
        List<Merk> merkList = merkService.getAllMerk();
        model.addAttribute("listMerk", merkList);
        return "/tipe/addTipe";
    }

    @GetMapping("/viewupdateTipe/{id_tipe}")
    public String viewupdateMerk(@PathVariable(value = "id_tipe") int id_tipe, Model model){

        Tipe tipe = tipeService.getTipeById(id_tipe);

        model.addAttribute("tipeObject", tipe);
        return "/tipe/updateTipe";
    }

    //    #Detail
    @GetMapping("/detailTipe/{id_tipe}")
    public String detailTipe(@PathVariable(value = "id_tipe") Integer id_tipe, Model model){
        Tipe tipess = tipeService.getTipeById(id_tipe);
        model.addAttribute("tipeObject", tipess);

        return "tipe/detailTipe";
    }

    //    #Update
    @PostMapping("/updateTipe/{id_tipe}")
    public String update(@PathVariable("id_tipe") int id_tipe, Tipe tipe,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            tipe.setId_tipe(id_tipe);
            return "/tipe/viewupdateTipe";
        }

        tipeService.update(id_tipe, tipe);
        return "redirect:/listTipe";
    }

    @GetMapping("/deleteTipe/{id_tipe}")
    public String deleteTipe(@PathVariable("id_tipe") int id_tipe, Tipe tipe,
                             BindingResult result, Model model) {

        tipeService.deleteTipe(id_tipe, tipe);
        return "redirect:/listTipe";

    }
}
