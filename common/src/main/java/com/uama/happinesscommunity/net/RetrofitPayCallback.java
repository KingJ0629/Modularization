package com.uama.happinesscommunity.net;

import retrofit2.Call;

public abstract class RetrofitPayCallback<T> implements RetrofitCallback<T> {
    protected abstract void onPayError(Call<T> call, String status, String error);
}
