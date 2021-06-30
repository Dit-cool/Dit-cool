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
import wagen.auto.service.MerkService;

import java.util.List;

@Controller
public class MerkController {
    @Autowired
    MerkService merkService;

    @GetMapping("/")
//    public String getIndex(){
//        return "index";
//    }

    @RequestMapping("/listMerk")
    public String getMerk (Model model){

        List<Merk> merkList = merkService.getAllMerk();
        model.addAttribute("listMerk", merkList);
        return "/merk/listMerk";
    }

    @PostMapping("/addMerk")
    public String addMerk(Merk merk){

        merkService.saveMerk(merk);

        return "redirect:/listMerk";
    }

    @RequestMapping ("viewaddMerk")
    public String viewAddMerk(Model model){
        model.addAttribute("merkObject", new Merk());
        return "/merk/addMerk";
    }

    @GetMapping("/viewupdateMerk/{id_merk}")
    public String viewupdateMerk(@PathVariable(value = "id_merk") int id_merk, Model model){

        Merk merk = merkService.getMerkById(id_merk);

        model.addAttribute("merkObject", merk);
        return "/merk/updateMerk";
    }

    //    #Detail
    @GetMapping("/detailMerk/{id_merk}")
    public String detailMerk(@PathVariable(value = "id_merk") Integer id_merk, Model model){
        Merk merks = merkService.getMerkById(id_merk);
        model.addAttribute("merkObject", merks);

        return "merk/detailMerk";
    }

    //    #Update
    @PostMapping("/updateMerk/{id_merk}")
    public String update(@PathVariable("id_merk") int id_merk, Merk merk,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            merk.setId_merk(id_merk);
            return "/merk/viewupdateMerk";
        }

        merkService.update(id_merk, merk);
        return "redirect:/listMerk";
    }

    @GetMapping("/deleteMerk/{id_merk}")
    public String deleteMerk(@PathVariable("id_merk") int id_merk, Merk merk,
                             BindingResult result, Model model) {

        merkService.deleteMerk(id_merk, merk);
        return "redirect:/listMerk";

    }

}
