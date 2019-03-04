package com.jz.frame.config.parse;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.jz.frame.config.data.HttpStatus;
import com.jz.frame.config.error.ServiceException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import static okhttp3.internal.Util.UTF_8;

/**
 * @author jackzhous
 * @package com.jz.appframe.data.net
 * @filename CustomGsonResponseBodyConverter
 * date on 2019/2/20 4:52 PM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
final class CustomGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    CustomGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        HttpStatus httpStatus = gson.fromJson(response, HttpStatus.class);
        if (httpStatus.isCodeInvalid()) {
            value.close();
            throw new ServiceException(httpStatus.getCode(), httpStatus.getMessage(),httpStatus.getOperatorName());
        }

        MediaType contentType = value.contentType();
        Charset charset = contentType != null ? contentType.charset(UTF_8) : UTF_8;
        InputStream inputStream = new ByteArrayInputStream(response.getBytes());
        Reader reader = new InputStreamReader(inputStream, charset);
        JsonReader jsonReader = gson.newJsonReader(reader);

        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }
    }
}
