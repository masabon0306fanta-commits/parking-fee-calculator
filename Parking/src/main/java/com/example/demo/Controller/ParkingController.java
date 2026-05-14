package com.example.demo.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repository.ParkingRepository;
import com.example.demo.Service.ParkingService;
import com.example.demo.entity.Parking;



@Controller
public class ParkingController {
	
	@Autowired 
	private ParkingRepository ParkingRepository;
	
	@GetMapping("/home")
	public String ShowFtirsPage(Model model){
		//データ検索
		List<Parking> list=ParkingRepository.findAll().stream().toList();
		
		model.addAttribute("ParkingList",list);
	
		
		return "FirstPage";
	}
	
	@GetMapping("/fee")
	public String Fee(@RequestParam("parkingId") Integer id, Model model) {
		Parking select =ParkingRepository.findById(id).orElse(null);
		//駐車時間残っていれば削除
		if(select.getEntryTime()!=null) {
			select.setEntryTime(null);
			ParkingRepository.save(select);
		}
		
		model.addAttribute("selectParking",select);
		
		
		return "FeePage";
	}
	
	@GetMapping("/calcution")
	public String calcution(@RequestParam("parkingId")Integer id,Model model){
		Parking parking =ParkingRepository.findById(id).orElse(null);
		//駐車時間保存
		if(parking != null) {
			if(parking.getEntryTime()==null) {
			parking.setEntryTime(LocalDateTime.now());
			ParkingRepository.save(parking);
			}
		}
		
		ParkingService ParkingService= new ParkingService();
		
		long fee = ParkingService.calculateTotalFee(parking);
		model.addAttribute("totalPrice", fee);
		model.addAttribute("selectParking", parking);
		
		return "calcutionPage";
	}
	
	@GetMapping("/registrationPage")
	public String registrationPage() {
		
		return "registrationPage";
	}
	
}
