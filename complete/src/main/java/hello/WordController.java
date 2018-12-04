package com.controller;
package com.model.Results;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/words")


public class WordController 
{
		@RequestMapping(value="/{word}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody Results getResult(@PathVariable("str") String word) 
		{
			Results rs= new Results();
				int length = word.length();
				int [] count = new int[10];
			     String reserve="";
			     boolean result;
			   //Locgic to check whether String is Palindrome or not
			      for (int i = length - 1; i >= 0; i--)
			    	  reserve = reserve + word.charAt(i);
			         
			      if (word.equals(reserve))
			         result=true;
			      else
			    	  result=false;
			      rs.setPalindrome(result);
			      
			      //Locgic to check whether String is anagraGram or not
			        for( int i = 0; i < word.length(); i++ )
			        {
			            char ch = word.charAt(i);
			            count[ch-'a']++;
			        }
			        int oddOccur = 0;
			        for( int cnt:count )
			        {
			            if( oddOccur > 1) 
			            	rs.setAnagram(false);
			            if( cnt%2 == 1 )
			                oddOccur++;
			            rs.setAnagram(true);
			        }
			}
			
		}
