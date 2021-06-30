package wagen.auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wagen.auto.model.EstimasiHarga;
import wagen.auto.model.Merk;
import wagen.auto.model.Tipe;
import wagen.auto.service.EstimasiHargaService;
import wagen.auto.service.MerkService;
import wagen.auto.service.TipeService;

import java.util.List;

@Controller
public class EstimasiHargaController {
    @Autowired
    EstimasiHargaService EstimasiHargaService;

    @Autowired
    MerkService merkService;

    @Autowired
    TipeService tipeService;


    @RequestMapping("/listEstimasiHarga")
    public String getEstimasiHarga (Model model){

        List<EstimasiHarga> EstimasiHargaList = EstimasiHargaService.getAllEstimasiHarga();
        model.addAttribute("listEstimasiHarga", EstimasiHargaList);
        return "EstimasiHarga/listEstimasiHarga";
    }

    @PostMapping("/addEstimasiHarga")
    public String addEstimasiHarga(EstimasiHarga EstimasiHarga){

        EstimasiHargaService.saveEstimasiHarga(EstimasiHarga);
        return "redirect:/listEstimasiHarga";
    }

    @RequestMapping ("/viewaddEstimasiHarga")
    public String viewaddEstimasiHarga(Model model){
        model.addAttribute("EstimasiHargaObject", new EstimasiHarga());

        List<Merk> merkList = merkService.getAllMerk();
        model.addAttribute("listMerk", merkList);

        List<Tipe> tipeList = tipeService.getAllTipe();
        model.addAttribute("listTipe", tipeList);

        return "EstimasiHarga/addEstimasiHarga";
    }

    @GetMapping("/viewupdateEstimasiHarga/{id_estimasi_harga}")
    public String viewupdateEstimasiHarga(@PathVariable(value = "id_estimasi_harga") int id_estimasi_harga, Model model){

        EstimasiHarga EstimasiHarga = EstimasiHargaService.getEstimasiHargaById(id_estimasi_harga);
        model.addAttribute("EstimasiHargaObject", EstimasiHarga);
        return "/EstimasiHarga/updateEstimasiHarga";
    }

    //    #Detail
    @GetMapping("/detailEstimasiHarga/{id_estimasi_harga}")
    public String detailEstimasiHarga(@PathVariable(value = "id_estimasi_harga") Integer id_estimasi_harga, Model model){
        EstimasiHarga EstimasiHargas = EstimasiHargaService.getEstimasiHargaById(id_estimasi_harga);
        model.addAttribute("EstimasiHargaObject", EstimasiHargas);
        return "EstimasiHarga/detailEstimasiHarga";
    }

    //    #Update
    @PostMapping("/updateEstimasiHarga/{id_estimasi_harga}")
    public String update(@PathVariable("id_estimasi_harga") int id_estimasi_harga, EstimasiHarga EstimasiHarga,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            EstimasiHarga.setId_estimasi_harga(id_estimasi_harga);
            return "/EstimasiHarga/viewupdateEstimasiHarga";
        }

        EstimasiHargaService.update(id_estimasi_harga, EstimasiHarga);
        return "redirect:/listEstimasiHarga";
    }

    @GetMapping("/deleteEstimasiHarga/{id_EstimasiHarga}")
    public String deleteEstimasiHarga(@PathVariable("id_EstimasiHarga") int id_EstimasiHarga, EstimasiHarga EstimasiHarga,
                                      BindingResult result, Model model) {

        EstimasiHargaService.deleteEstimasiHarga(id_EstimasiHarga, EstimasiHarga);
        return "redirect:/listEstimasiHarga";

    }
}
