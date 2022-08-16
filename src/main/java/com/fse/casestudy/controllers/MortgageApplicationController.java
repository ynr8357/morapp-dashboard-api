package com.fse.casestudy.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fse.casestudy.model.MortgageApplication;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MortgageApplicationController {

	private List<MortgageApplication> mortAppDetails = createList();
	
	@RequestMapping(value = "/mortAppDetails", method = RequestMethod.GET, produces = "application/json")
	public List<MortgageApplication> firstPage() {
		return mortAppDetails;
	}
	
	@DeleteMapping(path = { "/{id}" })
	public MortgageApplication delete(@PathVariable("appid") String appid) {
		MortgageApplication deletedMortDetl = null;
		for (MortgageApplication mortDetl : mortAppDetails) {
			if (mortDetl.getApplicationID().equals(appid)) {
				mortAppDetails.remove(mortDetl);
				deletedMortDetl = mortDetl;
				break;
			}
		}
		return deletedMortDetl;
	}

	@PostMapping
	public MortgageApplication create(@RequestBody MortgageApplication mortAppDetl) {
		mortAppDetails.add(mortAppDetl);
		System.out.println("Addtion === "+mortAppDetails);
		return mortAppDetl;
	}
	
	private static List<MortgageApplication> createList() {
		
		List<MortgageApplication> mortDetlsList = new ArrayList<>();
		
		MortgageApplication mortDetl1 = new MortgageApplication();
		mortDetl1.setApplicationID("11111");
		mortDetl1.setFirstName("FirstName1");
		mortDetl1.setLastName("LastName1");
		mortDetl1.setPropertyAddress("Address1");

		MortgageApplication mortDetl2 = new MortgageApplication();
		mortDetl2.setApplicationID("22222");
		mortDetl2.setFirstName("FirstName2");
		mortDetl2.setLastName("LastName2");
		mortDetl2.setPropertyAddress("Address2");
		
		mortDetlsList.add(mortDetl1);
		mortDetlsList.add(mortDetl2);
		
		return mortDetlsList;
	}
	
}
