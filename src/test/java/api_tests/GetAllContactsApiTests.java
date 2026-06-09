//package api_tests;
//
//import dto.ErrorMassageDto;
//import dto.TokenDto;
//import okhttp3.Request;
//import okhttp3.Response;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//import utils.BaseApi;
//import utils.iLogin;
//
//import java.io.IOException;
//
//public class GetAllContactsApiTests implements
//        BaseApi, iLogin {
//    TokenDto token;
//    SoftAssert softAssert = new SoftAssert();
//
//    @BeforeClass
//    public void login(){
//        token = login_get_token();
//    }
//
//    @Test
//    public void getAllUserContactsPositiveApiTest(){
//        System.out.println(token);
//        Request request = new Request.Builder()
//                .url(BASE_URL+GET_ALL_CONTACTS_URL)
//                .addHeader(AUTH, token.getToken())
//                .get()
//                .build();
//
//        okhttp3.Response response = null;
//
//        try{
//            response = OK_HTTP_CLIENT
//                    .newCall(request).execute();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Assert.assertEquals(response.code(), 200);
//    }
//
//    @Test
//    public void getAllUserContactsNegativeWrongTokenApiTest(){
//        Request request = new Request.Builder()
//                .url(BASE_URL+GET_ALL_CONTACTS_URL)
//                .addHeader(AUTH, "token.getToken()")
//                .get()
//                .build();
//
//        Response response = null;
//
//        try {
//            response = OK_HTTP_CLIENT.newCall(request).execute();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        softAssert.assertEquals(response.code(), 401, "validate status code");
//        try {
//            ErrorMassageDto errorMassageDto = GSON.fromJson(response.body().string(), ErrorMassageDto.class);
//            System.out.println(errorMassageDto);
//
//            softAssert.assertEquals(errorMassageDto.getError(), "Unauthorized", "validate error name");
//            softAssert.assertTrue(errorMassageDto.getMessage().contains("strings must contain exactly 2 period characters"), "validate massage");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        softAssert.assertAll();
//    }
//}
//
