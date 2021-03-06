/* Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License. */

package com.gao.hibernate.service;

import com.gao.hibernate.domain.City;
import com.gao.hibernate.domain.HotelSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Component("cityService")
@Transactional
class CityServiceImpl implements CityService {

    private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    private final CityRepository cityRepository;

    private final HotelRepository hotelRepository;

    public CityServiceImpl(CityRepository cityRepository, HotelRepository hotelRepository) {
        this.cityRepository = cityRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Page<City> findCities(CitySearchCriteria criteria, Pageable pageable) {

        Assert.notNull(criteria, "Criteria must not be null");
        String name = criteria.getName();

        if (!StringUtils.hasLength(name)) {
            return this.cityRepository.findAll(null);
        }

        String country = "";
        int splitPos = name.lastIndexOf(",");

        if (splitPos >= 0) {
            country = name.substring(splitPos + 1);
            name = name.substring(0, splitPos);
        }

        return this.cityRepository.findByNameContainingAndCountryContainingAllIgnoringCase(name.trim(), country.trim(),
                pageable);
    }

    @Override
    public City getCity(String name, String country) {
        Assert.notNull(name, "Name must not be null");
        Assert.notNull(country, "Country must not be null");
        return this.cityRepository.findByNameAndCountryAllIgnoringCase(name, country);
    }

    @Override
    public Page<HotelSummary> getHotels(City city, Pageable pageable) {
        Assert.notNull(city, "City must not be null");
        return this.hotelRepository.findByCity(city, pageable);
    }

    @Override
    public City save(City city) {
        return this.cityRepository.save(city);
    }

    public void test() {
        City city = new City("hhharbin", "china");
        city.setState("0");
        city.setMap("map");
        save(city);
        City cityRes = getCity("Bath", "UK");
        logger.info("cityName={}", cityRes.getName());
    }
}
