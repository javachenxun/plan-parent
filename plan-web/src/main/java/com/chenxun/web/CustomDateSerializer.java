package com.chenxun.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/** 
 * @author：chenxun
 * 创建时间：2016年7月10日 下午10:46:45 
 * 参考：
 * 说明：
 */
public class CustomDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        String formattedDate = formatter.format(date);  
        jsonGenerator.writeString(formattedDate);  
	}

}
