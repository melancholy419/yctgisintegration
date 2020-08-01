package com.babatunde.yctlocationintelligence.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConverterUtils {

	public static <T> String toJson(T obj) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException ex) {
			log.error("Failed to convert object to json because: {} ", ex.getMessage(), ex);
		}
		return "";
	}

}
