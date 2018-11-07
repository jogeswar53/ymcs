package com.admin.rr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admin.rr.entity.RrBrandMaster;
import com.admin.rr.service.RrBrandConfService;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class RrBrandConfServiceImpl implements RrBrandConfService {

	private Logger logger = LogManager.getLogger(this.getClass().getName());

	@Override
	public List<RrBrandMaster> getOnlineBrands() {

		List<RrBrandMaster> brandMasters = new ArrayList<>();

		try {
		} catch (Exception e) {
			logger.error("", e);
		}
		return brandMasters;
	}

}
