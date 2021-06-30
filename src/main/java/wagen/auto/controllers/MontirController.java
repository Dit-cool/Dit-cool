package wagen.auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wagen.auto.model.Montir;
import wagen.auto.service.MontirService;

import java.util.List;

@Controller
public class MontirController {
    @Autowired
    MontirService montirService;

    @RequestMapping("/listMontir")
    public String getMontir (Model model){

        List<Montir> montirList = montirService.getAllMontir();
        model.addAttribute("listMontir", montirList);
        return "/montir/listMontir";
    }

    @PostMapping("/addMontir")
    public String addMontir(Montir montir){

        montirService.saveMontir(montir);

        return "redirect:/listMontir";
    }

    @RequestMapping ("viewaddMontir")
    public String viewAddMontir(Model model){
        model.addAttribute("montirObject", new Montir());
        return "/montir/addMontir";
    }

    @GetMapping("/viewupdateMontir/{id_montir}")
    public String viewupdateMontir(@PathVariable(value = "id_montir") int id_montir, Model model){

        Montir montir = montirService.getMontirById(id_montir);

        model.addAttribute("montirObject", montir);
        return "/montir/updateMontir";
    }

    //    #Detail
    @GetMapping("/detailMontir/{id_montir}")
    public String detailMontir(@PathVariable(value = "id_montir") Integer id_montir, Model model){
        Montir montirs = montirService.getMontirById(id_montir);
        model.addAttribute("montirObject", montirs);

        return "montir/detailMontir";
    }

    //    #Update
    @PostMapping("/updateMontir/{id_montir}")
    public String update(@PathVariable("id_montir") int id_montir, Montir montir,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            montir.setId_montir(id_montir);
            return "/montir/viewupdateMontir";
        }

        montirService.update(id_montir, montir);
        return "redirect:/listMontir";
    }

    @GetMapping("/deleteMontir/{id_montir}")
    public String deleteMontir(@PathVariable("id_montir") int id_montir, Montir montir,
                                   BindingResult result, Model model) {

        montirService.deleteMontir(id_montir, montir);
        return "redirect:/listMontir";

    }
}
