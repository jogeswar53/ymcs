package com.admin.rr.service;

import java.util.List;

import com.admin.rr.beans.RrCountryBean;

/**
 * @author jogeswarsahu
 *
 */
public interface RrCountryConfService {

	public List<RrCountryBean> getAllCountryList();

	public String createCountry(RrCountryBean countryBean);

	public String updateCountry(RrCountryBean countryBean);

	public String deleteCountryById(Long countryId);

}
