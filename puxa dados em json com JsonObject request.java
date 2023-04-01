//Aqui está um exemplo de código que puxa dados em JSON usando JsonObjectRequest em Java: //
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class JSONRequest {

    private RequestQueue requestQueue;
    private String url;

    public JSONRequest(String url) {
        this.url = url;
        this.requestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
    }

    public void getJSON(final VolleyCallback callback) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        callback.onSuccess(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error" + error.getMessage());
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }

    public interface VolleyCallback {
        void onSuccess(JSONObject result);
    }
}

// Esse código utiliza a biblioteca Volley para lidar com as solicitações HTTP. Ele cria uma classe JSONRequestque//