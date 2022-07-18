package com.amazon.pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.amazon.base.TestBase;

public class PaginationPage extends TestBase {
	
	@FindBy (xpath= "//input[@id='twotabsearchtextbox']")
	WebElement searchtab;
	
	@FindBy (id="nav-search-submit-button")
	WebElement searchbtn;
	
	@FindBy (id="searchDropdownBox")
	WebElement searchdropdown;
	
	@FindBy (id="s-result-sort-select")
	WebElement sortby;
	
	@FindBy (xpath="//span[contains(text(),'Under $25')]")
	WebElement filter;
	
	public PaginationPage() 
    {
	PageFactory.initElements(driver, this);
	}
  
	public void SearchBar() 
	{
	searchtab.click();
	}
    public void SearchProduct(String keyword) 
    {		
    searchtab.sendKeys(keyword);;
	}
  /*  public void Dept(String dep)
	{
	Select dropdept = new Select(searchdropdown);
		dropdept.selectByVisibleText(dep);
	} */
    public void Searchbtn()
    {
    	searchbtn.click();
    }
    
    public void SortByDropdown(String text)
    {
    	Select sort =new Select(sortby);
    	sort.selectByVisibleText(text);
    }
	
    public void Sortedpagelist()
    
    {
    	
    	//capture all webelements into list
    	
    	List <WebElement> elementlist = driver.findElements(By.xpath("//h2/a"));
    	
    	//capture text of all webelements into new list 
    	List<String> originallist = elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
    	//sort on the original list
    	List<String> sortedList = originallist.stream().sorted().collect(Collectors.toList());
    	
    	System.out.println(sortedList);
    	System.out.println(originallist);
    	
    	Assert.assertEquals(originallist, sortedList);
    	 	
    }
	
    public void Filter()
    {
    	filter.click();
    }
	public void FilterPagelist()
	
	{
		
		List<WebElement> elementlist = driver.findElements(By.xpath("//h2/a"));
		
		List<String> originallist = elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> filterlist = originallist.stream().sorted().collect(Collectors.toList());
		
         Assert.assertEquals(originallist, filterlist);
         
         System.out.println(originallist);
         System.out.println(filterlist);
		
		
	}
	
	
	public void Pagination() {
		
		String totalpages=   driver.findElement(By.xpath("//span[@class='s-pagination-item s-pagination-disabled']")).getText();
	    System.out.println(totalpages);
		int pages = Integer.parseInt(totalpages);
		System.out.println(pages);
		for(int P=1;P<=pages;P++)
		{
			WebElement active_page= driver.findElement(By.cssSelector(".s-pagination-selected"));
			System.out.println("ActivePage:"+active_page.getText());
			// active_page.click();
			int items= driver.findElements(By.xpath("//h2/a/span")).size();
			System.out.println("Number of items:"+items);
			for(int r=1;r<=items;r++)
			{
				String itemlist = driver.findElement(By.xpath("//h2/a/span")).getText();
				System.out.println(itemlist);
			}
		    String pageno= Integer.toString(P+1);
			driver.findElement(By.xpath("//div/span/a[normalize-space()='"+pageno+"']")).click();
						
		}
		String displayedcount = driver.findElement(By.xpath("//span[contains(text(),'289-306 of over 100,000 results for')]")).getText().split("  ")[3];
		System.out.println("Total numb of displayed names: " +displayedcount);
		Assert.assertEquals(displayedcount, true);
		}   
	}

	

	
	
	
	
	
	
	
	
	
	

