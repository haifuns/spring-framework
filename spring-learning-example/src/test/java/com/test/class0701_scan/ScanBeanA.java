package com.test.class0701_scan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author haifuns
 * @date 2025-01-09 10:46
 */
@Slf4j
@Component
public class ScanBeanA {

	public ScanBeanA() {
		log.info("ScanBeanA constructor");
	}

	@PostConstruct
	public void init() {
		log.info("ScanBeanA init");
	}
}
