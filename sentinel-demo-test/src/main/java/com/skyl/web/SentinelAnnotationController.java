package com.skyl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skyl.service.DegradeService;
import com.skyl.service.FlowService;

@RestController
public class SentinelAnnotationController {

	@Autowired
	private FlowService flowService;
	
	@RequestMapping("/flow-test")
	public String flowTest() {
		return flowService.flow();
	}

	@Autowired
	private DegradeService degradeService;
	
	@RequestMapping("/degrade-test")
	public String degradeTest() {
		return degradeService.degrade();
	}
	
	
}
