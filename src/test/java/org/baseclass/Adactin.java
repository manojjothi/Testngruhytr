package org.baseclass;


	
	import java.io.IOException;

	import org.adac.AdactinSearchPage;
	import org.adac.AdactinConfirmPage;
	import org.adac.AdactinDetailsPage;
	import org.adac.AdactinSelectPage;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	public class Adactin extends BaseClass{
		@Test(dataProvider="sampleData")
		private void adactinExecution(String username, String password, String location, String hotel, String roomType, String roomNo, 
				String checkIn, String checkOut, String adult, String child, String fname, String lName, String address, String cardNo,
				String cardType, String expMonth, String expYear, String cardCVV) throws InterruptedException, IOException 
		{
			browserLaunch("http://adactinhotelapp.com/");
			
			Adactin a=new Adactin();
			WebElement txtusername = a.getUsername();
			entertext(txtusername, username);
			WebElement txtpassword = a.getPassword();
			entertext(txtpassword, password);
			WebElement login = a.getLogin();
			buttonClick(login);
			
			AdactinSearchPage b=new AdactinSearchPage();
			WebElement slocation = b.getLocation();
			int parseInt = Integer.parseInt(location);
			selectionByIndex(slocation, parseInt);
			WebElement shotel = b.getHotel();
			int parseInt1 = Integer.parseInt(hotel);
			selectionByIndex(shotel, parseInt1);
			WebElement sRoomType = b.getRoomType();
			int parseInt2 = Integer.parseInt(roomType);
			selectionByIndex(sRoomType, parseInt2);
			WebElement sRoomNo = b.getRoomNo();
			int parseInt3 = Integer.parseInt(roomNo);
			selectionByIndex(sRoomNo, parseInt3);
			WebElement txtcheckIn = b.getCheckIn();
			txtcheckIn.clear();
			entertext(txtcheckIn, checkIn);
			WebElement txtcheckOut = b.getCheckOut();
			txtcheckOut.clear();
			entertext(txtcheckOut, checkOut);
			WebElement sAdult = b.getAdult();
			int parseInt4 = Integer.parseInt(adult);
			selectionByIndex(sAdult, parseInt4);
			WebElement sChild = b.getChild();
			int parseInt5 = Integer.parseInt(child);
			selectionByIndex(sChild, parseInt5);
			WebElement search = b.getSearch();
			buttonClick(search);
			
			AdactinSelectPage c=new AdactinSelectPage();
			WebElement select = c.getSelect();
			buttonClick(select);
			WebElement bcontinue = c.getBcontinue();
			buttonClick(bcontinue);
			
			AdactinDetailsPage d=new AdactinDetailsPage();
			WebElement txtfName = d.getfName();
			entertext(txtfName, fname);
			WebElement txtlName = d.getlName();
			entertext(txtlName, lName);
			WebElement txtbAddress = d.getbAddress();
			entertext(txtbAddress, address);
			WebElement txtCardNo = d.getCardNo();
			entertext(txtCardNo, cardNo);
			WebElement sCardType = d.getCardType();
			int parseInt6 = Integer.parseInt(cardType);
			selectionByIndex(sCardType, parseInt6);
			WebElement sExpMonth = d.getExpMonth();
			int parseInt7 = Integer.parseInt(expMonth);
			selectionByIndex(sExpMonth, parseInt7);
			WebElement sExpYear = d.getExpYear();
			int parseInt8 = Integer.parseInt(expYear);
			selectionByIndex(sExpYear, parseInt8);
			WebElement txtCardCVV = d.getCardCVV();
			entertext(txtCardCVV, cardCVV);
			WebElement bookNow = d.getBookNow();
			buttonClick(bookNow);
			
			Thread.sleep(3000);
			
//			AdactinConfirmPage e=new AdactinConfirmPage();
//			WebElement orderNo = e.getOrderNo();
//			String attribute = getAttribute(orderNo, "value");
//			excelWrite("D:\\\\AdactinDB1.xlsx", "Sheet1", 1, 0, attribute);
		}
		private WebElement getLogin() {
			// TODO Auto-generated method stub
			return null;
		}
		private WebElement getPassword() {
			// TODO Auto-generated method stub
			return null;
		}
		private WebElement getUsername() {
			// TODO Auto-generated method stub
			return null;
		}
		private void browserLaunch(String string) {
			
		}
		@DataProvider(name="sampleData")
		private Object[][] data() throws IOException
		{
			return new Object[][] {
				{(excelRead(0, 0)),(excelRead(0, 1)),(excelRead(0, 2)),(excelRead(0, 3)),(excelRead(0, 4)),(excelRead(0, 5)),
					(excelRead(0, 6)),(excelRead(0, 7)),(excelRead(0, 8)),(excelRead(0, 9)),(excelRead(0, 10)),(excelRead(0, 11)),
					(excelRead(0, 12)),(excelRead(0, 13)),(excelRead(0, 14)),(excelRead(0, 15)),(excelRead(0, 16)),(excelRead(0, 17))},
				{(excelRead(1, 0)),(excelRead(1, 1)),(excelRead(1, 2)),(excelRead(1, 3)),(excelRead(1, 4)),(excelRead(1, 5)),
					(excelRead(1, 6)),(excelRead(1, 7)),(excelRead(1, 8)),(excelRead(1, 9)),(excelRead(1, 10)),(excelRead(1, 11)),
					(excelRead(1, 12)),(excelRead(1, 13)),(excelRead(1, 14)),(excelRead(1, 15)),(excelRead(1, 16)),(excelRead(1, 17))},
				{(excelRead(2, 0)),(excelRead(2, 1)),(excelRead(2, 2)),(excelRead(2, 3)),(excelRead(2, 4)),(excelRead(2, 5)),
					(excelRead(2, 6)),(excelRead(2, 7)),(excelRead(2, 8)),(excelRead(2, 9)),(excelRead(2, 10)),(excelRead(2, 11)),
					(excelRead(2, 12)),(excelRead(2, 13)),(excelRead(2, 14)),(excelRead(2, 15)),(excelRead(2, 16)),(excelRead(2, 17))}
				};
		}
	
	
	

}
