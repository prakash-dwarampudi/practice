package com.practice.core.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service(value=MessageService.class)
public class MessageServiceImpl implements MessageService{

	@Override
	public Message getMessage(int messageId)  throws Exception {
		HttpClient httpClient = HttpClientBuilder.create().build();
		String url = "http://localhost:8080/messenger/webapi/messages/"+messageId;
		HttpGet request = new HttpGet(url);
		
		HttpResponse resp = httpClient.execute(request);
		
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(resp.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		System.out.println(result);
		
		ObjectMapper objMapper = new ObjectMapper();
		Message msg = objMapper.readValue(result.toString(), Message.class);
		
		return msg;
		
	}

}
