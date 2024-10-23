package izaro.rubio.helloworld.redPackage

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService{
    @GET("posts")
    /*fun getPostById(@Path("id") postId: Int): Call<Post>*/
    fun getPosts(): Call<List<Post>> // Cambiado para obtener todos los posts
}