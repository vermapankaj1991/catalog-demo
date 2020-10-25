package com.demo.catalog.validator;

import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.demo.catalog.constants.ErrorConstants;
import com.demo.catalog.domain.PurchaseRequest;
import com.demo.catalog.exception.BadRequestException;
import com.demo.catalog.exception.ErrorInfo;

@Component
public class RequestValidator {
	
	
	/**
	 * Validates the purchase request against user and product 
	 * @param request
	 */
	public void validatePurchaseRequest(PurchaseRequest request){
		Predicate<PurchaseRequest> isValidUser = r -> (null != r.getUser() && null != r.getUser().getUserId() && r.getUser().getUserId() > 0);
		Predicate<PurchaseRequest> isProductSelected = p ->(null != p.getProducts() && !p.getProducts().isEmpty());
		if(!isProductSelected.test(request)){
			throw new BadRequestException(new ErrorInfo(ErrorConstants.ERROR_NO_PRODUCT_SELECTED, "No products selected, please select at least one product"));
		}else if(!isValidUser.test(request)){
			throw new BadRequestException(new ErrorInfo(ErrorConstants.ERROR_INVALID_USER, "Invalid user information, please provide valid user info"));

		}
	}
	
	/**
	 * Validate product type
	 * @param productType
	 */
	public void validateProductFilter(String productType){
		if(!productType.equalsIgnoreCase("Finance") && !productType.equalsIgnoreCase("Capital Market"))
			throw new BadRequestException(new ErrorInfo(ErrorConstants.ERROR_INVALID_PRODUCT_TYPE, "Invalid product type passed"));
	}
}
