package com.demo.catalog.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.catalog.constants.Constants;
import com.demo.catalog.domain.PurchaseRequest;
import com.demo.catalog.domain.PurchaseSummary;
import com.demo.catalog.service.PurchaseService;

@RestController
@RequestMapping(value=Constants.BASE_CONTEXT_PATH)
public class PurchaseResource {
	@Autowired
	private PurchaseService service;
	
	@PostMapping(value="/purchase")
	public ResponseEntity<PurchaseSummary> purchase(@RequestBody PurchaseRequest request){
		PurchaseSummary summary = service.purchase(request);
	    return new ResponseEntity<PurchaseSummary>(summary, HttpStatus.OK);
	}

}
