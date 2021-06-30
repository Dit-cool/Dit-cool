package wagen.auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wagen.auto.model.KatalogMobil;
import wagen.auto.model.Merk;
import wagen.auto.model.Tipe;
import wagen.auto.service.KatalogMobilService;
import wagen.auto.service.MerkService;
import wagen.auto.service.TipeService;

import java.util.List;

@Controller
public class KatalogMobilController {
    @Autowired
    KatalogMobilService KatalogMobilService;

    @Autowired
    MerkService merkService;

    @Autowired
    TipeService tipeService;


    @RequestMapping("/listKatalogMobil")
    public String getKatalogMobil (Model model){

       List<KatalogMobil> KatalogMobilList = KatalogMobilService.getAllKatalogMobil();
        model.addAttribute("listKatalogMobil", KatalogMobilList);
        return "KatalogMobil/listKatalogMobil";
    }

    @PostMapping("/addKatalogMobil")
    public String addKatalogMobil(KatalogMobil KatalogMobil){

        KatalogMobilService.saveKatalogMobil(KatalogMobil);
        return "redirect:/listKatalogMobil";
    }

    @RequestMapping ("/viewaddKatalogMobil")
    public String viewaddKatalogMobil(Model model){
        model.addAttribute("KatalogMobilObject", new KatalogMobil());

        List<Merk> merkList = merkService.getAllMerk();
        model.addAttribute("listMerk", merkList);

        List<Tipe> tipeList = tipeService.getAllTipe();
        model.addAttribute("listTipe", tipeList);

        return "KatalogMobil/addKatalogMobil";
    }

    @GetMapping("/viewupdateKatalogMobil/{id_KatalogMobil}")
    public String viewupdateKatalogMobil(@PathVariable(value = "id_KatalogMobil") int id_KatalogMobil, Model model){

        KatalogMobil KatalogMobil = KatalogMobilService.getKatalogMobilById(id_KatalogMobil);
        model.addAttribute("KatalogMobilObject", KatalogMobil);
        return "/KatalogMobil/updateKatalogMobil";
    }

    //    #Detail
    @GetMapping("/detailKatalogMobil/{id_KatalogMobil}")
    public String detailKatalogMobil(@PathVariable(value = "id_KatalogMobil") Integer id_KatalogMobil, Model model){
        KatalogMobil KatalogMobils = KatalogMobilService.getKatalogMobilById(id_KatalogMobil);
        model.addAttribute("KatalogMobilObject", KatalogMobils);
        return "KatalogMobil/detailKatalogMobil";
    }

    //    #Update
    @PostMapping("/updateKatalogMobil/{id_KatalogMobil}")
    public String update(@PathVariable("id_KatalogMobil") int id_KatalogMobil, KatalogMobil KatalogMobil,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            KatalogMobil.setId_katalog(id_KatalogMobil);
            return "/KatalogMobil/viewupdateKatalogMobil";
        }

        KatalogMobilService.update(id_KatalogMobil, KatalogMobil);
        return "redirect:/listKatalogMobil";
    }

    @GetMapping("/deleteKatalogMobil/{id_KatalogMobil}")
    public String deleteKatalogMobil(@PathVariable("id_KatalogMobil") int id_KatalogMobil, KatalogMobil KatalogMobil,
                             BindingResult result, Model model) {

        KatalogMobilService.deleteKatalogMobil(id_KatalogMobil, KatalogMobil);
        return "redirect:/listKatalogMobil";

    }
}
