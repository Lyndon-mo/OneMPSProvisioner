package com.pccw.onemps.test.service;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pccw.onemps.service.IMPSSoapService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@ComponentScan(basePackages = "com.pccw.onemps")
public class MPSSoapServiceTest {
	
	
	@Autowired
	private IMPSSoapService mpsSoapService;
	
	@Before
	public void before(){
	}
	
	@Test
	public void processTest(){
		
		try{
		
		List<String> msisdns = new ArrayList<String>();
		
		msisdns.add("85255595559");
		msisdns.add("85255595550");
		msisdns.add("85255595551");

		
		mpsSoapService.WhitelistMSISDNAppend(msisdns);

		}catch (Exception e){
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Append Fail!!!!!");
			fail(e.getMessage());
			
		}
		
	}
	@Test
	public void WhitelistMSISDNGetTest(){
		
		try{
		
		List<String> msisdns = new ArrayList<String>();
			
		msisdns = mpsSoapService.WhitelistMSISDNGet();
		for(String msisdn : msisdns){
			System.out.println("get white list success");
			System.out.println(msisdn);
		}
		}catch (Exception e){
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			fail(e.getMessage());
			System.out.println("get white list failed");

		}	
	}
	
	@Test
	public void WhitelistMSISDNRemoveTest(){
		
		try{
		
			List<String> msisdns = new ArrayList<String>();
			
			msisdns.add("85255595559");
			msisdns.add("85255595550");
			
			mpsSoapService.WhitelistMSISDNRemove(msisdns);
			
			
			}catch (Exception e){
				
				e.printStackTrace();
				System.out.println(e.getMessage());
				fail(e.getMessage());
				
			}
	}
	
	
	
}
