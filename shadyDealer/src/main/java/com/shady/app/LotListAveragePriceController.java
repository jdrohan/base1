package com.shady.app;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LotListAveragePriceController {

    @RequestMapping("/LotListAveragePrice")
    public ArrayList<Vehicle> lotListAveragePrice(@RequestParam(value="averageBy", defaultValue="type") String averageBy) {
    	ArrayList<Vehicle> avgPrice = new ArrayList<Vehicle>();
    	if (averageBy.toLowerCase().equals("type")) {
    		avgPrice = Lot.getAveragePriceByType();
    	}
    	else if (averageBy.toLowerCase().equals("brand")) {
    		avgPrice = Lot.getAveragePriceByBrand();
    	}
    	else if (averageBy.toLowerCase().equals("color")) {
    		avgPrice = Lot.getAveragePriceByColor();
    	}
    	else if (averageBy.toLowerCase().equals("enginetype")) {
    		avgPrice = Lot.getAveragePriceByEngineType();
    	}
    	else if (averageBy.toLowerCase().equals("year")) {
    		avgPrice = Lot.getAveragePriceByYear();
    	}
    	Collections.sort(avgPrice);
    	return avgPrice;
    }
}