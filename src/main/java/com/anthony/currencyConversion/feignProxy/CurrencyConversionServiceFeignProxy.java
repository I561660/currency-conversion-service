package com.anthony.currencyConversion.feignProxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anthony.currencyConversion.bean.CurrencyConversionBean;

//@FeignClient(name="currency-exchange-service", url="localhost:8000/currency-exchange")
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyConversionServiceFeignProxy {

	//@RequestMapping(path="/from/{from}/to/{to}", method= RequestMethod.GET)
	@RequestMapping(path="/currency-exchange-service/currency-exchange/from/{from}/to/{to}", method= RequestMethod.GET)
	public CurrencyConversionBean retriveExchangeValue(@PathVariable String from, @PathVariable String to);
}
