package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Optional;

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
import tn.esprit.spring.services.IHistoryService;

@RestController
@RequestMapping("/History")
public class HistoryRestController {
	@Autowired
	IHistoryService historyService;
	
	
	@PostMapping("/addH")
	public History addH (@RequestBody History his) {
		return historyService.addH(his);
	}
	
	@GetMapping("/getAllH")
    public List<History> getHistoryss(){
		return historyService.getHistorys();
	}
	 @GetMapping("/getH/{idhi}")
	public Optional<History> finHistoryById(@PathVariable ("idhi") Long idhi){
		return historyService.finHistoryById(idhi);
		
	}
	 @DeleteMapping("/DelH/{idhi}")
	 public void DeleteH (@PathVariable ("idhi") Long idhi) {
		 historyService.DeleteH(idhi);
	 }
	
	@PutMapping("/UpdaH")
    public History UpdateH (@RequestBody History his) {
		return historyService.UpdateH(his);
	}
	
	
   
    
   
 
	
	

}
