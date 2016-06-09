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
    	VehicleAverageManager vam = new VehicleAverageManager(Lot.LOT_LIST);
    	if (averageBy.toLowerCase().equals("type")) {
    		avgPrice = vam.getAveragePriceByType();
    	}
    	else if (averageBy.toLowerCase().equals("brand")) {
    		avgPrice = vam.getAveragePriceByBrand();
    	}
    	else if (averageBy.toLowerCase().equals("color")) {
    		avgPrice = vam.getAveragePriceByColor();
    	}
    	else if (averageBy.toLowerCase().equals("enginetype")) {
    		avgPrice = vam.getAveragePriceByEngineType();
    	}
    	else if (averageBy.toLowerCase().equals("year")) {
    		avgPrice = vam.getAveragePriceByYear();
    	}
    	Collections.sort(avgPrice);
    	return avgPrice;
    }
}