package wagen.auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wagen.auto.model.Karyawan;
import wagen.auto.service.KaryawanService;

import java.util.List;

@Controller
public class KaryawanController {
    @Autowired
    KaryawanService karyawanService;

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @RequestMapping("/listKaryawan")
    public String getKaryawan (Model model){

        List<Karyawan> karyawanList = karyawanService.getAllKaryawan();
        model.addAttribute("listKaryawan", karyawanList);
        return "/karyawan/listKaryawan";
    }

    @PostMapping("/addKaryawan")
    public String addKaryawan(Karyawan karyawan){

        karyawanService.saveKaryawan(karyawan);

        return "redirect:/listKaryawan";
    }

    @RequestMapping ("viewaddKaryawan")
    public String viewAddKaryawan(Model model){
        model.addAttribute("karyawanObject", new Karyawan());
        return "/karyawan/addKaryawan";
    }

    @GetMapping("/viewupdateKaryawan/{id_karyawan}")
    public String viewupdateKaryawan(@PathVariable(value = "id_karyawan") int id_karyawan, Model model){

        Karyawan karyawan = karyawanService.getKaryawanById(id_karyawan);

        model.addAttribute("karyawanObject", karyawan);
        return "/karyawan/updateKaryawan";
    }

    //    #Detail
    @GetMapping("/detailKaryawan/{id_karyawan}")
    public String detailKaryawan(@PathVariable(value = "id_karyawan") Integer id_karyawan, Model model){
        Karyawan karyawans = karyawanService.getKaryawanById(id_karyawan);
        model.addAttribute("karyawanObject", karyawans);

        return "karyawan/detailKaryawan";
    }

    //    #Update
    @PostMapping("/updateKaryawan/{id_karyawan}")
    public String update(@PathVariable("id_karyawan") int id_karyawan, Karyawan karyawan,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            karyawan.setId_karyawan(id_karyawan);
            return "/karyawan/viewupdateKaryawan";
        }

        karyawanService.update(id_karyawan, karyawan);
        return "redirect:/listKaryawan";
    }

    @GetMapping("/deleteKaryawan/{id_karyawan}")
    public String deleteKaryawan(@PathVariable("id_karyawan") int id_karyawan, Karyawan karyawan,
                             BindingResult result, Model model) {

        karyawanService.deleteKaryawan(id_karyawan, karyawan);
        return "redirect:/listKaryawan";

    }

}
