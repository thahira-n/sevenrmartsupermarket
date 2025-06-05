package com.sevenrmartsupermarket.dataproviders;

import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class DataProviders {
	ExcelReader excel=new ExcelReader();
	@DataProvider(name = "projectsitelogin")
    public Object[][] getData() {
        excel.setExcelFile("dataprovider");
        return excel.getMultidimentionalData(3,2);
    }
	@DataProvider(name = "projectsiteloginwithfakedata")
	public Object[][] getUserData() {
		Faker faker = new Faker();
		Object[][] data = new Object[3][2]; // 3 sets of data, each with 2 values

		for (int i = 0; i < 3; i++) {
			String name = faker.name().fullName();
			String value = faker.internet().password();
			data[i][0] = name;
			data[i][1] = value;
		}
		return data;
	}

}
