package com.demo.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.catalog.domain.PurchaseRequest;
import com.demo.catalog.domain.PurchaseSummary;
import com.demo.catalog.domain.TotalInfo;
import com.demo.catalog.repo.UserRepository;
import com.demo.catalog.validator.RequestValidator;

@Service
public class PurchaseService {
	
	@Autowired
	private RequestValidator validator;
	
	@Autowired
	private UserRepository userRepo;
	/**
	 * 
	 * @param request
	 * @return
	 */
	public PurchaseSummary purchase(PurchaseRequest request){
		validator.validatePurchaseRequest(request);
		return getPurchaseSummary(request);		
	}

	/**
	 * @param request.getProducts()
	 * @return
	 */
	private PurchaseSummary getPurchaseSummary(PurchaseRequest request) {
		PurchaseSummary summary = new PurchaseSummary();
		summary.setProduct(request.getProducts());
		calculateDiscountAndTotal(summary, request);
		return summary;
	}

	/**
	 * 
	 * @param summary
	 * @param request
	 */
	private void calculateDiscountAndTotal(PurchaseSummary summary, PurchaseRequest request) {
		TotalInfo total = new TotalInfo();
		double rate = 0 ;
		double totalAmount = 0;
		double discount = 0;
		
		if(isNewUser(request.getUser().getUserId())){
			rate = 10.0;
			userRepo.saveUser(request.getUser());
		}else if(request.getProducts().size() == 2 ) {
			
			long nonPromoAplicatbleProds = request.getProducts().stream().filter(i-> i.getIsPromoApplicable() ==  false).count();
			long productTypes = request.getProducts().stream().map(i-> i.getProductType()).distinct().count();
			if(nonPromoAplicatbleProds == 0 && productTypes == 1)
				rate = 10;
		}else if(request.getProducts().size() == 3 ) {
			long productTypes = request.getProducts().stream().map(i-> i.getProductType()).distinct().count();
			long nonPromoAplicatbleProds = request.getProducts().stream().filter(i-> i.getIsPromoApplicable() ==  false).count();
			if(nonPromoAplicatbleProds == 0 && productTypes == 1)
				rate = 20;
		}
		totalAmount = request.getProducts().stream().mapToDouble(i -> i.getCost()).sum();
		discount = totalAmount * rate /100;
		
		total.setTotalAmountBeforeDiscount(totalAmount);
		total.setDiscount(discount);
		total.setTotalAmountAfterDiscont(totalAmount - discount);
		total.setdiscountRate(rate);
		
		summary.setTotal(total);
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	private boolean isNewUser(Integer userId){
		return (null == userRepo.getUserById(userId))? true : false;
	}

}
