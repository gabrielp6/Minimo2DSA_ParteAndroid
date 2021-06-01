package edu.upc.dsa.minimo2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {

@GET("user/{username}")
    Call<Usuario> getUser(@Path("username")String username);

@GET("badges")
    Call<List<Insignia>> getAllInsignias();


}
