package com.shady.app;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LotListByPriceController {

    @RequestMapping("/LotListByPrice")
    public ArrayList<Vehicle> lotListByPrice() {
    	Collections.sort(Lot.LOT_LIST);
    	return Lot.LOT_LIST;
    }
    
}