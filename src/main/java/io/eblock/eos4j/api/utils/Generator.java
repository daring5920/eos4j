package io.eblock.eos4j.api.utils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.eblock.eos4j.api.exception.ApiError;
import io.eblock.eos4j.api.exception.ApiException;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.*;

public class Generator {

	private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


	private static Retrofit retrofit;

	private static Gson gson = new GsonBuilder().setLenient().create();

	private static Retrofit.Builder builder = new Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create(gson));

	public static <S> S createService(Class<S> serviceClass, String baseUrl) {
		builder.baseUrl(baseUrl);
		builder.client(httpClient.connectTimeout(180L, TimeUnit.SECONDS).readTimeout(180L, TimeUnit.SECONDS).build());
		builder.addConverterFactory(GsonConverterFactory.create(gson));
		retrofit = builder.build();
		return retrofit.create(serviceClass);
	}

	public static <T> T executeSync(Call<T> call) {
		try {
			Response<T> response = call.execute();
			if (response.isSuccessful()) {
				return response.body();
			} else {
				ApiError apiError = getApiError(response);
				throw new ApiException(apiError);
			}
		} catch (IOException e) {
			throw new ApiException(e);
		}
	}

	private static ApiError getApiError(Response<?> response) throws IOException, ApiException {
		return (ApiError) retrofit.responseBodyConverter(ApiError.class, new Annotation[0]).convert(response.errorBody());
	}
}
