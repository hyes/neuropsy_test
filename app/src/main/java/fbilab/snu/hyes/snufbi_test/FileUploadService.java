package fbilab.snu.hyes.snufbi_test;

import retrofit.Callback;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.mime.TypedFile;

/**
 * Created by hyes on 2015. 6. 24..
 */
public interface FileUploadService {

    public static final String BASE_URL = "http://your.api/endpoint/base-url";

    @Multipart
    @POST("/upload")
    void upload(@Part("myfile") TypedFile file,
                @Part("description") String description,
                Callback<String> cb);
}

