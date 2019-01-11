package com.objectfrontier.sample.ws.servlet;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAddressServlet extends TestBaseServlet {

    private static RequestHelper helper;

    @BeforeClass
    private void authenticate() {
        helper = super.login();
    }

    @Test(dataProvider = "dpCreate")
    public void testCreate(Address input, ErrorCode expectedError) {

        try {

            Address created = helper.setSecured(true)
                                    .setMethod(HttpMethod.PUT)
                                    .setInput(input)
                                    .requestObject("/do/address", Address.class);

            Address actual = helper.setSecured(true).requestObject("/do/address?id=" + created.id, Address.class);
            Assert.assertTrue(actual.id > 0, "Auto generated ID should be greater than zero");
            input.id = actual.id;
            Assert.assertEquals(JsonUtil.toJson(actual), JsonUtil.toJson(input));
        } catch (Exception e) {
            Assert.assertEquals(expectedError, e);
        }
    }

    @DataProvider
    public Object[][] dpCreate() {
        return new Object[][] {
            new Object[] { new Address(-1, "OMR",  "Chennai", "600013"), null },
            new Object[] { new Address(-1, null,   "Chennai", "600013"), new ErrorCode(AppErrorCode.ADDRESS_STREET_NULL) },
            new Object[] { new Address(-1, "CSIR", null,      "600013"), new ErrorCode(AppErrorCode.ADDRESS_CITY_NULL)   }
        };
    }

}
