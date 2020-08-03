package com.osg.ex81retrofitdatawithfile;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface RetrofitService {

    // MultipartBody.Part : 보낼 파일의 식별자, 파일명, 요청 객체를 가지고 있음
    //@Field를 사용하려면 @FormUrlEncoded가 필요
    // -> 문제 발생 : FormUrlEncoded와 @Multipart의 인코딩 타입이 같이 있을 수 없음
    // ->@Field처럼 개별 데이터를 전달하는 방법 - @PartMap (@GET방식의 @QueryMap과 흡사!)
    // @PartMap을 쓰면 나머지 데이터들을 MapColloction으로 전달!

    @Multipart
    @POST("/Retrofit/uploadData.php")
    Call<String> postDataWithFile(@PartMap Map<String, String> dataPart, @Part MultipartBody.Part filePart);

}
