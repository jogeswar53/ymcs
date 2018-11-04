package com.admin.rr.dao;

import java.util.List;

import com.admin.rr.entity.RrCountryMaster;

/**
 * @author jogeswarsahu
 *
 */
public interface RrCountryConfDao {

	public List<RrCountryMaster> getAllCountryList();

	public String createUpdateCountry(RrCountryMaster countryMaster);

	public RrCountryMaster getCountryById(Long countryId);

	public String deleteCountryById(Long countryId);

}
