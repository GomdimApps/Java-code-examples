// Primeiro você precisa importar a classe JsonObjectRequest:

// Imports
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

Em seguida, você deve instanciar um objeto RequestQueue e JsonObjectRequest:

// Criação de variáveis
RequestQueue requestQueue;
JsonObjectRequest jsonObjectRequest;

// Instanciação do objeto RequestQueue
requestQueue = Volley.newRequestQueue(this);

// Instanciação do objeto JsonObjectRequest
jsonObjectRequest = new JsonObjectRequest(
   Request.Method.GET,
   "https://www.suaurl.com/json/dados.json",
   null,
   new Response.Listener<JSONObject>() {
       @Override
       public void onResponse(JSONObject response) {
           // código quando a requisição obtiver retorno
       }
   },
   new Response.ErrorListener() {
       @Override
       public void onErrorResponse(VolleyError error) {
           // Código quando houver erros
       }
});

// Adiciona as requisições à fila
requestQueue.add(jsonObjectRequest);

// 2 - Exemplo //

// Para puxar as informações desse JSON com JsonObjectRequest no Android Studio, você precisará criar uma instância de JsonObjectRequest e passar o JSON como parâmetro. Por exemplo:

JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, json,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            int http_code = response.getInt("http_code");
                            boolean status = response.getBoolean("status");
                            String result = response.getString("result");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
            }
        });
        
// Adicione a instância de JsonObjectRequest à sua fila de requisições
RequestQueue queue = Volley.newRequestQueue(context);
queue.add(request);

// 3 - Exemplo //

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private EditText etCnpj, etSenha;
    private Button btnLogin;
    private RequestQueue mQueue;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCnpj = findViewById(R.id.etCnpj);
        etSenha = findViewById(R.id.etSenha);
        btnLogin = findViewById(R.id.btnLogin);
        mQueue = Volley.newRequestQueue(this);
        progressDialog = new ProgressDialog(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setMessage("Autenticando...");
                progressDialog.show();
                String url = "https://your-url-here/api/login";
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONArray jsonArray = response.getJSONArray("resultado");
                                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                                    boolean status = jsonObject.getBoolean("status");
                                    int code = jsonObject.getInt("code");
                                    String cnpj = jsonObject.getString("cnpj");
                                    String senha = jsonObject.getString("senha");

                                    if (status && code == 200 && cnpj.equals(etCnpj.getText().toString().trim()) && senha.equals(etSenha.getText().toString().trim())) {
                                        Toast.makeText(MainActivity.this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(MainActivity.this, "CNPJ ou senha inválidos", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", error.toString());
                    }
                });
            }}
        }
    }  

// 4 - Exemplo //

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.widget.DrawerLayout;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.*;
import android.widget.*;
import java.util.*;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import org.json.*;
import nnl.nnl.nnl.*;
import android.view.*;
import android.support.v4.widget.*;
import android.support.v7.app.*;
import android.content.*;
import java.security.*;
import android.graphics.drawable.*;
import com.linxycorporation.apps.projeto.Menu.*;
import com.linxycorporation.apps.projeto.ClassroomWeb.*;

public class MainActivityPlayVideo extends AppCompatActivity 
{
    private RecyclerView mRecyclerView;
	private ExampleAdapter mExampleAdapter;
	private ArrayList<VideoItems> mExampleList;
	private RequestQueue mRequestQueue;
	String url = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLHZtWxSCLF6BRPsmAXLAm4Tzo2HqUgwmt&fields=etag%2CeventId%2Citems%2Ckind%2CnextPageToken%2CpageInfo%2CprevPageToken%2CtokenPagination%2CvisitorId&key=AIzaSyCCfFJIsa1f-L4tBR2m_kXNyzW0oaJAlGY";
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_playvideo);
		mRecyclerView = (RecyclerView) findViewById(R.id.activity_main_play_RecyclerView);
		mRecyclerView.setHasFixedSize(true);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mExampleList = new ArrayList<>();
		mRequestQueue = Volley.newRequestQueue(this);
		
		
				
		parseJSON();
    }
	
// Chamada da Lista de Video //
	private void parseJSON()
	{
		JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
		new Response.Listener<JSONObject>(){

			@Override
			public void onResponse(JSONObject response)
			{
				
				try{
					JSONArray jsonArray = response.getJSONArray("items");
					
					for(int i=0;i<jsonArray.length();i++){
						JSONObject jsonObject1 = jsonArray.getJSONObject(i); 
						JSONObject jsonObjectSnippet = jsonObject1.getJSONObject("snippet");
						JSONObject jsonObjectDefault = jsonObject1.getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("high");
						JSONObject jsonVideoId = jsonObject1.getJSONObject("snippet").getJSONObject("resourceId");
						jsonObject1.getJSONObject("snippet").getString("channelTitle"); 
						VideoItems vd = new VideoItems();
						vd.setVideoId(jsonVideoId.getString("videoId"));
						vd.setTitle(jsonObjectSnippet.getString("title"));
						vd.setUrl(jsonObjectDefault.getString("url"));
						
						mExampleList.add(vd);
					}
					mExampleAdapter = new ExampleAdapter(MainActivityPlayVideo.this,mExampleList);
					mRecyclerView.setAdapter(mExampleAdapter);
				} catch(JSONException e){
					e.printStackTrace();
					}
			}
			}, new Response.ErrorListener(){
         // Error a carregar Lista de video //
				@Override
				public void onErrorResponse(VolleyError error)
				{
					
				}
		});
		mRequestQueue.add(request);
	}
}

// 5 - Exemplo //

//criando a request
JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    boolean status = response.getBoolean("status");
                    if (status) {
                        JSONObject result = response.getJSONObject("result");
                        String title = result.getString("title");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
            }
        });
//enviando a request
 RequestQueue requestQueue = Volley.newRequestQueue(context);
 requestQueue.add(jsonObjectRequest);