package com.chinasofti.ssm01.util;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;



public class FaceClient {
	private static volatile FaceClient faceClient;
	 private AipFace client =null;
	 private FaceClient(String APP_ID, String API_KEY, String SECRET_KEY) {
		 client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
	 }
	 public static FaceClient getInstance(String APP_ID, String API_KEY, String SECRET_KEY) {
       if (faceClient == null) {
           synchronized (FaceClient.class) {
               if (faceClient == null) {
            	   faceClient = new FaceClient(APP_ID, API_KEY, SECRET_KEY);
               }
           }
       }
       return faceClient;
   }
	 
	 public boolean faceContrast(String image1,String image2) {

		    // image1/image2涔熷彲浠ヤ负url鎴杅acetoken, 鐩稿簲鐨刬mageType鍙傛暟闇�瑕佷笌涔嬪搴斻��
		    MatchRequest req1 = new MatchRequest(image1, "BASE64");
		    MatchRequest req2 = new MatchRequest(image2, "BASE64");
		    ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
		    requests.add(req1);
		    requests.add(req2);

		    JSONObject res = client.match(requests);
		    System.out.println(res.toString());
		    Object object=res.get("result");
		    System.out.println("cccc=="+object);
		    if(object==null || object.toString().equals("null")){
		    	return false;
		    }else{
		    	res=(JSONObject) object;
			    double result=res.getDouble("score");
			    if(result>90){
			    	return true;
			    }else{
			    	return false;
			    }
		    }
		    
		}

}
