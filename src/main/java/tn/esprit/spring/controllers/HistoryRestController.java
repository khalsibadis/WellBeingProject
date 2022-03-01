package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.History;
import tn.esprit.spring.entities.Level;
import tn.esprit.spring.services.IHistoryService;
import tn.esprit.spring.services.ILevelService;
@RestController
@RequestMapping("/History")
public class HistoryRestController {
	@Autowired
	IHistoryService historyService;
	
	
	@PostMapping("/addH")
	public void addHH (@RequestBody History his) {
		historyService.addH(his);
	}
	
	@GetMapping("/getH")
    public List<History> getHistoryss(){
		return historyService.getHistorys();
	}
	@DeleteMapping("/Delete/{idh}")
    public void DeleteL (@PathVariable("idh") int idh) {
		historyService.DeleteH(idh);
	}
	@PutMapping("/Updah")
    public void UpdateL (@RequestBody History his) {
		historyService.UpdateH(his);
	}
	
	

}
