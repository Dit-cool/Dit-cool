package wagen.auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wagen.auto.model.PaketSalon;
import wagen.auto.service.PaketSalonService;

import java.util.List;

@Controller
public class PaketSalonController {
    @Autowired
    PaketSalonService paketSalonService;

    @RequestMapping("/listPaketSalon")
    public String getPaketSalon (Model model){

        List<PaketSalon> paketSalonList = paketSalonService.getAllPaketSalon();
        model.addAttribute("listPaketSalon", paketSalonList);
        return "/paket_salon/listPaketSalon";
    }

    @PostMapping("/addPaketSalon")
    public String addPaketSalon(PaketSalon paketSalon){

        paketSalonService.savePaketSalon(paketSalon);

        return "redirect:/listPaketSalon";
    }

    @RequestMapping ("viewaddPaketSalon")
    public String viewAddPaketSalon(Model model){
        model.addAttribute("paketSalonObject", new PaketSalon());
        return "/paket_salon/addPaketSalon";
    }

    @GetMapping("/viewupdatePaketSalon/{id_paket}")
    public String viewupdatePaketSalon(@PathVariable(value = "id_paket") int id_paket, Model model){

        PaketSalon paketSalon = paketSalonService.getPaketSalonById(id_paket);

        model.addAttribute("paketSalonObject", paketSalon);
        return "/paket_salon/updatePaketSalon";
    }

    //    #Detail
    @GetMapping("/detailPaketSalon/{id_paket}")
    public String detailPaketSalon(@PathVariable(value = "id_paket") Integer id_paket, Model model){
        PaketSalon paketSalons = paketSalonService.getPaketSalonById(id_paket);
        model.addAttribute("paketSalonObject", paketSalons);

        return "paket_salon/detailPaketSalon";
    }

    //    #Update
    @PostMapping("/updatePaketSalon/{id_paket}")
    public String update(@PathVariable("id_paket") int id_paket, PaketSalon paketSalon,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            paketSalon.setId_paket(id_paket);
            return "/paket_salon/viewupdatePaketSalon";
        }

        paketSalonService.update(id_paket, paketSalon);
        return "redirect:/listPaketSalon";
    }

    @GetMapping("/deletePaketSalon/{id_paket}")
    public String deletePaketSalon(@PathVariable("id_paket") int id_paket, PaketSalon paketSalon,
                             BindingResult result, Model model) {

        paketSalonService.deletePaketSalon(id_paket, paketSalon);
        return "redirect:/listPaketSalon";

    }

}
